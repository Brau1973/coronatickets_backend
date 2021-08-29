package controladores;

import java.util.ArrayList;

import excepciones.UsuarioRepetidoExcepcion;
import interfaces.IControladorUsuario;
import logica.Usuario;
import manejadores.ManejadorUsuario;

public class ControladorUsuario implements IControladorUsuario{

    public ControladorUsuario(){
	 super();
    }

    public void altaUsuario(Usuario usuario) throws UsuarioRepetidoExcepcion{
	 ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	 if(mU.buscarUsuario(usuario.getNickname()) != null){
	     throw new UsuarioRepetidoExcepcion("el nickname esta en uso");
	 }else if(mU.buscarUsuario(usuario.getEmail()) != null){
	     throw new UsuarioRepetidoExcepcion("el email esta en uso");
	 }
	 mU.altaUsuario(usuario);
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
	 return retorno;
    }

}