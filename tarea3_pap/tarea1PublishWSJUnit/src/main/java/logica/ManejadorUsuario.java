package logica;

import java.util.ArrayList;
import java.util.List;

import persistencia.Conexion;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import datatypes.DtRegistro;

public class ManejadorUsuario {
	private static ManejadorUsuario instancia = null;
	
	Conexion conexion = Conexion.getInstancia();	
	
	private ManejadorUsuario(){}
	
	public static ManejadorUsuario getInstancia() {
		if (instancia == null)
			instancia = new ManejadorUsuario();
		return instancia;
	}

	public void agregarUsuario(Usuario u) {		
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();		
		em.persist(u);		
		em.getTransaction().commit();
	}	
	
	public Usuario buscarUsuario(String nick) {
		Usuario ret = null;	
		EntityManager em = conexion.getEntityManager();		
		Query q = em.createQuery("select u from Usuario u where nickName=:nick");
		q.setParameter("nick", nick);
		try {
			ret = (Usuario) q.getSingleResult();
			em.refresh(ret);			
		} catch (Exception e) {
			ret = null;
		}		
		return ret;		
	}
	
	public Usuario buscarCorreo(String correo) {
		Usuario ret = null;
		EntityManager em = conexion.getEntityManager();	
		Query q = em.createQuery("select u from Usuario u where mail=:correo");
		q.setParameter("correo", correo);
		try {
			ret = (Usuario) q.getSingleResult();
			em.refresh(ret);			
		} catch (Exception e) {
			ret = null;
		}	
		return ret;
	}	
	
	public ArrayList<String> listarUsuarios() {
		EntityManager em = conexion.getEntityManager();		
		ArrayList<String> ret = new ArrayList<>();	
		Query q = em.createQuery("select u from Usuario u");		
		List<Usuario> lU = (List<Usuario>) q.getResultList();	
		for(Usuario u: lU)			
			ret.add(u.getNickName());			
		return ret;
	}	
	
	public ArrayList<String> listarEspectadores() {
		EntityManager em = conexion.getEntityManager();
		ArrayList<String> ret = new ArrayList<>();
		Query q = em.createQuery("select u from Usuario u where DTYPE='E'");
		List<Usuario> lU = (List<Usuario>) q.getResultList();			
		for(Usuario u: lU) 			
			ret.add(u.getNickName());
	
		
		return ret;
	}
	
	public List<String> listarArtista() {
		EntityManager em = conexion.getEntityManager();
		List<String> ret = new ArrayList<>();
		Query q = em.createQuery("select u from Usuario u where DTYPE='A'");
		List<Usuario> lU = (List<Usuario>) q.getResultList();	
		for(Usuario u: lU) 				
			ret.add(u.getNickName());	
		return ret;
	}	
	
	
	public ArrayList<DtRegistro> listarRegistrosEspectador(String nick) {		
		EntityManager em = conexion.getEntityManager();
		ArrayList<DtRegistro> ret = new ArrayList<>();
		Query q = em.createQuery("select r from Registro r where nickname=:nick");
		q.setParameter("nick", nick);
		List<Registro> lR = (List<Registro>) q.getResultList();	
		for(Registro r: lR) 				
			ret.add(r.getDt());	
		return ret;
	}
	
	
	public void modificarUsuario(Usuario u) {
		EntityManager em = conexion.getEntityManager();
		Query q;
		if (u instanceof Espectador) {			
			q = em.createQuery("update Usuario set nombre=:n, apellido=:ap, fnac=:f, imagen=:img where nickName=:nick").setHint("org.hibernate.cacheMode", "IGNORE");
			q.setParameter("nick", u.getNickName());
			q.setParameter("n", u.getNombre());			
			q.setParameter("ap", u.getApellido());					
			q.setParameter("f", u.getFnac());
			q.setParameter("img", u.getImagen());
			em.getTransaction().begin();		
			q.executeUpdate();
			em.getTransaction().commit();			
		}
		if (u instanceof Artista) {			
			q = em.createQuery("update Usuario set nombre=:n, apellido=:ap, fnac=:f, imagen=:img, biografia=:bio, descripcion=:d, url=:url where nickName=:nick").setHint("org.hibernate.cacheMode", "IGNORE");
			q.setParameter("nick", u.getNickName());
			q.setParameter("n", u.getNombre());
			q.setParameter("ap", u.getApellido());			
			q.setParameter("f", u.getFnac());
			q.setParameter("bio", ((Artista) u).getBiografia());
			q.setParameter("d", ((Artista) u).getDescripcion());
			q.setParameter("url", ((Artista) u).getURL());		
			q.setParameter("img", u.getImagen());
			em.getTransaction().begin();		
			q.executeUpdate();
			em.getTransaction().commit();			
		}			
	}	
	
	public List<Usuario> listarUsuariosCompleto() {
		EntityManager em = conexion.getEntityManager();
		Query q = em.createQuery("select u from Usuario u").setHint("org.hibernate.cacheMode", "IGNORE");
		List<Usuario> lU = (List<Usuario>) q.getResultList();	
		return lU;
	}	
	
	public List<String> listarSeguidores(String nick){
		List<String> ret = new ArrayList<>();
		List<Usuario> aux = listarUsuariosCompleto();		
		List<Usuario> aux2;
		for (Usuario k: aux) {
			aux2 = k.getSeguidos();
			if (aux2 != null) {				
				for (Usuario j: aux2) {
					if (j.getNickName().equals(nick)) {
						ret.add(k.getNickName());
					}
				}
			}
		}		
		return ret;
	}
}