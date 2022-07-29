package logica;

import java.time.LocalDate;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	public DtCompraPaquete getDt() {
		return new DtCompraPaquete(e.getNickName(), p.getNombre(), fechaReg);
	}
	
	
	
	
}
