package interfaces;

import controladores.ControladorEspectaculo;
import controladores.ControladorPaquete;
import controladores.ControladorPlataforma;
import controladores.ControladorUsuario;

public class Fabrica{
    private static Fabrica instancia = null;

    private Fabrica(){
    }

    public static Fabrica getInstancia(){
	 if(instancia == null)
	     instancia = new Fabrica();
	 return instancia;
    }

    public IControladorPlataforma getIControladorPlataforma(){
	 return new ControladorPlataforma();
    }

    public IControladorPaquete getIControladorPaquete(){
	 return new ControladorPaquete();
    }

    public IControladorEspectaculo getIControladorEspectaculo(){
	 return new ControladorEspectaculo();
    }

    public IControladorUsuario getIControladorUsuario(){
	 return new ControladorUsuario();
    }
}
