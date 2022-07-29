package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtEspectaculo;
import datatypes.DtEspectaculoCompleto;
import datatypes.DtFuncion;
import datatypes.DtPaquete;

import interfaces.IControladorEspectaculo;

import excepciones.PlataformaNoExisteException;
import excepciones.UsuarioNoExisteException;
import excepciones.EspectaculoNoValidoException;
import excepciones.FuncionNoValidaException;
import excepciones.PaqueteNoValidoException;

public class ControladorEspectaculo implements IControladorEspectaculo {
	private Plataforma plat;
	private Artista artistaOrg;
	private DtEspectaculo dtesp;	
	private byte[] img;
	
	public ControladorEspectaculo() {
		super();
	}
	
	public void ingresarEspectaculo(String nombrePlat, String artistaOrganizador, DtEspectaculo dte, byte[] imagen) throws PlataformaNoExisteException, UsuarioNoExisteException {		
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();		
		Plataforma pt = mP.buscarPlataforma(nombrePlat);		
		if (pt != null) {
			plat = pt;
		} else throw new PlataformaNoExisteException("Plataforma no existe en el sistema");				
		
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();			
		Usuario u = mU.buscarUsuario(artistaOrganizador);		
		if (u != null) {
			if (u instanceof Artista)
				artistaOrg = (Artista) u;
			else throw new UsuarioNoExisteException("El usuario no es un artista");
		} else throw new UsuarioNoExisteException("Artista no existe en el sistema");			
		dtesp = dte;	
		img = imagen;
	}
	
	public boolean chequearDisponibilidadNombre(String nombre) throws EspectaculoNoValidoException {	
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		Espectaculo e = mE.buscarEspectaculo(nombre);
		if (e == null)
			return true;
		else throw new EspectaculoNoValidoException("El nombre " + nombre + " ya existe en el sistema");
	}
	
	public void altaEspectaculo() {		
		Espectaculo newE = new Espectaculo (dtesp.getNombre(), dtesp.getDescripcion(), dtesp.getURL(), dtesp.getDuracion(), dtesp.getCantMax(), dtesp.getCantMin(), dtesp.getCosto(), dtesp.getFechaReg(), plat, artistaOrg, img);
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		mE.agregarEspectaculo(newE);
	}
	
	public ArrayList<String> listarEspectaculos(String nombrePlat) throws PlataformaNoExisteException{		
		ArrayList<String> ret = new ArrayList<>();		
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();		
		Plataforma pt = mP.buscarPlataforma(nombrePlat);			
		if (pt != null) {
			ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();			
			ret = mE.buscarEspectaculoPorPlataforma(nombrePlat);		
		} else throw new PlataformaNoExisteException("El nombre de la plataforma " + nombrePlat + " no existe en el sistema");
		
		return ret;		
	}	

	public DtEspectaculoCompleto seleccionarEspectaculo(String nombreEsp) throws Exception {
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		Espectaculo e = mE.buscarEspectaculo(nombreEsp);		
		if(e == null) {
			throw new EspectaculoNoValidoException("El espectáculo " + nombreEsp + " seleccionado no es válido");
		}else {
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
					e.getFechaReg(), e.getNickNameArtista(), e.getNombrePlataforma(), e.obtenerFunciones(), paquetesDelEspectaculo, img64);
			return ret;
		}
	}
	
	public DtFuncion seleccionarFuncion(String nombre) throws FuncionNoValidaException {
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		ArrayList<Espectaculo> lE = mE.listaEspec();
		int i = 0;
		Funcion f = null;
		while (i < lE.size() && (f == null)) {
			f = lE.get(i).obtenerFuncionUnica(nombre);
			i++;
		}
		if (f == null) {
			throw new FuncionNoValidaException("La función " + nombre + " ingresada no existe en el sistema");
		}		
		
		return f.getDt();
	}
	
	public DtPaquete seleccionarPaquete(String nombre) throws PaqueteNoValidoException {
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		Paquete paq = mP.buscarPaquete(nombre);
		if(paq == null) {
			throw new PaqueteNoValidoException("El paquete " + nombre + " ingresado no existe en el sistema");
		} else 
			return paq.getDt();
	}	
	
	public String getImagenFuncion(String nombreF) throws Exception {
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		ArrayList<Espectaculo> aux = mE.listaEspec();
		Funcion f = null;
		int i = 0;
		while (f == null && i <= aux.size()) {
			f = aux.get(i).obtenerFuncionUnica(nombreF);
			i++;
		}
		
		if (f != null) 
			return f.getImagen64();	
		else return null;		
	}
		
}