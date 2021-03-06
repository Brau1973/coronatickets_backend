package manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import logica.Espectaculo;
import persistencia.Conexion;

public class ManejadorEspectaculo{
	private static ManejadorEspectaculo instancia = null;

	private ManejadorEspectaculo(){
	}

	public static ManejadorEspectaculo getInstancia(){
		if(instancia == null)
			instancia = new ManejadorEspectaculo();
		return instancia;
	}

	public void agregarEspectaculo(Espectaculo espectaculo){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(espectaculo);
		em.getTransaction().commit();
	}

	public Espectaculo buscarEspectaculo(String nombre){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		return em.find(Espectaculo.class, nombre);
	}

	@SuppressWarnings("unchecked")
	public List<Espectaculo> obtenerEspectaculoArtista(String nickname){ // Ok Seba 23/10/2021
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		//em.getTransaction().begin();

		Query query = em.createQuery("select e from Espectaculo e where artista= '" + nickname + "'");
		List<Espectaculo> listEspectaculos = (List<Espectaculo>) query.getResultList();
		
		//em.getTransaction().commit();
		
		return listEspectaculos;
	}

	@SuppressWarnings("unchecked")
	public List<String> obtenerEspectaculodeArtista(String nickname){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		//em.getTransaction().begin();
		Query query = em.createQuery("select e from Espectaculo e");
		List<Espectaculo> listEspectaculo = (List<Espectaculo>) query.getResultList();
		//em.getTransaction().commit();
		

		List<String> aRetornar = new ArrayList<String>();
		for(Espectaculo e :listEspectaculo){
			if(e.getArtista() == nickname){
				aRetornar.add(e.getNombre());
			}
		}
		return aRetornar;
	}
}


/*  public Espectaculo buscarEspectaculoArtista(String nickArtista){
 Conexion conexion = Conexion.getInstancia();
 EntityManager em = conexion.getEntityManager();
 Espectaculo espectaculo = em.find(Espectaculo.class, nickArtista);
 return espectaculo;
}*/

