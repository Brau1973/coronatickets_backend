package interfaces;

import datatypes.DtEspectaculo;
import excepciones.PlataformaRepetidaExcepcion;

public interface IControlador{
    public void altaEspectaculo(DtEspectaculo dte);

    public void altaPlataforma(String nombre, String descripcion, String url) throws PlataformaRepetidaExcepcion;
}