package controladores;

import java.util.List;

import excepciones.FuncionRepetidaExcepcion;
import interfaces.IControladorFuncion;
import logica.Funcion;
import manejadores.ManejadorFuncion;

public class ControladorFuncion implements IControladorFuncion{

    public ControladorFuncion(){
	 super();
    }

    public void altaFuncion(Funcion funcion) throws FuncionRepetidaExcepcion{
	 ManejadorFuncion mF = ManejadorFuncion.getInstancia();
	 mF.agregarFuncion(funcion);
    }

    public Funcion obtenerFuncion(String nombre){
	 ManejadorFuncion mF = ManejadorFuncion.getInstancia();
	 return mF.buscarFuncion(nombre);
    }

    public List<Funcion> obtenerFuncionBD(String espectaculo){
	 ManejadorFuncion mF = ManejadorFuncion.getInstancia();
	 return mF.obtenerFuncionesBD(espectaculo);
    }

}
