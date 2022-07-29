package datatypes;

import java.time.LocalDate;

public class DtArtista extends DtUsuario {
	private String descripcion;
	private String url;
	private String biografia;

	public DtArtista(String nickName, String nombre, String apellido, LocalDate fnac, String mail, String p, String d, String url, String bio) {
		super(nickName, nombre, apellido, fnac, mail, p);
		this.descripcion = d;
		this.url = url;
		this.biografia = bio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getURL() {
		return url;
	}
	
	public String getBiografia() {
		return biografia;
	}		
	
	public String toString() {
		return "ARTISTA: " + this.getNickName() + "\nNombre: " + this.getNombre() + " " + this.getApellido() + "\nFecha de nacimiento: " 
	    + this.getFnac() + "\nmail: " + this.getMail() + "\ndescripcion: " + this.descripcion + "\nbiografia: " + this.biografia + "\nURL: " + this.url + "\n";
	}
}

	
    