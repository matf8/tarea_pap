package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import datatypes.DtPlataforma;
import excepciones.PlataformaNoValidaException;
import interfaces.Fabrica;
import interfaces.IControladorPlataforma;

public class ControladorPlataformaTest {
	
	Fabrica f = Fabrica.getInstancia();
	IControladorPlataforma cP = f.getIControladorPlataforma();	
	
	public void altaPlataformaTest() throws PlataformaNoValidaException {			
		
		DtPlataforma dtp = new DtPlataforma("P1", "url", "desc");
		cP.ingresarDatosPlataforma(dtp);
		cP.chequearDisponibilidadPlataforma("P1");
		cP.altaPlataforma();	
		
		try {
			cP.chequearDisponibilidadPlataforma("P1");
		} catch (Exception e) {
			if (!e.getMessage().equals("Nombre inválido, P1 ya existe en el sistema")) {
				throw e;
			}			
		}
		
		try {
			cP.altaPlataforma();	
		} catch (Exception e) {
			if (!e.getMessage().equals("La plataforma P1 ya existe en el sistema")) {
				throw e;
			}			
		}
		
		try {
			DtPlataforma dtpNull = new DtPlataforma(null, "url", "desc");
			cP.ingresarDatosPlataforma(dtpNull);	
		} catch (Exception e) {
			if (!e.getMessage().equals("La plataforma P1 ingresada no es valida")) {
				throw e;
			}	
		}
		
	}
	
	public void listarPlataformaTest() {
		List<String> resObt = cP.listaPlataformas();
		assertTrue(resObt.contains("P1"));
	}

	@Test
	public void eltest() throws Exception {
		try  {
			altaPlataformaTest();
		} catch (Exception e) {}
		try  {
			listarPlataformaTest();
		} catch (Exception e) {}		
	}		
}
