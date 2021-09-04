package controladores;

import java.util.List;

import datatypes.DtEspectaculo;
import excepciones.EspectaculoRepetidoExcepcion;
import interfaces.IControladorEspectaculo;
import logica.Espectaculo;
import logica.Funcion;
import manejadores.ManejadorEspectaculo;
import manejadores.ManejadorFuncion;

public class ControladorEspectaculo implements IControladorEspectaculo{
    public ControladorEspectaculo(){
	 super();
    }

    public void altaEspectaculo(DtEspectaculo dte) throws EspectaculoRepetidoExcepcion{
	 ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
	 Espectaculo espectaculo = new Espectaculo(dte.getArtista(), dte.getPlataforma(), dte.getNombre(), dte.getDescripcion(), dte.getDuracion(), dte.getCantMin(), dte.getCantMax(), dte.getUrl(), dte.getCosto(), dte.getRegistro());
	 mE.agregarEspectaculo(espectaculo);
    }
    
    public List<Espectaculo> listarEspectaculos(){
      	 ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
      	 return mE.obtenerEspectaculo();
          }

    /*public List<Espectaculo> listarEspectaculos(){ // ??????? se usa?
	 ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
	 List<Espectaculo> espectaculos;
	 Espectaculo espec = mE.buscarEspectaculo("espec");
	 return null; // Vpi ñe /// ¿?¿?¿?¿?¿? /// * ***XDXDXDXD*****
    }*/

    public Espectaculo obtenerEspectaculo(String nombre){
	 ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
	 return mE.buscarEspectaculo(nombre);
    }

}