package interfaces;

import excepciones.PlataformaRepetidaExcepcion;

public interface IControlador{
    public void altaPlataforma(String nombre, String descripcion, String url) throws PlataformaRepetidaExcepcion;
}