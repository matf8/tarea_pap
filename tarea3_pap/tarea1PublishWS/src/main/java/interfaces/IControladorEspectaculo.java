package interfaces;

import java.util.ArrayList;
import datatypes.DtEspectaculo;
import datatypes.DtEspectaculoCompleto;
import datatypes.DtFuncion;
import datatypes.DtPaquete;

import excepciones.PlataformaNoExisteException;
import excepciones.UsuarioNoExisteException;
import excepciones.EspectaculoNoValidoException;
import excepciones.FuncionNoValidaException;
import excepciones.PaqueteNoValidoException;

public interface IControladorEspectaculo {
	public void ingresarEspectaculo(String nombrePlat, String ArtistaOrganizador, DtEspectaculo dte, byte[] imagen) throws PlataformaNoExisteException, UsuarioNoExisteException;
	public boolean chequearDisponibilidadNombre(String nick) throws EspectaculoNoValidoException;
	public void altaEspectaculo();	
	public DtPaquete seleccionarPaquete(String nombre) throws PaqueteNoValidoException;
	public DtFuncion seleccionarFuncion(String nombre) throws FuncionNoValidaException;
	public DtEspectaculoCompleto seleccionarEspectaculo(String nombreEsp) throws Exception;
	public ArrayList<String> listarEspectaculos(String nombrePlat) throws PlataformaNoExisteException;
	public String getImagenFuncion(String nombreF) throws Exception;

}

