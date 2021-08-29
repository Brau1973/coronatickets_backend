package controladores;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import datatypes.DtHora;
import excepciones.FuncionRepetidaExcepcion;
import manejadores.ManejadorFuncion;
import interfaces.IControladorFuncion;
import logica.Funcion;


public class ControladorFuncion implements IControladorFuncion {
	
	public ControladorFuncion(){
		 super();
	}
	
	@Override
	public void altaFuncion(String nombre, String espectaculo, Date fecha, DtHora horaInicio, String artistas, Date registro) throws FuncionRepetidaExcepcion{
		ManejadorFuncion mF = ManejadorFuncion.getInstancia();
		Funcion funcion = mF.buscarFuncion(nombre);
		if (funcion != null)
            throw new FuncionRepetidaExcepcion("La funcion " + nombre + " ya esta registrada");
		funcion = new Funcion(nombre, espectaculo, fecha, horaInicio, artistas, registro);
		mF.agregarFuncion(funcion);
	}
	
	
	@Override
	public String[] listarPlataformas() {
		ArrayList<String> plataformas;
		ManejadorFuncion mP = ManejadorFuncion.getInstancia();
		plataformas = mP.obtenerPlataforma();
		String[] plataformas_ret = new String[plataformas.size()];
		int i=0;
		for(String id:plataformas) {
			plataformas_ret[i] = id;
			i++;
		}
		return plataformas_ret;
	}

}
