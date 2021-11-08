package logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import org.apache.commons.codec.binary.Base64;

import datatypes.DtPaquete;
import persistencia.Conexion;

@Entity
public class Paquete {
	@Id
	private String nombre;
	private String descripcion;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private LocalDate fechaRegistro;
	private float descuento;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Espectaculo> espectaculos = new ArrayList<>();
	@Lob
	@Column(columnDefinition="mediumblob")
	private byte[] imagen;
	
	public Paquete() {
		super();
	}

	public Paquete(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, LocalDate fechaR, float descuento, ArrayList<Espectaculo> espec, byte[] img) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaRegistro = fechaR;
		this.descuento = descuento;
		this.espectaculos = espec;
		this.imagen = img;
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

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
		
	public List<Espectaculo> getEspectaculos() {
		return espectaculos;
	}

	public void setEspectaculos(List<Espectaculo> espectaculos) {
		this.espectaculos = espectaculos;
	}

	public ArrayList<String> obtenerEspectaculos(){		
		ArrayList<String> ret = new ArrayList<>();
		for(Espectaculo e: espectaculos)			
			ret.add(e.getNombre());
		return ret;		
	}
	
	public DtPaquete getDt() {
		ArrayList<String> lE = new ArrayList<>();
		DtPaquete ret;
		lE = this.obtenerEspectaculos();
		ret = new DtPaquete(this.nombre, this.descripcion, this.fechaInicio, this.fechaFin, this.fechaRegistro, this.descuento,	lE);
		return ret;
	}
	
	public void agregarEspectaculo(Espectaculo es) {
		espectaculos.add(es);
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();		
		em.persist(this);		
		em.getTransaction().commit();
	}
	
	public boolean contieneEspectaculo(String nombreEsp) {
		int i=0;
		boolean ret = false;
		while (i < espectaculos.size() && !ret)	{		
			ret = espectaculos.get(i).getNombre().equals(nombreEsp);
			i++;
		}
		return ret;
	}
	
	public byte[] getImagen() {
        return imagen;
	}	

	public String getImagen64() throws Exception {		
		if (imagen != null) {  
			byte[] encodeBase64 = Base64.encodeBase64(imagen);
			String base64Encoded = new String(encodeBase64, "UTF-8");    
			return base64Encoded;		
		} else return null;
	}
		 
	public void setImagen(byte[] i) {
	        this.imagen = i;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(imagen);
		result = prime * result
				+ Objects.hash(descripcion, descuento, espectaculos, fechaFin, fechaInicio, fechaRegistro, nombre);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paquete other = (Paquete) obj;
		return Objects.equals(descripcion, other.descripcion)
				&& Float.floatToIntBits(descuento) == Float.floatToIntBits(other.descuento)
				&& Objects.equals(espectaculos, other.espectaculos) && Objects.equals(fechaFin, other.fechaFin)
				&& Objects.equals(fechaInicio, other.fechaInicio) && Objects.equals(fechaRegistro, other.fechaRegistro)
				&& Arrays.equals(imagen, other.imagen) && Objects.equals(nombre, other.nombre);
	}	
}