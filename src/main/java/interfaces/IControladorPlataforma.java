package interfaces;

import java.util.List;

import excepciones.PlataformaRepetidaExcepcion;
import logica.Plataforma;
import datatypes.DtPlataforma;

public interface IControladorPlataforma{
	//public void agregarPlataforma(DtPlataforma dtp);
	public void altaPlataforma(DtPlataforma dtPlataforma) throws PlataformaRepetidaExcepcion;

	public List<DtPlataforma> listarPlataformas();

	public List<String> listarPlataformasStr();
	
	public boolean existePlataforma(String nombrePlataforma);
}