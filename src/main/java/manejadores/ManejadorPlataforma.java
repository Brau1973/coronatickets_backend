package manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import datatypes.DtEspectaculo;
import logica.Artista;
import logica.Funcion;
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
    
    public List<String> obtenerPlataformas(){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 Query query = em.createQuery("select p from Plataforma p");
	 List<Plataforma> listPlataformas = (List<Plataforma>) query.getResultList();
	 
	 List<String> listPlataformasDt = new ArrayList<String>();
	 for(Plataforma p :listPlataformas){
		 listPlataformasDt.add((p.getNombre()));
	 }
	 return listPlataformasDt;
    }

	public List<DtEspectaculo> obtenerEspectaculos(String nombrePlataforma) {
		Plataforma plataforma = this.buscarPlataforma(nombrePlataforma);
		return plataforma.getEspectaculosDt();
	}
}