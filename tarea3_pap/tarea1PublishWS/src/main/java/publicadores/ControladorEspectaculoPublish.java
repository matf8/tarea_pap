package publicadores;

import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtEspectaculo;
import datatypes.DtEspectaculoCompleto;
import datatypes.DtFuncion;
import datatypes.DtPaquete;
import excepciones.EspectaculoNoValidoException;
import excepciones.PaqueteNoValidoException;
import excepciones.PlataformaNoExisteException;
import excepciones.UsuarioNoExisteException;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorEspectaculoPublish {
	private Fabrica fabrica;
	private IControladorEspectaculo icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorEspectaculoPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorEspectaculo();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorEsp", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorEsp");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public void ingresarEspectaculo(String nombrePlat, String artistaOrganizador, DtEspectaculo dte, byte[] imagen) throws PlataformaNoExisteException, UsuarioNoExisteException {		
		icon.ingresarEspectaculo(nombrePlat, artistaOrganizador, dte, imagen);
	}
	
	@WebMethod
	public boolean chequearDisponibilidadNombre(String nombre) throws EspectaculoNoValidoException {	
		return icon.chequearDisponibilidadNombre(nombre);
	}
	
	@WebMethod
	public void altaEspectaculo() {		
		icon.altaEspectaculo();
	}

	@WebMethod
	public String[] listarEspectaculos(String plat) throws PlataformaNoExisteException {
		try {
			ArrayList<String> lE = icon.listarEspectaculos(plat);
			int i = 0;
			String[] ret = new String[lE.size()];
	        for(String d: lE) {
	            ret[i]=d;
	            i++;            
	        }	   
	        return ret;
		} catch(Exception e) { 
			throw e;
		}		
	}
	
	@WebMethod
	public DtEspectaculoCompleto seleccionarEspectaculo(String nombreEsp) throws Exception {
		return icon.seleccionarEspectaculo(nombreEsp);
	}	
		
	@WebMethod
	public DtFuncion seleccionarFuncion(String nomFuncion) throws Exception {
		DtFuncion aux = null;
		aux = icon.seleccionarFuncion(nomFuncion);
		aux.setFechaString(aux.getFecha().toString());
		aux.setHoraIniString(aux.getHoraIni().toString());
		aux.setFechaRegString(aux.getFechaReg().toString());
		return aux;
	}
	
	@WebMethod
	public DtPaquete seleccionarPaquete(String nombre) throws PaqueteNoValidoException {
		return icon.seleccionarPaquete(nombre);
	}	
	
	@WebMethod
	public String getImagenFuncion(String nomFuncion) throws Exception {
		String aux = icon.getImagenFuncion(nomFuncion);
		if(aux == null)
			throw new Exception("La imagen no existe");
		return aux;
	}

	@WebMethod
	public DtEspectaculoCompleto getDT(String nomEspectaculo) throws Exception {
		DtEspectaculoCompleto aux = null;
		aux = icon.seleccionarEspectaculo(nomEspectaculo);
		aux.setFechaRegString(aux.getFechaReg().toString());
		return aux;
	}
}