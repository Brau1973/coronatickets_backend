package controladores;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import excepciones.UsuarioRepetidoExcepcion;
import interfaces.IControladorUsuario;
import logica.Usuario;
import manejadores.ManejadorUsuario;
import persistencia.Conexion;

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

    public void modificarUsuario(Usuario nuevo){ // 79S
	 ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 em.getTransaction().begin();
	 em.persist(mU.buscarUsuario(nuevo.getNickname()));
	 em.merge(nuevo);
	 em.getTransaction().commit();
    }

    public Usuario obtenerUsuario(String nickname){ // 79S
	 ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	 Usuario usuario = mU.buscarUsuario(nickname);
	 return usuario;
    }

    public String[] listarUsuarios(){ // 79S
	 ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	 ArrayList<String> usuario;
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