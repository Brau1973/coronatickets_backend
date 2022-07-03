package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import datatypes.DtFuncion;
import excepciones.FuncionYaRegistradaEnEspectaculoExcepcion;
import interfaces.IControladorFuncion;
import logica.Artista;
import logica.Espectaculo;
import logica.Espectador;
import logica.Funcion;
import logica.Registro;
import manejadores.ManejadorEspectaculo;
import manejadores.ManejadorFuncion;
import manejadores.ManejadorUsuario;
import persistencia.Conexion;

public class ControladorFuncion implements IControladorFuncion {

	public ControladorFuncion() {
		super();
	}

	@Override
	public void altaFuncion(DtFuncion dtFuncion, String nombreEspectaculo) throws FuncionYaRegistradaEnEspectaculoExcepcion {
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		Espectaculo espectaculo = mE.buscarEspectaculo(nombreEspectaculo);
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();

		if (espectaculo.funcionYaRegistrada(dtFuncion.getNombre())) {
			throw new FuncionYaRegistradaEnEspectaculoExcepcion("Error", "La Funcion " + dtFuncion.getNombre() + " ya esta registrada en el espectaculo " + espectaculo.getNombre());
		} else {
			ManejadorFuncion mF = ManejadorFuncion.getInstancia();
			List<Artista> artistas = new ArrayList<Artista>();
			dtFuncion.getArtistas().forEach((a) -> {
				artistas.add(mU.buscarArtista(a));
			});
			Funcion funcionACrear = new Funcion(dtFuncion.getNombre(), dtFuncion.getFecha(), dtFuncion.getHoraInicio(), dtFuncion.getRegistro(), artistas, espectaculo.getimageName());
			espectaculo.agregarFuncion(funcionACrear);
			mF.agregarFuncion(funcionACrear);
		}
	}

	@Override
	public List<DtFuncion> listarFunciones(String nomEsp) {
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		Espectaculo espectaculo = mE.buscarEspectaculo(nomEsp);
		List<DtFuncion> listFuncionesDt = new ArrayList<DtFuncion>();
		List<Funcion> listFunciones = espectaculo.getFunciones();
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		
		em.getTransaction().begin();
		for (Funcion f : listFunciones) {
			List<String> artistas = new ArrayList<String>();
			for (Artista a : f.getArtistas()) {
				artistas.add(a.getNickname());
			}
			DtFuncion DtFuncion = new DtFuncion(f.getNombre(), f.getFecha(), f.getHoraInicio(), f.getRegistro(), artistas,f.getImageName());
			listFuncionesDt.add(DtFuncion);
		}
		em.getTransaction().commit();
		return listFuncionesDt;
	}

	@Override
	public List<String> getFuncionesVigentesRegistradasPorEspectador(String nicknameEspectador) { // DEVUELVE TODAS LAS FUNCIONES (NOMBRES) EN LAS QUE SE REGISTRO UN ESPECTAODR																							// DADO, Y ESTAS SIGUEN VIGENTES
		List<String> funcionesARetornar = new ArrayList<String>();

		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Espectador espectador = mU.buscarEspectador(nicknameEspectador);

		List<Registro> registrosEspectador = new ArrayList<Registro>();
		registrosEspectador = espectador.getRegistros();

		for (Registro registro : registrosEspectador) {
			Date fecha = new Date();
			System.out.println(fecha);
			Funcion funcion = registro.getFuncion();
			if (funcion.getFecha().after(fecha) || funcion.getFecha().equals(fecha)) { // CARGA SOLAMENTE LAS FUNCIONES VIGENTES
				funcionesARetornar.add(funcion.getNombre());
			}
		}
		return funcionesARetornar;
	}
	
	@Override
	public boolean existeFuncion(String nomFun) {
		ManejadorFuncion mF = ManejadorFuncion.getInstancia();
		if(mF.buscarFuncion(nomFun) != null){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public DtFuncion getInfoFuncion (String nomFun) {
		ManejadorFuncion mF = ManejadorFuncion.getInstancia();
		Funcion funcion = (mF.buscarFuncion(nomFun));
		
		List<String> artistas = new ArrayList<String>();
		for (Artista a : funcion.getArtistas()) {
			artistas.add(a.getNickname());
		}
		
		DtFuncion infoFuncion = new DtFuncion(funcion.getNombre(),funcion.getFecha(),funcion.getHoraInicio(),funcion.getRegistro(),artistas, funcion.getImageName());
		
		return infoFuncion;
	}
	
}
// public int getCantidadEspectadoresRegistrados(String nombreFuncion){
// ManejadorFuncion mF = ManejadorFuncion.getInstancia();
// return mF.getCantidadEspectadoresRegistrados(nombreFuncion);
// }
