package controladores;

import excepciones.UsuarioRepetidoExcepcion;
import interfaces.IControladorUsuario;
import logica.Usuario;
import manejadores.ManejadorUsuario;

public class ControladorUsuario implements IControladorUsuario{

    public ControladorUsuario(){
	 super();
    }


	@Override
	

	public void altaUsuario(Usuario usuario) throws UsuarioRepetidoExcepcion{
		 ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	//	 Usuario user = new Usuario();
	//	user = mU.buscarUsuario(usuario.getNickname());
	 if(mU.buscarUsuario(usuario.getNickname()) != null) {
	    throw new UsuarioRepetidoExcepcion("el nickname esta en uso");
	 }else if(mU.buscarUsuario(usuario.getEmail()) != null){
		  throw new UsuarioRepetidoExcepcion("el email esta en uso");
		 
	 }
	 
		 mU.altaUsuario(usuario);
	  
	}

}