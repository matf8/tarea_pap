package logica;

import java.util.ArrayList;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	
	public Paquete() {
		super();
	}

	public Paquete(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, LocalDate fechaR, float descuento, ArrayList<Espectaculo> espec) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaRegistro = fechaR;
		this.descuento = descuento;
		this.espectaculos = espec;
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
}