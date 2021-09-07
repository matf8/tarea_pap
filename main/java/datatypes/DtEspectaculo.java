package datatypes;

import java.time.LocalDate;

public class DtEspectaculo {
	private String nombre;
	private String descripcion;
	private String url;
	private int duracion;
	private int cantMin; // cantidad espectadores
	private int cantMax;
	private float costo;
	private LocalDate fechaReg;
	private String organizador;
	private String plataforma;

	public DtEspectaculo(String nombre, String descripcion, String url, int duracion, int cMax, int cMin, float costo, LocalDate f, String org, String plat) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
		this.duracion = duracion;
		this.cantMax = cMax;
		this.cantMin = cMin;
		this.costo = costo;
		this.fechaReg = f;		
		this.organizador = org;
		this.plataforma = plat;
	}	

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getURL() {
		return url;
	}
	
	public int getDuracion() {
		return duracion;
	}

	public int getCantMax() {
		return cantMax;
	}

	public int getCantMin() {
		return cantMin;
	}

	public float getCosto() {
		return costo;
	}

	public LocalDate getFechaReg(){
		return fechaReg;
	}
	
	public String toString() {
		return "ESPECTACULO: " + this.getNombre() + "\nOrganizador: " + this.organizador + "\nPlataforma: " + this.plataforma + "\nDescripcion: " + this.getDescripcion() + 
				"\nDuracion: " + this.duracion +"\nUrl: "+ this.url + "\nCosto:" +  this.costo +
				"\nCantMin: "+ this.cantMin +"\nCantMax: " + this.cantMax;				
	}				
	
}