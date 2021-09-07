package interfaces;


import java.util.List;

import datatypes.DtFuncion;
import excepciones.FuncionRepetidaExcepcion;
import logica.Funcion;

public interface IControladorFuncion{

    public void altaFuncion(DtFuncion dtFuncion) throws FuncionRepetidaExcepcion;

    public Funcion obtenerFuncion(String nombre);

    public List<Funcion> obtenerFuncionBD(String espectaculo);

    public List<Funcion> listarFunciones();

}
