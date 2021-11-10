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
	private IControladorUsuario iconU;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorUsuarioPublish() {
		fabrica = Fabrica.getInstancia();
		iconU = fabrica.getIControladorUsuario();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			System.out.println("Exception config Usuario");
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
	@WebMethod(exclude = true)
	public void altaUsuario(DtUsuario dtu) {
		iconU.altaUsuario(dtu);
	}

	@WebMethod
	public void altaDtArtista(DtArtista dta) { // throws UsuarioRepetidoExcepcion {
		iconU.altaDtArtista(dta);
	}

	@WebMethod
	public void altaDtEspectador(DtEspectador dte) { // throws UsuarioRepetidoExcepcion {
		iconU.altaDtEspectador(dte);
	}

	@WebMethod
	public boolean emailRepetido(String email) {
		return iconU.emailRepetido(email);
	}

	@WebMethod
	public void seguirUsuario(String nicknameUsuario, String nicknameUsuarioASeguir) {
		iconU.seguirUsuario(nicknameUsuario, nicknameUsuarioASeguir);
	}

	@WebMethod
	public void dejarDeSeguirUsuario(String nicknameUsuario, String nicknameUsuarioADejarDeSeguir) {
		iconU.dejarDeSeguirUsuario(nicknameUsuario, nicknameUsuarioADejarDeSeguir);
	}

	@WebMethod
	public Usuario obtenerUsuario(String nickname) {
		return iconU.obtenerUsuario(nickname);
	}

	@WebMethod
	public Artista obtenerArtista(String nickname) {
		return iconU.obtenerArtista(nickname);
	}

	@WebMethod
	public String[] listarNicknameUsuarios() {
		List<String> nicknames = iconU.listarNicknameUsuarios();
	
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
		List<String> nicknames = iconU.listarNicknameArtistas();
		
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
		List<String> nicknames = iconU.listarNicknameEspectadores();
		
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
		List<String> nicknames = iconU.listarNicknameUsuariosNoSeguidos(nickname);
		
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
		List<String> nicknames = iconU.listarNicknameUsuariosSeguidos(nickname);
		
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
		return iconU.getLoginUsuario(nickname);
	}

	@WebMethod
	public DtArtista getLoginArtista(String nickname) {
		return iconU.getLoginArtista(nickname);
	}
	
	@WebMethod
	public DtUsuario getLoginUsuarioMail(String mail) {
		return iconU.getLoginUsuarioMail(mail);
	}
}
