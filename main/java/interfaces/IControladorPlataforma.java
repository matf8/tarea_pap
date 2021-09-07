package interfaces;

import datatypes.DtPlataforma;

import excepciones.PlataformaNoValidaException;

public interface IControladorPlataforma {
	public void ingresarDatosPlataforma(DtPlataforma dtp) throws PlataformaNoValidaException;
	public boolean chequearDisponibilidadPlataforma(String nombre) throws PlataformaNoValidaException;
	public void altaPlataforma() throws PlataformaNoValidaException;
}