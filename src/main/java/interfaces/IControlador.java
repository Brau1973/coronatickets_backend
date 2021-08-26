package interfaces;

import datatypes.DtEspectaculo;
import excepciones.PlataformaRepetidaExcepcion;

public interface IControlador{
    public void altaEspectaculo(DtEspectaculo dte);

    public String[] listarPlataformas();

    public void altaPlataforma(String nombre, String descripcion, String url) throws PlataformaRepetidaExcepcion;
}