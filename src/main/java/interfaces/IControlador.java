package interfaces;

import excepciones.PlataformaRepetidaExcepcion;

public interface IControlador{
    public void altaEspectaculo(String artista, String plataforma, String nombre, String descripcion, int duracion, int cantMinEsp, int cantMaxEsp, String url, int costo);
    public void altaPlataforma(String nombre, String descripcion, String url) throws PlataformaRepetidaExcepcion;
}
