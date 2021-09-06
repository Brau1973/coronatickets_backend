package excepciones;

public class FuncionYaRegistradaEnEspectaculoExcepcion extends Exception{
	private static final long serialVersionUID = 1L;

	public FuncionYaRegistradaEnEspectaculoExcepcion(String string) {
        super(string);
    }
}