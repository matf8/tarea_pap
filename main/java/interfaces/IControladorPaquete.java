package interfaces;

import java.util.ArrayList;

import datatypes.DtEspectaculoCompleto;
import datatypes.DtPaquete;
import excepciones.PaqueteNoValidoException;
import excepciones.PlataformaNoValidaException;

public interface IControladorPaquete {
	public void ingresarDatosPaquete(DtPaquete dtp) throws PaqueteNoValidoException;
	public boolean chequearDisponibilidadPaquete(String nombre);
	public void altaPaquete() throws PaqueteNoValidoException;
	public ArrayList<String> listarPaquetes();
	public DtPaquete seleccionarPaquete(String nombre);
	public DtEspectaculoCompleto seleccionarEspectaculo(String nombreEsp);
	public ArrayList<String> seleccionarPlataforma(String nombrePlat, String nombrePaq)throws PlataformaNoValidaException;
	public void agregarEspectaculoAPlataforma(String nombreEs) ;
}