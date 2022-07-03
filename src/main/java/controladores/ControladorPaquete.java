package controladores;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtEspectaculo;
import datatypes.DtPaqueteEspectaculos;
import interfaces.IControladorPaquete;
import logica.Espectaculo;
import logica.PaqueteEspectaculos;
import manejadores.ManejadorEspectaculo;
import manejadores.ManejadorPaquete;

public class ControladorPaquete implements IControladorPaquete {

	@Override
	public void altaPaquete(DtPaqueteEspectaculos dtPaqueteEsp) {
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
	    PaqueteEspectaculos pe = new PaqueteEspectaculos(dtPaqueteEsp.getNombre(),dtPaqueteEsp.getDescripcion()
	    		,dtPaqueteEsp.getFechaInicio(),dtPaqueteEsp.getFechaFin(),dtPaqueteEsp.getFechaAlta(),
	    		dtPaqueteEsp.getDescuento());
		mP.altaPaquete(pe);
	}

	@Override
	public Boolean existePaquete(String nombre) {
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		return mP.existePaquete(nombre);
	}

	@Override
	public List<DtPaqueteEspectaculos> obtenerPaquetes() {
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		return mapListEntityToDt(mP.obtenerPaquetes());
	}

	public List<DtPaqueteEspectaculos> mapListEntityToDt(List<PaqueteEspectaculos> p) {
		List<DtPaqueteEspectaculos> ret = new ArrayList<DtPaqueteEspectaculos>();
		for (PaqueteEspectaculos paq : p) {
			DtPaqueteEspectaculos dtP = mapEntityToDt(paq);
			ret.add(dtP);
		}
		return ret;
	}

	public DtPaqueteEspectaculos mapEntityToDt(PaqueteEspectaculos p) {
		DtPaqueteEspectaculos ret = new DtPaqueteEspectaculos(p.getNombre(), p.getDescripcion(), p.getFechaInicio(), p.getFechaFin(), p.getFechaAlta(), p.getDescuento());
		List<DtEspectaculo> listEspectaculosDt = new ArrayList<DtEspectaculo>();
		for (Espectaculo e : p.getEspectaculos()) {
			DtEspectaculo DtEspec = new DtEspectaculo(e.getArtista(), "", e.getNombre(), e.getDescripcion(), e.getDuracion(), e.getCantMinEsp(), e.getCantMaxEsp(), e.getUrl(), e.getCosto(), e.getRegistro(), e.getimageName());
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
	
	@Override
	public List<DtEspectaculo> getEspectaculosDePaquete(String paquete) {
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		ManejadorEspectaculo mEsp = ManejadorEspectaculo.getInstancia();
		
		PaqueteEspectaculos paq = mP.buscarPaquete(paquete);
		List<DtEspectaculo> listEspectaculosDt = new ArrayList<DtEspectaculo>();
		
		for (Espectaculo e : paq.getEspectaculos()) {
			DtEspectaculo DtEspec = new DtEspectaculo(e.getArtista(), "", e.getNombre(),
					e.getDescripcion(), e.getDuracion(), e.getCantMinEsp(), e.getCantMaxEsp(), e.getUrl(), e.getCosto(),
					e.getRegistro(), e.getimageName());
			listEspectaculosDt.add(DtEspec);
		}
		return listEspectaculosDt;
	}
	
	@Override
	public DtPaqueteEspectaculos getInfoPaquete (String nomPaquete) {
		ManejadorPaquete mPaq = ManejadorPaquete.getInstancia();
		PaqueteEspectaculos paquete= (mPaq.buscarPaquete(nomPaquete));
		
		DtPaqueteEspectaculos infoPaquete = new DtPaqueteEspectaculos(paquete.getNombre(),paquete.getDescripcion(),paquete.getFechaInicio(),paquete.getFechaFin(),paquete.getFechaAlta(),paquete.getDescuento());
		
		return infoPaquete;
	}

}