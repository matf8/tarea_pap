package datatypes;

import java.time.LocalDate;

public class DtEspectador extends DtUsuario {
	
	public DtEspectador(String nickName, String nombre, String apellido, LocalDate fnac, String mail, String p) {
		super(nickName, nombre, apellido, fnac, mail, p);		
	}	
	
	@Override	
	public String toString() {
		return "ESPECTADOR: " + this.getNickName() + "\nNombre: " + this.getNombre() + " " + this.getApellido() + "\nFecha de nacimiento: " + this.getFnac() + "\nmail: " + this.getMail();
	}

}

