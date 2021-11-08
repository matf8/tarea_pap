package logica;

import java.util.Date;
import java.util.Objects;

public class Compra {
	private Date fecha;	

	public Compra(){}

	public Compra(Date f){		
		this.fecha = f;	
	}
		
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date f) {
		this.fecha = f;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return Objects.equals(fecha, other.fecha);
	}	
	
}
	