package tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import org.junit.Test;

import datatypes.DtEspectaculo;
import logica.Artista;
import logica.Compra;
import logica.CompraPaquete;
import logica.Espectaculo;
import logica.Espectador;
import logica.Funcion;
import logica.Paquete;
import logica.Plataforma;
import logica.Registro;

public class AssertTest {
	
	@Test
	public void IgualesTest() throws Exception {			
		byte[] k = {1};					
		Artista a1 = new Artista("A","nombre","apellido", LocalDate.now(), "mail", "pass", null, "desc", "url", "bio", k);
		Artista a2 = new Artista();
		
		a2.setNickName(a1.getNickName());
		a2.setNombre(a1.getNombre());
		a2.setApellido(a1.getApellido());
		a2.setFnac(a1.getFnac());
		a2.setMail(a1.getMail());
		a2.setPasswd(a1.getPasswd());
		a2.setImagen(a1.getImagen());		
		a2.setDescripcion(a1.getDescripcion());
		a2.setURL(a1.getURL());
		a2.setBiografia(a1.getBiografia());		
		a2.setSeguidos(a1.getSeguidos());
		a2.toString();		
		a2.hashCode();
		a2.getImagen64();
		assertEquals(a1,a2);
		
		Espectador ue1 = new Espectador("E","nombre","apellido", LocalDate.now(), "mail", "pass", null, k);
		Espectador ue2 = new Espectador();
		
		ue1.setNickName(ue2.getNickName());
		ue1.setNombre(ue2.getNombre());
		ue1.setApellido(ue2.getApellido());
		ue1.setFnac(ue2.getFnac());
		ue1.setMail(ue2.getMail());
		ue1.setPasswd(ue2.getPasswd());
		ue1.setImagen(ue2.getImagen());		
		ue1.setSeguidos(ue2.getSeguidos());
		ue1.setRegistrosDeFunciones(ue2.getRegistrosDeFunciones());
		ue1.setComprasDePaquetes(ue2.getComprasDePaquetes());
		ue1.toString();		
		ue1.hashCode();
		ue1.getImagen64();
		assertEquals(ue2,ue1);				
		
		Plataforma p1 = new Plataforma("P", "desc", "url");
		Plataforma p2 = new Plataforma();
		p2.setNombre(p1.getNombre());
		p2.setDescripcion(p1.getDescripcion());
		p2.setUrl(p1.getUrl());
		assertEquals(p1,p2);
		
		Espectaculo e1 = new Espectaculo("E1", "desc", "url", 2, 1, 0, 10, LocalDate.now(), p1, a1, k);	
		Espectaculo e2 = new Espectaculo();
		e2.setNombre(e1.getNombre());
		e2.setDescripcion(e1.getDescripcion());
		e2.setURL(e1.getURL());
		e2.setDuracion(e1.getDuracion());
		e2.setCantMax(e1.getCantMax());
		e2.setCantMin(e1.getCantMin());
		e2.setCosto(e1.getCosto());
		e2.setFechaReg(e1.getFechaReg());
		e2.setImagen(e1.getImagen());
		e2.setPlataforma(e1.getPlataforma());
		e2.setArtista(e1.getArtista());
		e2.setFunciones(e1.getFunciones());		
		DtEspectaculo dt = e1.getDt();			
		e1.hashCode();
		e1.getImagen64();
		assertEquals(e1,e2);
		
		Funcion f1 = new Funcion("F1", LocalDate.now(), LocalTime.now(), LocalDate.now(), null, k);	
		Funcion f2 = new Funcion();
		f2.setNombre(f1.getNombre());
		f2.setFecha(f1.getFecha());
		f2.setHoraInicio(f1.getHoraInicio());
		f2.setFechaRegistro(f1.getFechaRegistro());
		f2.setArtistasInvitados(f1.getArtistasInvitados());
		f2.setImagen(f1.getImagen());	
		f2.setRegistros(f1.getRegistros());
		f2.hashCode();
		f2.getImagen64();
		assertEquals(f1,f2);

		Paquete paq1 = new Paquete("Paq1", "desc", LocalDate.now(), LocalDate.now(), LocalDate.now(), 20, null, k);
		Paquete paq2 = new Paquete();
		paq2.setNombre(paq1.getNombre());
		paq2.setDescripcion(paq1.getDescripcion());
		paq2.setFechaInicio(paq1.getFechaInicio());
		paq2.setFechaFin(paq1.getFechaFin());
		paq2.setFechaRegistro(paq1.getFechaRegistro());
		paq2.setDescuento(paq1.getDescuento());
		paq2.setImagen(paq1.getImagen());
		paq1.getImagen64();
		paq1.hashCode();
		paq2.setEspectaculos(paq1.getEspectaculos());
		assertEquals(paq1,paq2);
		
		Registro r1 = new Registro(f1, ue1, LocalDate.now(), 20);
		Registro r2 = new Registro();
		r2.setFuncion(r1.getFuncion());
		r2.setE(r1.getE());
		r2.setCosto(r1.getCosto());
		r2.setFechaReg(r1.getFechaReg());
		r2.setRegistrosCanjeados(r1.getRegistrosCanjeados());
		r2.setPaqueteCanjeado(r1.getPaqueteCanjeado());
		r1.getDt();
		r1.hashCode();
		assertEquals(r1,r2);
		
		CompraPaquete cp1 = new CompraPaquete(ue1, paq1, LocalDate.now());
		CompraPaquete cp2 = new CompraPaquete();
		cp2.setE(cp1.getEspectador());
		cp2.setP(cp1.getPaquete());
		cp2.setFechaReg(cp1.getFechaReg());
		cp1.getDt();
		cp1.hashCode();
		assertEquals(cp1,cp2);
		
		Date f = null;
		Compra c1 = new Compra(f);
		Compra c2 = new Compra();
		c2.setFecha(c1.getFecha());
		c2.hashCode();
		assertEquals(c1,c2);		
	}
		
}

