package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import datatypes.DtArtista;
import datatypes.DtEspectaculo;
import datatypes.DtEspectaculoCompleto;
import datatypes.DtEspectador;
import datatypes.DtPaquete;
import datatypes.DtPlataforma;
import excepciones.PlataformaNoValidaException;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorFuncion;
import interfaces.IControladorPaquete;
import interfaces.IControladorPlataforma;
import interfaces.IControladorUsuario;

public class ControladorPaqueteTest {

	Fabrica f = Fabrica.getInstancia();
	IControladorEspectaculo cE = f.getIControladorEspectaculo();
	IControladorUsuario cU = f.getIControladorUsuario();
	IControladorFuncion cF = f.getIControladorFuncion();
	IControladorPlataforma cPlat = f.getIControladorPlataforma();
	IControladorPaquete cP = f.getIControladorPaquete();	


	public void altaArtistaOrg() throws Exception {
		DtArtista dta = new DtArtista("AO3", "organizador3", "ao", LocalDate.now(), "AO3Correo", "pass", "", "", "");
	    cU.ingresarDatosArtista(dta, null);
		cU.chequearDisponibilidadNickname("AO3");	   
	    cU.altaUsuario();
	    DtEspectador dte = new DtEspectador("UE4", "espectador4", "ue", LocalDate.now(), "E4Correo", "pass");
	    cU.ingresarDatosEspectador(dte, null);
		cU.chequearDisponibilidadNickname("UE4");	   
	    cU.altaUsuario();
	}
	
	public void altaPlataformaEsp() throws Exception {
		DtPlataforma dtp = new DtPlataforma("PP", "url", "desc");
		cPlat.ingresarDatosPlataforma(dtp);
		cPlat.chequearDisponibilidadPlataforma("PP");
		cPlat.altaPlataforma();	
	}
	
	public void altaEspectaculo() throws Exception {
		DtEspectaculo dte = new DtEspectaculo("E3", "desc", "url", 2, 1, 0, 10, LocalDate.now(), "AO3", "PP");
		cE.ingresarEspectaculo("PP", "AO3", dte, null);		
		cE.chequearDisponibilidadNombre("E3");
		cE.altaEspectaculo();	
		DtEspectaculo dte2 = new DtEspectaculo("E4", "desc", "url", 2, 1, 0, 10, LocalDate.now(), "AO3", "PP");
		cE.ingresarEspectaculo("PP", "AO3", dte2, null);		
		cE.chequearDisponibilidadNombre("E4");
		cE.altaEspectaculo();	
	}	
	
	public void altaPaqueteTest() throws Exception {
		String sf = "2021-12-12";
		LocalDate f = LocalDate.parse(sf);
		ArrayList<String> esp = new ArrayList<String>();
		esp.add("E4");
		DtPaquete dtnull = new DtPaquete(null, "desc", LocalDate.now(), f, LocalDate.now(), 20, null);
		
		try {
			cP.ingresarDatosPaquete(dtnull, null);		
		} catch (Exception e) {
			if (!e.getMessage().equals("El paquete ingresado no es valido")) {
				throw e;
			}			
		}
		
		DtPaquete dtp = new DtPaquete("Paq2", "desc", LocalDate.now(), f, LocalDate.now(), 20, esp);				
		cP.ingresarDatosPaquete(dtp, null);			
		cP.chequearDisponibilidadPaquete("Paq2");
		cP.altaPaquete();	
		
		try {
			cP.altaPaquete();	
		} catch (Exception e) {
			if (!e.getMessage().equals("El paquete Paq2 ya existe en el sistema")) {
				throw e;
			}			
		}
	}
	
	public void seleccionarPaqueteTest() {
		DtPaquete dt = cP.seleccionarPaquete("Paq2");
		assertEquals(dt.getNombre(),"Paq2");
	}
	
	public void listarPaquetesTest() {	
		ArrayList<String> resObt = cP.listarPaquetes();		
		assertTrue(resObt.contains("Paq2"));
	}
	
	public void listarPaquetesVigentesTest() {	
		ArrayList<String> resObt = cP.listarPaquetesVigentes();		
		assertTrue(resObt.contains("Paq2"));
	}
	
	public void seleccionarEspectaculoTest() throws Exception{
		DtEspectaculoCompleto dt = cP.seleccionarEspectaculo("E3");
		assertEquals(dt.getNombre(),"E3");
	}
	
	public void seleccionarPlataformaTest() throws PlataformaNoValidaException {	
		try {
			ArrayList<String> resObt = cP.seleccionarPlataforma("PP222","Paq2");	
		} catch (Exception e) {
			if (!e.getMessage().equals("La Plataforma no es válida")) {
				throw e;
			}
		}
			
		ArrayList<String> resObt = cP.seleccionarPlataforma("PP","Paq2");			
	}
	
	public void agregarEspectaculoTest() {
		cP.agregarEspectaculoAPaquete("E3");
	}
	
	public void espectaculosDelPaqueteTest() {
		List<String> resObt = cP.espectaculosDelPaquete("Paq2");
		assertTrue(resObt.contains("E3"));
	}	
	
	public void getImagenPaqueteTest() throws Exception {		
		assertEquals(null, cP.getImagenPaquete("Paq2"));
		assertEquals(null, cP.getImagenPaquete("Paq123123"));		
	}
	
	public void comprarPaqueteTest() throws Exception {
		try {
			cP.comprarPaquete("Paq23232", "UE4");	
		} catch (Exception e) {
			if (!e.getMessage().equals("No ha seleccionado un paquete válido")) {
				throw e;
			}
		}		
		cP.comprarPaquete("Paq2", "UE4");		
		try {
			cP.comprarPaquete("Paq2", "UE4");
		} catch (Exception e) {
			if (!e.getMessage().equals("Ese paquete ya habia sido comprado")) {
				throw e;
			}			
		}
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
			altaEspectaculo();			
		} catch (Exception e) {			
		}
		try {
			altaPaqueteTest();			
		} catch (Exception e) {			
		}
		try {
			seleccionarPaqueteTest();			
		} catch (Exception e) {			
		}
		try {
			listarPaquetesTest();			
		} catch (Exception e) {			
		}
		try {
			listarPaquetesVigentesTest();			
		} catch (Exception e) {			
		}
		try {		
			seleccionarPlataformaTest();			
		} catch (PlataformaNoValidaException e) {			
		}					
		try {
			agregarEspectaculoTest();			
		} catch (Exception e) {			
		}
		try {
			espectaculosDelPaqueteTest();			
		} catch (Exception e) {			
		}
		try {		
			seleccionarEspectaculoTest();			
		} catch (Exception e) {			
		}	
		try {
			comprarPaqueteTest();			
		} catch (Exception e) {			
		}
		try {
			getImagenPaqueteTest();			
		} catch (Exception e) {			
		}		
	}	
}
