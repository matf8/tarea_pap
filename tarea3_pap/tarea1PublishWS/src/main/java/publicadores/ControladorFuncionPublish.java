package publicadores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtFuncion;
import datatypes.DtRegistroCompleto;
import datatypes.DtUsuario;
import excepciones.EspectaculoNoValidoException;
import excepciones.FuncionNoValidaException;
import excepciones.PlataformaNoExisteException;
import excepciones.UsuarioNoExisteException;
import interfaces.Fabrica;
import interfaces.IControladorFuncion;
import interfaces.IControladorUsuario;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorFuncionPublish {
	private Fabrica fabrica;
	private IControladorFuncion icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorFuncionPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorFuncion();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorFun", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorFun");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public String[] listarEspectaculosPorArtista(String nickOrganizador) throws Exception {
		ArrayList<String> lU = icon.listarEspectaculosPorArtista(nickOrganizador);
		int i = 0;
		String[] ret = new String[lU.size()];
		for(String d: lU) {
            ret[i] = d;
            i++;            
        }
		return ret;		
	}
	
	@WebMethod
	public String[] listarEspectaculos(String nombrePlat) throws PlataformaNoExisteException {
		ArrayList<String> lE = icon.listarEspectaculos(nombrePlat);
		int i = 0;
		String[] ret = new String[lE.size()];
		for(String d: lE) {
            ret[i] = d;
            i++;            
        }
		return ret;			 
	}
	
	@WebMethod
	public void seleccionarEspectaculo(String nombre) throws EspectaculoNoValidoException {
		icon.seleccionarEspectaculo(nombre);
	}
	
	@WebMethod
	public void ingresarFuncion(DtFuncion dtf, byte[] i) throws FuncionNoValidaException {
		icon.ingresarFuncion(dtf, i);
	}
	
	@WebMethod
	public void ingresarArtista(String nombreArt) throws UsuarioNoExisteException, Exception {
		icon.ingresarArtista(nombreArt);
	}
	
	@WebMethod
	public boolean chequearDisponibilidadNombreFuncion(String nombreF) throws FuncionNoValidaException {		
		return icon.chequearDisponibilidadNombreFuncion(nombreF);
	}
	
	@WebMethod
	public void altaFuncion() {		
		icon.altaFuncion();
	}
	
	@WebMethod
	public String[] listarFunciones() {	
		ArrayList<String> lF = icon.listarFunciones();
		int i = 0;
		String[] ret = new String[lF.size()];
		for(String d: lF) {
            ret[i] = d;
            i++;            
        }
		return ret;			 
	}
	
	@WebMethod
	public String[] listarFuncionesVigentes() {		
		ArrayList<String> lF = icon.listarFuncionesVigentes();
		int i = 0;
		String[] ret = new String[lF.size()];
		for(String d: lF) {
            ret[i] = d;
            i++;            
        }
		return ret;
	}
	
	@WebMethod
	public DtFuncion seleccionarFuncion(String nombre) throws FuncionNoValidaException {
		return icon.seleccionarFuncion(nombre);
	}
	
	@WebMethod
	public String[] listarEspectadores() {
		ArrayList<String> lE = icon.listarEspectadores();
		int i = 0;
		String[] ret = new String[lE.size()];
		for(String d: lE) {
            ret[i] = d;
            i++;            
        }
		return ret; 
	}	
	
	@WebMethod
	public DtFuncion[] listarFuncionesEspectador(String nick) {
		ArrayList<DtFuncion> lE = icon.listarFuncionesEspectador(nick);
		DtFuncion[] ret = new DtFuncion[lE.size()];
		int i = 0;	
		for(DtFuncion d: lE) {
            ret[i] = d;
            i++;            
        }
		return ret;
	}
	
	@WebMethod
	public DtRegistroCompleto[] listarRegistros(String nick) throws Exception {	
		ArrayList<DtRegistroCompleto> lR = icon.listarRegistros(nick);
		DtRegistroCompleto[] ret = new DtRegistroCompleto[lR.size()];
		int i = 0;	
		for(DtRegistroCompleto d: lR) {
            ret[i] = d;
            i++;            
        }
		return ret;
	}
	
	@WebMethod
	public void altaRegistro(Integer[] s) throws Exception {		
		if(s != null) {
			List<Integer> rS = new ArrayList<Integer>(s.length);
			for (int i: s) 
				rS.add(i);
			icon.altaRegistro(rS);
		}
	}
	
	@WebMethod
	public String[] listarPaquetes(String nick) {
		List<String> lE = icon.listarPaquetes(nick);
		int i = 0;
		String[] ret = new String[lE.size()];
		for(String d: lE) {
            ret[i] = d;
            i++;            
        }
		return ret;
	}
	
	public void altaRegistroPaquete(String nick, String nombreF, String espectaculo, String paquete) throws Exception {
		icon.altaRegistroPaquete(nick, nombreF, espectaculo, paquete);
	}

}