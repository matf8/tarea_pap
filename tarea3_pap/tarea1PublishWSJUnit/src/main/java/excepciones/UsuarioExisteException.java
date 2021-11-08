package excepciones;

public class UsuarioExisteException extends Exception {
	private static final long serialVersionUID = 1L;

	public UsuarioExisteException(String s) {
		super(s);
	}

}
