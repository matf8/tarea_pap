package interfaces;

import datatypes.DtEspectador;
import datatypes.DtUsuario;

import java.util.ArrayList;

import datatypes.DtArtista;

import excepciones.UsuarioExisteException;
import excepciones.CorreoExisteException;

public interface IControladorUsuario {
	public void ingresarDatosEspectador(DtEspectador dte);
	public void ingresarDatosArtista(DtArtista dta);	
	public boolean chequearDisponibilidadNickname(String nick) throws UsuarioExisteException;
	public boolean chequearDisponibilidadCorreo(String correo) throws CorreoExisteException;
	public void altaUsuario();
	public ArrayList<String> listarUsuarios();
	public DtUsuario seleccionarUsuario(String nombre);	
	public ArrayList<String> mostrarEspectaculosOrganizados(DtArtista dta);
	public void modificarUsuario(DtUsuario dtu);
}
