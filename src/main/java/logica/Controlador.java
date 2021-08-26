package logica;

import java.util.ArrayList;

import datatypes.DtEspectaculo;
import excepciones.PlataformaRepetidaExcepcion;
import interfaces.IControlador;

public class Controlador implements IControlador {

	public Controlador() {
		super();
	}

	public void altaEspectaculo(DtEspectaculo dte) {
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		Espectaculo espectaculo = new Espectaculo(dte.getArtista(), dte.getPlataforma(), dte.getNombre(),
				dte.getDescripcion(), dte.getDuracion(), dte.getCantMin(), dte.getCantMax(), dte.getUrl(),
				dte.getCosto(), dte.getRegistro());
		mE.agregarEspectaculo(espectaculo);
	}

	public String[] listarPlataformas() {
		ArrayList<String> plataforma;
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
		plataforma = mP.obtenerPlataforma();
		String[] retorno = new String[plataforma.size()];
		int i = 0;
		for (String p : plataforma) {
			retorno[i] = p;
			i++;
		}
		return retorno;
	}

	public void altaPlataforma(String nombre, String descripcion, String url) throws PlataformaRepetidaExcepcion {
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
		Plataforma plataforma = mP.buscarPlataforma(nombre);
		if (plataforma != null)
			throw new PlataformaRepetidaExcepcion("la plataforma " + nombre + " ya esta existe");
		plataforma = new Plataforma(nombre, descripcion, url);
		mP.altaPlataforma(plataforma);
	}

}