package datatypes;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class DtPaquete {
	private String nombre;
	private String descripcion;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private LocalDate fechaRegistro;
	private float descuento;
	private ArrayList<String> espectaculos = new ArrayList<>();	
	
	public DtPaquete(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, LocalDate fechaRegistro, float descuento,	ArrayList<String> espectaculos) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaRegistro = fechaRegistro;
		this.descuento = descuento;
		this.espectaculos = espectaculos;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	
	public LocalDate getFechaRegistro() {
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

