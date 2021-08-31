package manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import logica.Plataforma;
import persistencia.Conexion;

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

	 Plataforma plataforma = em.find(Plataforma.class, nombre);
	 return plataforma;
    }


    public List<Plataforma> obtenerPlataforma(){ // 79S
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();

	 Query query = em.createQuery("select p from Plataforma p");
	 List<Plataforma> listPlataforma = (List<Plataforma>) query.getResultList();

	 return listPlataforma;
    }
    
    

}