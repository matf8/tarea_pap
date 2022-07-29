package datatypes;

import java.time.LocalDate;

public class DtRegistroCompleto extends DtRegistro {
	private int id;	
    
	public DtRegistroCompleto(int id, String nombreF, LocalDate f, float c)  {
		super(nombreF, f, c);
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	//@Override
	public String toString() {
		return "\nRegistro: " + this.id + " funcion: " + this.getNombreFuncion();
	}		
}