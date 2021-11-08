package datatypes;

import java.util.Date;

public class DtRegistroCompleto extends DtRegistro {
	private int id;	
    
	public DtRegistroCompleto()  {
		super();
	}
	
	public DtRegistroCompleto(int id, String nombreF, Date f, float c)  {
		super(nombreF, f, c);
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
		
	public void setId(int id) {
		this.id = id;
	}

	//@Override
	public String toString() {
		return "\nRegistro: " + this.id + " funcion: " + this.getNombreFuncion();
	}		
}