package logica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import datatypes.DtEspectaculo;
import excepciones.PlataformaRepetidaExcepcion;
import interfaces.IControlador;


public class Controlador implements IControlador{
    private static EntityManager em;
    private static EntityManagerFactory emf;

    public Controlador(){
	 super();
    }

    public void altaEspectaculo(DtEspectaculo dte){
	 ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
	 Espectaculo espectaculo = new Espectaculo(dte.getArtista(), dte.getPlataforma(), dte.getNombre(), dte.getDescripcion(), dte.getDuracion(), dte.getCantMin(), dte.getCantMax(), dte.getUrl(), dte.getCosto(), dte.getRegistro());
	 mE.agregarEspectaculo(espectaculo);
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