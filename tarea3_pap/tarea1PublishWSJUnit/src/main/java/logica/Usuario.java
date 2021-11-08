package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import org.apache.commons.codec.binary.Base64;

import datatypes.DtUsuario;
import persistencia.UsuarioId;

@Entity
@IdClass(UsuarioId.class)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Usuario {
	@Id
	private String nickName;
	private String passwd;
	private String nombre;
	private String apellido;
	private LocalDate fnac;
	@Id
	private String mail;	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Usuario> seguidos = new ArrayList<Usuario>();
	@Lob
	@Column(columnDefinition="longblob")
	private byte[] imagen;
	
	public Usuario() {
		super();
	}	
	
	public Usuario(String nickName, String nombre, String apellido, LocalDate fnac, String mail, String p, List<Usuario> s, byte[] imagen) {
		
		super();
		this.nickName = nickName;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fnac = fnac;
		this.mail = mail;
		this.passwd = p;
		this.seguidos = s;
		this.imagen = imagen;
	}	
	
	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getPasswd() {
		return this.passwd;
	}
	
	public void setPasswd(String p) {
		this.passwd = p;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFnac() {
		return fnac;
	}

	public void setFnac(LocalDate fnac) {
		this.fnac = fnac;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}		

	public List<Usuario> getSeguidos() {
		return this.seguidos;
	}

	public void agregarUsuarioSeguido(Usuario u) {
		seguidos.add(u);
	}	

	public void setSeguidos(List<Usuario> l) {
		this.seguidos = l;
	}
	
	public void quitarUsuarioSeguido(Usuario u) {
		seguidos.remove(u);
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

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Usuario[nick=" + this.getNickName() + ", nombre=" + this.getNombre() + "]";
	}
	
	public DtUsuario getDt() {		
		return new DtUsuario(this.nickName, this.nombre, this.apellido, this.fnac, this.mail, this.passwd);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(imagen);
		result = prime * result + Objects.hash(apellido, fnac, mail, nickName, nombre, passwd, seguidos);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(fnac, other.fnac)
				&& Arrays.equals(imagen, other.imagen) && Objects.equals(mail, other.mail)
				&& Objects.equals(nickName, other.nickName) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(passwd, other.passwd) && Objects.equals(seguidos, other.seguidos);
	}
	
	
}
