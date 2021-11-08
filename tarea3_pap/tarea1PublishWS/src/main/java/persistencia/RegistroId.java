package persistencia;

import java.io.Serializable;
import java.util.Objects;

public class RegistroId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private UsuarioId e;
	private String f;	
	
	public RegistroId() {
		super();
	}

	public UsuarioId getE() {
		return e;
	}

	public void setE(UsuarioId e) {
		this.e = e;
	}

	public String getF() {
		return f;
	}

	public void setF(String f) {
		this.f = f;
	}

	@Override
	public int hashCode() {
		return Objects.hash(e, f);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistroId other = (RegistroId) obj;
		return Objects.equals(e, other.e) && Objects.equals(f, other.f);
	}	
}
