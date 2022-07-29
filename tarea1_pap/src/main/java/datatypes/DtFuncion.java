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
	
	public DtFuncion(String nombre, LocalDate fecha, LocalTime horaIni, LocalDate fechaReg, ArrayList<String> aI) {
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
	
	@Override
	public String toString() {
		return "FUNCION\nNombre = " + this.getNombre() + "\nFecha: " + this.getFecha() + "\nHoraInicio: " + this.getHoraIni() + "\nFechaRegistro: " + this.getFechaReg() + "\nInvitados: " + this.artistasInvitados.toString();
	}
	
	
}


