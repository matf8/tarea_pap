
package publicadores;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.4.4
 * 2021-11-02T02:10:41.860-03:00
 * Generated source version: 3.4.4
 */

@WebFault(name = "FuncionNoValidaException", targetNamespace = "http://publicadores/")
public class FuncionNoValidaException_Exception extends java.lang.Exception {

    private publicadores.FuncionNoValidaException faultInfo;

    public FuncionNoValidaException_Exception() {
        super();
    }

    public FuncionNoValidaException_Exception(String message) {
        super(message);
    }

    public FuncionNoValidaException_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public FuncionNoValidaException_Exception(String message, publicadores.FuncionNoValidaException funcionNoValidaException) {
        super(message);
        this.faultInfo = funcionNoValidaException;
    }

    public FuncionNoValidaException_Exception(String message, publicadores.FuncionNoValidaException funcionNoValidaException, java.lang.Throwable cause) {
        super(message, cause);
        this.faultInfo = funcionNoValidaException;
    }

    public publicadores.FuncionNoValidaException getFaultInfo() {
        return this.faultInfo;
    }
}
