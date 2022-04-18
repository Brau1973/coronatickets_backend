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
//import logica.Plataforma;

@WebService
@SOAPBinding(style=Style.RPC,parameterStyle=ParameterStyle.WRAPPED)
public class ControladorPlataformaPublish {
	private Fabrica fabrica;
	private IControladorPlataforma iconP;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorPlataformaPublish() {
		fabrica = Fabrica.getInstancia();
		iconP = fabrica.getIControladorPlataforma();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			System.out.println("Exception config Plataforma");
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

	// LOS MÉTODOS QUE VAMOS A PUBLICAR
	@WebMethod
	public void altaPlataforma(DtPlataforma dtp) throws PlataformaRepetidaExcepcion {
		iconP.altaPlataforma(dtp);
	}

	@WebMethod
	public DtPlataforma[] listarPlataformas() {
		List<DtPlataforma> listPlataformas = iconP.listarPlataformas();
		int i = 0;
		DtPlataforma[] ret = new DtPlataforma[listPlataformas.size()];
		for (DtPlataforma dtp : listPlataformas) {
			ret[i] = dtp;
			i++;
		}
		return ret;
	}

	@WebMethod
	public String[] listarPlataformasStr() {
		List<String> lst = iconP.listarPlataformasStr();
		String[] arr = new String[lst.size()];
		arr = lst.toArray(arr);
		return arr;
	}

	/*
	@WebMethod  (exclude = true) // VER
	public DtPlataforma[] mapListEntityToDt(List<Plataforma> p) {
		List<DtPlataforma> lst = iconP.mapListEntityToDt(p);
		DtPlataforma[] ret = new DtPlataforma[lst.size()];
		ret = lst.toArray(ret);
		return ret;
	}

	@WebMethod
	public DtPlataforma mapEntityToDt(Plataforma p) {
		return iconP.mapEntityToDt(p);
	}
	*/
}
