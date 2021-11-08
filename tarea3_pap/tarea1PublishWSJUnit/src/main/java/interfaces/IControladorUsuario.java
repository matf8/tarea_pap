package interfaces;

import datatypes.DtEspectador;
import datatypes.DtUsuario;
import datatypes.DtRegistro;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtArtista;

import excepciones.UsuarioExisteException;
import excepciones.CorreoExisteException;

public interface IControladorUsuario {
	public void ingresarDatosEspectador(DtEspectador dte, byte[] imagen);
	public void ingresarDatosArtista(DtArtista dta, byte[] imagen);	
	public boolean chequearDisponibilidadNickname(String nick) throws UsuarioExisteException;
	public boolean chequearDisponibilidadCorreo(String correo) throws CorreoExisteException;
	public void altaUsuario();
	public ArrayList<String> listarUsuarios();
	public DtUsuario seleccionarUsuario(String nombre);	
	public ArrayList<String> mostrarEspectaculosOrganizados(String nick);
	public ArrayList<DtRegistro> mostrarRegistrosEspectador(String nick);
	public void modificarUsuario(DtUsuario dtu, byte[] imagen);
	public String iniciarSesion(String nick, String password) throws Exception;
	public void cerrarSesion();
	public DtUsuario whoami();
	public void seguirUsuario(String nick) throws Exception;
	public void dejarSeguirUsuario(String nick) throws Exception;
	public List<String> listarArtista();
	public List<String> listarSeguidos(String nick);
	public List<String> listarSeguidores(String nick);
	public List<String> listarPaquetes(String nick);
	public String getImagenUsuario(String nick) throws Exception;

}
