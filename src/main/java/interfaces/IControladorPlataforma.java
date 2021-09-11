package interfaces;

import java.util.List;

import datatypes.DtEspectaculo;
import datatypes.DtPlataforma;
import excepciones.PlataformaRepetidaExcepcion;
import logica.Plataforma;

public interface IControladorPlataforma{
    public void altaPlataforma(DtPlataforma dtPlataforma) throws PlataformaRepetidaExcepcion;

    public List<DtPlataforma> listarPlataformas();
    
    public List<String> listarPlataformasStr();
    
    public Plataforma buscarPlataforma(String nombrePlataforma);
}