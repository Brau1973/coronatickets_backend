package publicadores;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtEspectaculo;
import excepciones.EspectaculoRepetidoExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import logica.Espectaculo;

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

	@WebMethod(exclude = true)
	public void publicar() {
		System.out.println("http://");
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorEspectaculo", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorEspectaculo");
	}

	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
		return endpoint;
	}

	// LOS MÉTODOS QUE VAMOS A PUBLICAR
	@WebMethod
	public void altaEspectaculo(DtEspectaculo dte, String nombrePlataforma) throws EspectaculoRepetidoExcepcion {
		icon.altaEspectaculo(dte, nombrePlataforma);
	}

	@WebMethod
	public Espectaculo obtenerEspectaculo(String nombre) {
		return icon.obtenerEspectaculo(nombre);
	}

	@WebMethod
	public List<DtEspectaculo> listarEspectaculos(String nombrePlataforma) {
		return icon.listarEspectaculos(nombrePlataforma);
	}

	@WebMethod
	public List<DtEspectaculo> obtenerAllDtEspectaculos(String nickname) {
		return icon.obtenerAllDtEspectaculos(nickname);
	}

	@WebMethod
	public List<DtEspectaculo> listEntityToDtEsp(List<Espectaculo> liste) {
		return icon.listEntityToDtEsp(liste);
	}

	@WebMethod
	public List<Espectaculo> obtenerEspectaculo2(String plataforma) {
		return icon.obtenerEspectaculo2(plataforma);
	}

	@WebMethod
	public List<String> obtenerEspectaculosArtista(String nickname) { // veer
		return icon.obtenerEspectaculosArtista(nickname);
	}
}
