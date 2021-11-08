package interfaces;

import java.util.List;

import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtUsuario;
import logica.Artista;
import logica.Usuario;

public interface IControladorUsuario {
	public void altaUsuario(DtUsuario u);

	public void altaDtArtista(DtArtista dtArtista);

	public void altaDtEspectador(DtEspectador dtEspectador);

	//public void altaDtArtista(DtArtista dtArtista) throws UsuarioRepetidoExcepcion ;
	
	//public void altaDtEspectador(DtEspectador dtEspectador) throws UsuarioRepetidoExcepcion ;
	
	public void modificarUsuario(Usuario nuevo);

	public Usuario obtenerUsuario(String nickname);

	public Artista obtenerArtista(String nickname);

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
}