package controladores;

import java.util.ArrayList;

import interfaces.IControladorUsuario;
import manejadores.ManejadorUsuario;

public class ControladorUsuario implements IControladorUsuario{
    public ControladorUsuario(){
	 super();
    }


    public String[] listarUsuarios(){
	 ArrayList<String> usuario;
	 ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	 usuario = mU.obtenerUsuario();
	 String[] retorno = new String[usuario.size()];
	 int i = 0;
	 for(String u :usuario){
	     retorno[i] = u;
	     i++;
	 }
	 // String[] retorno = {"Lucas Sugo", "Denis Elias"}; // ---> Quitar, cuando este AltaUsuario.
	 return retorno;
    }

}