package persistencia;

import java.io.Serializable;
import java.util.Objects;

public class CompraPaqueteId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private UsuarioId e;
	private String p;
	
	public CompraPaqueteId() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(e,p);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompraPaqueteId other = (CompraPaqueteId) obj;
		return Objects.equals(e, other.e)&& Objects.equals(p, other.p);
	}	
}
