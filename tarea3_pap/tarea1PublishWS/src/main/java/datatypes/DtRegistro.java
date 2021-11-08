package datatypes;

import java.util.Date;

public class DtRegistro {
	private String nombreFuncion;
	private Date fechaReg;
	private float costo;	
    
	public DtRegistro() {
		super();
	}
	
	public DtRegistro(String n, Date f, float c) {
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

	public Date getFechaReg() {
		return fechaReg;
	}
		
	public void setNombreFuncion(String nombreFuncion) {
		this.nombreFuncion = nombreFuncion;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public String toString() {
		return "función: " + this.nombreFuncion + "\nfecha registro: " + this.fechaReg + "\ncosto: $" + this.costo + "\n";
	}			
}