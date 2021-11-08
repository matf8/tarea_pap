package excepciones;

public class PaqueteNoValidoException extends Exception {
	private static final long serialVersionUID = 1L;

	public PaqueteNoValidoException(String p) {
		super(p);
	}
}
