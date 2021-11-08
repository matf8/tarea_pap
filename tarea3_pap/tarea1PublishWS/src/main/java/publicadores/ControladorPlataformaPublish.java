package publicadores;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtPlataforma;
import excepciones.PlataformaNoValidaException;
import interfaces.Fabrica;
import interfaces.IControladorPlataforma;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPlataformaPublish {
	
	private Fabrica fabrica;
	private IControladorPlataforma icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorPlataformaPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorPlataforma();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorPlat", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorPlat");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public void ingresarDatosPlataforma(DtPlataforma dtp) throws PlataformaNoValidaException {
		icon.ingresarDatosPlataforma(dtp);
	}
	
	@WebMethod
	public boolean chequearDisponibilidadPlataforma(String nombre) throws PlataformaNoValidaException {
		return icon.chequearDisponibilidadPlataforma(nombre);
	}
	
	@WebMethod
	public void altaPlataforma() throws PlataformaNoValidaException {
		icon.altaPlataforma();
	}
	
	@WebMethod
	public String[] listaPlataformas() {
		List<String> lP = icon.listaPlataformas();
		int i = 0;
		String[] ret = new String[lP.size()];
		for(String d: lP) {
            ret[i] = d;
            i++;            
        }
		return ret;			
	}	

}
