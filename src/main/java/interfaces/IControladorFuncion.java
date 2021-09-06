package interfaces;

import datatypes.DtFuncion;

import java.util.List;
import excepciones.FuncionRepetidaExcepcion;
import logica.Espectaculo;
import logica.Funcion;
import logica.Plataforma;

public interface IControladorFuncion{
	
	public void altaFuncion(DtFuncion dtFuncion) throws FuncionRepetidaExcepcion;


    public void altaFuncion(Funcion funcion) throws FuncionRepetidaExcepcion;

    public List<Funcion> listarFunciones();
    
    public Funcion obtenerFuncion(String nombre);
    
    public List<Funcion> obtenerFuncionBD(String espectaculo);
    
    // public String[] listarPlataformas();

    // public String[] listarEspectaculos(String plataforma);

}
