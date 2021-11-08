package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


import datatypes.DtArtista;
import datatypes.DtEspectaculo;
import datatypes.DtEspectador;
import datatypes.DtFuncion;
import datatypes.DtPaquete;
import datatypes.DtPlataforma;
import datatypes.DtRegistroCompleto;
import excepciones.FuncionNoValidaException;
import excepciones.UsuarioNoExisteException;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorFuncion;
import interfaces.IControladorPaquete;
import interfaces.IControladorPlataforma;
import interfaces.IControladorUsuario;

public class ControladorFuncionTest {
	
	Fabrica f = Fabrica.getInstancia();
	IControladorEspectaculo cE = f.getIControladorEspectaculo();
	IControladorUsuario cU = f.getIControladorUsuario();
	IControladorPlataforma cP = f.getIControladorPlataforma();
	IControladorFuncion cF = f.getIControladorFuncion();
	IControladorPaquete cPaq = f.getIControladorPaquete();	
		
	
	public void altaPlataformaEsp() throws Exception {
		DtPlataforma dtp = new DtPlataforma("P2", "url", "desc");
		cP.ingresarDatosPlataforma(dtp);
		cP.chequearDisponibilidadPlataforma("P2");
		cP.altaPlataforma();	
	}
	
	public void altaArtistaOrg() throws Exception {
	
	    DtArtista dt1 = new DtArtista("AO2", "organizador2", "ao", LocalDate.now(), "AO2Correo", "pass", "", "", "");
	    cU.ingresarDatosArtista(dt1, null);
		cU.chequearDisponibilidadNickname("AO2");	   
	    cU.altaUsuario();	 
	    
	    DtArtista dt2 = new DtArtista("AI2", "invitado", "ai", LocalDate.now(), "Ai2Correo", "pass", "", "", "");
	    cU.ingresarDatosArtista(dt2, null);
		cU.chequearDisponibilidadNickname("AI2");	   
	    cU.altaUsuario();	
		
	    DtEspectador dte = new DtEspectador("UE2", "nombre2", "ap2", LocalDate.now(), "E2Correo", "pass");
	    cU.ingresarDatosEspectador(dte, null);
	    cU.chequearDisponibilidadNickname("UE2");	   
	    cU.altaUsuario();
	}
	
	public void altaEspectaculo() throws Exception {
		DtEspectaculo dte = new DtEspectaculo("E2", "desc", "url", 2, 1, 0, 10, LocalDate.now(), "AO2", "P2");
					
		cE.ingresarEspectaculo("P2", "AO2", dte, null);			
		
		cE.chequearDisponibilidadNombre("E2");
		cE.altaEspectaculo();		
	}
	
	public void altaPaquete() throws Exception {
		DtPaquete dtp = new DtPaquete("Paq3", "desc", LocalDate.now(), LocalDate.now(), LocalDate.now(), 20, null);
		cPaq.ingresarDatosPaquete(dtp, null);
		cPaq.chequearDisponibilidadPaquete("Paq3");	
		cPaq.altaPaquete();	
		cPaq.seleccionarPlataforma("P2","Paq3");	
		cPaq.agregarEspectaculoAPaquete("E2");
		cPaq.comprarPaquete("Paq3", "UE2");
		
	}	

	public void altaFuncionTest() throws Exception {
		String sf = "2021-12-12";
		LocalDate f = LocalDate.parse(sf);
		DtFuncion dtf = new DtFuncion("F2", f, LocalTime.now(), LocalDate.now(), null);
		
		try {
			cF.ingresarFuncion(null, null);
		} catch (Exception e) {
			if (!e.getMessage().equals("La función ingresada no es valida")) {
				throw e;
			}			
		}			
				
		cF.ingresarFuncion(dtf, null);
		cF.chequearDisponibilidadNombreFuncion("F2");	
		cF.ingresarArtista("AI2");	
		
			
		try {
			cF.ingresarArtista("AI2");	
		} catch (Exception e) {
			if (!e.getMessage().equals("Artista ya ingresado")) {
				throw e;
			}			
		}			
		
		try {
			cF.ingresarArtista("UE2");	
		} catch (Exception e) {
			if (!e.getMessage().equals("Usuario no es artista")) {
				throw e;
			}			
		}	
		
		try {
			cF.ingresarArtista("A12312313");	
		} catch (UsuarioNoExisteException e) {	
			
		}		
				
		try {
			cF.seleccionarEspectaculo("E3333");	
		} catch (Exception e) {
			if (!e.getMessage().equals("El espectáculo seleccionado no es valido")) {
				throw e;
			}			
		}
		
		cF.seleccionarEspectaculo("E2");				
		cF.altaFuncion();		
		
		try {
			cF.chequearDisponibilidadNombreFuncion("F2");	
		} catch (Exception e) {
			if (!e.getMessage().equals("El nombre de la función ya existe")) {
				throw e;
			}			
		}
				
		DtFuncion dtf2 = new DtFuncion("F3", f, LocalTime.now(), LocalDate.now(), null);
		cF.ingresarFuncion(dtf2, null);
		cF.altaFuncion();		
		DtFuncion dtf3 = new DtFuncion("F4", f, LocalTime.now(), LocalDate.now(), null);
		cF.ingresarFuncion(dtf3, null);
		cF.altaFuncion();
		DtFuncion dtf4 = new DtFuncion("F5", f, LocalTime.now(), LocalDate.now(), null);
		cF.ingresarFuncion(dtf4, null);
		cF.altaFuncion();
		DtFuncion dtf5 = new DtFuncion("F6", f, LocalTime.now(), LocalDate.now(), null);
		cF.ingresarFuncion(dtf5, null);
		cF.altaFuncion();
		
	}
	
	public void listarEspectaculosPorArtistaTest() throws Exception {
		List<String> resEsp = new ArrayList<String>();		
		resEsp.add("E2");			
		List<String> resObt = cF.listarEspectaculosPorArtista("AO2");
		assertEquals(resEsp, resObt);	
		
		try {
			resObt = cF.listarEspectaculosPorArtista("AI2");
		} catch (Exception e) {
			if (!e.getMessage().equals("No tienes espectaculos organizados, da de alta un espectaculo")) {
				throw e;
			}
		}

		
	}
	
	public void listarEspectaculosTest() throws Exception {
		List<String> resEsp = new ArrayList<String>();		
		resEsp.add("E2");			
		List<String> resObt = cF.listarEspectaculos("P2");
		assertEquals(resEsp, resObt);	
	}
	
	public void listarFuncionesTest() throws Exception {				
		List<String> resObt = cF.listarFunciones();
		assertTrue(resObt.contains("F2"));		
		
	}
	
	public void listarFuncionesVigenteTest() throws Exception {
		List<String> resObt = cF.listarFuncionesVigentes();
		assertTrue(resObt.contains("F2"));			
	}
	
	public void seleccionarFuncionTest() throws FuncionNoValidaException, Exception {		
		
		try {
			DtFuncion dt = cF.seleccionarFuncion("F2");
			assertEquals(dt.getNombre(), "F2");	
		} catch (FuncionNoValidaException e) { }
		
		try {
			DtFuncion dt = cF.seleccionarFuncion("F33434");			
		} catch (FuncionNoValidaException e) { }
				
	}	
		
	public void listarEspectadoresTest() {
		ArrayList<String> resObt = cF.listarEspectadores();		
		assertTrue(resObt.contains("UE2"));
	}
	
	public void listarFuncionesEspectadorTest() throws FuncionNoValidaException, Exception {			
		ArrayList<DtFuncion> resObt = cF.listarFuncionesEspectador("UE2");
		boolean b = false;
		for (DtFuncion d: resObt) {
			if (d.getNombre().equals("F2")) 
				b = true;							
		}
		assertTrue(b);
	
	}
	
	public void listarRegistrosTest() throws Exception {		
		try {
			ArrayList<DtRegistroCompleto> resObt = cF.listarRegistros("U123123E2");
		} catch (Exception e) {
			if (!e.getMessage().equals("El usuario no es un espectador"))
				throw e;
		}
		
		ArrayList<DtRegistroCompleto> resObt = cF.listarRegistros("UE2");
		boolean b = false;
		for (DtRegistroCompleto d: resObt) 
			if (d.getNombreFuncion().equals("F2")) 
				b = true;						
		assertTrue(b);	
	}
	
	public void altaRegistroTest() throws Exception {
		try {			
			cF.seleccionarEspectaculo("E2");
			cF.listarRegistros("UE2");
			DtFuncion dtf = cF.seleccionarFuncion("F3");
			List<Integer> rS = new ArrayList<Integer>();			
			cF.altaRegistro(rS);
			
			DtFuncion dtf2 = cF.seleccionarFuncion("F4");			
			cF.altaRegistro(rS);
			
			DtFuncion dtf3 = cF.seleccionarFuncion("F5");			
			cF.altaRegistro(rS);
			
			try {
				cF.altaRegistro(rS);
			} catch (Exception e) {
				if (!e.getMessage().equals("El registro a la funcion F5 ya existe"))
					throw e;
			}
				
			rS.add(0);
			rS.add(1);
			rS.add(2);
			DtFuncion dtf4 = cF.seleccionarFuncion("F6");		
			cF.listarRegistros("UE2");
			cF.altaRegistro(rS);
			
		} catch (Exception e) {
			
		}
		
	}
	
	public void listarPaquetesTest() {
		List<String> resEsp = new ArrayList<String>();	
		resEsp.add("Paq3");
		List<String> resObt = cF.listarPaquetes("UE2");		
		assertEquals(resEsp, resObt);

	}
	
	public void altaRegistroPaqueteTest() throws Exception {		
		try {
			cF.seleccionarEspectaculo("E2");
			cF.altaRegistroPaquete("UE2", "F2", "E2", "Paq3");
		} catch (Exception e) {
			if (!e.getMessage().equals("El registro a la funcion F2 ya existe")) {
				throw e;
			}
		}
	}
	
	@Test
	public void eltest() throws Exception {	
		
		try {
			altaPlataformaEsp();	
		} catch (Exception e) {			
		}
		try {
			altaArtistaOrg();	
		} catch (Exception e) {			
		}
		try {
			altaEspectaculo();	
		} catch (Exception e) {			
		}
		try {
			altaPaquete();	
		} catch (Exception e) {			
		}
		try {
			altaFuncionTest();	
		} catch (Exception e) {			
		}
		try {
			listarEspectaculosPorArtistaTest();	
		} catch (Exception e) {			
		}
		try {
			listarEspectaculosTest();	
		} catch (Exception e) {			
		}
		try {
			listarFuncionesTest();	
		} catch (Exception e) {			
		}
		try {
			listarFuncionesVigenteTest();	
		} catch (Exception e) {			
		}
		try {
			seleccionarFuncionTest();	
		} catch (FuncionNoValidaException e) {			
		}
		try {
			listarEspectadoresTest();	
		} catch (Exception e) {			
		}			
		try {
			altaRegistroTest();	
		} catch (Exception e) {			
		}	
		try {
			listarPaquetesTest();	
		} catch (Exception e) {			
		}
		try {
			altaRegistroPaqueteTest();	
		} catch (Exception e) {			
		}	
		try {
			listarFuncionesEspectadorTest();	
		} catch (Exception e) {			
		}
		try {
			listarRegistrosTest();	
		} catch (Exception e) {			
		}
	}	
}
