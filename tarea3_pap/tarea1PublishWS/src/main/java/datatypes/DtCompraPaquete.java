package datatypes;

import java.util.Date;

public class DtCompraPaquete {
	private String e;
	private String p;
	private Date f;
		
	public DtCompraPaquete() {
		super();
	}

	public DtCompraPaquete(String e, String p, Date f) {
		super();
		this.e = e;
		this.p = p;
		this.f = f;
	}	
	
	public String getEspectaculo() {
		return e;
	}

	public String getPaquete() {
		return p;
	}

	public Date getFecha() {
		return f;
	}

	public void setE(String e) {
		this.e = e;
	}

	public void setP(String p) {
		this.p = p;
	}

	public void setF(Date f) {
		this.f = f;
	}	
	
	
}
