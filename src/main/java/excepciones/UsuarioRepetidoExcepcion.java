package excepciones;

public class UsuarioRepetidoExcepcion extends Exception {
	private static final long serialVersionUID = 1L;

	public UsuarioRepetidoExcepcion(String string) {
		super(string);
	}
}
