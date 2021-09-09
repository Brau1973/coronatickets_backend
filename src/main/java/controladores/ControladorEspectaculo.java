package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import datatypes.DtEspectaculo;
import excepciones.EspectaculoRepetidoExcepcion;
import excepciones.FuncionYaRegistradaEnEspectaculoExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorPlataforma;
import interfaces.IControladorUsuario;
import logica.Artista;
import logica.Espectaculo;
import logica.Plataforma;
import manejadores.ManejadorEspectaculo;
import manejadores.ManejadorFuncion;
import manejadores.ManejadorPlataforma;
import persistencia.Conexion;

public class ControladorEspectaculo implements IControladorEspectaculo {
	public ControladorEspectaculo() {
		super();
	}

	public void altaEspectaculo(DtEspectaculo dte,String nombrePlataforma) throws EspectaculoRepetidoExcepcion {
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();

		IControladorUsuario iconU = Fabrica.getInstancia().getIControladorUsuario();
		IControladorPlataforma iconP = Fabrica.getInstancia().getIControladorPlataforma();

		Artista artistaOrganizador = iconU.obtenerArtista(dte.getArtista());

		Plataforma plataforma = iconP.buscarPlataforma(nombrePlataforma);

		Espectaculo espectaculo = new Espectaculo(artistaOrganizador, dte.getNombre(), dte.getDescripcion(),
				dte.getDuracion(), dte.getCantMin(), dte.getCantMax(), dte.getUrl(), dte.getCosto(), dte.getRegistro());

		plataforma.aniadirEspectaculo(espectaculo);
		
		mE.agregarEspectaculo(espectaculo);
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

	public List<Espectaculo> obtenerEspectaculo2(String plataforma) {
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		return mE.obtenerEspectaculoBD(plataforma);
	}

}