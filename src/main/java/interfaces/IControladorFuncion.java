package interfaces;

import java.util.List;

import datatypes.DtFuncion;
import logica.Funcion;

public interface IControladorFuncion {
	public void altaFuncion(DtFuncion dtFuncion, String nombreEspectaculo, byte[] imagen);

	public List<DtFuncion> listarFunciones(String nomEsp);

	public List<String> getFuncionesVigentesRegistradasPorEspectador(String nicknameEspectador);

	public Funcion obtenerFuncion(String nombre);
	// public int getCantidadEspectadoresRegistrados(String nombreFuncion);
}