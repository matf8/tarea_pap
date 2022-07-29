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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getURL() {
		return url;
	}

	public void setURL(String url) {
		this.url = url;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getCantMin() {
		return cantMin;
	}

	public void setCantMin(int cantMin) {
		this.cantMin = cantMin;
	}

	public int getCantMax() {
		return cantMax;
	}

	public void setCantMax(int cantMax) {
		this.cantMax = cantMax;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public LocalDate getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(LocalDate fechaReg) {
		this.fechaReg = fechaReg;
	}

	public String getOrganizador() {
		return organizador;
	}

	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String toString() {
		return "ESPECTACULO: " + this.getNombre() + "\nOrganizador: " + this.organizador + "\nPlataforma: " + this.plataforma + "\nDescripcion: " + this.getDescripcion() + 
				"\nDuracion: " + this.duracion +"\nUrl: "+ this.url + "\nCosto:" +  this.costo +
				"\nCantMin: "+ this.cantMin +"\nCantMax: " + this.cantMax;				
	}				
	
}