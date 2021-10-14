package controladores;

import datatypes.DtRegistro;
import interfaces.IControladorRegistro;
import logica.Espectador;
import logica.Funcion;
import logica.Registro;
import manejadores.ManejadorFuncion;
import manejadores.ManejadorRegistro;
import manejadores.ManejadorUsuario;

public class ControladorRegistro  implements IControladorRegistro{

	public ControladorRegistro() {
		super();
	}
	
	public void altaRegistro(DtRegistro dtRegistro, String nicknameEspectador) {
		
		ManejadorFuncion mF = ManejadorFuncion.getInstancia();
		Funcion funcion = mF.buscarFuncion(dtRegistro.getFuncion());
		
		Registro registro = new Registro(funcion,dtRegistro.getFechaRegistro(),dtRegistro.getCosto());
		
		funcion.agregarRegistro(registro);
		
    	ManejadorUsuario mU = ManejadorUsuario.getInstancia();
    	Espectador espectador = mU.buscarEspectador(nicknameEspectador);
    	espectador.agregarRegistro(registro);
		
		ManejadorRegistro mR = ManejadorRegistro.getInstancia();
		mR.agregarRegistro(registro);
	}

}
