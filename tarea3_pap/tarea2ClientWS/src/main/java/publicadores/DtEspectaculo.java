
package publicadores;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for dtEspectaculo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dtEspectaculo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cantMax" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cantMin" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="costo" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="duracion" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="fechaReg" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fechaRegString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="organizador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="plataforma" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="URL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtEspectaculo", propOrder = {
    "cantMax",
    "cantMin",
    "costo",
    "descripcion",
    "duracion",
    "fechaReg",
    "fechaRegString",
    "nombre",
    "organizador",
    "plataforma",
    "url"
})
@XmlSeeAlso({
    DtEspectaculoCompleto.class
})
public class DtEspectaculo {

    protected int cantMax;
    protected int cantMin;
    protected float costo;
    protected String descripcion;
    protected int duracion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaReg;
    protected String fechaRegString;
    protected String nombre;
    protected String organizador;
    protected String plataforma;
    @XmlElement(name = "URL")
    protected String url;

    /**
     * Gets the value of the cantMax property.
     * 
     */
    public int getCantMax() {
        return cantMax;
    }

    /**
     * Sets the value of the cantMax property.
     * 
     */
    public void setCantMax(int value) {
        this.cantMax = value;
    }

    /**
     * Gets the value of the cantMin property.
     * 
     */
    public int getCantMin() {
        return cantMin;
    }

    /**
     * Sets the value of the cantMin property.
     * 
     */
    public void setCantMin(int value) {
        this.cantMin = value;
    }

    /**
     * Gets the value of the costo property.
     * 
     */
    public float getCosto() {
        return costo;
    }

    /**
     * Sets the value of the costo property.
     * 
     */
    public void setCosto(float value) {
        this.costo = value;
    }

    /**
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the duracion property.
     * 
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Sets the value of the duracion property.
     * 
     */
    public void setDuracion(int value) {
        this.duracion = value;
    }

    /**
     * Gets the value of the fechaReg property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaReg() {
        return fechaReg;
    }

    /**
     * Sets the value of the fechaReg property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaReg(XMLGregorianCalendar value) {
        this.fechaReg = value;
    }

    /**
     * Gets the value of the fechaRegString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaRegString() {
        return fechaRegString;
    }

    /**
     * Sets the value of the fechaRegString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaRegString(String value) {
        this.fechaRegString = value;
    }

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the organizador property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizador() {
        return organizador;
    }

    /**
     * Sets the value of the organizador property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizador(String value) {
        this.organizador = value;
    }

    /**
     * Gets the value of the plataforma property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlataforma() {
        return plataforma;
    }

    /**
     * Sets the value of the plataforma property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlataforma(String value) {
        this.plataforma = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURL() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURL(String value) {
        this.url = value;
    }

}
