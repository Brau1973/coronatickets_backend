package controladores;

import java.util.Date;

import javax.persistence.EntityManager;

import excepciones.FuncionRepetidaExcepcion;
import interfaces.IControladorFuncion;
import logica.Funcion;
import manejadores.ManejadorFuncion;
import persistencia.Conexion;

public class ControladorFuncion implements IControladorFuncion{

    public ControladorFuncion(){
	 super();
    }

    public void altaFuncion(Funcion funcion) throws FuncionRepetidaExcepcion{
	 ManejadorFuncion mF = ManejadorFuncion.getInstancia();
	 mF.agregarFuncion(funcion);
    }
}
