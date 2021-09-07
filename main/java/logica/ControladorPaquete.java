package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtEspectaculo;
import datatypes.DtEspectaculoCompleto;
import datatypes.DtPaquete;
import excepciones.EspectaculoNoValidoException;
import excepciones.PaqueteNoValidoException;
import excepciones.PlataformaNoValidaException;
import interfaces.IControladorPaquete;

public class ControladorPaquete implements IControladorPaquete{
	private DtPaquete dtpaq;
	private Paquete paq;
	
	public ControladorPaquete() {
		super();
	}
	
	public void agregarEspectaculoAPlataforma(String nombreEs) {
		ManejadorEspectaculo mE=ManejadorEspectaculo.getInstancia();
		paq.agregarEspectaculo(mE.buscarEspectaculo(nombreEs));
	}
	
	public ArrayList<String> seleccionarPlataforma(String nombrePlat, String nombrePaq)throws PlataformaNoValidaException{
		
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
	
	public DtEspectaculoCompleto seleccionarEspectaculo(String nombreEsp){
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
		DtEspectaculoCompleto ret = new DtEspectaculoCompleto(e.getNombre(),e.getDescripcion(),e.getURL(),e.getDuracion(),e.getCantMax(),e.getCantMin(),e.getCosto(),
				e.getFechaReg(), e.getNickNameArtista(), e.getNombrePlataforma(), e.obtenerFunciones(), paquetesDelEspectaculo);
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
	
	public DtPaquete seleccionarPaquete(String nombre) {
		ManejadorPaquete mP= ManejadorPaquete.getInstancia();
		Paquete aux= mP.buscarPaquete(nombre);
		return aux.getDt();
		
	}
	public void ingresarDatosPaquete(DtPaquete dtp) throws PaqueteNoValidoException {
		if (dtp.getNombre() == null)
			throw new PaqueteNoValidoException("El paquete " + dtp.getNombre() +  " ingresado no es valida");
		dtpaq = dtp;
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
			Paquete newP = new Paquete(dtpaq.getNombre(), dtpaq.getDescripcion(), dtpaq.getFechaInicio(), dtpaq.getFechaFin(), dtpaq.getFechaRegistro(), dtpaq.getDescuento(), lE);
			mP.agregarPaquete(newP);
		}
	}
	
}
