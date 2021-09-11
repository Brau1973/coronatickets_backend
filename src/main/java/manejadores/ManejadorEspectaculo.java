package manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import logica.Espectaculo;
import logica.Funcion;
import logica.Plataforma;
import persistencia.Conexion;

public class ManejadorEspectaculo {
	private static ManejadorEspectaculo instancia = null;

	private ManejadorEspectaculo() {
	}

	public static ManejadorEspectaculo getInstancia() {
		if (instancia == null)
			instancia = new ManejadorEspectaculo();
		return instancia;
	}

	public void agregarEspectaculo(Espectaculo espectaculo) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(espectaculo);
		em.getTransaction().commit();
	}
    
    public List<Espectaculo> obtenerEspectaculo() { // 79S
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select e from Espectaculo e");
		List<Espectaculo> listEspectaculo = (List<Espectaculo>) query.getResultList();
		return listEspectaculo;

    }
    
	public Espectaculo buscarEspectaculo(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		return em.find(Espectaculo.class, nombre);
	}

//    /////////////// CHECK USO
//    @SuppressWarnings("unchecked")
//    public ArrayList<String> obtenerEspectaculodeArtista(String nickname){ /// ok
//	 Conexion conexion = Conexion.getInstancia();
//	 EntityManager em = conexion.getEntityManager();
//	 Query query = em.createQuery("select e from Espectaculo e");
//	 List<Espectaculo> listEspectaculo = (List<Espectaculo>) query.getResultList();
//	 ArrayList<String> aRetornar = new ArrayList<>();
//	 for(Espectaculo e :listEspectaculo){
//	     if(e.getArtista().getNickname() == nickname){
//		  aRetornar.add(e.getNombre());
//	     }
//	 }
//	 return aRetornar;
//    }


    @SuppressWarnings("unchecked")
    public List<Espectaculo> listEspectaculos(){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 Query query = em.createQuery("select e from Espectaculo e");
	 List<Espectaculo> listEspectaculos = (List<Espectaculo>) query.getResultList();
	 return listEspectaculos;
    }

    /// aca

    // CHECK USO
    @SuppressWarnings("unchecked")
    public List<Espectaculo> obtenerEspectaculoArtista(String nickname){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 Query query = em.createQuery("select e from Espectaculo e where artista==nickname");
	 List<Espectaculo> listEspectaculos = (List<Espectaculo>) query.getResultList();
	 return listEspectaculos;
    }

    /*  public Espectaculo buscarEspectaculoArtista(String nickArtista){
     Conexion conexion = Conexion.getInstancia();
     EntityManager em = conexion.getEntityManager();
     Espectaculo espectaculo = em.find(Espectaculo.class, nickArtista);
     return espectaculo;
    }*/
    
    // CHECK USO
    public List<Espectaculo> obtenerEspectaculoBD(String plataforma) { // 
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select e from Espectaculo e where plataforma_nombre = :plataforma");
		query.setParameter("plataforma", plataforma);
		List<Espectaculo> listEspectaculo = (List<Espectaculo>) query.getResultList();
		return listEspectaculo;
    }

}
