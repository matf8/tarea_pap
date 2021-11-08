package datatypes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtEspectaculoCompleto extends DtEspectaculo{	
	private List<String> funcionesAsociadas = new ArrayList<>();
	private List<String> paquetesAsociados = new ArrayList<>();
	private String imagen;
	
	public DtEspectaculoCompleto() {
		super();
	}
	public DtEspectaculoCompleto(final String nombre, final String descripcion, final String url, final int duracion, final int cMax, final int cMin,
			final float costo, final Date f, final String artOrg, final String plat, List<String> funcionesAsociadas, List<String> paquetesAsociados, String img64) {
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
	
	public void setFuncionesAsociadas(List<String> funcionesAsociadas) {
		this.funcionesAsociadas = funcionesAsociadas;
	}

	public void setPaquetesAsociados(List<String> paquetesAsociados) {
		this.paquetesAsociados = paquetesAsociados;
	}

	public String toString() {
		return super.toString() + "\n	Funciones: " + this.funcionesAsociadas.toString()+"\n	Paquetes: "+ this.paquetesAsociados.toString();	
	}	

}
