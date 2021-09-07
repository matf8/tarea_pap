package logica;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import datatypes.DtArtista;

@Entity
@DiscriminatorValue("A")
public class Artista extends Usuario{
	private String descripcion;
	private String url;
	private String biografia;

	public Artista() {
		super(); 
	}
    
	public Artista(String nickName, String nombre, String apellido, LocalDate fnac, String mail, String desc, String url, String bio) {
		super(nickName, nombre, apellido, fnac, mail);
		this.descripcion = desc;
		this.url = url;
		this.biografia = bio;
	}

	public Artista(String desc, String url, String bio) {
		super();
		this.descripcion = desc;
		this.url = url;
		this.biografia = bio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String desc) {
		this.descripcion = desc;
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
	
	@Override
	public String toString() {
		return "Artista[nick=" + this.getNickName() + ", nombre=" + this.getNombre() + "]";
	}
	
	public DtArtista getDt() {		
		return new DtArtista(getNickName(), getNombre(), getApellido(), getFnac(), getMail(), this.descripcion, this.url, this.biografia);
	}
}