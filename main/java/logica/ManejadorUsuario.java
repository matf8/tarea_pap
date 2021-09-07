package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import persistencia.Conexion;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ManejadorUsuario {
	private static ManejadorUsuario instancia = null;
	
	private ManejadorUsuario(){}
	
	public static ManejadorUsuario getInstancia() {
		if (instancia == null)
			instancia = new ManejadorUsuario();
		return instancia;
	}

	public void agregarUsuario(Usuario u) {		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();		
		em.persist(u);		
		em.getTransaction().commit();	
	}	
	
	public Usuario buscarUsuario(String nick) {
		Usuario ret = null;
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query q = em.createQuery("select u from Usuario u where nickName=:nick");
		q.setParameter("nick", nick);
		try {
			ret = (Usuario) q.getSingleResult();
		} catch (Exception e) {
			ret = null;
		}
		return ret;
	}
	
	public Usuario buscarCorreo(String correo) {
		Usuario ret = null;
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query q = em.createQuery("select u from Usuario u where mail=:correo");
		q.setParameter("correo", correo);
		try {
			ret = (Usuario) q.getSingleResult();
		} catch (Exception e) {
			ret = null;
		}
		return ret;
	}	
	
	public ArrayList<String>  listarUsuarios() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		ArrayList<String> ret = new ArrayList<>();
		Query q = em.createQuery("select u from Usuario u");
		List<Usuario> lU = (List<Usuario>) q.getResultList();	
		for(Usuario u: lU) 				
			ret.add(u.getNickName());	
		return ret;
	}	
	
	public ArrayList<String> listarEspectadores() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		ArrayList<String> ret = new ArrayList<>();
		Query q = em.createQuery("select u from Usuario u where DTYPE='E'");
		List<Usuario> lU = (List<Usuario>) q.getResultList();	
		for(Usuario u: lU) 				
			ret.add(u.getNickName());	
		return ret;
	}	
	
	public void modificarUsuario(Usuario u) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query q;
		if (u instanceof Espectador) {
			q = em.createQuery("update Usuario set nombre=:n, apellido=:ap, fnac=:f where nickName=:nick");
			q.setParameter("nick", u.getNickName());
			q.setParameter("n", u.getNombre());			
			q.setParameter("ap", u.getApellido());					
			q.setParameter("f", u.getFnac());			
			em.getTransaction().begin();		
			q.executeUpdate();
			em.getTransaction().commit();
		}
		if (u instanceof Artista) {
			q = em.createQuery("update Usuario set nombre=:n, apellido=:ap, fnac=:f, biografia=:bio, descripcion=:d, url=:url where nickName=:nick");
			q.setParameter("nick", u.getNickName());
			q.setParameter("n", u.getNombre());
			q.setParameter("ap", u.getApellido());			
			q.setParameter("f", u.getFnac());
			q.setParameter("bio", ((Artista) u).getBiografia());
			q.setParameter("d", ((Artista) u).getDescripcion());
			q.setParameter("url", ((Artista) u).getURL());			
			em.getTransaction().begin();		
			q.executeUpdate();
			em.getTransaction().commit();
		}		
	}		
}