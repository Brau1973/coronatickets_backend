package excepciones;

public class FuncionRepetidaExcepcion extends Exception{

    private static final long serialVersionUID = 1L;

    public FuncionRepetidaExcepcion(String string){
	 super(string);
    }
}
