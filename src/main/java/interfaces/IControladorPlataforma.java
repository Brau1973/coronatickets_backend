package interfaces;

import java.util.List;

import datatypes.DtEspectaculo;
import excepciones.PlataformaRepetidaExcepcion;
import logica.Plataforma;

public interface IControladorPlataforma{
    public void altaPlataforma(String nombre, String descripcion, String url) throws PlataformaRepetidaExcepcion;

    public List<Plataforma> listarPlataformas();
    
    public List<String> listarPlataformasDt();
    
    public List<DtEspectaculo> listarEspectaculos(String nombrePlataforma);
}