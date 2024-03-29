package interfaces;

import java.util.List;

import datatypes.DtPlataforma;

import excepciones.PlataformaNoValidaException;

public interface IControladorPlataforma {
	public void ingresarDatosPlataforma(DtPlataforma dtp) throws PlataformaNoValidaException;
	public boolean chequearDisponibilidadPlataforma(String nombre) throws PlataformaNoValidaException;
	public void altaPlataforma() throws PlataformaNoValidaException;
	public List<String> listaPlataformas();
}