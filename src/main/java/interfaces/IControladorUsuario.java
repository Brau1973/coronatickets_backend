package interfaces;

import java.util.List;

import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtUsuario;
import excepciones.UsuarioRepetidoExcepcion;
import logica.Artista;
import logica.Usuario;

public interface IControladorUsuario {
	public void altaUsuario(DtUsuario u) throws UsuarioRepetidoExcepcion;

	public void altaDtArtista(DtArtista dtArtista) throws UsuarioRepetidoExcepcion;

	public void altaDtEspectador(DtEspectador dtEspectador) throws UsuarioRepetidoExcepcion;

	public void modificarUsuario(DtUsuario nuevo);

	public List<String> listarNicknameUsuarios();

	public List<String> listarNicknameArtistas();

	public List<String> listarNicknameEspectadores();

	public void seguirUsuario(String nicknameUsuario, String nicknameUsuarioASeguir);

	public void dejarDeSeguirUsuario(String nicknameUsuario, String nicknameUsuarioADejarDeSeguir);

	public List<String> listarNicknameUsuariosNoSeguidos(String nickname);

	public List<String> listarNicknameUsuariosSeguidos(String nickname);

	public DtUsuario getLoginUsuario(String nickname);

	public DtArtista getLoginArtista(String nickname);

	public boolean emailRepetido(String email);

	public DtUsuario getLoginUsuarioMail(String mail);
	
	public DtUsuario obtenerInfoUsuario(String nickname);
}