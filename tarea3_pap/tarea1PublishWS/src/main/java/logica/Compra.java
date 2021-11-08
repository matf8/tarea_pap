package logica;

import java.util.Date;

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
}
	