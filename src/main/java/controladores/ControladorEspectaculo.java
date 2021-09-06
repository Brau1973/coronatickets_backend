package controladores;

<<<<<<< HEAD
=======
import java.util.Date;
>>>>>>> 6c8a5d938bb3ef6d18e666bd22ba8210faea9619
import java.util.List;

import javax.persistence.EntityManager;

import datatypes.DtEspectaculo;
import excepciones.EspectaculoRepetidoExcepcion;
import excepciones.FuncionYaRegistradaEnEspectaculoExcepcion;
import interfaces.IControladorEspectaculo;
import logica.Espectaculo;
<<<<<<< HEAD
import manejadores.ManejadorEspectaculo;
=======
import logica.Funcion;
import logica.Plataforma;
import manejadores.ManejadorEspectaculo;
import manejadores.ManejadorFuncion;
import persistencia.Conexion;
>>>>>>> 6c8a5d938bb3ef6d18e666bd22ba8210faea9619

public class ControladorEspectaculo implements IControladorEspectaculo{
    public ControladorEspectaculo(){
	 super();
    }

    public void altaEspectaculo(DtEspectaculo dte) throws EspectaculoRepetidoExcepcion{
//	 ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
//	 Espectaculo espectaculo = new Espectaculo(dte.getArtista(), dte.getPlataforma(), dte.getNombre(), dte.getDescripcion(), dte.getDuracion(), dte.getCantMin(), dte.getCantMax(), dte.getUrl(), dte.getCosto(), dte.getRegistro());
//	 mE.agregarEspectaculo(espectaculo);
    }

<<<<<<< HEAD
    public List<Espectaculo> listarEspectaculos(){ // CORREGIR
	 ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
	 List<Espectaculo> espectaculos;
	 Espectaculo espec = mE.buscarEspectaculo("espec");

	 return null;
=======
    public List<Espectaculo> listarEspectaculos(){ 
	 ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
	 List<Espectaculo> espectaculos;
	 Espectaculo espec = mE.buscarEspectaculo("espec");
	 return null; 
>>>>>>> 6c8a5d938bb3ef6d18e666bd22ba8210faea9619
    }

    public Espectaculo obtenerEspectaculo(String nombre){
	 ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
	 return mE.buscarEspectaculo(nombre);
    }
<<<<<<< HEAD

=======
    
    
//    @Override
//	public void agregarFuncion(String nombreEspectaculo,String nombreFuncion) throws FuncionYaRegistradaEnEspectaculoExcepcion{
//		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
//		Espectaculo espectaculo = mE.buscarEspectaculo(nombreEspectaculo);
//		ManejadorFuncion mF = ManejadorFuncion.getInstancia();
//		Funcion funcion = mF.buscarFuncion(nombreFuncion);
//		if (espectaculo.funcionYaRegistrada(nombreFuncion))
//			throw new FuncionYaRegistradaEnEspectaculoExcepcion("La Funcion" + nombreFuncion + " ya esta registrada en el espectaculo " + nombreEspectaculo);
//		espectaculo.agregarFuncion(funcion);
//
//		Conexion conexion = Conexion.getInstancia();
//		EntityManager em = conexion.getEntityManager();
//		em.getTransaction().begin();
//		em.persist(espectaculo); 
//		em.getTransaction().commit();
//	}
>>>>>>> 6c8a5d938bb3ef6d18e666bd22ba8210faea9619

}