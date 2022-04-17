package interfaces;

import java.util.List;

import datatypes.DtPaqueteEspectaculo;
import logica.PaqueteEspectaculos;

public interface IControladorPaquete {
	public void altaPaquete(DtPaqueteEspectaculo dtPaqueteEsp);

	public Boolean existePaquete(String nombre);

	public List<DtPaqueteEspectaculo> obtenerPaquetes();

	public void agregarEspectaculo(String paquete, String espectaculo);

	DtPaqueteEspectaculo mapEntityToDt(PaqueteEspectaculos p);

	public List<DtPaqueteEspectaculo> mapListEntityToDt(List<PaqueteEspectaculos> p);
}