package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion{
    private static Conexion instancia = null;
    private static EntityManagerFactory emf;
    private static EntityManager em;

    private Conexion(){
    }

    public static Conexion getInstancia(){
	 if(instancia == null){
	     instancia = new Conexion();
	     emf = Persistence.createEntityManagerFactory("bd_coronaTickets");
	     em = emf.createEntityManager();
	 }
	 return instancia;
    }

    @SuppressWarnings("static-access")
    public EntityManager getEntityManager(){
	 return this.em;
    }

    @SuppressWarnings("static-access")
    public void close(){
	 this.em.close();
	 this.emf.close();
    }

}