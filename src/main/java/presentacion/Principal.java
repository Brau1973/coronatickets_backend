package presentacion;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import logica.Artista;
import logica.Espectador;
import logica.Usuario;
import persistencia.Conexion;

public class Principal{
	
	//private static EntityManagerFactory emf;
	//private static EntityManager em;
	    
    public static void main(String[] args){
    	
    //	emf = Persistence.createEntityManagerFactory("bd_coronaTickets");
    //	em = emf.createEntityManager();
   // 	Usuario us1 = new Espectador("seba","sebastian","gonzalez", "sebaasdasdasd", new Date(12,12,2021));
    //	Usuario us2 = new Artista("sebw","sebastiaw","gonzalew", "sebaasdasdasw", new Date(12,12,2021),"descripcion","bio","url");
    //	Conexion conexion = Conexion.getInstancia();
    	
    //EntityManager em = conexion.getEntityManager();
   //	 em.getTransaction().begin();
   //	 em.persist(us1);
  //	em.persist(us2);
  // 	 em.getTransaction().commit();
   //	 em.close();
   //	 emf.close();
    	
    	
    	
	 FrmPrincipal frmInicio = new FrmPrincipal();
	 frmInicio.setVisible(true);
    }
}