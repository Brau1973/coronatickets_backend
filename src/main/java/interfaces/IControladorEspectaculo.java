package interfaces;

import datatypes.DtEspectaculo;
import excepciones.EspectaculoRepetidoExcepcion;

public interface IControladorEspectaculo{
    public void altaEspectaculo(DtEspectaculo dte) throws EspectaculoRepetidoExcepcion;

    public String[] listarPlataformas();
}