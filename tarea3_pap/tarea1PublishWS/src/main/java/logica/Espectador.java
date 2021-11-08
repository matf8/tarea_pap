package logica;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.OneToMany;
import javax.persistence.Query;

import datatypes.DtEspectador;
import datatypes.DtFuncion;
import persistencia.Conexion;

@Entity
@DiscriminatorValue("E")
public class Espectador extends Usuario{		
	@OneToMany(mappedBy="e", cascade=CascadeType.ALL, orphanRemoval=true)	
	private List<Registro> registrosDeFunciones = new ArrayList<Registro>();
	@OneToMany(mappedBy="e", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<CompraPaquete> comprasDePaquetes = new ArrayList<CompraPaquete>();
	
	public Espectador() {
		super(); 
	}
    
	public Espectador(String nickName, String nombre, String apellido, LocalDate fnac, String mail, String pass, List<Usuario> l, byte[] imagen) {
		super(nickName, nombre, apellido, fnac, mail, pass, l, imagen);	
	}
	
	@Override
	public String toString() {
		return "Espectador[nick=" + this.getNickName() + ", nombre=" + this.getNombre() + "]";
	}
	
	public DtEspectador getDt() {
		ZoneId defaultZoneId = ZoneId.systemDefault();	           
        Date f = Date.from(getFnac().atStartOfDay(defaultZoneId).toInstant());
		return new DtEspectador(getNickName(), getNombre(), getApellido(), f, getMail(), getPasswd());
	}
	
	public void agregarRegistro(Registro r) { 		
		registrosDeFunciones.add(r);	
		r.getFuncion().agregarRegistro(r);			
	}
	
	public ArrayList<Registro> getRegistros(){
		ArrayList<Registro> ret = new ArrayList<Registro>();
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query q = em.createQuery("select r from Registro r where nickName=:nick");
		q.setParameter("nick", this.getNickName());
		try {
			ret = (ArrayList<Registro>) q.getResultList();
		} catch (Exception e) {
			ret = null;
		}
		return ret;		
	}	
	
	public ArrayList<DtFuncion> getDtFuncion() {
		ArrayList<DtFuncion> ret = new ArrayList<DtFuncion>();
		for (Registro r: registrosDeFunciones) {
			ret.add(r.getFuncion().getDt());
		}
		return ret;		
	}
	
	public boolean chequearDisponibilidadRegistro(String nombreFuncion) {		
		int i = 0;
		boolean encontre = false;
		while (i < registrosDeFunciones.size() && !encontre) {
			if (registrosDeFunciones.get(i).getNombreFuncion().equals(nombreFuncion))
				encontre = true;			
			i++;
		}	
		return !encontre;		
	}
	
	public boolean comproPaquete(String nombrePaquete) {
		int i=0;
		boolean ret=false;
		while (i<comprasDePaquetes.size() && !ret) {
			ret=comprasDePaquetes.get(i).getPaquete().getNombre().equals(nombrePaquete);
			i++;
		}
		return ret;
	}
	
	public void agregarCompra(CompraPaquete compra) {
		comprasDePaquetes.add(compra);
	}
	
	public List<String> listaPaquetesEspectaculo(String nombreEsp){
		List<String> ret = new ArrayList<>();
		for (CompraPaquete c: comprasDePaquetes) {
			if (c.getPaquete().contieneEspectaculo(nombreEsp))
				ret.add(c.getPaquete().getNombre());
		}		
		return ret;
	}
	
	public List<String> listaPaquetesEspectador(){
		List<String> ret = new ArrayList<>();
		for (CompraPaquete c: comprasDePaquetes) {			
			ret.add(c.getPaquete().getNombre());
		}		
		return ret;
	}
	
	public Paquete obtenerPaquete(String nombrePaq) {
		Paquete ret = null;
		int i = 0;
		boolean s = false;
		while (i < comprasDePaquetes.size() && !s) {
			if (comprasDePaquetes.get(i).getPaquete().getNombre().equals(nombrePaq)) {
				ret = comprasDePaquetes.get(i).getPaquete();
				s = true;			
			}
			i++;
		}
		return ret;
	}
	
}