package interfaces;

import java.util.List;

import excepciones.PlataformaRepetidaExcepcion;
import logica.Plataforma;


public interface IControladorPlataforma{
    public void altaPlataforma(String nombre, String descripcion, String url) throws PlataformaRepetidaExcepcion;

    public List<Plataforma> listarPlataformas();
}