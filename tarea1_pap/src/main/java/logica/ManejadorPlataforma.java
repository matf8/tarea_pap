package logica;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorPlataforma {
	private static ManejadorPlataforma instancia = null;
	
	private ManejadorPlataforma(){}
	
	public static ManejadorPlataforma getInstancia() {
		if (instancia == null)
			instancia = new ManejadorPlataforma();
		return instancia;
	}
	
	public void agregarPlataforma(Plataforma p) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();		
		em.persist(p);		
		em.getTransaction().commit();	
	}
	
	public Plataforma buscarPlataforma(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Plataforma ret = em.find(Plataforma.class,nombre);		
		return ret;
	}
	
	public ArrayList<Plataforma> listarPlataformas(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query q= em.createQuery("select p from Plataforma p");
		ArrayList<Plataforma> ret = (ArrayList<Plataforma>)q.getResultList();
		return ret;		
	}
}

