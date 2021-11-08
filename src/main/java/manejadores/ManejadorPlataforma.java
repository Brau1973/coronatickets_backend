package manejadores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import logica.Plataforma;
import persistencia.Conexion;

@SuppressWarnings("unused")
public class ManejadorPlataforma{
    private static ManejadorPlataforma instancia = null;
   private static EntityManager em;
    private static EntityManagerFactory emf;

    private ManejadorPlataforma(){
    }

    public static ManejadorPlataforma getInstancia(){
	 if(instancia == null)
	     instancia = new ManejadorPlataforma();
	 return instancia;
    }

    public void altaPlataforma(Plataforma plataforma){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 em.getTransaction().begin();
	 em.persist(plataforma);
	 em.getTransaction().commit();
    }

    public Plataforma buscarPlataforma(String nombre){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 return em.find(Plataforma.class, nombre);
    }

    @SuppressWarnings("unchecked")
    public List<Plataforma> obtenerPlataforma(){ // NO SE DEBERIA USAR BORRAR UNA VEZ PASADO A DT
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 Query query = em.createQuery("select p from Plataforma p");
	 List<Plataforma> listPlataforma = (List<Plataforma>) query.getResultList();
	 return listPlataforma;
    }
    
    public List<Plataforma> obtenerPlataformas(){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 Query query = em.createQuery("select p from Plataforma p");
	 @SuppressWarnings("unchecked")
	List<Plataforma> listPlataformas = (List<Plataforma>) query.getResultList();
	 
	 return listPlataformas;
    }
}