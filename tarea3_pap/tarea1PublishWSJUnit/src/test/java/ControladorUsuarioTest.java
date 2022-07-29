 package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtRegistro;
import datatypes.DtUsuario;
import excepciones.CorreoExisteException;
import excepciones.UsuarioExisteException;
import interfaces.Fabrica;
import interfaces.IControladorUsuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControladorUsuarioTest {
	
	Fabrica f = Fabrica.getInstancia();
	IControladorUsuario cU = f.getIControladorUsuario();	
		
	public void altaArtistaTest() throws CorreoExisteException {
		DtArtista dta = new DtArtista("A1", "nombre", "ap", LocalDate.now(), "A1Correo", "pass", "", "", "");
	    cU.ingresarDatosArtista(dta, null);
		cU.chequearDisponibilidadCorreo("A1Correo");	   
	    cU.altaUsuario();	    
		cU.chequearDisponibilidadCorreo("A1Correo");	
		
	}
	
	public void altaEspectadorTest() throws UsuarioExisteException {
		DtEspectador dte = new DtEspectador("UE1", "nombre", "ap", LocalDate.now(), "E1Correo", "pass");
	    cU.ingresarDatosEspectador(dte, null);
	    cU.chequearDisponibilidadNickname("UE1");	   
	    cU.altaUsuario();
	    cU.chequearDisponibilidadNickname("UE1");		
	}
	
	public void seleccionarUsuarioTest() {
		DtUsuario dt = cU.seleccionarUsuario("UE1");
		assertEquals(dt.getNickName(),"UE1");		
	}
	
	public void modificarUsuarioEspectadorTest() {		
		DtEspectador dtM = new DtEspectador("UE1", "nombreM2", "ap", LocalDate.now(), "E1Correo", "pass");							
		cU.modificarUsuario(dtM, null);		
		DtUsuario dt = cU.seleccionarUsuario("UE1");
		assertEquals(dt.getNombre(),dtM.getNombre());	
	} 
	
	public void modificarUsuarioArtistaTest() {
		DtArtista dtM = new DtArtista("A1", "M2Nombre", "ap", LocalDate.now(), "A1Correo", "pass", "", "", "");
		cU.modificarUsuario(dtM, null);		
		DtUsuario dt = cU.seleccionarUsuario("A1");
		assertEquals(dt.getNombre(),dtM.getNombre());
	} 
	
	public void iniciarSesionTest() throws Exception {	
		String tipo;
		
		try {
			cU.seguirUsuario("UE1");	
		} catch (Exception e) {
			if (!e.getMessage().equals("Logeado = null")) {
				throw e;
			}			
		}
		
		try {
			tipo = cU.iniciarSesion("A12323", "pass");
		} catch (Exception e) {
			if (!e.getMessage().equals("El usuario no existe")) {
				throw e;
			}			
		}
		
		try {
			tipo = cU.iniciarSesion("A1", "pass123123");
		} catch (Exception e) {
			if (!e.getMessage().equals("contraseña incorrecta")) {
				throw e;
			}			
		}
		
		tipo = cU.iniciarSesion("A1", "pass");

		try {
			tipo = cU.iniciarSesion("A1", "pass");
		} catch (Exception e) {
			if (!e.getMessage().equals("usuario ya logeado")) {
				throw e;
			}			
		}
		
		boolean artista = tipo.equals("artista");	
		DtUsuario dtA = cU.whoami();		
		cU.seguirUsuario("UE1");	
		
		try {
			cU.seguirUsuario("UE1");	
		} catch (Exception e) {
			if (!e.getMessage().equals("El usuario ya lo sigue.")) {
				throw e;
			}			
		}	
		
		try {
			cU.seguirUsuario("E1123123123");	
		} catch (Exception e) {
			if (!e.getMessage().equals("El usuario no existe")) {
				throw e;
			}			
		}
			
		cU.dejarSeguirUsuario("UE1");		
		
		try {
			cU.dejarSeguirUsuario("UE1");
		} catch (Exception e) {
			if (!e.getMessage().equals("El usuario no seguía a UE1")) {
				throw e;
			}			
		}
		
		try {
			cU.dejarSeguirUsuario("E1123131");		
		} catch (Exception e) {
			if (!e.getMessage().equals("El usuario no existe")) {
				throw e;
			}			
		}		
		
		cU.seguirUsuario("UE1");	
		cU.cerrarSesion();
		
		tipo = cU.iniciarSesion("UE1", "pass");
		boolean espectador = tipo.equals("espectador");	
		DtUsuario dtE = cU.whoami();
		cU.seguirUsuario("A1");
		cU.cerrarSesion();
		
		try {
			cU.dejarSeguirUsuario("UE1");	
		} catch (Exception e) {
			if (!e.getMessage().equals("Logeado = null")) {
				throw e;
			}			
		}
		
		assertTrue(artista && espectador);			
		assertEquals("A1", dtA.getNickName());		
		assertEquals("UE1", dtE.getNickName());			
	}		
	
	public void listarUsuariosTest() {
		ArrayList<String> resObt = cU.listarUsuarios();							
		assertTrue(resObt.contains("A1"));
		assertTrue(resObt.contains("UE1"));
	}
	
	public void listarArtistaTest() {					
		List<String> resObt = cU.listarArtista();					
		assertTrue(resObt.contains("A1"));
	}
	
	public void mostrarEspectactuclosOrganizadosTest() {
		ArrayList<String> resEsp = new ArrayList<String>();		
		ArrayList<String> resObt = cU.mostrarEspectaculosOrganizados("A1");
		assertEquals(resEsp, resObt);		

	}
	
	public void mostrarRegistrosEspectadorTest() {
		ArrayList<DtRegistro> resEsp = new ArrayList<DtRegistro>();		
		ArrayList<DtRegistro> resObt = cU.mostrarRegistrosEspectador("UE1");
		assertEquals(resEsp, resObt);		

	}
	
	public void listarSeguidosTest() {	
		List<String> resEsp = new ArrayList<String>();		
		resEsp.add("UE1");			
		List<String> resObt = cU.listarSeguidos("A1");			

		assertEquals(resEsp, resObt);			
	}
		
	public void listarSeguidoresTest() {		
		
		List<String> resEsp = new ArrayList<String>();		
		resEsp.add("A1");			
		List<String> resObt = cU.listarSeguidores("UE1");
		assertEquals(resEsp, resObt);		
	}
	
	
	public void listarPaquetesTest() {		
		List<String> resEsp = new ArrayList<String>();					
		List<String> resObt = cU.listarPaquetes("UE1");
		assertEquals(resEsp, resObt);		
	}
	
	
	public void getImagenUsuarioTest() throws Exception {
		String img = cU.getImagenUsuario("UE1");
		assertEquals(null, img);			
	}
		
	@Test
	public void eltest() throws Exception {
		try  {
			altaArtistaTest();
		} catch (Exception e) {
			
		}
		try  {
			altaEspectadorTest();
		} catch (Exception e) {
			
		}
		try  {
			seleccionarUsuarioTest();
		} catch (Exception e) {
			
		}
		try  {
			modificarUsuarioEspectadorTest();
		} catch (Exception e) {
			
		}
		try  {
			modificarUsuarioArtistaTest();
		} catch (Exception e) {
			
		}
		try  {
			iniciarSesionTest();
		} catch (Exception e) {
			
		}
		try  {
			listarUsuariosTest();
		} catch (Exception e) {
			
		}
		try  {
			listarArtistaTest();
		} catch (Exception e) {
			
		}
		try  {
			mostrarEspectactuclosOrganizadosTest();
		} catch (Exception e) {		
		
		}
		try  {
			mostrarRegistrosEspectadorTest();
		} catch (Exception e) {
			
		}
		try  {
			listarSeguidosTest();
		} catch (Exception e) {
			
		}
		try  {
			listarSeguidoresTest();
		} catch (Exception e) {
			
		}
		try  {
			listarPaquetesTest();
		} catch (Exception e) {
			
		}		
		try  {
			getImagenUsuarioTest();
		} catch (Exception e) {	
		}
		
	}
	
	
}
