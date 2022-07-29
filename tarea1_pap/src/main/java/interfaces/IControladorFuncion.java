package interfaces;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtFuncion;
import datatypes.DtRegistroCompleto;

import excepciones.PlataformaNoExisteException;
import excepciones.EspectaculoNoValidoException;
import excepciones.UsuarioNoExisteException;
import excepciones.FuncionNoValidaException;

public interface IControladorFuncion {
	public ArrayList<String> listarEspectaculos(String nombrePlat) throws PlataformaNoExisteException;
	public void seleccionarEspectaculo(String nombre) throws EspectaculoNoValidoException;
	public void ingresarFuncion(DtFuncion dtf, byte[] img) throws FuncionNoValidaException;
	public void ingresarArtista(String nombreArt) throws UsuarioNoExisteException, Exception;
	public boolean chequearDisponibilidadNombreFuncion(String nombreF) throws FuncionNoValidaException;
	public void altaFuncion();
	public ArrayList<String> listarFunciones();
	public DtFuncion seleccionarFuncion(String nombre) throws FuncionNoValidaException;
	public ArrayList<String> listarEspectadores();	
	public ArrayList<DtFuncion> listarFuncionesEspectador(String nick);
	public ArrayList<DtRegistroCompleto> listarRegistros(String nick) throws Exception;
	public void altaRegistro(List<Integer> rS) throws Exception;
	public ArrayList<String> listarEspectaculosPorArtista(String nick) throws Exception;
	public ArrayList<String> listarFuncionesVigentes();
	public List<String> listarPaquetes(String nick);
	public void altaRegistroPaquete(String nick, String nombreF, String espectaculo, String paquete) throws Exception;
}