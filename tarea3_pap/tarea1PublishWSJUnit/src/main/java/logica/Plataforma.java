package logica;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Plataforma {
	@Id
	private String nombre;
	private String descripcion;
	private String url;	

	public Plataforma() {
		super();
	}

	public Plataforma(String nombre, String descripcion, String url) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, nombre, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plataforma other = (Plataforma) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(url, other.url);
	}	
	
}
