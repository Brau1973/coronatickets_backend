package publicadores;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtPaqueteEspectaculo;
import interfaces.Fabrica;
import interfaces.IControladorPaquete;
import logica.PaqueteEspectaculos;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPaquetePublish {
	private Fabrica fabrica;
	private IControladorPaquete icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorPaquetePublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorPaquete();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {

		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorPaquete", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorPaquete");
	}

	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
		return endpoint;
	}

	// LOS MÉTODOS QUE VAMOS A PUBLICAR
	@WebMethod
	public void altaPaquete(PaqueteEspectaculos pEsp) {
		icon.altaPaquete(pEsp);
	}

	@WebMethod
	public Boolean existePaquete(String nombre) {
		return icon.existePaquete(nombre);
	}

	@WebMethod
	public List<DtPaqueteEspectaculo> obtenerPaquetes() {
		return icon.obtenerPaquetes();
	}

	@WebMethod
	public void agregarEspectaculo(String paquete, String espectaculo) {
		icon.agregarEspectaculo(paquete, espectaculo);
	}
}
