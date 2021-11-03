package publicadores;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtFuncion;
import interfaces.Fabrica;
import interfaces.IControladorFuncion;
import logica.Funcion;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorFuncionPublish {
	private Fabrica fabrica;
	private IControladorFuncion icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorFuncionPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorFuncion();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {

		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorFuncion", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorFuncion");
	}

	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
		return endpoint;
	}

	// LOS MÉTODOS QUE VAMOS A PUBLICAR

	//  @WebMethod
	//	public void altaFuncion(DtFuncion dtFuncion, String nombreEspectaculo, byte[] imagen) {
	//		icon.altaFuncion(dtFuncion, nombreEspectaculo, imagen);
	//  }

	//	@WebMethod
	//  public List<DtFuncion> listarFunciones(String nomEsp) {
	//		return icon.listarFunciones(nomEsp);
	//	}

	//	@WebMethod
	//	public List<String> getFuncionesVigentesRegistradasPorEspectador(String nicknameEspectador) {
	//		return icon.getFuncionesVigentesRegistradasPorEspectador(nicknameEspectador);
	//	}

	//	@WebMethod
	//	public Funcion obtenerFuncion(String nombre) {
	//		return icon.obtenerFuncion(nombre);
	//	}
}
