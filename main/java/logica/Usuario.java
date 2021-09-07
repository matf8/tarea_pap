package logica;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import datatypes.DtUsuario;
import persistencia.UsuarioId;

@Entity
@IdClass(UsuarioId.class)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Usuario {
	@Id
	private String nickName;
	private String nombre;
	private String apellido;
	private LocalDate fnac;
	@Id
	private String mail;	

	public Usuario() {
		super();
	}

	public Usuario(String nickName, String nombre, String apellido, LocalDate fnac, String mail) {
		super();
		this.nickName = nickName;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fnac = fnac;
		this.mail = mail;
	}
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFnac() {
		return fnac;
	}

	public void setFnac(LocalDate fnac) {
		this.fnac = fnac;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}	
	
	@Override
	public String toString() {
		return "Usuario[nick=" + this.getNickName() + ", nombre=" + this.getNombre() + "]";
	}
	
	public DtUsuario getDt() {		
		return new DtUsuario(this.nickName, this.nombre, this.apellido, this.fnac, this.mail);
	}
}
