package logica;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import datatypes.DtEspectaculoCompleto;
import datatypes.DtPaquete;
import excepciones.PaqueteNoValidoException;
import excepciones.PlataformaNoValidaException;
import interfaces.IControladorPaquete;
import persistencia.Conexion;

public class ControladorPaquete implements IControladorPaquete{
	private DtPaquete dtpaq;
	private Paquete paq;
	private byte[] img;
	
	public ControladorPaquete() {
		super();
	}
	
	public void agregarEspectaculoAPaquete(String nombreEs) {
		ManejadorEspectaculo mE=ManejadorEspectaculo.getInstancia();
		paq.agregarEspectaculo(mE.buscarEspectaculo(nombreEs));
	}
	
	public ArrayList<String> seleccionarPlataforma(String nombrePlat, String nombrePaq) throws PlataformaNoValidaException{
		
		ArrayList<String> ret = new ArrayList<String>();
		ManejadorEspectaculo mE= ManejadorEspectaculo.getInstancia();
		ManejadorPaquete mP=ManejadorPaquete.getInstancia();
		ManejadorPlataforma mPlat=ManejadorPlataforma.getInstancia();
		if(mPlat.buscarPlataforma(nombrePlat)==null) {
			throw new PlataformaNoValidaException("La Plataforma no es válida");
		}
		
		ArrayList<String> arrayEsPlat=mE.buscarEspectaculoPorPlataforma(nombrePlat);
		paq=mP.buscarPaquete(nombrePaq);
		ArrayList<String> arrayEsPaq=paq.obtenerEspectaculos();
		for (String s :arrayEsPlat) {
			if (!arrayEsPaq.contains(s)) {
				ret.add(s);
			}
		}			
		return ret;
	}
	
	public DtEspectaculoCompleto seleccionarEspectaculo(String nombreEsp) throws Exception {
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		Espectaculo e = mE.buscarEspectaculo(nombreEsp);		
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		ArrayList<Paquete> paquetes = new ArrayList<>();
		ArrayList<String> espectaculos = new ArrayList<>();
		ArrayList<String> paquetesDelEspectaculo = new ArrayList<>();
		paquetes = mP.listaPaquetes();				
		boolean encontre = false;
		int k = 0;
		int i = 0;
		while (k < paquetes.size()) {
			espectaculos = paquetes.get(k).obtenerEspectaculos();
			i = 0;
			encontre = false;
			while (i < espectaculos.size() && !encontre) {
				encontre = espectaculos.get(i).equals(nombreEsp);
				if(encontre) 
					paquetesDelEspectaculo.add(paquetes.get(k).getNombre());				
				i++;			
			}
			k++;			
		}
		String img64 = e.getImagen64();
		DtEspectaculoCompleto ret = new DtEspectaculoCompleto(e.getNombre(),e.getDescripcion(),e.getURL(),e.getDuracion(),e.getCantMax(),e.getCantMin(),e.getCosto(),
				java.sql.Date.valueOf(e.getFechaReg()), e.getNickNameArtista(), e.getNombrePlataforma(), e.obtenerFunciones(), paquetesDelEspectaculo, img64);
		return ret;
	}
	
	
	public ArrayList<String> listarPaquetes(){
		ArrayList<String> ret=new ArrayList<String>();
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		ArrayList<Paquete> arrayP= mP.listaPaquetes();
		for (Paquete p: arrayP) {
			ret.add(p.getNombre());
		}
		return ret;
	}
	
	public ArrayList<String> listarPaquetesVigentes(){
		ArrayList<String> ret=new ArrayList<String>();
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		ArrayList<Paquete> arrayP= mP.listaPaquetes();
		LocalDate ahora= LocalDate.now();
		for (Paquete p: arrayP) {
			if (!(p.getFechaFin().isBefore(ahora)))///esta negado para incluir fechas en el mismo día, 
				ret.add(p.getNombre());
		}
		return ret;
	}
	
	public DtPaquete seleccionarPaquete(String nombre) {
		ManejadorPaquete mP= ManejadorPaquete.getInstancia();
		Paquete aux= mP.buscarPaquete(nombre);
		return aux.getDt();
		
	}
	public void ingresarDatosPaquete(DtPaquete dtp, byte[] imagen) throws PaqueteNoValidoException {
		if (dtp.getNombre() == null)
			throw new PaqueteNoValidoException("El paquete " + dtp.getNombre() +  " ingresado no es valida");
		dtpaq = dtp;
		img = imagen;
	}

	public boolean chequearDisponibilidadPaquete(String nombre) {
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		Paquete p = mP.buscarPaquete(nombre);
		if (p == null) 
			return true; //throw new PaqueteNoValidoException("Nombre inválido, " + nombre + " ya existe en el sistema");
		else return false;
	}
	
	public void altaPaquete() throws PaqueteNoValidoException {
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		Paquete p = mP.buscarPaquete(dtpaq.getNombre());
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		ArrayList<Espectaculo> lE = new ArrayList<>();
		ArrayList<String> aux = dtpaq.getEspectaculos();
		if (aux != null) {
			for (String s: aux) {
				lE.add(mE.buscarEspectaculo(s));
			}
		}
		if (p != null) {
			throw new PaqueteNoValidoException("El paquete " + dtpaq.getNombre() + " ya existe en el sistema");
		} else {
			Paquete newP = new Paquete(dtpaq.getNombre(), dtpaq.getDescripcion(), dtpaq.getFechaInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), dtpaq.getFechaFin().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), dtpaq.getFechaRegistro().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), dtpaq.getDescuento(), lE, img);
			mP.agregarPaquete(newP);
		}
	}
	
	public List<String> espectaculosDelPaquete(String nombre){
		List<String> ret = new ArrayList<>();
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		Paquete p = mP.buscarPaquete(nombre);
		if (p != null) ret = p.obtenerEspectaculos();						
		
		return ret;
	}
	
	public void comprarPaquete(String nomPaquete, String nickEs)throws Exception {
		ManejadorPaquete mP=ManejadorPaquete.getInstancia();
		ManejadorUsuario mU=ManejadorUsuario.getInstancia();
		Paquete paq= mP.buscarPaquete(nomPaquete);
		if (paq==null) {
			throw new Exception ("no ha seleccionado un paquete válido");
		}
		Espectador esp=(Espectador)mU.buscarUsuario(nickEs);
		if (esp.comproPaquete(nomPaquete))
			{throw new Exception("ese paquete ya habia sido comprado");}
		else {
			CompraPaquete aux =new CompraPaquete(esp, paq, LocalDate.now());
			esp.agregarCompra(aux);
		}
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();		
		em.getTransaction().begin();
		em.persist(esp);					
		em.getTransaction().commit();
		
	}
	
	public String getImagenPaquete(String nombre) throws Exception {
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		Paquete tmp = mP.buscarPaquete(nombre);
		if (tmp != null)
			return tmp.getImagen64();
		else return null;
	}	
}
