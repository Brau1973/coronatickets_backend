package excepciones;

import javax.xml.ws.WebFault;

@WebFault
public class FuncionYaRegistradaEnEspectaculoExcepcion extends Exception{
	private static final long serialVersionUID = 1L;

	private String errorDetails;
	
	public FuncionYaRegistradaEnEspectaculoExcepcion(String string, String errorDetails) {
		super(string);
		this.errorDetails = errorDetails;
	}
	
	public String getFaultInfo() {
		return errorDetails;
	}
}