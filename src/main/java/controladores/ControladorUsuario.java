package controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtUsuario;
import interfaces.IControladorUsuario;
import logica.Artista;
import logica.Espectador;
import logica.Usuario;
import manejadores.ManejadorUsuario;
import persistencia.Conexion;

public class ControladorUsuario implements IControladorUsuario {

	public ControladorUsuario() {
		super();
	}

	@Override
	public void altaUsuario(DtUsuario dtu) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();

		if (mU.buscarUsuario(dtu.getNickname()) != null) {
			//throw new Exception("El nickname esta en uso");
		} else if (emailRepetido(dtu.getEmail())) {
			//throw new Exception("El email esta en uso");
		}

		if (dtu instanceof DtArtista) {
			Usuario usuario = new Artista(dtu.getNickname(), dtu.getNombre(), dtu.getApellido(), dtu.getEmail(), dtu.getfNacimiento(), dtu.getContrasenia(), dtu.getImagen(), ((DtArtista) dtu).getDescripcion(), ((DtArtista) dtu).getBiografia(), ((DtArtista) dtu).getLink());
			mU.altaUsuario(usuario);
		}
		if (dtu instanceof DtEspectador) {
			Usuario usuario = new Espectador(dtu.getNickname(), dtu.getNombre(), dtu.getApellido(), dtu.getEmail(), dtu.getfNacimiento(), dtu.getContrasenia(), dtu.getImagen());
			mU.altaUsuario(usuario);
		}
	}

	@Override
	public void altaDtArtista(DtArtista dta) {//throws UsuarioRepetidoExcepcion {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usuario = new Artista(dta.getNickname(), dta.getNombre(), dta.getApellido(), dta.getEmail(), dta.getfNacimiento(), dta.getContrasenia(), dta.getImagen(), ((DtArtista) dta).getDescripcion(), ((DtArtista) dta).getBiografia(), ((DtArtista) dta).getLink());
		mU.altaUsuario(usuario);
	}

	@Override
	public void altaDtEspectador(DtEspectador dte) {// throws UsuarioRepetidoExcepcion {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usuario = new Espectador(dte.getNickname(), dte.getNombre(), dte.getApellido(), dte.getEmail(), dte.getfNacimiento(), dte.getContrasenia(), dte.getImagen());
		System.out.println("******estoy en altaDtEspectador");
		mU.altaUsuario(usuario);
	}

	@Override
	public boolean emailRepetido(String email) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario entity = mU.buscarUsuarioMail(email);
		if (entity != null) {
			return true;
		}
		return false;
	}

	public void seguirUsuario(String nicknameUsuario, String nicknameUsuarioASeguir) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usuario = mU.buscarUsuario(nicknameUsuario);
		Usuario usuarioASeguir = mU.buscarUsuario(nicknameUsuarioASeguir);

		usuario.seguirUsuario(usuarioASeguir);
		usuarioASeguir.agregarSeguidor(usuario);

		mU.ActualizarRegistro(usuario);
	}

	@Override
	public void dejarDeSeguirUsuario(String nicknameUsuario, String nicknameUsuarioADejarDeSeguir) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usuario = mU.buscarUsuario(nicknameUsuario);
		Usuario usuarioADejarDeSeguir = mU.buscarUsuario(nicknameUsuarioADejarDeSeguir);

		usuario.dejarSeguirUsuario(usuarioADejarDeSeguir);
		usuarioADejarDeSeguir.quitarSeguidor(usuario);

		mU.ActualizarRegistro(usuario);
	}

	@Override
	public void modificarUsuario(Usuario nuevo) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(mU.buscarUsuario(nuevo.getNickname()));
		em.merge(nuevo);
		em.getTransaction().commit();
	}

	@Override
	public Usuario obtenerUsuario(String nickname) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		return mU.buscarUsuario(nickname);
	}

	@Override
	public Artista obtenerArtista(String nickname) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		return mU.buscarArtista(nickname);
	}

	@Override
	public List<String> listarNicknameUsuarios() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		List<String> listStringUsuarios = new ArrayList<String>();
		List<Usuario> listUsuarios = new ArrayList<Usuario>();
		listUsuarios = mU.listarUsuarios();
		for (Usuario u : listUsuarios) {
			listStringUsuarios.add(u.getNickname());
		}
		return listStringUsuarios;
	}

	@Override
	public List<String> listarNicknameArtistas() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		List<String> listStringArtistas = new ArrayList<String>();
		List<Artista> listArtistas = new ArrayList<Artista>();
		listArtistas = mU.listarArtistas();
		for (Artista a : listArtistas) {
			listStringArtistas.add(a.getNickname());
		}
		return listStringArtistas;
	}

	@Override
	public List<String> listarNicknameEspectadores() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		List<String> listStringEspectadores = new ArrayList<String>();
		List<Espectador> listEspectadores = new ArrayList<Espectador>();
		listEspectadores = mU.listarEspectadores();
		for (Espectador e : listEspectadores) {
			listStringEspectadores.add(e.getNickname());
		}
		return listStringEspectadores;
	}

	@Override
	public List<String> listarNicknameUsuariosNoSeguidos(String nickname) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		List<String> listStringUsuariosNoSeguidos = new ArrayList<String>(); // a retornar

		Usuario usuario = mU.buscarUsuario(nickname);
		List<Usuario> listUsuariosSeguidos = new ArrayList<Usuario>();
		List<Usuario> listAllUsuarios = new ArrayList<Usuario>();
		List<Usuario> listUsuariosNoSeguidos = new ArrayList<Usuario>();

		listAllUsuarios = mU.listarUsuarios(); // TODOS LOS USU DEL SISTEMA
		listUsuariosSeguidos = usuario.getSeguidos(); // Usuario ya seguidos por el usuario recibido por param

		for (Usuario u : listUsuariosSeguidos) {
			listAllUsuarios.remove(u);
		}

		listAllUsuarios.remove(usuario); // Quito al usuario mismo de la lista

		listUsuariosNoSeguidos = listAllUsuarios;

		for (Usuario u : listUsuariosNoSeguidos) {
			listStringUsuariosNoSeguidos.add(u.getNickname());
		}
		return listStringUsuariosNoSeguidos;
	}

	@Override
	public List<String> listarNicknameUsuariosSeguidos(String nickname) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usuario = mU.buscarUsuario(nickname);
		List<String> listStringUsuariosSeguidos = new ArrayList<String>(); // a retornar

		List<Usuario> listUsuariosSeguidos = new ArrayList<Usuario>();
		listUsuariosSeguidos = usuario.getSeguidos(); // Usuario ya seguidos por el usuario recibido por param

		for (Usuario u : listUsuariosSeguidos) {
			listStringUsuariosSeguidos.add(u.getNickname());
		}
		return listStringUsuariosSeguidos;
	}

	@Override
	public DtUsuario getLoginUsuario(String nickname) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario entity = mU.buscarUsuario(nickname);
		DtUsuario dt = null;
		if (entity != null) {
			if (entity instanceof Artista) {
				dt = new DtArtista(entity.getNickname(), entity.getNombre(), entity.getApellido(), entity.getEmail(), entity.getfNacimiento(), null, null, entity.getContrasenia(), entity.getImagen(), ((Artista) entity).getDescripcion(), ((Artista) entity).getBiografia(), ((Artista) entity).getLink());
			} else {
				dt = new DtEspectador(entity.getNickname(), entity.getNombre(), entity.getApellido(), entity.getEmail(), entity.getfNacimiento(), null, null, entity.getContrasenia(), entity.getImagen());
			}
		}
		return dt;
	}

	public DtArtista getLoginArtista(String nickname) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario entity = mU.buscarUsuario(nickname);
		DtArtista dt = new DtArtista(entity.getNickname(), entity.getNombre(), entity.getApellido(), entity.getEmail(), entity.getfNacimiento(), null, null, entity.getContrasenia(), entity.getImagen(), ((Artista) entity).getDescripcion(), ((Artista) entity).getBiografia(), ((Artista) entity).getLink());

		return dt;
	}

	@Override
	public DtUsuario getLoginUsuarioMail(String mail) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario entity = mU.buscarUsuarioMail(mail);
		DtUsuario dt = null;
		if (entity != null) {
			if (entity instanceof Artista) {
				dt = new DtArtista(entity.getNickname(), entity.getNombre(), entity.getApellido(), entity.getEmail(), entity.getfNacimiento(), null, null, entity.getContrasenia(), entity.getImagen(), ((Artista) entity).getDescripcion(), ((Artista) entity).getBiografia(), ((Artista) entity).getLink());
			} else {
				dt = new DtEspectador(entity.getNickname(), entity.getNombre(), entity.getApellido(), entity.getEmail(), entity.getfNacimiento(), null, null, entity.getContrasenia(), entity.getImagen());
			}
		}
		return dt;
	}

}