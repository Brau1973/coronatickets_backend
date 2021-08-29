package controladores;

import java.util.ArrayList;

import datatypes.DtEspectaculo;
import excepciones.EspectaculoRepetidoExcepcion;
import interfaces.IControladorEspectaculo;
import logica.Espectaculo;
import manejadores.ManejadorEspectaculo;
import manejadores.ManejadorPlataforma;
import manejadores.ManejadorUsuario;

public class ControladorEspectaculo implements IControladorEspectaculo{
    public ControladorEspectaculo(){
	 super();
    }

    public void altaEspectaculo(DtEspectaculo dte) throws EspectaculoRepetidoExcepcion{
	 ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
	 Espectaculo espectaculo = new Espectaculo(dte.getArtista(), dte.getPlataforma(), dte.getNombre(), dte.getDescripcion(), dte.getDuracion(), dte.getCantMin(), dte.getCantMax(), dte.getUrl(), dte.getCosto(), dte.getRegistro());
	 mE.agregarEspectaculo(espectaculo);
    }

    public String[] listarPlataformas(){
	 ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
	 ArrayList<String> plataforma;
	 plataforma = mP.obtenerPlataforma();
	 String[] retorno = new String[plataforma.size()];
	 int i = 0;
	 for(String p :plataforma){
	     retorno[i] = p;
	     i++;
	 }
	 return retorno;
    }

    public String[] listarArtistas(){
	 ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	 ArrayList<String> artistas;
	 artistas = mU.obtenerUsuario();
	 String[] retorno = new String[artistas.size()];
	 int i = 0;
	 for(String a :artistas){
	     retorno[i] = a;
	     i++;
	 }
	 return retorno;
    }

}