package interfaces;

import java.util.List;

import datatypes.DtEspectaculo;
import excepciones.EspectaculoRepetidoExcepcion;
import logica.Espectaculo;

public interface IControladorEspectaculo{
    public void altaEspectaculo(DtEspectaculo dte) throws EspectaculoRepetidoExcepcion;

    public List<Espectaculo> listarEspectaculos();

    public Espectaculo obtenerEspectaculo(String nombre);
    
    public List<Espectaculo> obtenerEspectaculo2(String plataforma);
}