package interfaces;

import java.util.List;

import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtPaqueteEspectaculos;
import excepciones.EspectaculoRepetidoExcepcion;

public interface IControladorEspectaculo{
    public void altaEspectaculo(DtEspectaculo dte, String nombrePlataforma) throws EspectaculoRepetidoExcepcion;

    public List<DtEspectaculo> listarEspectaculos(String nombrePlataforma);
    
    public List<String> obtenerEspectaculosArtista(String nickname);
    
	public List<DtEspectaculo> obtenerAllDtEspectaculos(String nickname);
	
	public List<DtFuncion> obtenerEspectaculoFunciones(String nombreEsp);
	
	public List<DtPaqueteEspectaculos> obtenerEspectaculoPaquetes(String nombreEsp);
	
	public boolean existeEspectaculo(String nombreEsp);
}