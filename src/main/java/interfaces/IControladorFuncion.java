package interfaces;

import java.util.List;

//import datatypes.DtHora;
import datatypes.DtFuncion;
import excepciones.FuncionRepetidaExcepcion;
import logica.Espectaculo;
import logica.Funcion;
import logica.Plataforma;

public interface IControladorFuncion{

	public void altaFuncion(DtFuncion dtFuncion) throws FuncionRepetidaExcepcion;

    public List<Funcion> listarFunciones();
    
    public Funcion obtenerFuncion(String nombre);
    
    // public String[] listarPlataformas();

    // public String[] listarEspectaculos(String plataforma);

}
