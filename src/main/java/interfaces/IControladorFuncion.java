package interfaces;

import java.util.List;

import datatypes.DtFuncion;
import excepciones.FuncionYaRegistradaEnEspectaculoExcepcion;
import logica.Funcion;

public interface IControladorFuncion{
    public void altaFuncion(DtFuncion dtFuncion, String nombreEspectaculo) throws FuncionYaRegistradaEnEspectaculoExcepcion;

    public List<DtFuncion> listarFunciones(String espectaculo);
    public List<Funcion> listarFunciones2(String espectaculo);
}