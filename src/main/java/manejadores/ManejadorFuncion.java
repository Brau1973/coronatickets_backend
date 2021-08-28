package Manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

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

}