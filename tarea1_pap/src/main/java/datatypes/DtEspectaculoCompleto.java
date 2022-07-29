package datatypes;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class DtEspectaculoCompleto extends DtEspectaculo{	
	private List<String> funcionesAsociadas = new ArrayList<>();
	private List<String> paquetesAsociados = new ArrayList<>();
	private String imagen;
	
	public DtEspectaculoCompleto(String nombre, String descripcion, String url, int duracion, int cMax, int cMin,
			float costo, LocalDate f, String artOrg, String plat, List<String> funcionesAsociadas, List<String> paquetesAsociados, String img64) {
		super(nombre, descripcion, url, duracion, cMax, cMin, costo, f, artOrg, plat);
		this.funcionesAsociadas = funcionesAsociadas;
		this.paquetesAsociados = paquetesAsociados;
		this.imagen = img64;
	}

	public List<String> getFuncionesAsociadas() {
		return funcionesAsociadas;
	}

	public List<String> getPaquetesAsociados() {
		return paquetesAsociados;
	}
		
	public String getImagen() {
		return imagen;
	}

	public void setImgagen(String img64) {
		this.imagen = img64;
	}

	public String toString() {
		return super.toString() + "\n	Funciones: " + this.funcionesAsociadas.toString()+"\n	Paquetes: "+ this.paquetesAsociados.toString();	
	}	

}
