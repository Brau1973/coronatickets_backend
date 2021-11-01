package publicadores;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtClase;
import datatypes.DtEntrenamiento;
import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtSocio;
import datatypes.DtSpinning;
import datatypes.DtUsuario;
import excepciones.EspectaculoRepetidoExcepcion;
import excepciones.FuncionYaRegistradaEnEspectaculoExcepcion;
import excepciones.UsuarioRepetidoExcepcion;
import interfaces.Fabrica;
import interfaces.IControlador;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorFuncion;
import interfaces.IControladorUsuario;
import logica.Artista;
import logica.Espectaculo;
import logica.Funcion;
import logica.Usuario;

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

//	@WebMethod(exclude = true)
//	public void publicar() {
//		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controlador", this);
//		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controlador");
//	}
//	
//	@WebMethod(exclude = true)
//	public Endpoint getEndpoint() {
//        return endpoint;
//	}
	
	//LOS MÉTODOS QUE VAMOS A PUBLICAR
	@WebMethod
	public void altaFuncion(DtFuncion dtFuncion, String nombreEspectaculo, byte[] imagen) throws FuncionYaRegistradaEnEspectaculoExcepcion{
		icon.altaFuncion(dtFuncion, nombreEspectaculo, imagen);
	}
	
	@WebMethod
	public List<DtFuncion> listarFunciones(String nomEsp){
		icon.listarFunciones(nomEsp);
	}
	
	@WebMethod
	public List<String> getFuncionesVigentesRegistradasPorEspectador(String nicknameEspectador){
		icon.getFuncionesVigentesRegistradasPorEspectador(nicknameEspectador);
	}
	
	@WebMethod
	public Funcion obtenerFuncion(String nombre){ // Ok Seba 23-10-2021
		icon.obtenerFuncion(nombre);
	}
}
