package interfaces;

import logica.ControladorPlataforma;
import logica.ControladorUsuario;
import logica.ControladorEspectaculo;
import logica.ControladorFuncion;
import logica.ControladorPaquete;

public class Fabrica {
	private static Fabrica instancia = null;
	
	private Fabrica(){}
	
	public static Fabrica getInstancia() {
		if (instancia == null)
			instancia = new Fabrica();
		return instancia;
	}
	
	public IControladorUsuario getIControladorUsuario() {
		return new ControladorUsuario();
	}
	
	public IControladorPlataforma getIControladorPlataforma() {
		return new ControladorPlataforma();
	}
	
	public IControladorEspectaculo getIControladorEspectaculo() {
		return new ControladorEspectaculo();
	}
	
	public IControladorFuncion getIControladorFuncion() {
		return new ControladorFuncion();
	}
	
	public IControladorPaquete getIControladorPaquete() {
		return new ControladorPaquete();
	}	
}


