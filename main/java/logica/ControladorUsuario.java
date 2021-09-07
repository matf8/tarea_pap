package logica;

import datatypes.DtUsuario;

import java.util.ArrayList;

import datatypes.DtArtista;
import datatypes.DtEspectador;

import interfaces.IControladorUsuario;
import excepciones.UsuarioExisteException;
import excepciones.CorreoExisteException;

public class ControladorUsuario implements IControladorUsuario {
	private DtUsuario Dtuser;
	
	public ControladorUsuario() {
		super();
	}

	@Override	
   public void ingresarDatosEspectador(DtEspectador dte) {
		Dtuser = dte;		
	}

	@Override
	public void ingresarDatosArtista(DtArtista dta) {
		Dtuser = dta;
	}
	
	@Override
	public boolean chequearDisponibilidadNickname(String nick) throws UsuarioExisteException {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.buscarUsuario(nick);
		if (u == null)
			return true;
		else throw new UsuarioExisteException("Nick no es válido, ya existe.");			
	}

	@Override
	public boolean chequearDisponibilidadCorreo(String correo) throws CorreoExisteException {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.buscarCorreo(correo);
		if (u == null) 
			return true;
		else throw new CorreoExisteException("Correo no es válido, ya existe.");			
	}
		
	@Override
	public void altaUsuario() {
		Usuario newU = null;
		if (Dtuser instanceof DtArtista)
			newU = new Artista(Dtuser.getNickName(),Dtuser.getNombre(),Dtuser.getApellido(),Dtuser.getFnac(), Dtuser.getMail(),((DtArtista) Dtuser).getDescripcion(),((DtArtista) Dtuser).getURL(),((DtArtista) Dtuser).getBiografia()); 
		if (Dtuser instanceof DtEspectador)
			newU = new Espectador(Dtuser.getNickName(),Dtuser.getNombre(),Dtuser.getApellido(),Dtuser.getFnac(), Dtuser.getMail());		
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		mU.agregarUsuario(newU);
	}		
	
	@Override	
	public ArrayList<String> listarUsuarios() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<String> ret = mU.listarUsuarios();
		return ret;
	}
	
	public DtUsuario seleccionarUsuario(String nick) {		
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.buscarUsuario(nick);
		DtUsuario dtu = u.getDt();
		return dtu;
	}

	public ArrayList<String> mostrarEspectaculosOrganizados(DtArtista dta){
		ArrayList<String> ret = new ArrayList<String>();
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		ret = mE.listarEspectaculosOrganizados(dta.getNickName());		
		return ret;
	}	
		
	public void modificarUsuario(DtUsuario dtu) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();	
		Usuario u = null;
		if (dtu instanceof DtArtista)
			u = new Artista(dtu.getNickName(),dtu.getNombre(),dtu.getApellido(),dtu.getFnac(), dtu.getMail(),((DtArtista) dtu).getDescripcion(),((DtArtista) dtu).getURL(),((DtArtista) dtu).getBiografia()); 
		if (dtu instanceof DtEspectador)
			u = new Espectador(dtu.getNickName(),dtu.getNombre(),dtu.getApellido(),dtu.getFnac(), dtu.getMail());		
				
		mU.modificarUsuario(u);	
	}
	
	
}