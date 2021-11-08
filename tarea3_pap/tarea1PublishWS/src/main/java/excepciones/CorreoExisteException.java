package excepciones;

public class CorreoExisteException extends Exception {
	private static final long serialVersionUID = 1L;

	public CorreoExisteException(String s) {
		super(s);
	}

}
