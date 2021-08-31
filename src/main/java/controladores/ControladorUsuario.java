package controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import excepciones.UsuarioRepetidoExcepcion;
import interfaces.IControladorUsuario;
import logica.Artista;
import logica.Usuario;
import manejadores.ManejadorUsuario;
import persistencia.Conexion;

public class ControladorUsuario implements IControladorUsuario {
	public ControladorUsuario() {
		super();
	}

	public void altaUsuario(Usuario usuario) throws UsuarioRepetidoExcepcion {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		if (mU.buscarUsuario(usuario.getNickname()) != null) {
			throw new UsuarioRepetidoExcepcion("el nickname esta en uso");
		} else if (mU.buscarUsuario(usuario.getEmail()) != null) {
			throw new UsuarioRepetidoExcepcion("el email esta en uso");
		}
		mU.altaUsuario(usuario);
	}

	public void modificarUsuario(Usuario nuevo) { // 79S
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(mU.buscarUsuario(nuevo.getNickname()));
		em.merge(nuevo);
		em.getTransaction().commit();
	}

	public Usuario obtenerUsuario(String nickname) { // 79S
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usuario = mU.buscarUsuario(nickname);
		return usuario;
	}

	public List<Usuario> listarUsuarios() { // 79S
		List<Usuario> usuarios;
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		usuarios = mU.obtenerUsuario();

		return usuarios;

	}

	public List<Artista> listarArtistas() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		return mU.listarArtistas();
	}
	
	public List<String> listarArtistasStr() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		return mU.listarArtistasStr();
	}
	
    public Artista ObtenerArtista(String nickname){
    	ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		return mU.ObtenerArtista(nickname);
    }
}