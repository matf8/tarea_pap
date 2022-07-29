
package publicadores;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.4.4
 * 2021-11-02T02:10:10.881-03:00
 * Generated source version: 3.4.4
 */

@WebFault(name = "PlataformaNoValidaException", targetNamespace = "http://publicadores/")
public class PlataformaNoValidaException_Exception extends java.lang.Exception {

    private publicadores.PlataformaNoValidaException faultInfo;

    public PlataformaNoValidaException_Exception() {
        super();
    }

    public PlataformaNoValidaException_Exception(String message) {
        super(message);
    }

    public PlataformaNoValidaException_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public PlataformaNoValidaException_Exception(String message, publicadores.PlataformaNoValidaException plataformaNoValidaException) {
        super(message);
        this.faultInfo = plataformaNoValidaException;
    }

    public PlataformaNoValidaException_Exception(String message, publicadores.PlataformaNoValidaException plataformaNoValidaException, java.lang.Throwable cause) {
        super(message, cause);
        this.faultInfo = plataformaNoValidaException;
    }

    public publicadores.PlataformaNoValidaException getFaultInfo() {
        return this.faultInfo;
    }
}