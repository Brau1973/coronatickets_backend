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
import excepciones.FuncionYaRegistradaEnEspectaculoExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorFuncion;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorFuncionPublish {
	private Fabrica fabrica;
	private IControladorFuncion iconF;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorFuncionPublish() {
		fabrica = Fabrica.getInstancia();
		iconF = fabrica.getIControladorFuncion();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			System.out.println("Exception config Funcion");
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
	@WebMethod
	public void altaFuncion(DtFuncion dtFuncion, String nombreEspectaculo) throws FuncionYaRegistradaEnEspectaculoExcepcion {
		iconF.altaFuncion(dtFuncion, nombreEspectaculo);
	}

	@WebMethod
	public DtFuncion[] listarFunciones(String nomEsp) {
		List<DtFuncion> lst = iconF.listarFunciones(nomEsp);
		DtFuncion[] arr = new DtFuncion[lst.size()];
		arr = lst.toArray(arr);
		return arr;
	}

	@WebMethod
	public String[] getFuncionesVigentesRegistradasPorEspectador(String nicknameEspectador) {
		List<String> lst = iconF.getFuncionesVigentesRegistradasPorEspectador(nicknameEspectador);
		String[] arr = new String[lst.size()];
		arr = lst.toArray(arr);
		return arr;
	}
	
	@WebMethod
	public DtFuncion getInfoFuncion (String nomFun) {
		DtFuncion infoFuncion = iconF.getInfoFuncion(nomFun);
		return infoFuncion;
	}

}
