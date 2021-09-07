package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import persistencia.Conexion;

public class ManejadorPaquete {
	private static ManejadorPaquete instancia=null;
	
	private ManejadorPaquete(){}
	
	public static ManejadorPaquete getInstancia() {
		if (instancia == null)
			instancia = new ManejadorPaquete();
		return instancia;
	}
	
	public void agregarPaquete(Paquete p) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();		
		em.persist(p);		
		em.getTransaction().commit();	
	}
		
	public Paquete buscarPaquete(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Paquete ret = em.find(Paquete.class,nombre);			
		return ret;				
	}	
		
	public ArrayList<Paquete> listaPaquetes() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();				
		Query q = em.createQuery("select p from Paquete p");
		List<Paquete> lP = (List<Paquete>) q.getResultList();		
		ArrayList<Paquete> ret = new ArrayList<>();
		for(Paquete p: lP) 
			ret.add(p);	
		return ret;			
	}	
}

