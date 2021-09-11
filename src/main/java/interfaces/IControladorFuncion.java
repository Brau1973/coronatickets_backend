package interfaces;

import java.util.List;

//import datatypes.DtHora;
import datatypes.DtFuncion;

import java.util.List;
import excepciones.FuncionRepetidaExcepcion;
import excepciones.FuncionYaRegistradaEnEspectaculoExcepcion;
import logica.Espectaculo;
import logica.Funcion;
import logica.Plataforma;

public interface IControladorFuncion{
	
	public void altaFuncion(DtFuncion dtFuncion, String nombreEspectaculo) throws FuncionYaRegistradaEnEspectaculoExcepcion;
    
    public List<DtFuncion> listarFunciones(String espectaculo);

}
