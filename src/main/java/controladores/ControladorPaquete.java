package controladores;

import interfaces.IControladorPaquete;
import logica.PaqueteEspectaculos;
import manejadores.ManejadorPaquete;

public class ControladorPaquete implements IControladorPaquete{

    @Override
    public void altaPaquete(PaqueteEspectaculos pEsp){
	 ManejadorPaquete mP = ManejadorPaquete.getInstancia();
	 mP.altaPaquete(pEsp);
    }

    @Override
    public Boolean existePaquete(String nombre){
	 ManejadorPaquete mP = ManejadorPaquete.getInstancia();
	 return mP.existePaquete(nombre);
    }

}