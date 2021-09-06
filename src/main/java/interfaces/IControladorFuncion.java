package interfaces;

<<<<<<< HEAD
import java.util.List;

//import datatypes.DtHora;
=======
import datatypes.DtFuncion;
>>>>>>> 6c8a5d938bb3ef6d18e666bd22ba8210faea9619
import excepciones.FuncionRepetidaExcepcion;
import logica.Espectaculo;
import logica.Funcion;
import logica.Plataforma;

public interface IControladorFuncion{
<<<<<<< HEAD

    public void altaFuncion(Funcion funcion) throws FuncionRepetidaExcepcion;

    public List<Funcion> listarFunciones();
    
    public Funcion obtenerFuncion(String nombre);
    
    // public String[] listarPlataformas();

    // public String[] listarEspectaculos(String plataforma);

=======
	public void altaFuncion(DtFuncion dtFuncion) throws FuncionRepetidaExcepcion;
>>>>>>> 6c8a5d938bb3ef6d18e666bd22ba8210faea9619
}
