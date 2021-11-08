package publicadores;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtEspectaculoCompleto;
import datatypes.DtPaquete;
import excepciones.PaqueteNoValidoException;
import excepciones.PlataformaNoValidaException;
import interfaces.Fabrica;
import interfaces.IControladorPaquete;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPaquetePublish {
	private Fabrica fabrica;
	private IControladorPaquete icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorPaquetePublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorPaquete();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorPaq", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorPaq");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public void agregarEspectaculoAPaquete(String nombreEs) {
		icon.agregarEspectaculoAPaquete(nombreEs);
	}
	
	@WebMethod
	public String[] seleccionarPlataforma(String nombrePlat, String nombrePaq) throws PlataformaNoValidaException{
		ArrayList<String> lU = icon.seleccionarPlataforma(nombrePlat, nombrePaq);
		int i = 0;
		String[] ret = new String[lU.size()];
		for(String d: lU) {
            ret[i] = d;
            i++;            
        }
		return ret;		
	}
	
	@WebMethod
	public DtEspectaculoCompleto seleccionarEspectaculo(String nombreEsp) throws Exception {
		return icon.seleccionarEspectaculo(nombreEsp);
	}
	
	@WebMethod
	public String[] listarPaquetes(){
		ArrayList<String> lP = icon.listarPaquetes();
		int i = 0;
		String[] ret = new String[lP.size()];
		for(String d: lP) {
            ret[i] = d;
            i++;            
        }
		return ret;	
	}
	
	@WebMethod
	public String[] listarPaquetesVigentes(){		
		ArrayList<String> lP = icon.listarPaquetesVigentes();
		int i = 0;
		String[] ret = new String[lP.size()];
		for(String d: lP) {
            ret[i] = d;
            i++;            
        }
		return ret;	
	}
	
	@WebMethod
	public DtPaquete seleccionarPaquete(String nombre) {
		return icon.seleccionarPaquete(nombre);
	}
	
	@WebMethod
	public void ingresarDatosPaquete(DtPaquete dtp, byte[] imagen) throws PaqueteNoValidoException {
		icon.ingresarDatosPaquete(dtp, imagen);
	}
	
	@WebMethod
	public boolean chequearDisponibilidadPaquete(String nombre) {
		return icon.chequearDisponibilidadPaquete(nombre);		
	}
	
	@WebMethod
	public void altaPaquete() throws PaqueteNoValidoException {
		icon.altaPaquete();
	}
	
	@WebMethod
	public String[] espectaculosDelPaquete(String nombre){
		List<String> lP = icon.espectaculosDelPaquete(nombre);
		int i = 0;
		String[] ret = new String[lP.size()];
		for(String d: lP) {
            ret[i] = d;
            i++;            
        }
		return ret;	
	}
	
	@WebMethod
	public void comprarPaquete(String nomPaquete, String nickEs) throws Exception {
		icon.comprarPaquete(nomPaquete, nickEs);
	}
	
	public String getImagenPaquete(String nombre) throws Exception {
		return icon.getImagenPaquete(nombre);
	}

}
