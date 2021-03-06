package manejadores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import logica.Funcion;
//import logica.Registro;
import persistencia.Conexion;

public class ManejadorFuncion{
    private static ManejadorFuncion instancia = null;

    private ManejadorFuncion(){
    }

    public static ManejadorFuncion getInstancia(){
	 if(instancia == null)
	     instancia = new ManejadorFuncion();
	 return instancia;
    }

    public void agregarFuncion(Funcion funcion){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 em.getTransaction().begin();
	 em.persist(funcion);
	 em.getTransaction().commit();
    }

    public Funcion buscarFuncion(String nombre){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 return em.find(Funcion.class, nombre);
    }
    
//    public int getCantidadEspectadoresRegistrados(String nombreFuncion){ //
//	 Conexion conexion = Conexion.getInstancia();
//	 EntityManager em = conexion.getEntityManager();
//	 Query query = em.createQuery("select count(funcion) from Registro r where registro_funcion = :nombreFuncion");
//	 query.setParameter("funcion", nombreFuncion);
//	 
//	 int cantEspectadoresRegistradosAFuncion = Integer.parseInt(query.getResultList().toString());
//	 System.out.println("cantEspectadoresRegistradosAFuncion: "+cantEspectadoresRegistradosAFuncion);
//	 return cantEspectadoresRegistradosAFuncion;
//	 
//    }
    
}