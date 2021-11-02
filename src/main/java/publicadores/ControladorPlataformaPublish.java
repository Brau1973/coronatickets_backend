package publicadores;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtPlataforma;
import excepciones.PlataformaRepetidaExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorPlataforma;
import logica.Plataforma;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPlataformaPublish {
	private Fabrica fabrica;
	private IControladorPlataforma icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorPlataformaPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorPlataforma();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorPlataforma", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorPlataforma");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//LOS MÉTODOS QUE VAMOS A PUBLICAR
	@WebMethod
	public void altaPlataforma(DtPlataforma dtPlataforma) throws PlataformaRepetidaExcepcion {
		icon.altaPlataforma(dtPlataforma);
	}
	
	@WebMethod
	public List<DtPlataforma> listarPlataformas() { 
		return icon.listarPlataformas();
	}
	
	@WebMethod
	public List<String> listarPlataformasStr() {
		return icon.listarPlataformasStr();
	}
	
	@WebMethod
	public Plataforma buscarPlataforma(String nombrePlataforma) {
		return icon.buscarPlataforma(nombrePlataforma);
	}
	
	@WebMethod
	public List<DtPlataforma> mapListEntityToDt(List<Plataforma> p){
		return icon.mapListEntityToDt(p);
	}
	
	@WebMethod
	public DtPlataforma mapEntityToDt(Plataforma p){
		return icon.mapEntityToDt(p);
	}
}
