package interfaces;

import java.util.List;

import datatypes.DtEspectaculo;
import excepciones.EspectaculoRepetidoExcepcion;
import logica.Espectaculo;

public interface IControladorEspectaculo{
    public void altaEspectaculo(DtEspectaculo dte, String nombrePlataforma) throws EspectaculoRepetidoExcepcion;

    public Espectaculo obtenerEspectaculo(String nombre);

    // public void agregarFuncion(String nombreEspectaculo,String nombreFuncion) throws FuncionYaRegistradaEnEspectaculoExcepcion;

    public List<Espectaculo> obtenerEspectaculo2(String plataforma);

    public List<DtEspectaculo> listarEspectaculos(String nombrePlataforma);
    
    public List<String> obtenerEspectaculosArtista(String nickname);

}