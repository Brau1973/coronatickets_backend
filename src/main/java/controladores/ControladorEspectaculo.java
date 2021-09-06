package controladores;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import datatypes.DtEspectaculo;
import excepciones.EspectaculoRepetidoExcepcion;
import excepciones.FuncionYaRegistradaEnEspectaculoExcepcion;
import interfaces.IControladorEspectaculo;
import logica.Espectaculo;
import logica.Funcion;
import logica.Plataforma;
import manejadores.ManejadorEspectaculo;
import manejadores.ManejadorFuncion;
import persistencia.Conexion;

public class ControladorEspectaculo implements IControladorEspectaculo{
    public ControladorEspectaculo(){
	 super();
    }

    public void altaEspectaculo(DtEspectaculo dte) throws EspectaculoRepetidoExcepcion{
//	 ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
//	 Espectaculo espectaculo = new Espectaculo(dte.getArtista(), dte.getPlataforma(), dte.getNombre(), dte.getDescripcion(), dte.getDuracion(), dte.getCantMin(), dte.getCantMax(), dte.getUrl(), dte.getCosto(), dte.getRegistro());
//	 mE.agregarEspectaculo(espectaculo);
    }

    public List<Espectaculo> listarEspectaculos(){ 
	 ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
	 List<Espectaculo> espectaculos;
	 Espectaculo espec = mE.buscarEspectaculo("espec");
	 return null; 
    }

    public Espectaculo obtenerEspectaculo(String nombre){
	 ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
	 return mE.buscarEspectaculo(nombre);
    }
    
    public List<Espectaculo> obtenerEspectaculo2(String plataforma){
   	 ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
   	 return mE.obtenerEspectaculoBD(plataforma);
       }
    
    
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

}