
package publicadores;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for dtRegistro complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dtRegistro"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="costo" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="fechaReg" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="nombreFuncion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtRegistro", propOrder = {
    "costo",
    "fechaReg",
    "nombreFuncion"
})
//@XmlSeeAlso({
//    DtRegistroCompleto.class
//})
public class DtRegistro {

    protected float costo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaReg;
    protected String nombreFuncion;

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
     * Gets the value of the nombreFuncion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreFuncion() {
        return nombreFuncion;
    }

    /**
     * Sets the value of the nombreFuncion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreFuncion(String value) {
        this.nombreFuncion = value;
    }

}
