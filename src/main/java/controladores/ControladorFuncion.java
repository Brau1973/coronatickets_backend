package controladores;

import java.util.ArrayList;

import interfaces.IControladorFuncion;
import manejadores.ManejadorFuncion;

public class ControladorFuncion implements IControladorFuncion{
    public ControladorFuncion(){
	 super();
    }

    @Override
    public String[] listarPlataformas(){
	 ArrayList<String> plataformas;
	 ManejadorFuncion mP = ManejadorFuncion.getInstancia();
	 plataformas = mP.obtenerPlataforma();
	 String[] plataformas_ret = new String[plataformas.size()];
	 int i = 0;
	 for(String id :plataformas){
	     plataformas_ret[i] = id;
	     i++;
	 }
	 return plataformas_ret;
    }

}
