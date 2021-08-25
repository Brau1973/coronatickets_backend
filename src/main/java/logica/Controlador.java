package logica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IControlador;

public class Controlador implements IControlador{
    private static EntityManager em;
    private static EntityManagerFactory emf;

    public Controlador(){
	 super();
    }

    public void altaEspectaculo(String artista, String plataforma, String nombre, String descripcion, int duracion, int cantMinEsp, int cantMaxEsp, String url, int costo){
	 emf = Persistence.createEntityManagerFactory("bd_coronaTickets");
	 em = emf.createEntityManager();
	 em.getTransaction().begin();
	 Espectaculo espectaculo = new Espectaculo(artista, plataforma, nombre, descripcion, duracion, cantMinEsp, cantMaxEsp, url, costo);
	 em.persist(espectaculo);
	 em.getTransaction().commit();
	 em.close();
    }
}