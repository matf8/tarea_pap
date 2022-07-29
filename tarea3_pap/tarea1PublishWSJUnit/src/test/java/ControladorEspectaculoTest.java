package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import org.junit.Test;

import datatypes.DtArtista;
import datatypes.DtEspectaculo;
import datatypes.DtEspectaculoCompleto;
import datatypes.DtFuncion;
import datatypes.DtPaquete;
import datatypes.DtPlataforma;
import excepciones.FuncionNoValidaException;
import excepciones.PaqueteNoValidoException;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorFuncion;
import interfaces.IControladorPaquete;
import interfaces.IControladorPlataforma;
import interfaces.IControladorUsuario;


public class ControladorEspectaculoTest {
	
	Fabrica f = Fabrica.getInstancia();
	IControladorEspectaculo cE = f.getIControladorEspectaculo();
	IControladorUsuario cU = f.getIControladorUsuario();
	IControladorPlataforma cP = f.getIControladorPlataforma();
	IControladorFuncion cF = f.getIControladorFuncion();
	IControladorPaquete cPaq = f.getIControladorPaquete();	
	
	public void altaArtistaOrg() throws Exception {
		DtArtista dta = new DtArtista("AO", "organizador", "ao", LocalDate.now(), "AOCorreo", "pass", "", "", "");
	    cU.ingresarDatosArtista(dta, null);
		cU.chequearDisponibilidadNickname("AO");	   
	    cU.altaUsuario();
	    
	    DtArtista dt1 = new DtArtista("AI1", "invitado", "ai", LocalDate.now(), "AiCorreo", "pass", "", "", "");
	    cU.ingresarDatosArtista(dt1, null);
		cU.chequearDisponibilidadNickname("AI1");	   
	    cU.altaUsuario();	    
		
	}
	
	public void altaPlataformaEsp() throws Exception {
		DtPlataforma dtp = new DtPlataforma("PE", "url", "desc");
		cP.ingresarDatosPlataforma(dtp);
		cP.chequearDisponibilidadPlataforma("PE");
		cP.altaPlataforma();	
	}
	
	public void altaFuncion() throws Exception {
		DtFuncion dtf = new DtFuncion("F1", LocalDate.now(), LocalTime.now(), LocalDate.now(), null);
		cF.ingresarFuncion(dtf, null);
		cF.chequearDisponibilidadNombreFuncion("F1");	
		cF.ingresarArtista("AI1");	
		cF.seleccionarEspectaculo("E1");
		cF.altaFuncion();
		
	}
	
	public void altaPaquete() throws Exception {
		DtPaquete dtp = new DtPaquete("Paq1", "desc", LocalDate.now(), LocalDate.now(), LocalDate.now(), 20, null);
		cPaq.ingresarDatosPaquete(dtp, null);
		cPaq.chequearDisponibilidadPaquete("Paq1");	
		cPaq.altaPaquete();	
		cPaq.chequearDisponibilidadPaquete("Paq1");	
		
	}	
	
	public void altaEspectaculoTest() throws Exception {
		DtEspectaculo dte = new DtEspectaculo("E1", "desc", "url", 2, 1, 0, 10, LocalDate.now(), "AO", "PE");
		
		try {
			cE.ingresarEspectaculo("PH", "AO", dte, null);
		} catch (Exception e) {
			if (!e.getMessage().equals("Plataforma no existe en el sistema")) {
				throw e;
			}			
		}			
		
		try {
			cE.ingresarEspectaculo("PE", "UE1", dte, null);
		} catch (Exception e) {
			if (!e.getMessage().equals("El usuario no es un artista")) {
				throw e;
			}			
		}	
		
		try {
			cE.ingresarEspectaculo("PE", "A1231231", dte, null);
		} catch (Exception e) {
			if (!e.getMessage().equals("Artista no existe en el sistema")) {
				throw e;
			}			
		}			
		
		cE.ingresarEspectaculo("PE", "AO", dte, null);			
		
		cE.chequearDisponibilidadNombre("E1");
		cE.altaEspectaculo();		
		cE.chequearDisponibilidadNombre("E1");		
	}
	
	public void agregarEspecPaqueteTest() throws Exception{
		try {
			cPaq.seleccionarPlataforma("PE","Paq1");			
			cPaq.agregarEspectaculoAPaquete("E1");
		} catch(Exception e) {	
		}
	}
	
	public void listarEspectaculosTest() throws Exception {
		ArrayList<String> resEsp = new ArrayList<String>();		
		resEsp.add("E1");	
		
		try {
			cE.listarEspectaculos("PJ");
		} catch (Exception e) {
			if (!e.getMessage().equals("El nombre de la plataforma PJ no existe en el sistema")) {
				throw e;
			}			
		}	
				
		ArrayList<String> resObt = cE.listarEspectaculos("PE");						
		assertEquals(resEsp, resObt);		
	}
	
	public void seleccionarEspectaculoTest() throws Exception {
		try {
			cE.seleccionarEspectaculo("PJ");
		} catch (Exception e) {
			if (!e.getMessage().equals("El espectáculo PJ seleccionado no es válido")) {
				throw e;
			}			
		}			
		DtEspectaculoCompleto dtc = cE.seleccionarEspectaculo("E1");	
		assertEquals(dtc.getNombre(), "E1");
	}
	
	public void seleccionarFuncionTest() throws FuncionNoValidaException {
		try {
			DtFuncion dt = cE.seleccionarFuncion("F2");	
		} catch (Exception e) {	
			if (!e.getMessage().equals("La función F2 ingresada no existe en el sistema")) {
				throw e;
			}
		}		
		DtFuncion dt = cE.seleccionarFuncion("F1");			
	}
	
	public void seleccionarPaqueteTest() throws PaqueteNoValidoException {
		try {
			cE.seleccionarPaquete("Paq33");
		} catch (PaqueteNoValidoException e) {	
			if (!e.getMessage().equals("El paquete Paq33 ingresado no existe en el sistema")) {
				throw e;
			}
		}			
		DtPaquete d = cE.seleccionarPaquete("Paq1");
	}
	
	public void getImagenFuncionTest() throws Exception {		
		assertEquals(null, cE.getImagenFuncion("F1"));
		assertEquals(null, cE.getImagenFuncion("F34"));
	}
	
	@Test
	public void eltest() throws Exception {	
		
		try {
			altaArtistaOrg();	
		} catch (Exception e) {			
		}
		try {
			altaPlataformaEsp();	
		} catch (Exception e) {			
		}		
		try {
			altaPaquete();	
		} catch (PaqueteNoValidoException e) {			
		}
		try {
			altaEspectaculoTest();	
		} catch (Exception e) {			
		}
		try {
			altaFuncion();	
		} catch (Exception e) {			
		}
		try {
			agregarEspecPaqueteTest();	
		} catch (Exception e) {			
		}		
		try {
			listarEspectaculosTest();	
		} catch (Exception e) {			
		}
		try {
			seleccionarEspectaculoTest();	
		} catch (Exception e) {			
		}
		try {
			seleccionarFuncionTest();	
		} catch (Exception e) {			
		}
		try {
			seleccionarPaqueteTest();	
		} catch (Exception e) {			
		}
		try {
			getImagenFuncionTest();	
		} catch (Exception e) {			
		}
	}
	
	
}