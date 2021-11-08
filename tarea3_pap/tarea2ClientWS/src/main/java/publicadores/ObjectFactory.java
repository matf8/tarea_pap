
package publicadores;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the publicadores package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CorreoExisteException_QNAME = new QName("http://publicadores/", "CorreoExisteException");
	private final static QName _EspectaculoNoValidoException_QNAME = new QName("http://publicadores/", "EspectaculoNoValidoException");
	private final static QName _Exception_QNAME = new QName("http://publicadores/", "Exception");
    private final static QName _UsuarioExisteException_QNAME = new QName("http://publicadores/", "UsuarioExisteException");
	private final static QName _FuncionNoValidaException_QNAME = new QName("http://publicadores/", "FuncionNoValidaException");
	private final static QName _PaqueteNoValidoException_QNAME = new QName("http://publicadores/", "PaqueteNoValidoException");
    private final static QName _PlataformaNoExisteException_QNAME = new QName("http://publicadores/", "PlataformaNoExisteException");
	private final static QName _UsuarioNoExisteException_QNAME = new QName("http://publicadores/", "UsuarioNoExisteException");
	private final static QName _PlataformaNoValidaException_QNAME = new QName("http://publicadores/", "PlataformaNoValidaException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: publicadores
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CorreoExisteException }
     * 
     */
    public CorreoExisteException createCorreoExisteException() {
        return new CorreoExisteException();
    }

	/**
     * Create an instance of {@link EspectaculoNoValidoException }
     * 
     */
    public EspectaculoNoValidoException createEspectaculoNoValidoException() {
        return new EspectaculoNoValidoException();
    }

	/**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link UsuarioExisteException }
     * 
     */
    public UsuarioExisteException createUsuarioExisteException() {
        return new UsuarioExisteException();
    }

	/**
     * Create an instance of {@link DtUsuario }
     * 
     */
    public DtUsuario createDtUsuario() {
        return new DtUsuario();
    }

	/**
     * Create an instance of {@link FuncionNoValidaException }
     * 
     */
    public FuncionNoValidaException createFuncionNoValidaException() {
        return new FuncionNoValidaException();
    }

	/**
     * Create an instance of {@link PaqueteNoValidoException }
     * 
     */
    public PaqueteNoValidoException createPaqueteNoValidoException() {
        return new PaqueteNoValidoException();
    }

    /**
     * Create an instance of {@link PlataformaNoExisteException }
     * 
     */
    public PlataformaNoExisteException createPlataformaNoExisteException() {
        return new PlataformaNoExisteException();
    }

	/**
     * Create an instance of {@link UsuarioNoExisteException }
     * 
     */
    public UsuarioNoExisteException createUsuarioNoExisteException() {
        return new UsuarioNoExisteException();
    }

	/**
     * Create an instance of {@link PlataformaNoValidaException }
     * 
     */
    public PlataformaNoValidaException createPlataformaNoValidaException() {
        return new PlataformaNoValidaException();
    }

    /**
     * Create an instance of {@link DtPlataforma }
     * 
     */
    public DtPlataforma createDtPlataforma() {
        return new DtPlataforma();
    }

	/**
     * Create an instance of {@link DtPaquete }
     * 
     */
    public DtPaquete createDtPaquete() {
        return new DtPaquete();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EspectaculoNoValidoException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EspectaculoNoValidoException }{@code >}
     */
//    @XmlElementDecl(namespace = "http://publicadores/", name = "EspectaculoNoValidoException")
    public JAXBElement<EspectaculoNoValidoException> createEspectaculoNoValidoException(EspectaculoNoValidoException value) {
        return new JAXBElement<EspectaculoNoValidoException>(_EspectaculoNoValidoException_QNAME, EspectaculoNoValidoException.class, null, value);
    }

	/**
     * Create an instance of {@link DtEspectaculoCompleto }
     * 
     */
    public DtEspectaculoCompleto createDtEspectaculoCompleto() {
        return new DtEspectaculoCompleto();
    }

    /**
     * Create an instance of {@link DtEspectaculo }
     * 
     */
    public DtEspectaculo createDtEspectaculo() {
        return new DtEspectaculo();
    }

    /**
     * Create an instance of {@link DtFuncion }
     * 
     */
    public DtFuncion createDtFuncion() {
        return new DtFuncion();
    }

	/**
     * Create an instance of {@link DtRegistroCompleto }
     * 
     */
    public DtRegistroCompleto createDtRegistroCompleto() {
        return new DtRegistroCompleto();
    }

	/**
     * Create an instance of {@link DtRegistro }
     * 
     */
    public DtRegistro createDtRegistro() {
        return new DtRegistro();
    }

	/**
     * Create an instance of {@link DtEspectador }
     * 
     */
    public DtEspectador createDtEspectador() {
        return new DtEspectador();
    }

	/**
     * Create an instance of {@link DtArtista }
     * 
     */
    public DtArtista createDtArtista() {
        return new DtArtista();
    }

	/**
     * Create an instance of {@link DtRegistroArray }
     * 
     */
    public DtRegistroArray createDtRegistroArray() {
        return new DtRegistroArray();
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link CorreoExisteException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CorreoExisteException }{@code >}
     */
    @XmlElementDecl(namespace = "http://publicadores/", name = "CorreoExisteException")
    public JAXBElement<CorreoExisteException> createCorreoExisteException(CorreoExisteException value) {
        return new JAXBElement<CorreoExisteException>(_CorreoExisteException_QNAME, CorreoExisteException.class, null, value);
    }

	/**
     * Create an instance of {@link DtFuncionArray }
     * 
     */
    public DtFuncionArray createDtFuncionArray() {
        return new DtFuncionArray();
    }

	/**
     * Create an instance of {@link DtRegistroCompletoArray }
     * 
     */
    public DtRegistroCompletoArray createDtRegistroCompletoArray() {
        return new DtRegistroCompletoArray();
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}
     */
//    @XmlElementDecl(namespace = "http://publicadores/", name = "Exception")
    @XmlElementDecl(namespace = "http://publicadores/", name = "Exception")
	public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsuarioExisteException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UsuarioExisteException }{@code >}
     */
    @XmlElementDecl(namespace = "http://publicadores/", name = "UsuarioExisteException")
    public JAXBElement<UsuarioExisteException> createUsuarioExisteException(UsuarioExisteException value) {
        return new JAXBElement<UsuarioExisteException>(_UsuarioExisteException_QNAME, UsuarioExisteException.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link FuncionNoValidaException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FuncionNoValidaException }{@code >}
     */
//    @XmlElementDecl(namespace = "http://publicadores/", name = "FuncionNoValidaException")
    public JAXBElement<FuncionNoValidaException> createFuncionNoValidaException(FuncionNoValidaException value) {
        return new JAXBElement<FuncionNoValidaException>(_FuncionNoValidaException_QNAME, FuncionNoValidaException.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaqueteNoValidoException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PaqueteNoValidoException }{@code >}
     */
////    @XmlElementDecl(namespace = "http://publicadores/", name = "PaqueteNoValidoException")
//    @XmlElementDecl(namespace = "http://publicadores/", name = "PaqueteNoValidoException")
	public JAXBElement<PaqueteNoValidoException> createPaqueteNoValidoException(PaqueteNoValidoException value) {
        return new JAXBElement<PaqueteNoValidoException>(_PaqueteNoValidoException_QNAME, PaqueteNoValidoException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlataformaNoExisteException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PlataformaNoExisteException }{@code >}
     */
//    @XmlElementDecl(namespace = "http://publicadores/", name = "PlataformaNoExisteException")
    public JAXBElement<PlataformaNoExisteException> createPlataformaNoExisteException(PlataformaNoExisteException value) {
        return new JAXBElement<PlataformaNoExisteException>(_PlataformaNoExisteException_QNAME, PlataformaNoExisteException.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsuarioNoExisteException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UsuarioNoExisteException }{@code >}
     */
//    @XmlElementDecl(namespace = "http://publicadores/", name = "UsuarioNoExisteException")
    public JAXBElement<UsuarioNoExisteException> createUsuarioNoExisteException(UsuarioNoExisteException value) {
        return new JAXBElement<UsuarioNoExisteException>(_UsuarioNoExisteException_QNAME, UsuarioNoExisteException.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlataformaNoValidaException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PlataformaNoValidaException }{@code >}
     */
//    @XmlElementDecl(namespace = "http://publicadores/", name = "PlataformaNoValidaException")
    public JAXBElement<PlataformaNoValidaException> createPlataformaNoValidaException(PlataformaNoValidaException value) {
        return new JAXBElement<PlataformaNoValidaException>(_PlataformaNoValidaException_QNAME, PlataformaNoValidaException.class, null, value);
    }

}
