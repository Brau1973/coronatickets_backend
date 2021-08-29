package interfaces;

import excepciones.PlataformaRepetidaExcepcion;


public interface IControladorPlataforma{
    public void altaPlataforma(String nombre, String descripcion, String url) throws PlataformaRepetidaExcepcion;

	
}