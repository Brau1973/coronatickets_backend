package interfaces;

import java.util.List;

import logica.PaqueteEspectaculos;

public interface IControladorPaquete{
    public void altaPaquete(PaqueteEspectaculos pEsp);

    public Boolean existePaquete(String nombre);

    public List<PaqueteEspectaculos> obtenerPaquetes();
}