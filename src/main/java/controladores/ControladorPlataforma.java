package controladores;

import java.util.List;

import excepciones.PlataformaRepetidaExcepcion;
import interfaces.IControladorPlataforma;
import logica.Plataforma;
import manejadores.ManejadorPlataforma;

public class ControladorPlataforma implements IControladorPlataforma{

    public ControladorPlataforma(){
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

    public List<Plataforma> listarPlataformas(){
	 ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
	 return mP.obtenerPlataforma();
    }

}