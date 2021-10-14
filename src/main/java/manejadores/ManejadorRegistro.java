package manejadores;

import javax.persistence.EntityManager;

import logica.Registro;
import persistencia.Conexion;

public class ManejadorRegistro {
	private static ManejadorRegistro instancia = null;

	public ManejadorRegistro() {
		super();
	}
	
    public static ManejadorRegistro getInstancia(){
	 if(instancia == null)
	     instancia = new ManejadorRegistro();
	 return instancia;
    }
    
    public void agregarRegistro(Registro registro){
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 em.getTransaction().begin();
	 em.persist(registro);
	 em.getTransaction().commit();
    }
	
}
