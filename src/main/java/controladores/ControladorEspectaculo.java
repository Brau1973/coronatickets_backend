package controladores;

import java.util.List;

import datatypes.DtEspectaculo;
import excepciones.EspectaculoRepetidoExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorPlataforma;
import interfaces.IControladorUsuario;
import logica.Artista;
import logica.Espectaculo;
import logica.Plataforma;
import manejadores.ManejadorEspectaculo;
import manejadores.ManejadorPlataforma;

public class ControladorEspectaculo implements IControladorEspectaculo{
    public ControladorEspectaculo(){
	 super();
    }

    public void altaEspectaculo(DtEspectaculo dte) throws EspectaculoRepetidoExcepcion{
	 ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();

	 IControladorUsuario iconU = Fabrica.getInstancia().getIControladorUsuario();
	 IControladorPlataforma iconP = Fabrica.getInstancia().getIControladorPlataforma();

	 Artista artistaOrganizador = iconU.obtenerArtista(dte.getArtista());

	 Plataforma plataforma = iconP.buscarPlataforma(dte.getPlataforma());

	 Espectaculo espectaculo = new Espectaculo(artistaOrganizador, plataforma, dte.getNombre(), dte.getDescripcion(), dte.getDuracion(), dte.getCantMin(), dte.getCantMax(), dte.getUrl(), dte.getCosto(), dte.getRegistro());
	 // agregar espectaculo a coleccion de espectaculos de la plataforma
	 mE.agregarEspectaculo(espectaculo);
    }

    /*public List<Espectaculo> listarEspectaculos(){
      	 ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
      	 return mE.obtenerEspectaculo();
          }*/

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

    // @Override
    // public void agregarFuncion(String nombreEspectaculo,String nombreFuncion) throws FuncionYaRegistradaEnEspectaculoExcepcion{
    // ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
    // Espectaculo espectaculo = mE.buscarEspectaculo(nombreEspectaculo);
    // ManejadorFuncion mF = ManejadorFuncion.getInstancia();
    // Funcion funcion = mF.buscarFuncion(nombreFuncion);
    // if (espectaculo.funcionYaRegistrada(nombreFuncion))
    // throw new FuncionYaRegistradaEnEspectaculoExcepcion("La Funcion" + nombreFuncion + " ya esta registrada en el espectaculo " + nombreEspectaculo);
    // espectaculo.agregarFuncion(funcion);
    //
    // Conexion conexion = Conexion.getInstancia();
    // EntityManager em = conexion.getEntityManager();
    // em.getTransaction().begin();
    // em.persist(espectaculo);
    // em.getTransaction().commit();
    // }

    public List<DtEspectaculo> listarEspectaculos(String nombrePlataforma){
	 ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
	 Plataforma plataforma = mP.buscarPlataforma(nombrePlataforma);
	 return plataforma.getEspectaculosDt();
    }

    public List<Espectaculo> obtenerEspectaculo2(String plataforma){
	 ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
	 return mE.obtenerEspectaculoBD(plataforma);
    }


}