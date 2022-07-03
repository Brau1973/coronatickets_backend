package controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtPaqueteEspectaculos;
import excepciones.EspectaculoRepetidoExcepcion;
import interfaces.IControladorEspectaculo;
import logica.Artista;
import logica.Espectaculo;
import logica.Plataforma;
import manejadores.ManejadorEspectaculo;
import manejadores.ManejadorPlataforma;
import manejadores.ManejadorUsuario;
import persistencia.Conexion;

public class ControladorEspectaculo implements IControladorEspectaculo {
	public ControladorEspectaculo() {
		super();
	}

	@Override
	public void altaEspectaculo(DtEspectaculo dte, String nombrePlataforma) throws EspectaculoRepetidoExcepcion {
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		if (mE.buscarEspectaculo(dte.getNombre()) == null) {

			ManejadorUsuario mU = ManejadorUsuario.getInstancia();
			Artista artistaOrganizador = mU.buscarArtista(dte.getArtista());

			ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
			Plataforma plataforma = mP.buscarPlataforma(nombrePlataforma);

			Espectaculo espectaculo = new Espectaculo(artistaOrganizador, dte.getNombre(), dte.getDescripcion(),
					dte.getDuracion(), dte.getCantMin(), dte.getCantMax(), dte.getUrl(), dte.getCosto(),
					dte.getRegistro(), dte.getimageName());

			plataforma.aniadirEspectaculo(espectaculo);

			mE.agregarEspectaculo(espectaculo);
		} else {
			throw new EspectaculoRepetidoExcepcion("Error",
					"El espectaculo con el nombre " + dte.getNombre() + " ya existe.");
		}
	}

	@Override
	public List<DtEspectaculo> listarEspectaculos(String nombrePlataforma) {
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
		Plataforma plataforma = mP.buscarPlataforma(nombrePlataforma);

		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();

		List<DtEspectaculo> listEspectaculosDt = new ArrayList<DtEspectaculo>();

		em.getTransaction().begin();
		for (Espectaculo e : plataforma.getEspectaculo()) {
			System.out.println("ITERANDO EN :" + e.getNombre());
			DtEspectaculo DtEspec = new DtEspectaculo(e.getArtista(), nombrePlataforma, e.getNombre(),
					e.getDescripcion(), e.getDuracion(), e.getCantMinEsp(), e.getCantMaxEsp(), e.getUrl(), e.getCosto(),
					e.getRegistro(), e.getimageName());
			listEspectaculosDt.add(DtEspec);
		}
		em.getTransaction().commit();
		return listEspectaculosDt;
	}

	@Override
	public List<DtEspectaculo> obtenerAllDtEspectaculos(String nickname) {
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		List<Espectaculo> listEsp = mE.obtenerEspectaculoArtista(nickname);
		return listEntityToDtEsp(listEsp);
	}

	public List<DtEspectaculo> listEntityToDtEsp(List<Espectaculo> liste) {
		List<DtEspectaculo> listEspectaculosDt = new ArrayList<DtEspectaculo>();
		for (Espectaculo e : liste) {
			DtEspectaculo DtEspec = new DtEspectaculo(e.getArtista(), "", e.getNombre(), e.getDescripcion(),
					e.getDuracion(), e.getCantMinEsp(), e.getCantMaxEsp(), e.getUrl(), e.getCosto(), e.getRegistro(), e.getimageName());
			listEspectaculosDt.add(DtEspec);
		}
		return listEspectaculosDt;
	}

	@Override
	public List<String> obtenerEspectaculosArtista(String nickname) { // veer
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		return mE.obtenerEspectaculodeArtista(nickname);
	}

	public List<DtFuncion> obtenerEspectaculoFunciones(String nombreEsp) {
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		return mE.buscarEspectaculo(nombreEsp).getFuncionesDt();
	}

	public List<DtPaqueteEspectaculos> obtenerEspectaculoPaquetes(String nombreEsp) {
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		return mE.buscarEspectaculo(nombreEsp).getPaqueteEspectaculoDt();
	}

	public boolean existeEspectaculo(String nombreEsp) {
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		if (mE.buscarEspectaculo(nombreEsp) != null) {
			return true;
		} else {
			return false;
		}
	}

}
