package interfaces;

import java.util.List;

import datatypes.DtFuncion;
import excepciones.FuncionYaRegistradaEnEspectaculoExcepcion;

public interface IControladorFuncion{
    public void altaFuncion(DtFuncion dtFuncion, String nombreEspectaculo, byte[] imagen) throws FuncionYaRegistradaEnEspectaculoExcepcion; //, FuncionRepetidaExcepcion;

    public List<DtFuncion> listarFunciones(String nomEsp);

    public List<String> getFuncionesVigentesRegistradasPorEspectador(String nicknameEspectador);
    
    public boolean existeFuncion(String nomFun);
    
   // public int getCantidadEspectadoresRegistrados(String nombreFuncion);
}