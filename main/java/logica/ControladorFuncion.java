package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import interfaces.IControladorFuncion;

import datatypes.DtFuncion;
import datatypes.DtRegistro;
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

	public ControladorFuncion() {
		super();
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
	
	public void ingresarFuncion(DtFuncion dtf) throws FuncionNoValidaException {
		if (dtf != null)
			dtfun = dtf;
		else throw new FuncionNoValidaException ("La función ingresada no es valida");
	}
	
	public void ingresarArtista(String nombreArt) throws UsuarioNoExisteException {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usr = mU.buscarUsuario(nombreArt);		
		if (usr != null) {
			if (usr instanceof Artista)	
				invitados.add((Artista) usr);
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
		Funcion f = new Funcion(dtfun.getNombre(), dtfun.getFecha(), dtfun.getHoraIni(), dtfun.getFechaReg(), invitados);
		e.agregarFuncion(f, e);		
	}	
	
	public ArrayList<String> listarFunciones() {		
		return e.obtenerFunciones();		
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
		ArrayList<Registro> canjeados = null;		
		int i = 0;	
		while (i <= lR.size() && lRAC.size() >= 3) {			
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
		for (int j=0; j<=lRAC.size(); j++) {
			dtr = new DtRegistroCompleto(j, lRAC.get(j).getNombreFuncion(), lRAC.get(j).getFechaReg(), lRAC.get(j).getCosto());
			ret.add(dtr);
		}		
		registros = lRAC;
		return ret;		
	}
	
	public void altaRegistro(List<Integer> rS) {		
		List<Registro> lR = new ArrayList<>();
		LocalDate fecha = LocalDate.now();		
		float costo = e.getCosto();		
		Registro r = null;
		if (rS.size() == 3) {
			for (Integer w: rS) {				
				lR.add(registros.get(w));
			}			
			r = new Registro(fR, fecha, costo, lR);
		} else if (rS.size() == 0) {
			r = new Registro(fR, fecha, costo);
		}
		eR.agregarRegistro(r);
	}	
}
	