package datatypes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DtFuncion {
	private String nombre;
	private LocalDate fecha;
	private LocalTime horaIni;
	private LocalDate fechaReg;
	private ArrayList<String> artistasInvitados = new ArrayList<>();
	private String fechaString;
	private String horaIniString;
	private String fechaRegString;
	
	public DtFuncion(final String nombre, LocalDate fecha, LocalTime horaIni, LocalDate fechaReg, final ArrayList<String> aI) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.horaIni = horaIni;
		this.fechaReg = fechaReg;
		this.artistasInvitados = aI;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public LocalTime getHoraIni() {
		return horaIni;
	}

	public LocalDate getFechaReg() {
		return fechaReg;
	}	
	
	public ArrayList<String> getInvitados() {
		return artistasInvitados;
	}
	
	public ArrayList<String> getArtistasInvitados() {
		return artistasInvitados;
	}

	public String getFechaRegString() {
		return fechaReg.toString();
	}
	
	public String getFechaString() {
		return fecha.toString();
	}
	
	public String getHoraIniString() {
		return horaIni.toString();
	}
	
	public void setFechaString(String fechaString) {
		this.fechaString = fechaString;
	}

	public void setHoraIniString(String horaIniString) {
		this.horaIniString = horaIniString;
	}

	public void setFechaRegString(String fechaRegString) {
		this.fechaRegString = fechaRegString;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setHoraIni(LocalTime horaIni) {
		this.horaIni = horaIni;
	}

	public void setFechaReg(LocalDate fechaReg) {
		this.fechaReg = fechaReg;
	}

	public void setArtistasInvitados(ArrayList<String> artistasInvitados) {
		this.artistasInvitados = artistasInvitados;
	}

	@Override
	public String toString() {
		return "FUNCION\nNombre = " + this.getNombre() + "\nFecha: " + this.getFecha() + "\nHoraInicio: " + this.getHoraIni() + "\nFechaRegistro: " + this.getFechaReg() + "\nInvitados: " + this.artistasInvitados.toString();
	}
	
	
}


