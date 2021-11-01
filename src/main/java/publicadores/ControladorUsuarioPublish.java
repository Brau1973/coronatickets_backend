package publicadores;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtClase;
import datatypes.DtEntrenamiento;
import datatypes.DtSocio;
import datatypes.DtSpinning;
import datatypes.DtUsuario;
import excepciones.UsuarioRepetidoExcepcion;
import interfaces.Fabrica;
import interfaces.IControlador;
import interfaces.IControladorUsuario;
import logica.Artista;
import logica.Usuario;

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

//	@WebMethod(exclude = true)
//	public void publicar() {
//		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controlador", this);
//		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controlador");
//	}
//	
//	@WebMethod(exclude = true)
//	public Endpoint getEndpoint() {
//        return endpoint;
//	}
	
	//LOS MÉTODOS QUE VAMOS A PUBLICAR
	@WebMethod
	public void altaUsuario(DtUsuario dtu) throws UsuarioRepetidoExcepcion{
		icon.altaUsuario(dtu);
	}
	
	@WebMethod
	public boolean emailRepetido(String email){
		icon.emailRepetido(email);
	}
	
	@WebMethod
	public void seguirUsuario(String nicknameUsuario, String nicknameUsuarioASeguir){
		icon.seguirUsuario(nicknameUsuario, nicknameUsuarioASeguir);
	}
	
	@WebMethod
	public void dejarDeSeguirUsuario(String nicknameUsuario, String nicknameUsuarioADejarDeSeguir){
		icon.dejarDeSeguirUsuario(nicknameUsuario, nicknameUsuarioADejarDeSeguir);
	}
	
	@WebMethod
	public Usuario obtenerUsuario(String nickname){
		icon.obtenerUsuario(nickname);
	}
	
	@WebMethod
	public Artista obtenerArtista(String nickname){
		icon.obtenerArtista(nickname);
	}
	
	@WebMethod
	public List<String> listarNicknameUsuarios(){
		return icon.listarNicknameUsuarios()
	}
	
	@WebMethod
	public List<String> listarNicknameArtistas(){
		return icon.listarNicknameArtistas();
	}
	
	@WebMethod
	public List<String> listarNicknameEspectadores(){
		return icon.listarNicknameEspectadores();
	}
	
	@WebMethod
	public List<String> listarNicknameUsuariosNoSeguidos(String nickname){
		return icon.listarNicknameUsuariosNoSeguidos(nickname);
	}
	
	@WebMethod
	public List<String> listarNicknameUsuariosSeguidos(String nickname){
		return icon.listarNicknameUsuariosSeguidos(nickname);
	}
	
	@WebMethod
	public DtUsuario getLoginUsuario(String nickname){
		return icon.getLoginUsuario(nickname);
	}
	
	@WebMethod
	public DtUsuario getLoginUsuarioMail(String mail){
		return icon.getLoginUsuarioMail(mail);
	}
	
	

}
