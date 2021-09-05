package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import datatypes.DtFuncion;
import excepciones.FuncionRepetidaExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorFuncion;
import interfaces.IControladorUsuario;
import logica.Artista;
import logica.Funcion;
import manejadores.ManejadorFuncion;
import persistencia.Conexion;

public class ControladorFuncion implements IControladorFuncion {

	public ControladorFuncion() {
		super();
	}

	public void altaFuncion(DtFuncion dtFuncion) throws FuncionRepetidaExcepcion {
		ManejadorFuncion mF = ManejadorFuncion.getInstancia();
		Funcion funcion = mF.buscarFuncion(dtFuncion.getNombre());
//     if (funcion != null)
//         throw new FuncionRepetidaExcepcion("La Funcion "+ dtFuncion.getNombre() + "ya esta registrada");
		IControladorUsuario iconU = Fabrica.getInstancia().getIControladorUsuario();
		List<Artista> artistas = new ArrayList<Artista>();
		dtFuncion.getArtistas().forEach((a) -> {
			artistas.add(iconU.obtenerArtista(a));

		});
		
		Funcion funcionACrear = new Funcion(dtFuncion.getNombre(), dtFuncion.getFecha(), dtFuncion.getHoraInicio(),
				dtFuncion.getRegistro(), artistas);
		
		IControladorEspectaculo iconE = Fabrica.getInstancia().getIControladorEspectaculo();
		funcionACrear.setEspectaculo(iconE.obtenerEspectaculo(dtFuncion.getEspectaculo()));
		
		mF.agregarFuncion(funcionACrear);
	}
}
