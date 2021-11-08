package interfaces;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtEspectaculoCompleto;
import datatypes.DtPaquete;
import excepciones.PaqueteNoValidoException;
import excepciones.PlataformaNoValidaException;

public interface IControladorPaquete {
	public void ingresarDatosPaquete(DtPaquete dtp, byte[] img) throws PaqueteNoValidoException;
	public boolean chequearDisponibilidadPaquete(String nombre);
	public void altaPaquete() throws PaqueteNoValidoException;
	public ArrayList<String> listarPaquetes();
	public ArrayList<String> listarPaquetesVigentes();
	public DtPaquete seleccionarPaquete(String nombre);
	public DtEspectaculoCompleto seleccionarEspectaculo(String nombreEsp) throws Exception;
	public ArrayList<String> seleccionarPlataforma(String nombrePlat, String nombrePaq) throws PlataformaNoValidaException;
	public void agregarEspectaculoAPaquete(String nombreEs);
	public List<String> espectaculosDelPaquete(String nombre);
	public void comprarPaquete(String nomPaquete, String nickEs) throws Exception;
	public String getImagenPaquete(String nombre) throws Exception;
}