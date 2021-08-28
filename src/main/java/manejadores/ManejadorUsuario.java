package manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import logica.Usuario;
import persistencia.Conexion;

public class ManejadorUsuario{
    private static ManejadorUsuario instancia = null;

    private ManejadorUsuario(){
    }

    public static ManejadorUsuario getInstancia(){
	 if(instancia == null)
	     instancia = new ManejadorUsuario();
	 return instancia;
    }

    public void agregarUsuario(Usuario usuario){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 em.getTransaction().begin();
	 em.persist(usuario);
	 em.getTransaction().commit();
    }

    public void ModificarUsuario(Usuario u, Usuario nuevo){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 em.getTransaction().begin();
	 u.setNombre(u.getNombre());
	 u.setApellido(u.getApellido());
	 em.persist(u);

	 nuevo.setNombre(nuevo.getNombre());
	 nuevo.setApellido(nuevo.getApellido());
	 em.merge(nuevo);
	 em.getTransaction().commit();
    }


    public Usuario buscarUsuario(String nickname){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 Usuario usuario = em.find(Usuario.class, nickname);
	 return usuario;
    }

    public ArrayList<String> obtenerUsuario(){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 Query query = em.createQuery("select u from Usuario u");
	 @SuppressWarnings("unchecked")
	 List<Usuario> listUsuario = (List<Usuario>) query.getResultList();
	 ArrayList<String> aRetornar = new ArrayList<>();
	 for(Usuario u :listUsuario){
	     aRetornar.add(u.getNickname());
	 }
	 return aRetornar;
    }

}
