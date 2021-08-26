package interfaces;

import controladores.Controlador;
import controladores.ControladorEspectaculo;
import controladores.ControladorPaquete;

public class Fabrica{
    private static Fabrica instancia = null;

    private Fabrica(){
    }

    public static Fabrica getInstancia(){
	 if(instancia == null)
	     instancia = new Fabrica();
	 return instancia;
    }

    public IControlador getIControlador(){
	 return new Controlador();
    }

    public IControladorPaquete getIControladorPaquete(){
	 return new ControladorPaquete();
    }

    public IControladorEspectaculo getIControladorEspectaculo(){
	 return new ControladorEspectaculo();
    }
}
