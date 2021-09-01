package controladores;

import java.util.List;

import datatypes.DtEspectaculo;
import excepciones.EspectaculoRepetidoExcepcion;
import interfaces.IControladorEspectaculo;
import logica.Espectaculo;
import manejadores.ManejadorEspectaculo;

public class ControladorEspectaculo implements IControladorEspectaculo{
    public ControladorEspectaculo(){
	 super();
    }

    public void altaEspectaculo(DtEspectaculo dte) throws EspectaculoRepetidoExcepcion{
	 ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
	 Espectaculo espectaculo = new Espectaculo(dte.getArtista(), dte.getPlataforma(), dte.getNombre(), dte.getDescripcion(), dte.getDuracion(), dte.getCantMin(), dte.getCantMax(), dte.getUrl(), dte.getCosto(), dte.getRegistro());
	 mE.agregarEspectaculo(espectaculo);
    }

    public List<Espectaculo> listarEspectaculos(){ // CORREGIR
	 ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
	 List<Espectaculo> espectaculos;
	 Espectaculo espec = mE.buscarEspectaculo("espec");

	 return null;
    }

    public Espectaculo obtenerEspectaculo(String nombre){
	 ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
	 return mE.buscarEspectaculo(nombre);
    }


}