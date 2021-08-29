package interfaces;

import java.util.Date;

import datatypes.DtHora;
import excepciones.FuncionRepetidaExcepcion;

public interface IControladorFuncion{
	
	public void altaFuncion(String nombre, String espectaculo, Date fecha, DtHora horaInicio, String artistas, Date registro) throws FuncionRepetidaExcepcion;
	
	public String[] listarPlataformas();

}
