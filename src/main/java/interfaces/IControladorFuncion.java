package interfaces;

import java.util.List;

import datatypes.DtFuncion;
import excepciones.FuncionYaRegistradaEnEspectaculoExcepcion;

public interface IControladorFuncion{
    public void altaFuncion(DtFuncion dtFuncion, String nombreEspectaculo, byte[] imagen) throws FuncionYaRegistradaEnEspectaculoExcepcion;

    public List<DtFuncion> listarFunciones(String nomEsp);
    
    public List<String> getFuncionesVigentesRegistradasPorEspectador(String nicknameEspectador);
    
   // public int getCantidadEspectadoresRegistrados(String nombreFuncion);
}