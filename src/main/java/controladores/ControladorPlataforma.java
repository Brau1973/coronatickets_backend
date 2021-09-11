package controladores;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtEspectaculo;
import datatypes.DtPlataforma;
import excepciones.PlataformaRepetidaExcepcion;
import interfaces.IControladorPlataforma;
import logica.Espectaculo;
import logica.Plataforma;
import manejadores.ManejadorPlataforma;

public class ControladorPlataforma implements IControladorPlataforma {

	
	public ControladorPlataforma() {
		super();
	}

	public void altaPlataforma(DtPlataforma dtPlataforma) throws PlataformaRepetidaExcepcion {
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
		Plataforma plataforma = mP.buscarPlataforma(dtPlataforma.getNombre());
		if (plataforma != null)
			throw new PlataformaRepetidaExcepcion("la plataforma " + dtPlataforma.getNombre() + " ya esta existe");
		plataforma = new Plataforma(dtPlataforma.getNombre(), dtPlataforma.getDescripcion(), dtPlataforma.getUrl());
		mP.altaPlataforma(plataforma);
	}

	public List<DtPlataforma> listarPlataformas() { 
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
		List<Plataforma> listPlat = mP.obtenerPlataforma();
		return mapListEntityToDt(listPlat);
	}

	public List<String> listarPlataformasStr() {
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();

		List<Plataforma> listPlataformas = new ArrayList<Plataforma>();
		listPlataformas = mP.obtenerPlataforma();

		List<String> listPlataformasStr = new ArrayList<String>();

		for (Plataforma p : listPlataformas) {
			listPlataformasStr.add((p.getNombre()));
		}
		return listPlataformasStr;
	}

	public Plataforma buscarPlataforma(String nombrePlataforma) {
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
		Plataforma plataforma = mP.buscarPlataforma(nombrePlataforma);
		return plataforma;

	}

	public List<DtPlataforma> mapListEntityToDt(List<Plataforma> p){
		List<DtPlataforma> ret = new ArrayList<DtPlataforma>();
		p.forEach((plat) -> {
			DtPlataforma dtP = mapEntityToDt(plat);
			ret.add(dtP);
		});
		return ret;
	}

	public DtPlataforma mapEntityToDt(Plataforma p){
    	DtPlataforma ret = new DtPlataforma(p.getNombre(), p.getDescripcion(), p.getUrl());
		List<DtEspectaculo> listEspectaculosDt = new ArrayList<DtEspectaculo>();
		for (Espectaculo e : p.getEspectaculo()) {
			DtEspectaculo DtEspec = new DtEspectaculo(e.getArtista(),p.getNombre(),e.getNombre(),e.getDescripcion(),e.getDuracion(),e.getCantMinEsp(),e.getCantMaxEsp(),e.getUrl(),e.getCosto(),e.getRegistro());
			listEspectaculosDt.add(DtEspec);
		}
		ret.setEspectaculo(listEspectaculosDt);
    	return ret;
    }
	
}