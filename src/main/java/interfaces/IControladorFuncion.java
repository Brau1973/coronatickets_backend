package interfaces;

import java.util.List;

import excepciones.FuncionRepetidaExcepcion;
import logica.Funcion;

public interface IControladorFuncion{
    public void altaFuncion(Funcion funcion) throws FuncionRepetidaExcepcion;

    public Funcion obtenerFuncion(String nombre);

    public List<Funcion> obtenerFuncionBD(String espectaculo);
}
