package datatypes;

import java.util.ArrayList;
import java.util.Date;

public class DtPaquete {
	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaRegistro;
	private float descuento;
	private ArrayList<String> espectaculos = new ArrayList<>();	
	
	public DtPaquete() {
		super();
	}
	
	public DtPaquete(String nombre, String descripcion, Date fechaInicio, Date fechaFin, Date fechaRegistro, float descuento, ArrayList<String> espectaculos) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaRegistro = fechaRegistro;
		this.descuento = descuento;
		this.espectaculos = espectaculos;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public void setEspectaculos(ArrayList<String> espectaculos) {
		this.espectaculos = espectaculos;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}
	
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
		
	public float getDescuento() {
		return descuento;
	}
	
	public ArrayList<String> getEspectaculos() {
		return espectaculos;
	}
	
	@Override	
	public String toString() {
		return "Paquete: " + this.nombre + "\ndescripcion: " + this.descripcion + "\nFecha de inicio: " + this.fechaInicio + "\nFecha de inicio: " 
	    + this.fechaFin + "\ndescuento: " + this.descuento + "\nespectaculos: " + this.espectaculos.toString();
	}
	
}

