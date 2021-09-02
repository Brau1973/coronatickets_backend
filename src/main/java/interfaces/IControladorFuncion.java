package interfaces;

import excepciones.FuncionRepetidaExcepcion;
import logica.Funcion;

public interface IControladorFuncion{
    public void altaFuncion(Funcion funcion) throws FuncionRepetidaExcepcion;
}
