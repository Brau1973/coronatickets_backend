package interfaces;

import Controladores.ControladorEspectaculo;
import Controladores.ControladorPaquete;
import Controladores.ControladorPlataforma;
import Controladores.ControladorFuncion;

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
    
    public IControladorFuncion getIControladorFuncion(){
   	 return new ControladorFuncion();
       }
}
