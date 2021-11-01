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
import datatypes.DtEspectaculo;
import datatypes.DtSocio;
import datatypes.DtSpinning;
import datatypes.DtUsuario;
import excepciones.EspectaculoRepetidoExcepcion;
import excepciones.UsuarioRepetidoExcepcion;
import interfaces.Fabrica;
import interfaces.IControlador;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorUsuario;
import logica.Artista;
import logica.Espectaculo;
import logica.Usuario;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorEspectaculoPublish {
	private Fabrica fabrica;
	private IControladorEspectaculo icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorEspectaculoPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorEspectaculo();
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
	public void altaEspectaculo(DtEspectaculo dte, String nombrePlataforma) throws EspectaculoRepetidoExcepcion{
		icon.altaEspectaculo(dte, nombrePlataforma);
	}
	
	@WebMethod
	public Espectaculo obtenerEspectaculo(String nombre){
		icon.obtenerEspectaculo(nombre);
	}
	
	@WebMethod
	public List<DtEspectaculo> listarEspectaculos(String nombrePlataforma){
		icon.listarEspectaculos(nombrePlataforma);
	}
	
	@WebMethod
	public List<DtEspectaculo> obtenerAllDtEspectaculos(String nickname){
		icon.obtenerAllDtEspectaculos(nickname);
	}
	
	@WebMethod
	public List<DtEspectaculo> listEntityToDtEsp(List<Espectaculo> liste){
		icon.listEntityToDtEsp(liste);
	}
	
	@WebMethod
	public List<Espectaculo> obtenerEspectaculo2(String plataforma){
		icon.obtenerEspectaculo2(plataforma);
	}
	
	@WebMethod
	public List<String> obtenerEspectaculosArtista(String nickname){ // veer
		return icon.obtenerEspectaculosArtista(nickname);
	}
}
