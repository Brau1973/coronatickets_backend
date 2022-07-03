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
import datatypes.DtPaqueteEspectaculos;
import interfaces.Fabrica;
import interfaces.IControladorPaquete;

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
	public void altaPaquete(DtPaqueteEspectaculos dtPaqueteEspe) {
		iconPa.altaPaquete(dtPaqueteEspe);
	}

	@WebMethod
	public Boolean existePaquete(String nombre) {
		return iconPa.existePaquete(nombre);
	}

	@WebMethod
	public DtPaqueteEspectaculos[] obtenerPaquetes() {
		List<DtPaqueteEspectaculos> lst = iconPa.obtenerPaquetes();
		DtPaqueteEspectaculos[] ret = new DtPaqueteEspectaculos[lst.size()];
		ret = lst.toArray(ret);
		return ret;
	}

	@WebMethod
	public void agregarEspectaculo(String paquete, String espectaculo) {
		iconPa.agregarEspectaculo(paquete, espectaculo);
	}
	
	@WebMethod
	public DtEspectaculo[] getEspectaculosDePaquete(String paquete) { 
		List<DtEspectaculo> lst=iconPa.getEspectaculosDePaquete(paquete);
		DtEspectaculo[] arr=new DtEspectaculo[lst.size()];
		arr=lst.toArray(arr);
		return arr;
	}
	
	@WebMethod
	public DtPaqueteEspectaculos getInfoPaquete (String nomPaquete) { 
		return iconPa.getInfoPaquete(nomPaquete);
	}
	
}
