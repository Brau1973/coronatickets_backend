package publicadores;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.transaction.Transactional;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtUsuario;
import excepciones.UsuarioRepetidoExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorUsuario;
import logica.Artista;
import logica.Usuario;

@Transactional
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
	public void altaUsuario(DtUsuario dtu) throws UsuarioRepetidoExcepcion {
		iconU.altaUsuario(dtu);
	}

	@WebMethod
	public void altaDtArtista(DtArtista dtArtista)  throws UsuarioRepetidoExcepcion {
		iconU.altaDtArtista(dtArtista);
	}

	@WebMethod
	public void altaDtEspectador(DtEspectador dtEspectador) throws UsuarioRepetidoExcepcion {
		iconU.altaDtEspectador(dtEspectador);
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
		List<String> lst = iconU.listarNicknameUsuarios();
		String[] arr = new String[lst.size()];
		arr = lst.toArray(arr);
		return arr;
	}

	@WebMethod
	public String[] listarNicknameArtistas() {
		List<String> lst = iconU.listarNicknameArtistas();
		String[] arr = new String[lst.size()];
		arr = lst.toArray(arr);
		return arr;
	}

	@WebMethod
	public String[] listarNicknameEspectadores() {
		List<String> lst = iconU.listarNicknameEspectadores();
		String[] arr = new String[lst.size()];
		arr = lst.toArray(arr);
		return arr;
	}

	@WebMethod
	public String[] listarNicknameUsuariosNoSeguidos(String nickname) {
		List<String> lst = iconU.listarNicknameUsuariosNoSeguidos(nickname);
		String[] arr = new String[lst.size()];
		arr = lst.toArray(arr);
		return arr;
	}

	@WebMethod
	public String[] listarNicknameUsuariosSeguidos(String nickname) {
		List<String> lst = iconU.listarNicknameUsuariosSeguidos(nickname);
		String[] arr = new String[lst.size()];
		arr = lst.toArray(arr);
		return arr;
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
