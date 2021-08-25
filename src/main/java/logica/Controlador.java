package logica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import excepciones.PlataformaRepetidaExcepcion;
import interfaces.IControlador;
import persistencia.Conexion;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;


public class Controlador implements IControlador{
   private static EntityManager em;
   private static EntityManagerFactory emf;

    public Controlador(){
	 super();
    }

    public void altaEspectaculo(String artista, String plataforma, String nombre, String descripcion, int duracion, int cantMinEsp, int cantMaxEsp, String url, int costo){
	 emf = Persistence.createEntityManagerFactory("bd_coronaTickets");
	 em = emf.createEntityManager();
	 em.getTransaction().begin();
	 Espectaculo espectaculo = new Espectaculo(artista, plataforma, nombre, descripcion, duracion, cantMinEsp, cantMaxEsp, url, costo);
	 em.persist(espectaculo);
	 em.getTransaction().commit();
	 em.close();
    }
    
  
	public void altaPlataforma(String nombre, String descripcion, String url) throws PlataformaRepetidaExcepcion { 
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
        Plataforma plataforma = mP.buscarPlataforma(nombre);
        if (plataforma != null)
           throw new PlataformaRepetidaExcepcion("la plataforma " + nombre + " ya esta existe");
		plataforma = new Plataforma(nombre, descripcion, url);
		mP.altaPlataforma(plataforma);
	
	    }
	}

