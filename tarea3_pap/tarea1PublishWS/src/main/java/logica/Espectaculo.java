package logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import datatypes.DtEspectaculo;
import persistencia.Conexion;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.codec.binary.Base64;

@Entity
public class Espectaculo {
	@Id
	private String nombre;
	private String descripcion;
	private String url;
	private int duracion;
	private int cantMin; // cantidad espectadores
	private int cantMax;
	private float costo;
	private LocalDate fechaReg; 
	@ManyToOne
	private Plataforma plataforma;
	@ManyToOne
	private Artista artistaOrganizador;	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Funcion> funciones = new ArrayList<>();
	@Lob
	@Column(columnDefinition="mediumblob")
	private byte[] imagen;
			
	public Espectaculo() {
		super();
	}

	public Espectaculo(String nombre, String descripcion, String url, int duracion, int cMax, int cMin, float costo, LocalDate f, Plataforma p, Artista a, byte[] imagen) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
		this.duracion = duracion;
		this.cantMax = cMax;
		this.cantMin = cMin;
		this.costo = costo;
		this.fechaReg = f;
		this.plataforma = p;
		this.artistaOrganizador = a;
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String n) {
		this.nombre = n;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String d) {
		this.descripcion = d;
	}

	public String getURL() {
		return url;
	}

	public void setURL(String u) {
		this.url = u;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int dur) {
		this.duracion = dur;
	}

	public int getCantMax() {
		return cantMax;
	}

	public void setCantMax(int cx) {
		this.cantMax = cx;
	}

	public int getCantMin() {
		return cantMin;
	}

	public void setCantMin(int cn) {
		this.cantMax = cn;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public LocalDate getFechaReg(){
		return fechaReg;
	}

	public void setFechaReg(LocalDate f){
		this.fechaReg = f;
	}
	
	public byte[] getImagen() {
	        return imagen;
	 }
	
	public String getImagen64() throws Exception {		
		if (imagen != null) {  
			byte[] encodeBase64 = Base64.encodeBase64(imagen);
			String base64Encoded = new String(encodeBase64, "UTF-8");    
			return base64Encoded;		
		} else return null;
	}
		 
	public void setImagen(byte[] i) {
	        this.imagen = i;
	}

	public Plataforma getPlataforma(){
		return plataforma;
	}	
	
	public void setPlataforma(Plataforma p){
		this.plataforma = p;
	}

	public String getNombrePlataforma(){
		return this.plataforma.getNombre();
	}

	public Artista getArtista(){
		return artistaOrganizador;
	}

	public void setArtista(Artista a){
		this.artistaOrganizador = a;
	}

	public String getNickNameArtista(){
		return this.artistaOrganizador.getNickName();
	}	
	
	public void agregarFuncion(Funcion f, Espectaculo e) {			
		funciones.add(f);
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();		
		em.persist(e);		
		em.getTransaction().commit();
	}
	
	public ArrayList<String> obtenerFunciones(){		
		ArrayList<String> ret = new ArrayList<>();
		for(Funcion f: funciones)			
			ret.add(f.getNombre());
		return ret;		
	}	
	
	public ArrayList<String> obtenerFuncionesVigentes(){		
		ArrayList<String> ret = new ArrayList<>();
		LocalDate ahoraFecha = LocalDate.now();
		LocalTime ahoraTiempo = LocalTime.now();
		for(Funcion f: funciones) {				
			if ((f.getFecha().isAfter(ahoraFecha) || ((f.getFecha().isEqual(ahoraFecha) && f.getHoraInicio().isAfter(ahoraTiempo))))) {					
					ret.add(f.getNombre());
			}
		}		
		return ret;		
	}
	
	public Funcion obtenerFuncionUnica(String nombre) {
		Funcion ret = null;
		Integer i = 0;
		while (i < funciones.size() && ret == null) {
			if (funciones.get(i).getNombre().equals(nombre))
				ret = funciones.get(i);
			i++;			
		}	
		
		return ret;			
	}	
	
	public DtEspectaculo getDt() {		
		return new DtEspectaculo(this.nombre, this.descripcion, this.url, this.duracion, this.cantMax, this.cantMin, this.costo,
				java.sql.Date.valueOf(this.fechaReg), this.artistaOrganizador.getNickName(), this.plataforma.getNombre());
	}	
}
