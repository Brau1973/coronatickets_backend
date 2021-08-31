package controladores;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import datatypes.DtHora;
import excepciones.FuncionRepetidaExcepcion;
import manejadores.ManejadorFuncion;
import manejadores.ManejadorPlataforma;
import interfaces.IControladorFuncion;
import logica.Artista;
import logica.Espectaculo;
import logica.Funcion;

public class ControladorFuncion implements IControladorFuncion {
	
	public ControladorFuncion(){
		 super();
	}
	
	@Override
	public void altaFuncion(String nombre, Espectaculo espectaculo, Date fecha, Time horaInicio, List<Artista> artistas, Date registro) throws FuncionRepetidaExcepcion{
		ManejadorFuncion mF = ManejadorFuncion.getInstancia();
		Funcion funcion = mF.buscarFuncion(nombre);
		if (funcion != null)
            throw new FuncionRepetidaExcepcion("La funcion " + nombre + " ya esta registrada");
		funcion = new Funcion(nombre, espectaculo, fecha, horaInicio, artistas, registro);
		mF.agregarFuncion(funcion);
	}
	
	
//	@Override
//	public String[] listarPlataformas() {
//		ArrayList<String> plataformas;
//		ManejadorFuncion mF = ManejadorFuncion.getInstancia();
//		plataformas = mF.obtenerPlataforma();
//		String[] plataformas_ret = new String[plataformas.size()];
//		int i=0;
//		for(String id:plataformas) {
//			plataformas_ret[i] = id;
//			i++;
//		}
//		return plataformas_ret;
//	}
	
//	@Override
//	public Plataforma[] listarPlataformas() {
//		ArrayList<String> plataformas;
//		ManejadorFuncion mF = ManejadorFuncion.getInstancia();
//		plataformas = mF.obtenerPlataforma();
//		String[] plataformas_ret = new String[plataformas.size()];
//		int i=0;
//		for(String id:plataformas) {
//			plataformas_ret[i] = id;
//			i++;
//		}
//		return plataformas_ret;
//	}

//	@Override
//	public String[] listarEspectaculos(String plataforma) {
//		ArrayList<String> espectaculos;
//		ManejadorFuncion mF = ManejadorFuncion.getInstancia();
//		espectaculos = mF.obtenerEspectaculo(plataforma);
//		String[] espectaculos_ret = new String[espectaculos.size()];
//		int i=0;
//		for(String id:espectaculos) {
//			espectaculos_ret[i] = id;
//			i++;
//		}
//		return espectaculos_ret;
//	}
//	
}
