package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatypes.DtFuncion;
import excepciones.FuncionYaRegistradaEnEspectaculoExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorFuncion;
import interfaces.IControladorUsuario;
import logica.Artista;
import logica.Espectaculo;
import logica.Espectador;
import logica.Funcion;
import logica.Registro;
import manejadores.ManejadorEspectaculo;
import manejadores.ManejadorFuncion;
import manejadores.ManejadorUsuario;

public class ControladorFuncion implements IControladorFuncion {

	public ControladorFuncion() {
		super();
	}

	@Override
	public void altaFuncion(DtFuncion dtFuncion, String nombreEspectaculo, byte[] imagen) throws FuncionYaRegistradaEnEspectaculoExcepcion {
		IControladorEspectaculo iconE = Fabrica.getInstancia().getIControladorEspectaculo();
		Espectaculo espectaculo = iconE.obtenerEspectaculo(nombreEspectaculo);

		if (espectaculo.funcionYaRegistrada(dtFuncion.getNombre())) {
			throw new FuncionYaRegistradaEnEspectaculoExcepcion("Error", "La Funcion " + dtFuncion.getNombre() + " ya esta registrada en el espectaculo " + espectaculo.getNombre());
		} else {
			ManejadorFuncion mF = ManejadorFuncion.getInstancia();
			IControladorUsuario iconU = Fabrica.getInstancia().getIControladorUsuario();
			List<Artista> artistas = new ArrayList<Artista>();
			dtFuncion.getArtistas().forEach((a) -> {
				artistas.add(iconU.obtenerArtista(a));
			});
			Funcion funcionACrear = new Funcion(dtFuncion.getNombre(), dtFuncion.getFecha(), dtFuncion.getHoraInicio(), dtFuncion.getRegistro(), artistas, imagen);
			espectaculo.agregarFuncion(funcionACrear);
			mF.agregarFuncion(funcionACrear);
		}
	}

	@Override
	public List<DtFuncion> listarFunciones(String nomEsp) {
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		Espectaculo espectaculo = mE.buscarEspectaculo(nomEsp);
		return espectaculo.getFuncionesDt();
	}

	@Override
	public List<String> getFuncionesVigentesRegistradasPorEspectador(String nicknameEspectador) { // DEVUELVE TODAS LAS FUNCIONES (NOMBRES) EN LAS QUE SE REGISTRO UN ESPECTAODR																							// DADO, Y ESTAS SIGUEN VIGENTES
		List<String> funcionesARetornar = new ArrayList<String>();

		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Espectador espectador = mU.buscarEspectador(nicknameEspectador);

		List<Registro> registrosEspectador = new ArrayList<Registro>();
		
		return funcionesARetornar;
	}

	@Override
	public Funcion obtenerFuncion(String nombre) { // Ok Seba 23-10-2021
		ManejadorFuncion mF = ManejadorFuncion.getInstancia();
		return mF.buscarFuncion(nombre);
	}
}
// public int getCantidadEspectadoresRegistrados(String nombreFuncion){
// ManejadorFuncion mF = ManejadorFuncion.getInstancia();
// return mF.getCantidadEspectadoresRegistrados(nombreFuncion);
// }
