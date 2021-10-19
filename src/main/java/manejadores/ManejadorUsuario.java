package manejadores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import logica.Artista;
import logica.Espectador;
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
    
    public void ActualizarRegistro(Usuario u){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 em.getTransaction().begin();
	 em.persist(u);
	 em.merge(u);
	 em.getTransaction().commit();
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
    
    public Usuario buscarUsuarioMail(String mail){
   	 Conexion conexion = Conexion.getInstancia();
   	 EntityManager em = conexion.getEntityManager();
   	 Query query = em.createQuery("select u from Usuario u where email = '" + mail + "'");
	 Usuario user = (Usuario) query.getSingleResult();
   	 return user;
     }
    
    public Espectador buscarEspectador(String nickname){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 return em.find(Espectador.class, nickname);
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
    public List<Usuario> listarUsuarios(){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 Query query = em.createQuery("select u from Usuario u");
	 List<Usuario> listUsuarios = (List<Usuario>) query.getResultList();
	 return listUsuarios;
    }

    @SuppressWarnings("unchecked")
    public List<Artista> listarArtistas(){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 Query query = em.createQuery("select a from Artista a");
	 List<Artista> listArtista = (List<Artista>) query.getResultList();
	 return listArtista;
    }
    
    @SuppressWarnings("unchecked")
    public List<Espectador> listarEspectadores(){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 Query query = em.createQuery("select e from Espectador e");
	 List<Espectador> listEspectador = (List<Espectador>) query.getResultList();
	 return listEspectador;
    }

    ///// aca
    public Artista buscarArtista(String nickname){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
    	 return em.find(Artista.class, nickname);
    }
}
