package logica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import datatypes.DtEspectaculo;
import interfaces.IControlador;

public class Controlador implements IControlador{
    private static EntityManager em;
    private static EntityManagerFactory emf;

    public Controlador(){
	 super();
    }

    public void altaEspectaculo(DtEspectaculo dte){
	 ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
	 Espectaculo espectaculo = new Espectaculo(dte.getArtista(), dte.getPlataforma(), dte.getNombre(), dte.getDescripcion(), dte.getDuracion(), dte.getCantMin(), dte.getCantMax(), dte.getUrl(), dte.getCosto(), dte.getRegistro());
	 mE.agregarEspectaculo(espectaculo);
    }
}