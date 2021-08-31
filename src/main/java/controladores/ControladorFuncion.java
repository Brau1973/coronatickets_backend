package controladores;

import java.util.ArrayList;

import interfaces.IControladorFuncion;
import manejadores.ManejadorFuncion;
import manejadores.ManejadorPlataforma;

public class ControladorFuncion implements IControladorFuncion{
    public ControladorFuncion(){
	 super();
    }


    public String[] listarEspectaculos(String plataforma){
	 ArrayList<String> espectaculos;
	 ManejadorFuncion mF = ManejadorFuncion.getInstancia();
	 espectaculos = mF.obtenerEspectaculo(plataforma);
	 String[] espectaculos_ret = new String[espectaculos.size()];
	 int i = 0;
	 for(String id :espectaculos){
	     espectaculos_ret[i] = id;
	     i++;
	 }
	 return espectaculos_ret;
    }

    /*  public String[] listarPlataformas(){
     ManejadorFuncion mF = ManejadorFuncion.getInstancia();
     ArrayList<String> plataformas;
     plataformas = mF.obtenerPlataforma();
     String[] plataformas_ret = new String[plataformas.size()];
     int i = 0;
     for(String id :plataformas){
         plataformas_ret[i] = id;
         i++;
     }
     return plataformas_ret;
    }
    */
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

}
