package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import datatypes.DtEspectador;

@Entity
@DiscriminatorValue("E")
public class Espectador extends Usuario{		
	@OneToMany(mappedBy="e",cascade=CascadeType.ALL,orphanRemoval=true)	
	private List<Registro> registrosDeFunciones = new ArrayList<Registro>();

	public Espectador() {
		super(); 
	}
    
	public Espectador(String nickName, String nombre, String apellido, LocalDate fnac, String mail) {
		super(nickName, nombre, apellido, fnac, mail);	
	}
	
	@Override
	public String toString() {
		return "Espectador[nick=" + this.getNickName() + ", nombre=" + this.getNombre() + "]";
	}
	
	public DtEspectador getDt() {		
		return new DtEspectador(getNickName(), getNombre(), getApellido(), getFnac(), getMail());
	}
	
	public void agregarRegistro(Registro r) {
		registrosDeFunciones.add(r);		
	}
	
	public ArrayList<Registro> getRegistros(){
		return (ArrayList<Registro>) this.registrosDeFunciones;
	}	
}