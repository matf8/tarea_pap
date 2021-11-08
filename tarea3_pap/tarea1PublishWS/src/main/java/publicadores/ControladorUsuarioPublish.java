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
import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtRegistro;
import datatypes.DtUsuario;
import excepciones.CorreoExisteException;
import excepciones.UsuarioExisteException;
import interfaces.Fabrica;
import interfaces.IControladorUsuario;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorUsuarioPublish {
	private Fabrica fabrica;
	private IControladorUsuario icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorUsuarioPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorUsuario();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorUsuario", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorUsuario");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public void ingresarDatosEspectador(DtEspectador dte, byte[] img) {
		icon.ingresarDatosEspectador(dte, img);
	}
 
	@WebMethod
	public void ingresarDatosArtista(DtArtista dta, byte[] img) {
		icon.ingresarDatosArtista(dta, img);
	}
	
	@WebMethod
	public boolean chequearDisponibilidadNickname(String nick) throws UsuarioExisteException {
		return icon.chequearDisponibilidadNickname(nick);
	}
	
	@WebMethod
	public boolean chequearDisponibilidadCorreo(String mail) throws CorreoExisteException {
		return icon.chequearDisponibilidadCorreo(mail);
	}
	
	@WebMethod
	public void altaUsuario() {
		icon.altaUsuario();
	}
	
	@WebMethod
	public void altaUsuarioWS(DtUsuario dtu, byte[] img) {
		icon.altaUsuarioWS(dtu, img);
	}
	
	@WebMethod
	public String[] listarUsuarios() {
		ArrayList<String> lU = icon.listarUsuarios();
		int i = 0;
		String[] ret = new String[lU.size()];
		for(String d: lU) {
            ret[i] = d;
            i++;            
        }
		return ret;
	}	
	
	@WebMethod
	public DtUsuario seleccionarUsuario(String nick) {
		return icon.seleccionarUsuario(nick);		
	}
	
	@WebMethod
	public String[] mostrarEspectaculosOrganizados(String nick){
		ArrayList<String> lE = icon.mostrarEspectaculosOrganizados(nick);
		int i = 0;
		String[] ret = new String[lE.size()];
		for(String d: lE) {
            ret[i] = d;
            i++;            
        }
		return ret;
	}	
	
	@WebMethod
	public DtRegistro[] mostrarRegistrosEspectadors(String nick){
		ArrayList<DtRegistro> lR = icon.mostrarRegistrosEspectador(nick);
		int i = 0;
		DtRegistro[] ret = new DtRegistro[lR.size()];
		for(DtRegistro d: lR) {
            ret[i] = d;
            i++;            
        }
		return ret;
	}
	
	@WebMethod
	public void modificarUsuario(DtUsuario dtu, byte[] imagen) {		
		icon.modificarUsuario(dtu, imagen);		
	}	
	
	@WebMethod
	public String iniciarSesion(String user, String pass) throws Exception {
		String ret = null;
		ret = icon.iniciarSesion(user, pass);
		return ret;
	}
	
	@WebMethod
	public void cerrarSesion() {
		icon.cerrarSesion();
	}
	
	@WebMethod
	public DtUsuario whoami() {
		return icon.whoami();		
	}	
	
	@WebMethod
	public void seguirUsuario(String nick) throws Exception {
		icon.seguirUsuario(nick);
	}
	
	@WebMethod
	public void dejarSeguirUsuario(String nick) throws Exception {	
		icon.dejarSeguirUsuario(nick);
	}
	
	@WebMethod
	public String[] listarArtista() {
		List<String> lA = icon.listarArtista();
		int i = 0;
		String[] ret = new String[lA.size()];
		for(String d: lA) {
            ret[i] = d;
            i++;            
        }
		return ret;
	}
	
	@WebMethod
	public String[] listarSeguidos(String nick) {
		List<String> lS = icon.listarSeguidos(nick);
		int i = 0;
		String[] ret = new String[lS.size()];
		for(String d: lS) {
            ret[i] = d;
            i++;            
        }
		return ret;
	}
	
	@WebMethod
	public String[] listarSeguidores(String nick) {
		List<String> lS = icon.listarSeguidores(nick);
		int i = 0;
		String[] ret = new String[lS.size()];
		for(String d: lS) {
            ret[i] = d;
            i++;            
        }
		return ret;
	}
	
	@WebMethod
	public String[] listarPaquetes(String nick) {
		List<String> lS = icon.listarPaquetes(nick);
		int i = 0;
		String[] ret = new String[lS.size()];
		for(String d: lS) {
            ret[i] = d;
            i++;            
        }
		return ret;
	}
	
	@WebMethod
	public String getImagenUsuario(String nick) {
		try {
			return icon.getImagenUsuario(nick);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}	
}