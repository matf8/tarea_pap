package logica;

import datatypes.DtUsuario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtRegistro;
import interfaces.IControladorUsuario;
import persistencia.Conexion;
import excepciones.UsuarioExisteException;
import excepciones.CorreoExisteException;

public class ControladorUsuario implements IControladorUsuario {
	private DtUsuario Dtuser;
	private byte[] img;
	private static Usuario logeado;
	
	public ControladorUsuario() {
		super();
	}

   @Override	
   public void ingresarDatosEspectador(DtEspectador dte, byte[] imagen) {
		Dtuser = dte;		
		img = imagen;
	}

	@Override
	public void ingresarDatosArtista(DtArtista dta, byte[] imagen) {
		Dtuser = dta;
		img = imagen;
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
		List<Usuario> s = null;
		if (Dtuser instanceof DtArtista)
			newU = new Artista(Dtuser.getNickName(),Dtuser.getNombre(),Dtuser.getApellido(),Dtuser.getFnac(), Dtuser.getMail(), Dtuser.getPasswd(), s, ((DtArtista) Dtuser).getDescripcion(),((DtArtista) Dtuser).getURL(),((DtArtista) Dtuser).getBiografia(), img); 
		if (Dtuser instanceof DtEspectador)
			newU = new Espectador(Dtuser.getNickName(),Dtuser.getNombre(),Dtuser.getApellido(),Dtuser.getFnac(), Dtuser.getMail(), Dtuser.getPasswd(), s, img);		
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		mU.agregarUsuario(newU);
	}		
	
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

	public ArrayList<String> mostrarEspectaculosOrganizados(String nick){
		ArrayList<String> ret = new ArrayList<String>();
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		ret = mE.listarEspectaculosOrganizados(nick);		
		return ret;
	}	
	
	public ArrayList<DtRegistro> mostrarRegistrosEspectador(String nick){
		ArrayList<DtRegistro> ret = new ArrayList<DtRegistro>();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ret = mU.listarRegistrosEspectador(nick);		
		return ret;
	}	
		
	public void modificarUsuario(DtUsuario dtu, byte[] imagen) {		
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();	
		Usuario u = null;
		List<Usuario> s = null;
		Usuario tmp = mU.buscarUsuario(dtu.getNickName());		
		if (imagen == null)
			imagen = tmp.getImagen();			
		if (dtu instanceof DtArtista)
			u = new Artista(dtu.getNickName(),dtu.getNombre(),dtu.getApellido(),dtu.getFnac(), dtu.getMail(), dtu.getPasswd(), s, ((DtArtista) dtu).getDescripcion(),((DtArtista) dtu).getURL(),((DtArtista) dtu).getBiografia(), imagen); 
		if (dtu instanceof DtEspectador)
			u = new Espectador(dtu.getNickName(),dtu.getNombre(),dtu.getApellido(),dtu.getFnac(), dtu.getMail(), dtu.getPasswd(), s, imagen);
		mU.modificarUsuario(u);	
	}		

	public String iniciarSesion(String nickMail, String p) throws Exception {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		String ret = "";
		Usuario u = mU.buscarUsuario(nickMail);
		if (u == null)
			u = mU.buscarCorreo(nickMail);
		if (u == null)
			throw new Exception ("El usuario no existe");
		else {
			if (u.getPasswd().equals(p)) {
				if (logeado == null) {
					logeado = u;
					if(u instanceof Espectador)
						ret = "espectador";
					else {
						ret = "artista";
					}
				} else if (logeado.getNickName().equals(u.getNickName()))			
					throw new Exception ("usuario ya logeado");
			} else {
				throw new Exception ("contraseña incorrecta");
			}
		}
		return ret;
	} 
	
	public void cerrarSesion() {
		logeado = null;	
	}
	
	public DtUsuario whoami() {
		DtUsuario ret = null;
		if (logeado != null)
			 ret = logeado.getDt();
		return ret;
	}
	
	public void seguirUsuario(String nick) throws Exception {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.buscarUsuario(nick);		
		
		
		if (u != null)
			if (logeado != null)
				if (!logeado.getSeguidos().contains(u))
					logeado.agregarUsuarioSeguido(u);
				else throw new Exception ("El usuario ya lo sigue."); 
			else throw new Exception ("Logeado = null");			
		else throw new Exception ("El usuario no existe");
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();		
		em.getTransaction().begin();
		em.persist(logeado);					
		em.getTransaction().commit();			
		
	}
	
	public void dejarSeguirUsuario(String nick) throws Exception {		
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.buscarUsuario(nick);
		if (u != null)
			if (logeado != null)
				if (logeado.getSeguidos().contains(u))
					logeado.quitarUsuarioSeguido(u);
				else throw new Exception ("El usuario no seguía a " + nick); 
			else throw new Exception ("Logeado = null");
		else throw new Exception ("El usuario no existe");
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();		
		em.getTransaction().begin();
		em.persist(logeado);					
		em.getTransaction().commit();	
	}
	
	public List<String> listarArtista() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		List<String> ret = mU.listarArtista();		
		return ret;
	}
		
	public List<String> listarSeguidos(String nick) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.buscarUsuario(nick);	
		List<Usuario> lS = u.getSeguidos();		
		List<String> ret = new ArrayList<String>();
		if (lS != null) {			
			for (Usuario s: lS)
				ret.add(s.getNickName());
		} else ret = null;
		return ret;
	}
	
	public List<String> listarSeguidores(String nick) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();		
		List<String> ret = mU.listarSeguidores(nick);		
		return ret;
	}
	
	public List<String> listarPaquetes(String nick) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();	
		Espectador e = (Espectador) mU.buscarUsuario(nick);
		List<String> ret = e.listaPaquetesEspectador();
		return ret;
	}
	
	public String getImagenUsuario(String nick) throws Exception{
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();		
		Usuario u = mU.buscarUsuario(nick);
		return u.getImagen64();	
	}
	
}