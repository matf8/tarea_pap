package logica;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import datatypes.DtCompraPaquete;
import persistencia.CompraPaqueteId;


@Entity
@IdClass(CompraPaqueteId.class)
public class CompraPaquete {	
	@Id
	@ManyToOne
	@JoinColumns({@JoinColumn(name="nickname", referencedColumnName="nickname"),
		  			@JoinColumn(name="mail", referencedColumnName="mail")}) 	
	private Espectador e;
	@Id
	@ManyToOne
	private Paquete p;
	private LocalDate fechaReg;
	
	public CompraPaquete() {
		super();
	}
	
	public CompraPaquete(Espectador e, Paquete p, LocalDate fechaReg) {
		super();
		this.e = e;
		this.p = p;
		this.fechaReg = fechaReg;
	}
	
	public Espectador getEspectador() {
		return e;
	}
	public Paquete getPaquete() {
		return p;
	}
	public LocalDate getFechaReg() {
		return fechaReg;
	}
		
	public void setE(Espectador e) {
		this.e = e;
	}

	public void setP(Paquete p) {
		this.p = p;
	}

	public void setFechaReg(LocalDate fechaReg) {
		this.fechaReg = fechaReg;
	}

	public DtCompraPaquete getDt() {
		return new DtCompraPaquete(e.getNickName(), p.getNombre(), fechaReg);
	}

	@Override
	public int hashCode() {
		return Objects.hash(e, fechaReg, p);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompraPaquete other = (CompraPaquete) obj;
		return Objects.equals(e, other.e) && Objects.equals(fechaReg, other.fechaReg) && Objects.equals(p, other.p);
	}	
}
