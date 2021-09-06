package manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import logica.Funcion;
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
<<<<<<< HEAD

	 Funcion funcion = em.find(Funcion.class, nombre);
	 return funcion;
    }

    public List<Funcion> obtenerFunciones(){ // 79S
   	 Conexion conexion = Conexion.getInstancia();
   	 EntityManager em = conexion.getEntityManager();
   	 Query query = em.createQuery("select f from Funcion f");
   	 List<Funcion> listFuncion = (List<Funcion>) query.getResultList();
   	 return listFuncion;
       }


    // public ArrayList<Plataforma> obtenerPlataforma(){
    // Conexion conexion = Conexion.getInstancia();
    // EntityManager em = conexion.getEntityManager();
    //
    // Query query = em.createQuery("select p from Plataforma p");
    // List<Plataforma> listPlataforma = (List<Plataforma>) query.getResultList();
    ////
    //// ArrayList<String> aRetornar = new ArrayList<>();
    //// for(Plataforma p :listPlataforma){
    //// aRetornar.add(p.getNombre());
    //// }
    // return aRetornar;
    // }
    //
    // public ArrayList<String> obtenerEspectaculo(String plataforma){
    //
    // Conexion conexion = Conexion.getInstancia();
    // EntityManager em = conexion.getEntityManager();
    //
    // Query query = em.createQuery("select e from Espectaculo e where plataforma =:plataforma");
    // query.setParameter("plataforma", plataforma);
    // List<Espectaculo> listEspectaculo = (List<Espectaculo>) query.getResultList();
    //
    // ArrayList<String> aRetornar = new ArrayList<>();
    // for(Espectaculo e :listEspectaculo){
    // aRetornar.add(e.getNombre());
    // }
    // return aRetornar;
    // }
=======
	 return em.find(Funcion.class, nombre);
    }

    public ArrayList<String> obtenerFunciones(){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 Query query = em.createQuery("select f from Funcion f");
	 List<Funcion> listFuncion = (List<Funcion>) query.getResultList();
	 ArrayList<String> aRetornar = new ArrayList<>();
	 for(Funcion f :listFuncion){
	     aRetornar.add((f.getNombre()));
	 }
	 return aRetornar;
    }

    public ArrayList<String> obtenerEspectaculo(String plataforma){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();

	 Query query = em.createQuery("select e from Espectaculo e where plataforma =:plataforma");
	 query.setParameter("plataforma", plataforma);
	 List<Espectaculo> listEspectaculo = (List<Espectaculo>) query.getResultList();

	 ArrayList<String> aRetornar = new ArrayList<>();
	 for(Espectaculo e :listEspectaculo){
	     aRetornar.add(e.getNombre());
	 }
	 return aRetornar;
    }
>>>>>>> 6c8a5d938bb3ef6d18e666bd22ba8210faea9619

    // Consulta para obtener Funciones de Espectaculo
    /*public ArrayList<String> obtenerFuncion(String espectaculo){ 
      	 Conexion conexion = Conexion.getInstancia();
      	 EntityManager em = conexion.getEntityManager();
    
      	 Query query = em.createQuery("select f from Funcion f where espectaculo =:espectaculo");
      	 query.setParameter("espectaculo", espectaculo);
      	 List<Funcion> listFuncion = (List<Funcion>) query.getResultList();
    
      	 ArrayList<String> aRetornar = new ArrayList<>();
      	 for(Funcion f :listFuncion){
      	     aRetornar.add(f.getNombre());
      	 }
      	 return aRetornar;
          }*/
}