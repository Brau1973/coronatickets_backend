package interfaces;

//import datatypes.DtHora;
import excepciones.FuncionRepetidaExcepcion;
import logica.Funcion;

public interface IControladorFuncion{

    public void altaFuncion(Funcion funcion) throws FuncionRepetidaExcepcion;

    // public String[] listarPlataformas();

    // public String[] listarEspectaculos(String plataforma);

}
