package Manejadores;

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
	 Espectaculo espectaculo = em.find(Espectaculo.class, nombre);
	 return espectaculo;
    }

    public ArrayList<String> obtenerEspectaculo(){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 Query query = em.createQuery("select e from Espectaculo e");
	 @SuppressWarnings("unchecked")
	 List<Espectaculo> listEspectaculo = (List<Espectaculo>) query.getResultList();
	 ArrayList<String> aRetornar = new ArrayList<>();
	 for(Espectaculo e :listEspectaculo){
	     aRetornar.add(e.getNombre());
	 }
	 return aRetornar;
    }

}
