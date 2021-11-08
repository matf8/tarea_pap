package datatypes;

import java.time.LocalDate;

public class DtCompraPaquete {


	private String e;
	private String p;
	private LocalDate f;
	
	
	public String getEspectaculo() {
		return e;
	}

	public String getPaquete() {
		return p;
	}

	public LocalDate getFecha() {
		return f;
	}

	
	public DtCompraPaquete(String e, String p, LocalDate f) {
		super();
		this.e = e;
		this.p = p;
		this.f = f;
	}
	
	
	
}
