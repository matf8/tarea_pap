package datatypes;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtArtista extends DtUsuario {
	private String descripcion;
	private String url;
	private String biografia;
	
	public DtArtista() {
		super();
	}
	
	public DtArtista(final String nickName, final String nombre, final String apellido, final Date fnac, final String mail, final String p, String d, String url, String bio) {
		super(nickName, nombre, apellido, fnac, mail, p); 
		this.descripcion = d;
		this.url = url;
		this.biografia = bio;
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

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String toString() {
		return "ARTISTA: " + this.getNickName() + "\nNombre: " + this.getNombre() + " " + this.getApellido() + "\nFecha de nacimiento: " 
	    + this.getFnac() + "\nmail: " + this.getMail() + "\ndescripcion: " + this.descripcion + "\nbiografia: " + this.biografia + "\nURL: " + this.url + "\n";
	}
}

	
    