package interfaces;

import java.util.List;

import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtPaqueteEspectaculo;
import excepciones.EspectaculoRepetidoExcepcion;
import logica.Espectaculo;

public interface IControladorEspectaculo{
    public void altaEspectaculo(DtEspectaculo dte, String nombrePlataforma) throws EspectaculoRepetidoExcepcion;

    // public void agregarFuncion(String nombreEspectaculo,String nombreFuncion) throws FuncionYaRegistradaEnEspectaculoExcepcion;

    public List<DtEspectaculo> listarEspectaculos(String nombrePlataforma);
    
    public List<String> obtenerEspectaculosArtista(String nickname);
    
	public List<DtEspectaculo> listEntityToDtEsp(List<Espectaculo> dte);
	public List<DtEspectaculo> obtenerAllDtEspectaculos(String nickname);
	
	public List<DtFuncion> obtenerEspectaculoFunciones(String nombreEsp);
	
	public List<DtPaqueteEspectaculo> obtenerEspectaculoPaquetes(String nombreEsp);
}