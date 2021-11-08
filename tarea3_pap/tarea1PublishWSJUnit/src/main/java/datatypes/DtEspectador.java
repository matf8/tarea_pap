package datatypes;

import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtEspectador extends DtUsuario {
	
	public DtEspectador(final String nickName, final String nombre, final String apellido, final LocalDate fnac, final String mail, final String p) {
		super(nickName, nombre, apellido, fnac, mail, p);		
	}		
	
	@Override	
	public String toString() {
		return "ESPECTADOR: " + this.getNickName() + "\nNombre: " + this.getNombre() + " " + this.getApellido() + "\nFecha de nacimiento: " + this.getFnac() + "\nmail: " + this.getMail();
	}

}

