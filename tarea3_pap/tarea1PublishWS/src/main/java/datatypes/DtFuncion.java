package datatypes;

import java.util.ArrayList;
import java.util.Date;

public class DtFuncion {
	private String nombre;
	private Date fecha;
	private Date horaIni;
	private Date fechaReg;
	private ArrayList<String> artistasInvitados = new ArrayList<>();
	private String fechaString;
	private String horaIniString;
	private String fechaRegString;
	
	public DtFuncion() {
		super();
	}
	
	public DtFuncion(final String nombre, Date fecha, Date horaIni, Date fechaReg, final ArrayList<String> aI) {
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

	public Date getFecha() {
		return fecha;
	}

	public Date getHoraIni() {
		return horaIni;
	}

	public Date getFechaReg() {
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

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setHoraIni(Date horaIni) {
		this.horaIni = horaIni;
	}

	public void setFechaReg(Date fechaReg) {
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


