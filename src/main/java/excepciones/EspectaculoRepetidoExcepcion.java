package excepciones;

public class EspectaculoRepetidoExcepcion extends Exception{
    private static final long serialVersionUID = 1L;

    public EspectaculoRepetidoExcepcion(String string){
	 super(string);
    }
}
