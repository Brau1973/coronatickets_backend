package interfaces;

import java.util.List;

import datatypes.DtFuncion;
import excepciones.FuncionYaRegistradaEnEspectaculoExcepcion;

public interface IControladorFuncion{
    public void altaFuncion(DtFuncion dtFuncion, String nombreEspectaculo) throws FuncionYaRegistradaEnEspectaculoExcepcion;

    public List<DtFuncion> listarFunciones(String espectaculo);
    
   // public int getCantidadEspectadoresRegistrados(String nombreFuncion);
}