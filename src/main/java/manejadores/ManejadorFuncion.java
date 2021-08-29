package manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import logica.Espectaculo;
import logica.Funcion;
import logica.Plataforma;
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
    
    //Consulta para obtener Funciones de Espectaculo
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