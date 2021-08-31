package interfaces;

import java.util.List;

import datatypes.DtEspectaculo;
import excepciones.EspectaculoRepetidoExcepcion;
import logica.Espectaculo;
import logica.Plataforma;

public interface IControladorEspectaculo{
    public void altaEspectaculo(DtEspectaculo dte) throws EspectaculoRepetidoExcepcion;

    public List<Espectaculo> listarEspectaculos();

    //public String[] listarArtistas();
}