package logica;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import interfaces.IControlador;

public class Controlador implements IControlador{
    private static EntityManager em;
    private static EntityManagerFactory emf;

    public Controlador(){
	 super();
    }

    public void altaEspectaculo(String artista, String plataforma, String nombre, String descripcion, int duracion, int cantMinEsp, int cantMaxEsp, String url, int costo, Date registro){
	 ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
	 Espectaculo espectaculo = new Espectaculo(artista, plataforma, nombre, descripcion, duracion, cantMinEsp, cantMaxEsp, url, costo, registro);
	 mE.agregarEspectaculo(espectaculo);
    }
}