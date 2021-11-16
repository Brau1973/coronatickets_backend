package controladores;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtEspectaculo;
import datatypes.DtPaqueteEspectaculo;
import interfaces.IControladorPaquete;
import logica.Espectaculo;
import logica.PaqueteEspectaculos;
import manejadores.ManejadorEspectaculo;
import manejadores.ManejadorPaquete;

public class ControladorPaquete implements IControladorPaquete {
	public ControladorPaquete() {
		super();
	}

	@Override
	public void altaPaquete(PaqueteEspectaculos pEsp) {
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		mP.altaPaquete(pEsp);
	}

	@Override
	public Boolean existePaquete(String nombre) {
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		return mP.existePaquete(nombre);
	}

	@Override
	public List<DtPaqueteEspectaculo> obtenerPaquetes() {
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		return mapListEntityToDt(mP.obtenerPaquetes());
	}

	public List<DtPaqueteEspectaculo> mapListEntityToDt(List<PaqueteEspectaculos> p) {
		List<DtPaqueteEspectaculo> ret = new ArrayList<DtPaqueteEspectaculo>();
		for (PaqueteEspectaculos paq : p) {
			DtPaqueteEspectaculo dtP = mapEntityToDt(paq);
			ret.add(dtP);
		}
		return ret;
	}

	public DtPaqueteEspectaculo mapEntityToDt(PaqueteEspectaculos p) {
		DtPaqueteEspectaculo ret = new DtPaqueteEspectaculo(p.getNombre(), p.getDescripcion(), p.getFechaInicio(), p.getFechaFin(), p.getFechaAlta(), p.getDescuento());
		List<DtEspectaculo> listEspectaculosDt = new ArrayList<DtEspectaculo>();
		for (Espectaculo e : p.getEspectaculos()) {
			DtEspectaculo DtEspec = new DtEspectaculo(e.getArtista(), "", e.getNombre(), e.getDescripcion(), e.getDuracion(), e.getCantMinEsp(), e.getCantMaxEsp(), e.getUrl(), e.getCosto(), e.getRegistro());
			listEspectaculosDt.add(DtEspec);
		}
		ret.setEspectaculos(listEspectaculosDt);
		return ret;
	}

	@Override
	public void agregarEspectaculo(String paquete, String espectaculo) {
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
	//	ManejadorPlataforma mPlat = ManejadorPlataforma.getInstancia();
		ManejadorEspectaculo mEsp = ManejadorEspectaculo.getInstancia();
		PaqueteEspectaculos paq = mP.buscarPaquete(paquete);
		System.out.println("Espectaculo = " + espectaculo);
		Espectaculo esp = mEsp.buscarEspectaculo(espectaculo);
		System.out.println(esp.getNombre());
		paq.addEspectaculo(esp);
		esp.agregarPaquete(paq);
		mP.altaPaquete(paq);
	}

}