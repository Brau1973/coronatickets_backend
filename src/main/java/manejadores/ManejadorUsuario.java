package manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import logica.Usuario;
import persistencia.Conexion;

public class ManejadorUsuario{
    private static ManejadorUsuario instancia = null;
    private static EntityManager em;
    private static EntityManagerFactory emf;

    private ManejadorUsuario(){
    }

    public static ManejadorUsuario getInstancia(){
	 if(instancia == null)
	     instancia = new ManejadorUsuario();
	 return instancia;
    }

    public void altaUsuario(Usuario u){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 em.getTransaction().begin();
	 em.persist(u);
	 em.getTransaction().commit();
    }

    public Usuario buscarUsuario(String nickname){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();

	 Usuario u = em.find(Usuario.class, nickname);
	 return u;
    }


    public ArrayList<String> obtenerUsuario(){ 
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();

	 Query query = em.createQuery("select u from Usuario u");
	 List<Usuario> listUsuario = (List<Usuario>) query.getResultList();

	 ArrayList<String> aRetornar = new ArrayList<>();
	 for(Usuario u :listUsuario){
	     aRetornar.add(u.getNickname());
	 }
	 return aRetornar;
    }

}