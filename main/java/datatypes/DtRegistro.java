package datatypes;

import java.time.LocalDate;

public class DtRegistro {
	private String nombreFuncion;
	private LocalDate fechaReg;
	private float costo;	
    
	public DtRegistro(String n, LocalDate f, float c) {
		super();
		this.nombreFuncion = n;
		this.fechaReg = f;
		this.costo = c;
	}

	public String getNombreFuncion() {
		return this.nombreFuncion;
	}
	
	public float getCosto() {
		return costo;
	}

	public LocalDate getFechaReg() {
		return fechaReg;
	}
	
	public String toString() {
		return "funcion: " + this.nombreFuncion + "\nfecha registro: " + this.fechaReg + "\ncosto: $" + this.costo + "\n";
	}	
}