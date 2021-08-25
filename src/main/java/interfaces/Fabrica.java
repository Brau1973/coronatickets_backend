package interfaces;

import logica.Controlador;

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
}
