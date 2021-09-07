package logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import datatypes.DtFuncion;

@Entity
public class Funcion {
	@Id
	private String nombre;
	private LocalDate fecha;
	private LocalTime horaInicio;
	private LocalDate fechaRegistro;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Artista> artistasInvitados = new ArrayList<>();
	
	@OneToMany(mappedBy="f",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Registro> registros = new ArrayList<>();
	
	public Funcion() {
		super();
	}

	public Funcion(String nombre, LocalDate fecha, LocalTime horaInicio, LocalDate fechaRegistro, List<Artista> aI) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.fechaRegistro = fechaRegistro;
		this.artistasInvitados = aI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public ArrayList<String> obtenerArtistasInvitados(){		
		ArrayList<String> ret = new ArrayList<>();
		for(Artista f: artistasInvitados)			
			ret.add(f.getNickName());
		return ret;		
	}

	public DtFuncion getDt() {
		ArrayList<String> ret = obtenerArtistasInvitados();
		return new DtFuncion(this.getNombre(),this.getFecha(),this.getHoraInicio(),this.getFechaRegistro(), ret);
	}

	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}	
}
