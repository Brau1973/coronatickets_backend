package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtRegistro;
import interfaces.Fabrica;
import interfaces.IControladorRegistro;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorRegistroPublish {
	private Fabrica fabrica;
	private IControladorRegistro icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorRegistroPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorRegistro();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {

		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorRegistro", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorRegistro");
	}

	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
		return endpoint;
	}

	// LOS MÉTODOS QUE VAMOS A PUBLICAR
	@WebMethod
	public void altaRegistro(DtRegistro dtRegistro, String nicknameEspectador) {
		icon.altaRegistro(dtRegistro, nicknameEspectador);
	}

}
