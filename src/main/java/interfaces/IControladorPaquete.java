package interfaces;

import java.util.List;

import datatypes.DtEspectaculo;
import datatypes.DtPaqueteEspectaculos;

public interface IControladorPaquete {
	public void altaPaquete(DtPaqueteEspectaculos dtPaqueteEsp);

	public Boolean existePaquete(String nombre);

	public List<DtPaqueteEspectaculos> obtenerPaquetes();

	public void agregarEspectaculo(String paquete, String espectaculo);

	List<DtEspectaculo> getEspectaculosDePaquete(String paquete);

	DtPaqueteEspectaculos getInfoPaquete(String nomPaquete);
}