package controladores;

import java.util.List;

import datatypes.DtEspectaculo;
import datatypes.DtPlataforma;
import excepciones.PlataformaRepetidaExcepcion;
import interfaces.IControladorPlataforma;
import logica.Plataforma;
import manejadores.ManejadorPlataforma;

public class ControladorPlataforma implements IControladorPlataforma{

    public ControladorPlataforma(){
	 super();
    }

    public void altaPlataforma(DtPlataforma dtPlataforma) throws PlataformaRepetidaExcepcion{
	 ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
	 Plataforma plataforma = mP.buscarPlataforma(dtPlataforma.getNombre());
	 if(plataforma != null)
	     throw new PlataformaRepetidaExcepcion("la plataforma " + dtPlataforma.getNombre() + " ya esta existe");
	 plataforma = new Plataforma(dtPlataforma.getNombre(), dtPlataforma.getDescripcion(), dtPlataforma.getUrl());
	 mP.altaPlataforma(plataforma);
    }

    public List<Plataforma> listarPlataformas(){ // NO SE DEBERIA USAR, LA CORRECTA ES listarPlataformasDt
	 ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
	 return mP.obtenerPlataforma();
    }
    
    public List<String> listarPlataformasDt(){
	 ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
	 return mP.obtenerPlataformas();
    }
    
    public Plataforma buscarPlataforma(String nombrePlataforma){
	 ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
	 Plataforma plataforma = mP.buscarPlataforma(nombrePlataforma);
	 return plataforma;
	 
    }
}