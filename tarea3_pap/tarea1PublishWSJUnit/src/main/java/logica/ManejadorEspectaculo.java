package logica;

import java.util.ArrayList;
import java.util.List;

import persistencia.Conexion;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ManejadorEspectaculo {
	private static ManejadorEspectaculo instancia = null;
	
	private ManejadorEspectaculo(){}
	
	public static ManejadorEspectaculo getInstancia() {
		if (instancia == null)
			instancia = new ManejadorEspectaculo();
		return instancia;
	}
	
	public void agregarEspectaculo(Espectaculo e) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();		
		em.persist(e);		
		em.getTransaction().commit();	
	}
		
	public Espectaculo buscarEspectaculo(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Espectaculo ret = em.find(Espectaculo.class,nombre);	
		if (ret != null)
			em.refresh(ret);		
		return ret;
	}		
			
	public ArrayList<String> buscarEspectaculoPorPlataforma(String nombrePlat) {
		
		ArrayList<String> ret = new ArrayList<>();
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();				
		Query q = em.createQuery("select e from Espectaculo e");
		List<Espectaculo> lE = (List<Espectaculo>) q.getResultList();	
		for(Espectaculo e: lE) {	
			if (e.getNombrePlataforma().equals(nombrePlat))		
				ret.add(e.getNombre());	
		}
		return ret;		
	}
	
	public boolean buscarFuncion(String nombreF) {	
		boolean ret = false;
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();			
		Query q = em.createQuery("select count(*) from Funcion where nombre=:nombreFuncion");
		q.setParameter("nombreFuncion", (String) nombreF);		
		Long count = (Long) q.getSingleResult();
		if (count > 0) 		
			ret = true;		
		return ret;		
	}
			
	public ArrayList<Espectaculo> listaEspec() {	
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();				
		Query q = em.createQuery("select e from Espectaculo e");
		List<Espectaculo> le = (List<Espectaculo>) q.getResultList();		
		ArrayList<Espectaculo> ret = new ArrayList<>();
		for(Espectaculo e: le) 
			ret.add(e);	
		return ret;		
	}	
	
	public ArrayList<String> listarEspectaculosOrganizados(String nick) {
		ArrayList<String> ret = new ArrayList<>();
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();			
		Query q = em.createQuery("select nombre from Espectaculo where artistaOrganizador_nickName=:nick");
		q.setParameter("nick", (String) nick);
		List<String> lEO = (List<String>) q.getResultList();
		for (String k: lEO)
			ret.add(k);
		return ret;
	}	
	
	/*public List<String> listarEspectaculosPlataforma(String p) {
		List<String> ret = new ArrayList<>();
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();			
		Query q = em.createQuery("select nombre from Espectaculo where plataforma_nombre=:p");
		q.setParameter("p", p);
		List<String> lEP= (List<String>) q.getResultList();
		for (String k: lEP)
			ret.add(k);
		return ret;
		
	}*/
}