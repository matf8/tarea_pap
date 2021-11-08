package datatypes;

import java.time.LocalDate;

public class DtUsuario {
	private String nickName;
	private String passwd;
	private String nombre;
	private String apellido;
	private LocalDate fnac;
	private String mail;
    
	public DtUsuario(final String nickName, final String nombre, final String apellido, final LocalDate fnac, final String mail, final String p) {
		super();
		this.nickName = nickName;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fnac = fnac;
		this.mail = mail;
		this.passwd = p;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
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
		return "nickName = " + nickName + "\nNombre: " + nombre + " " + apellido + "\nFecha de nacimiento: " + fnac + "\nmail: " + mail;
	}

}