package datatypes;

import java.util.Date;

public class DtEspectaculo {
	private String nombre;
	private String descripcion;
	private String url;
	private int duracion;
	private int cantMin;
	private int cantMax;
	private float costo;
	private Date fechaReg;
	private String organizador;
	private String plataforma;
	private String fechaRegString;

	public DtEspectaculo() {
		super();
	}
	public DtEspectaculo(final String nombre, final String descripcion, final String url, final int duracion, final int cMax, final int cMin, final float costo, final Date f, final String org, final String plat) {
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

	public Date getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
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
	
	public String getFechaRegString() {
		return fechaRegString;
	}

	public void setFechaRegString(String fechaRegString) {
		this.fechaRegString = fechaRegString;
	}

	public String toString() {
		return "ESPECTACULO: " + this.getNombre() + "\nOrganizador: " + this.organizador + "\nPlataforma: " + this.plataforma + "\nDescripcion: " + this.getDescripcion() + 
				"\nDuracion: " + this.duracion +"\nUrl: "+ this.url + "\nCosto:" +  this.costo +
				"\nCantMin: "+ this.cantMin +"\nCantMax: " + this.cantMax;				
	}				
	
}