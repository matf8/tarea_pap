package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import datatypes.DtRegistro;
import persistencia.RegistroId;

@Entity
@IdClass(RegistroId.class)
public class Registro {	
	@Id
	@ManyToOne
	private Funcion f;	
	@Id
	@ManyToOne
	@JoinColumns({@JoinColumn(name="nickname", referencedColumnName="nickname"),
				  @JoinColumn(name="mail", referencedColumnName="mail")}) 	
	private Espectador e;		
	private LocalDate fechaReg;
	private float costo;	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Registro> registrosCanjeados = new ArrayList<Registro>();

	public Registro(){
		super();
	}

	public Registro(Funcion f, LocalDate fechaR, float c){
		this.f = f;
		this.fechaReg = fechaR;
		this.costo = c;
	}
	
	public Registro(Funcion f, LocalDate fechaR, float c, List<Registro> l){
		this.f = f;
		this.fechaReg = fechaR;
		this.costo = c;
		this.registrosCanjeados = l;
	}
		
	public Funcion getFuncion() {
		return this.f;
	}
	
	public void setFuncion(Funcion f) {
		this.f = f;
	}	
	
	public String getNombreFuncion() {
		return this.f.getNombre();
	}
	
	public Espectador getEspectador() {
		return this.e;
	}
	
	public void setEspectador(Espectador e){
		this.e = e;
	}	
	
	public String getNicknameEspectador() {
		return this.e.getNickName();
	}
	
	public float getCosto() {
		return costo;
	}

	public void setCosto(float c) {
		this.costo = c;
	}
	
	public LocalDate getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(LocalDate f) {
		this.fechaReg = f;
	}
	
	public void agregarRegistroCanjeado(Registro r) {
		registrosCanjeados.add(r);
	}
	
	public ArrayList<Registro> getCanjeados(){
		return (ArrayList<Registro>) this.registrosCanjeados;
	}
	
	public DtRegistro getDt() {
		return new DtRegistro(f.getNombre(), this.fechaReg, this.costo);
	}	
}
	