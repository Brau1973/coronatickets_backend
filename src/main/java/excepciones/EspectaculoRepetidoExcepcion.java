package excepciones;

import javax.xml.ws.WebFault;

@WebFault
public class EspectaculoRepetidoExcepcion extends Exception{
	private static final long serialVersionUID = 1L;

	private String errorDetails;
	
	public EspectaculoRepetidoExcepcion(String string, String errorDetails) {
		super(string);
		this.errorDetails = errorDetails;
	}

	public String getFaultInfo() {
		return errorDetails;
	}
}
