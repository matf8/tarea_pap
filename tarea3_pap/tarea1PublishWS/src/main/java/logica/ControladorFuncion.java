package logica;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import persistencia.Conexion;
import javax.persistence.EntityManager;

import interfaces.IControladorFuncion;
import datatypes.DtFuncion;
import datatypes.DtRegistroCompleto;

import excepciones.PlataformaNoExisteException;
import excepciones.EspectaculoNoValidoException;
import excepciones.UsuarioNoExisteException;
import excepciones.FuncionNoValidaException;

public class ControladorFuncion implements IControladorFuncion {	
	private Espectaculo e;
	private DtFuncion dtfun;
	private List<Artista> invitados = new ArrayList<>();
	private List<Registro> registros = new ArrayList<>();
	private Funcion fR;
	private Espectador eR;
	private byte[] img;

	public ControladorFuncion() {
		super();
	}
	
	public ArrayList<String> listarEspectaculosPorArtista(String nickOrganizador) throws Exception {
		ArrayList<String> ret = new ArrayList<>();		
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();		
		ArrayList<Espectaculo> aux = mE.listaEspec();
		for (Espectaculo e: aux) {
				if (e.getNickNameArtista().equals(nickOrganizador))
					ret.add(e.getNombre());
		}
		if (ret.isEmpty())
			throw new Exception("No tienes espectaculos organizados, da de alta un espectaculo maldito energumeno");
		return ret;		
	}	
		
	public ArrayList<String> listarEspectaculos(String nombrePlat) throws PlataformaNoExisteException {
		
		ArrayList<String> ret = new ArrayList<>();		
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();		
		Plataforma plat = mP.buscarPlataforma(nombrePlat);		
		if (plat != null) {		
			ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();			
			ret = mE.buscarEspectaculoPorPlataforma(nombrePlat);			
		} else throw new PlataformaNoExisteException("La plataforma no existe en el sistema");
			
		return ret;		
	}	
	
	public void seleccionarEspectaculo(String nombre) throws EspectaculoNoValidoException {
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		Espectaculo tmp = mE.buscarEspectaculo(nombre);
		if (tmp == null) 		
			throw new EspectaculoNoValidoException("El espectáculo seleccionado no es valido");
		else e = tmp;			
	}
	
	public void ingresarFuncion(DtFuncion dtf, byte[] i) throws FuncionNoValidaException {
		img = i;
		if (dtf != null)
			dtfun = dtf;
		else throw new FuncionNoValidaException ("La función ingresada no es valida");
	}
	
	public void ingresarArtista(String nombreArt) throws UsuarioNoExisteException, Exception {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usr = mU.buscarUsuario(nombreArt);		
		if (usr != null) {
			if (usr instanceof Artista)	
				if (!invitados.contains((Artista) usr))
					invitados.add((Artista) usr);
				else throw new Exception("Artista ya ingresado");
			else throw new Exception("Usuario no es artista");
		} else throw new UsuarioNoExisteException("El artista ingresado no existe en el sistema");
	
	}
		
	public boolean chequearDisponibilidadNombreFuncion(String nombreF) throws FuncionNoValidaException {		
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		boolean ret = mE.buscarFuncion(nombreF);	
		if(!ret) {
			return !ret;
		}
		else throw new FuncionNoValidaException("El nombre de la función ya existe");			
	}
	
	public void altaFuncion() {
		Instant instant = Instant.ofEpochMilli(dtfun.getHoraIni().getTime());
		Funcion f = new Funcion(dtfun.getNombre(), dtfun.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalTime(), dtfun.getFechaReg().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), invitados, img);
		e.agregarFuncion(f, e);		
	}	
	
	public ArrayList<String> listarFunciones() {		
		return e.obtenerFunciones();		
	}	
	
	public ArrayList<String> listarFuncionesVigentes() {		
		return e.obtenerFuncionesVigentes();		
	}	
			
	public DtFuncion seleccionarFuncion(String nombre) throws FuncionNoValidaException {
		Funcion f = null;
		f = e.obtenerFuncionUnica(nombre);		
		if (f == null)
			throw new FuncionNoValidaException("La funcion ingresada no existe en el sistema");
		else {
			fR = f;
			return f.getDt();
		}		
	}	
	
	public ArrayList<String> listarEspectadores() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<String> ret = mU.listarEspectadores();
		return ret;
	}	
	
	public ArrayList<DtFuncion> listarFuncionesEspectador(String nick) {
		ArrayList<DtFuncion> ret = new ArrayList<DtFuncion>();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Espectador u = (Espectador) mU.buscarUsuario(nick);	
		ret = u.getDtFuncion();				
	
		return ret;
	}
	
	public ArrayList<DtRegistroCompleto> listarRegistros(String nick) throws Exception {	
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.buscarUsuario(nick);	
		Espectador esp = null;
		
		if (u instanceof Espectador)
			 esp = (Espectador) u;
		else throw new Exception("El usuario no es un espectador");	
		eR = esp;
		
		ArrayList<Registro> lR = (ArrayList<Registro>) esp.getRegistros();					
		ArrayList<Registro> lRAC = new ArrayList<>(lR);
		List<Registro> canjeados = null;	
				
		int i = 0;	
		while (i < lR.size() && lRAC.size() >= 3) {			
			canjeados = lR.get(i).getCanjeados();
			if (canjeados != null) {
				for (Registro c: canjeados) {
					lRAC.remove(c);
				}			
			}
			i++;						
		}
		
		ArrayList<DtRegistroCompleto> ret = new ArrayList<>();		
		DtRegistroCompleto dtr = null;				
		for (int j=0; j<lRAC.size(); j++) {
			dtr = new DtRegistroCompleto(j, lRAC.get(j).getNombreFuncion(), java.sql.Date.valueOf(lRAC.get(j).getFechaReg()), lRAC.get(j).getCosto());
			ret.add(dtr);
		}		
		registros = lRAC;
		return ret;		
	}
	
	@Override
	public void altaRegistro(List<Integer> rS) throws Exception {			
		List<Registro> lR = new ArrayList<>();
		LocalDate fecha = LocalDate.now();		
		float costo = e.getCosto();		
		Registro r = null;		
		if (rS.size() == 3) {
			for (Integer w: rS) {				
				lR.add(registros.get(w));
			}			
			costo = 0;
			r = new Registro(fR, eR, fecha, costo, lR);
		} else {			
			r = new Registro(fR, eR, fecha, costo);
		}				
		
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();		
		Usuario u = mU.buscarUsuario(eR.getNickName());
		
		if (eR.chequearDisponibilidadRegistro(fR.getNombre())) 
			eR.agregarRegistro(r);		
		else throw new Exception("El registro a la funcion " + fR.getNombre() + " ya existe");			
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();		
		em.getTransaction().begin();
		em.persist(u);					
		em.getTransaction().commit();		
	}	
	
	public List<String> listarPaquetes(String nick) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Espectador esp = (Espectador) mU.buscarUsuario(nick);
		List<String> ret = new ArrayList<>();
		ret = esp.listaPaquetesEspectaculo(e.getNombre());	
		return ret;
	}		
		
	public void altaRegistroPaquete(String nick, String nombreF, String espectaculo, String paquete) throws Exception {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();		
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		//ManejadorPaquete mP = ManejadorPaquete.getInstancia();

		Espectador espectador = (Espectador) mU.buscarUsuario(nick);
		Espectaculo e = mE.buscarEspectaculo(espectaculo);
		Funcion f = e.obtenerFuncionUnica(nombreF);		
		Paquete p = espectador.obtenerPaquete(paquete);
		LocalDate fecha = LocalDate.now();	
		Registro r = null;		
		
		if (espectador.chequearDisponibilidadRegistro(f.getNombre())) {
			if (p != null) {							
				r = new Registro(f, espectador, fecha, e, p);			
			}	
			espectador.agregarRegistro(r);		
		} else throw new Exception("El registro a la funcion " + f.getNombre() + " ya existe");			
		
		//Usuario u = mU.buscarUsuario(espectador.getNickName());		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();		
		em.getTransaction().begin();
		em.persist(espectador);					
		em.getTransaction().commit();			
	}	
}
	