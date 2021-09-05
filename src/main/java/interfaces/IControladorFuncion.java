package interfaces;

import datatypes.DtFuncion;
import excepciones.FuncionRepetidaExcepcion;
import logica.Funcion;

public interface IControladorFuncion{
	public void altaFuncion(DtFuncion dtFuncion) throws FuncionRepetidaExcepcion;
}
