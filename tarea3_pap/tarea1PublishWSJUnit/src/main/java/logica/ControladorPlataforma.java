package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtPlataforma;
import excepciones.PlataformaNoValidaException;
import interfaces.IControladorPlataforma;

public class ControladorPlataforma implements IControladorPlataforma{
	private DtPlataforma dtplat;
	
	public ControladorPlataforma() {
		super();
	}
	
	public void ingresarDatosPlataforma(DtPlataforma dtp) throws PlataformaNoValidaException {
		if(dtp.getNombre() == null)
			throw new PlataformaNoValidaException("La plataforma " + dtp.getNombre() +  " ingresada no es valida");
		dtplat = dtp;
	}

	public boolean chequearDisponibilidadPlataforma(String nombre) throws PlataformaNoValidaException {
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
		Plataforma p = mP.buscarPlataforma(nombre);
		if (p == null) 
			return true;
		else throw new PlataformaNoValidaException("Nombre inválido, " + nombre + " ya existe en el sistema");
	}

	public void altaPlataforma() throws PlataformaNoValidaException {
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
		Plataforma p = mP.buscarPlataforma(dtplat.getNombre());
		if (p != null) {
			throw new PlataformaNoValidaException("La plataforma " + dtplat.getNombre() + " ya existe en el sistema");
		} else {
			Plataforma newP = new Plataforma(dtplat.getNombre(), dtplat.getDescripcion(), dtplat.getUrl());
			mP.agregarPlataforma(newP);
		}
	}
	
	public List<String> listaPlataformas(){
		List<String> ret = new ArrayList<>();
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
		List<Plataforma> tmp = mP.listarPlataformas();
		for (Plataforma p: tmp)
			ret.add(p.getNombre());		
		return ret;		
	}
}
