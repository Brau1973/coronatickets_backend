package interfaces;

import logica.PaqueteEspectaculos;

public interface IControladorPaquete{
    public void altaPaquete(PaqueteEspectaculos pEsp);

    public Boolean existePaquete(String nombre);
}