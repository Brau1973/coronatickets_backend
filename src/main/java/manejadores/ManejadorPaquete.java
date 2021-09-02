package manejadores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import logica.PaqueteEspectaculos;
import persistencia.Conexion;


public class ManejadorPaquete{
    private static ManejadorPaquete instancia = null;

    private ManejadorPaquete(){
    }

    public static ManejadorPaquete getInstancia(){
	 if(instancia == null)
	     instancia = new ManejadorPaquete();
	 return instancia;
    }

    public void altaPaquete(PaqueteEspectaculos paquete){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 em.getTransaction().begin();
	 em.persist(paquete);
	 em.getTransaction().commit();
    }

    public PaqueteEspectaculos buscarPlataforma(String nombre){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 return em.find(PaqueteEspectaculos.class, nombre);
    }

    @SuppressWarnings("unchecked")
    public List<PaqueteEspectaculos> obtenerPaquetes(){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 Query query = em.createQuery("select p from PaqueteEspectaculos p");
	 List<PaqueteEspectaculos> listPaquete = query.getResultList();
	 return listPaquete;
    }

    public Boolean existePaquete(String nombre){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 PaqueteEspectaculos paquete = em.find(PaqueteEspectaculos.class, nombre);
	 return paquete != null ? true : false;
    }


}