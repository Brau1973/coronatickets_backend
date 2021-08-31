package manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import logica.Artista;
import logica.Funcion;
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
	 Usuario u = em.find(Usuario.class, nickname);
	 return u;
    }

    @SuppressWarnings("unchecked")
    public List<Usuario> obtenerUsuario(){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 Query query = em.createQuery("select u from Usuario u");
	 List<Usuario> listUsuario = (List<Usuario>) query.getResultList();
	 return listUsuario;
    }

	public List<Artista> listarArtistas() {
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 Query query = em.createQuery("select a from Artista a");
	 List<Artista> listArtista = (List<Artista>) query.getResultList();
	 return listArtista;
	}
	
	public List<String> listarArtistasStr() {
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 Query query = em.createQuery("select a from Artista a");
	 List<Artista> listArtista = (List<Artista>) query.getResultList();
	 
	 List<String> aRetornar = new ArrayList<>();
		for(Artista a: listArtista) {
			aRetornar.add((a.getNickname()));
		}
		return aRetornar;
	}
	
    public Artista ObtenerArtista(String nickname){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 Artista a = em.find(Artista.class, nickname);
	 return a;
    }

}
