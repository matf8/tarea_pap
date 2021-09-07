package datatypes;

import java.time.LocalDate;

public class DtUsuario {
	private String nickName;
	private String nombre;
	private String apellido;
	private LocalDate fnac;
	private String mail;
    
	public DtUsuario(String nickName, String nombre, String apellido, LocalDate fnac, String mail) {
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

	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public LocalDate getFnac() {
		return fnac;
	}

	public String getMail() {
		return mail;
	}

	@Override
	public String toString() {
		return "nickName = " + nickName + "\nNombre: " + nombre + " " + apellido + "\nFecha de nacimiento: " + fnac + "\nmail: " + mail;
	}


}