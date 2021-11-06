package publicadores;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtUsuario;
import excepciones.UsuarioRepetidoExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorUsuario;
import logica.Artista;
import logica.Espectador;
import logica.Usuario;
import manejadores.ManejadorUsuario;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorUsuarioPublish {
	private Fabrica fabrica;
	private IControladorUsuario icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorUsuarioPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorUsuario();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {

		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorUsuario", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorUsuario");
	}

	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
		return endpoint;
	}

	// LOS MÉTODOS QUE VAMOS A PUBLICAR
	@WebMethod	
	public void altaDtArtista(DtArtista dtArtista) throws UsuarioRepetidoExcepcion {
		icon.altaDtArtista(dtArtista);
	}
	
	@WebMethod	
	public void altaDtEspectador(DtEspectador dtEspectador) throws UsuarioRepetidoExcepcion {
		icon.altaDtEspectador(dtEspectador);
	}

	@WebMethod
	public boolean emailRepetido(String email) {
		return icon.emailRepetido(email);
	}

	@WebMethod
	public void seguirUsuario(String nicknameUsuario, String nicknameUsuarioASeguir) {
		icon.seguirUsuario(nicknameUsuario, nicknameUsuarioASeguir);
	}

	@WebMethod
	public void dejarDeSeguirUsuario(String nicknameUsuario, String nicknameUsuarioADejarDeSeguir) {
		icon.dejarDeSeguirUsuario(nicknameUsuario, nicknameUsuarioADejarDeSeguir);
	}

	@WebMethod
	public Usuario obtenerUsuario(String nickname) {
		return icon.obtenerUsuario(nickname);
	}

	@WebMethod
	public Artista obtenerArtista(String nickname) {
		return icon.obtenerArtista(nickname);
	}

	@WebMethod
	public String[] listarNicknameUsuarios() {
		List<String> nicknames = icon.listarNicknameUsuarios();
	
		int i = 0;
		String[] ret = new String[nicknames.size()];
		for (String nickname : nicknames) {
			ret[i] = nickname;
			i++;
		}
		return ret;
	}

	@WebMethod
	public String[] listarNicknameArtistas() {
		List<String> nicknames = icon.listarNicknameArtistas();
		
		int i = 0;
		String[] ret = new String[nicknames.size()];
		for (String nickname : nicknames) {
			ret[i] = nickname;
			i++;
		}
		return ret;
	}

	@WebMethod
	public String[] listarNicknameEspectadores() {
		List<String> nicknames = icon.listarNicknameEspectadores();
		
		int i = 0;
		String[] ret = new String[nicknames.size()];
		for (String nickname : nicknames) {
			ret[i] = nickname;
			i++;
		}
		return ret;
	}

	@WebMethod
	public String[] listarNicknameUsuariosNoSeguidos(String nickname) {
		
		List<String> nicknames = icon.listarNicknameUsuariosNoSeguidos(nickname);
		
		int i = 0;
		String[] ret = new String[nicknames.size()];
		for (String nick : nicknames) {
			ret[i] = nick;
			i++;
		}
		return ret;
	}

	@WebMethod
	public String[] listarNicknameUsuariosSeguidos(String nickname) {
		
		List<String> nicknames = icon.listarNicknameUsuariosSeguidos(nickname);
		
		int i = 0;
		String[] ret = new String[nicknames.size()];
		for (String nick : nicknames) {
			ret[i] = nick;
			i++;
		}
		return ret;
	}

	@WebMethod
	public DtUsuario getLoginUsuario(String nickname) {
		return icon.getLoginUsuario(nickname);
	}

	@WebMethod
	public DtUsuario getLoginUsuarioMail(String mail) {
		return icon.getLoginUsuarioMail(mail);
	}
}
