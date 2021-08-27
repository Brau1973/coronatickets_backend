package Controladores;

import java.util.List;

import Manejadores.ManejadorPaquete;
import interfaces.IControladorPaquete;
import logica.PaqueteEspectaculos;


public class ControladorPaquete implements IControladorPaquete{
	
    @Override
	public void altaPaquete(PaqueteEspectaculos pEsp) {
    	ManejadorPaquete mP = ManejadorPaquete.getInstancia();
    	mP.altaPaquete(pEsp);
	}
    
	@Override
	public Boolean existePaquete(String nombre) {
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		return mP.existePaquete(nombre);
	}

	@Override
	public List<PaqueteEspectaculos> obtenerPaquetes() {
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		return mP.obtenerPaquetes();
	}

}