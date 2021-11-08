
package publicadores;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for dtFuncion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dtFuncion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="artistasInvitados" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fechaReg" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fechaRegString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="horaIni" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="horaIniString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtFuncion", propOrder = {
    "artistasInvitados",
    "fecha",
    "fechaReg",
    "fechaRegString",
    "fechaString",
    "horaIni",
    "horaIniString",
    "nombre"
})
public class DtFuncion {

    @XmlElement(nillable = true)
    protected List<String> artistasInvitados;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaReg;
    protected String fechaRegString;
    protected String fechaString;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar horaIni;
    protected String horaIniString;
    protected String nombre;

    /**
     * Gets the value of the artistasInvitados property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the artistasInvitados property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArtistasInvitados().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getArtistasInvitados() {
        if (artistasInvitados == null) {
            artistasInvitados = new ArrayList<String>();
        }
        return this.artistasInvitados;
    }

    /**
     * Gets the value of the fecha property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Sets the value of the fecha property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
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
     * Gets the value of the fechaString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaString() {
        return fechaString;
    }

    /**
     * Sets the value of the fechaString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaString(String value) {
        this.fechaString = value;
    }

    /**
     * Gets the value of the horaIni property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getHoraIni() {
        return horaIni;
    }

    /**
     * Sets the value of the horaIni property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setHoraIni(XMLGregorianCalendar value) {
        this.horaIni = value;
    }

    /**
     * Gets the value of the horaIniString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoraIniString() {
        return horaIniString;
    }

    /**
     * Sets the value of the horaIniString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoraIniString(String value) {
        this.horaIniString = value;
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

}
