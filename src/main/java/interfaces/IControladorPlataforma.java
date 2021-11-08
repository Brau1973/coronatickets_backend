package interfaces;

import java.util.List;

import datatypes.DtPlataforma;
import logica.Plataforma;

public interface IControladorPlataforma{
	//public void agregarPlataforma(DtPlataforma dtp);
	public void altaPlataforma(DtPlataforma dtPlataforma);

	public List<DtPlataforma> listarPlataformas();

	public List<String> listarPlataformasStr();

	public Plataforma buscarPlataforma(String nombrePlataforma);

	public List<DtPlataforma> mapListEntityToDt(List<Plataforma> p);

	public DtPlataforma mapEntityToDt(Plataforma p);
}