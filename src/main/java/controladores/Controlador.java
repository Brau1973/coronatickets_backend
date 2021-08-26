package controladores;

import excepciones.PlataformaRepetidaExcepcion;
import interfaces.IControlador;
import logica.Plataforma;
import manejadores.ManejadorPlataforma;

public class Controlador implements IControlador{

    public Controlador(){
	 super();
    }

    public void altaPlataforma(String nombre, String descripcion, String url) throws PlataformaRepetidaExcepcion{
	 ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
	 Plataforma plataforma = mP.buscarPlataforma(nombre);
	 if(plataforma != null)
	     throw new PlataformaRepetidaExcepcion("la plataforma " + nombre + " ya esta existe");
	 plataforma = new Plataforma(nombre, descripcion, url);
	 mP.altaPlataforma(plataforma);
    }

}