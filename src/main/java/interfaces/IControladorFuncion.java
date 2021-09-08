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
	
	public void altaFuncion(DtFuncion dtFuncion) throws FuncionYaRegistradaEnEspectaculoExcepcion;
    
    //public DtFuncion obtenerFuncion(String nombre);
    
    public Funcion obtenerFuncion(String nombre);
    
    public List<Funcion> obtenerFuncionBD(String espectaculo);
    
    public List<DtFuncion> listarFuncionesDt(String espectaculo);
    
    // public String[] listarPlataformas();

    // public String[] listarEspectaculos(String plataforma);


}
