package manejadores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import logica.Artista;
import logica.Usuario;
import persistencia.Conexion;

@SuppressWarnings("unused")
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
	 return em.find(Usuario.class, nickname);
    }

    @SuppressWarnings("unchecked")
    public List<Usuario> obtenerUsuario(){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 Query query = em.createQuery("select u from Usuario u");
	 List<Usuario> listUsuario = (List<Usuario>) query.getResultList();
	 return listUsuario;
    }

    @SuppressWarnings("unchecked")
    public List<Artista> listarArtistas(){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 Query query = em.createQuery("select a from Artista a");
	 List<Artista> listArtista = (List<Artista>) query.getResultList();
	 return listArtista;
    }


    ///// aca
    public Artista buscarArtista(String nickname){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 return em.find(Artista.class, nickname);
    }
}
