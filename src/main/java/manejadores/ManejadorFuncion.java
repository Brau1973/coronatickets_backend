package manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import logica.Funcion;
import logica.Plataforma;
import persistencia.Conexion;

public class ManejadorFuncion{
    private static ManejadorFuncion instancia = null;

    private ManejadorFuncion(){}

    public static ManejadorFuncion getInstancia(){
	 if(instancia == null)
	     instancia = new ManejadorFuncion();
	 return instancia;
    }
    
	public void agregarFuncion(Funcion funcion) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(funcion);
		
		em.getTransaction().commit();
	}
	
	public Funcion buscarFuncion(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Funcion funcion = em.find(Funcion.class, nombre);
		return funcion;
	}
	
	public ArrayList<String> obtenerFunciones(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select f from Funciones f");
		List<Funcion> listFuncion = (List<Funcion>) query.getResultList();
		
		ArrayList<String> aRetornar = new ArrayList<>();
		for(Funcion f: listFuncion) {
			aRetornar.add((f.getNombre()));
		}
		return aRetornar;
	}


    public ArrayList<String> obtenerPlataforma(){ 
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();

	 Query query = em.createQuery("select p from Plataforma p");
	 List<Plataforma> listPlataforma = (List<Plataforma>) query.getResultList();

	 ArrayList<String> aRetornar = new ArrayList<>();
	 for(Plataforma p :listPlataforma){
	     aRetornar.add(p.getNombre());
	 }
	 return aRetornar;
    }

}