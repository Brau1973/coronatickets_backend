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
	private IControladorPaquete iconPa;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorPaquetePublish() {
		fabrica = Fabrica.getInstancia();
		iconPa = fabrica.getIControladorPaquete();
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
	public void altaPaquete(DtPaqueteEspectaculo dtPaqueteEspe) {
		iconPa.altaPaquete(dtPaqueteEspe);
	}

	@WebMethod
	public Boolean existePaquete(String nombre) {
		return iconPa.existePaquete(nombre);
	}

	@WebMethod
	public DtPaqueteEspectaculo[] obtenerPaquetes() {
		List<DtPaqueteEspectaculo> lst = iconPa.obtenerPaquetes();
		DtPaqueteEspectaculo[] ret = new DtPaqueteEspectaculo[lst.size()];
		ret = lst.toArray(ret);
		return ret;
	}

	@WebMethod
	public void agregarEspectaculo(String paquete, String espectaculo) {
		iconPa.agregarEspectaculo(paquete, espectaculo);
	}
}
