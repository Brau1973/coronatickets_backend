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
			System.out.println("config ok" );
		} catch (Exception ex) {
			System.out.println("Exception config" );
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		System.out.println("http://");
		System.out.println("1http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorEspectaculo");
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
	public DtEspectaculo[] listarEspectaculos(String nombrePlataforma) {
		List<DtEspectaculo> espectaculos = icon.listarEspectaculos(nombrePlataforma);
		
		int i = 0;
		DtEspectaculo[] ret = new DtEspectaculo[espectaculos.size()];
		for (DtEspectaculo espec : espectaculos) {
			ret[i] = espec;
			i++;
		}
		return ret;
	}

	@WebMethod
	public DtEspectaculo[] obtenerAllDtEspectaculos(String nickname) {
		List<DtEspectaculo> espectaculos = icon.obtenerAllDtEspectaculos(nickname);
		
		int i = 0;
		DtEspectaculo[] ret = new DtEspectaculo[espectaculos.size()];
		for (DtEspectaculo espec : espectaculos) {
			ret[i] = espec;
			i++;
		}
		return ret;
	}

	@WebMethod
	public DtEspectaculo[] listEntityToDtEsp(List<Espectaculo> liste) {
		
		List<DtEspectaculo> espectaculos = icon.listEntityToDtEsp(liste);
		
		int i = 0;
		DtEspectaculo[] ret = new DtEspectaculo[espectaculos.size()];
		for (DtEspectaculo espec : espectaculos) {
			ret[i] = espec;
			i++;
		}
		return ret;
	}

	@WebMethod
	public Espectaculo[] obtenerEspectaculo2(String plataforma) {
		
		List<Espectaculo> espectaculos = icon.obtenerEspectaculo2(plataforma);
		
		int i = 0;
		Espectaculo[] ret = new Espectaculo[espectaculos.size()];
		for (Espectaculo espec : espectaculos) {
			ret[i] = espec;
			i++;
		}
		return ret;
	}

	@WebMethod
	public String[] obtenerEspectaculosArtista(String nickname) { // veer

		List<String> espectaculos = icon.obtenerEspectaculosArtista(nickname);
		
		int i = 0;
		String[] ret = new String[espectaculos.size()];
		for (String espec : espectaculos) {
			ret[i] = espec;
			i++;
		}
		return ret;
	}
}
