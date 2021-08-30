package interfaces;

import java.sql.Time;
import java.util.Date;
import java.util.List;

//import datatypes.DtHora;
import excepciones.FuncionRepetidaExcepcion;
import logica.Artista;
import logica.Espectaculo;

public interface IControladorFuncion{
	
	public void altaFuncion(String nombre, Espectaculo espectaculo, Date fecha, Time horaInicio, List<Artista> artistas, Date registro) throws FuncionRepetidaExcepcion;
	
	public String[] listarPlataformas();
	
	public String[] listarEspectaculos(String plataforma);

}
