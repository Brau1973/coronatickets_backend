package interfaces;

import java.util.List;

import excepciones.PlataformaRepetidaExcepcion;
import datatypes.DtPlataforma;
import logica.Plataforma;

public interface IControladorPlataforma{
	//public void agregarPlataforma(DtPlataforma dtp);
	public void altaPlataforma(DtPlataforma dtPlataforma) throws PlataformaRepetidaExcepcion;

	public List<DtPlataforma> listarPlataformas();

	public List<String> listarPlataformasStr();

	public List<DtPlataforma> mapListEntityToDt(List<Plataforma> p);

	public DtPlataforma mapEntityToDt(Plataforma p);
}