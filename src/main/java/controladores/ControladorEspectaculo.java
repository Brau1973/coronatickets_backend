package controladores;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtEspectaculo;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorPlataforma;
import interfaces.IControladorUsuario;
import logica.Artista;
import logica.Espectaculo;
import logica.Plataforma;
import manejadores.ManejadorEspectaculo;
import manejadores.ManejadorPlataforma;

public class ControladorEspectaculo implements IControladorEspectaculo {
	public ControladorEspectaculo() {
		super();
	}

	public void altaEspectaculo(DtEspectaculo dte, String nombrePlataforma){
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		if (mE.buscarEspectaculo(dte.getNombre()) == null) {

			IControladorUsuario iconU = Fabrica.getInstancia().getIControladorUsuario();
			IControladorPlataforma iconP = Fabrica.getInstancia().getIControladorPlataforma();

			Artista artistaOrganizador = iconU.obtenerArtista(dte.getArtista());

			Plataforma plataforma = iconP.buscarPlataforma(nombrePlataforma);

			Espectaculo espectaculo = new Espectaculo(artistaOrganizador, dte.getNombre(), dte.getDescripcion(), dte.getDuracion(), dte.getCantMin(), dte.getCantMax(), dte.getUrl(), dte.getCosto(), dte.getRegistro());

			plataforma.aniadirEspectaculo(espectaculo);

			mE.agregarEspectaculo(espectaculo);
		} /*else {
			throw new EspectaculoRepetidoExcepcion("El espectaculo con el nombre " + dte.getNombre() + " ya existe.");
		}*/
	}

	public Espectaculo obtenerEspectaculo(String nombre) {
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		return mE.buscarEspectaculo(nombre);
	}

	public List<DtEspectaculo> listarEspectaculos(String nombrePlataforma) {
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
		Plataforma plataforma = mP.buscarPlataforma(nombrePlataforma);
		return plataforma.getEspectaculosDt();
	}

	public List<DtEspectaculo> obtenerAllDtEspectaculos(String nickname) { // Ok Seba 22-10-2021
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		List<Espectaculo> listEsp = mE.obtenerEspectaculoArtista(nickname);
		return listEntityToDtEsp(listEsp);
	}

	public List<DtEspectaculo> listEntityToDtEsp(List<Espectaculo> liste) { // Ok Seba 22-10-2021
		List<DtEspectaculo> listEspectaculosDt = new ArrayList<DtEspectaculo>();
		for (Espectaculo e : liste) {
			DtEspectaculo DtEspec = new DtEspectaculo(e.getArtista(), "", e.getNombre(), e.getDescripcion(), e.getDuracion(), e.getCantMinEsp(), e.getCantMaxEsp(), e.getUrl(), e.getCosto(), e.getRegistro());
			listEspectaculosDt.add(DtEspec);
		}
		return listEspectaculosDt;
	}

	public List<Espectaculo> obtenerEspectaculo2(String plataforma) {
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		return mE.obtenerEspectaculoBD(plataforma);
	}

	public List<String> obtenerEspectaculosArtista(String nickname) { // veer
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		return mE.obtenerEspectaculodeArtista(nickname);
	}

}