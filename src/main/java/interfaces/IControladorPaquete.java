package interfaces;

import java.util.List;

import datatypes.DtPaqueteEspectaculo;

public interface IControladorPaquete {
	public void altaPaquete(DtPaqueteEspectaculo dtPaqueteEsp);

	public Boolean existePaquete(String nombre);

	public List<DtPaqueteEspectaculo> obtenerPaquetes();

	public void agregarEspectaculo(String paquete, String espectaculo);
}