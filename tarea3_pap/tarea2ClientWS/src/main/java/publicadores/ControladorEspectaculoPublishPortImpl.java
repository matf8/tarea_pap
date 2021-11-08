
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package publicadores;

import java.util.logging.Logger;

/**
 * This class was generated by Apache CXF 3.4.4
 * 2021-11-02T02:10:27.068-03:00
 * Generated source version: 3.4.4
 *
 */

@javax.jws.WebService(
                      serviceName = "ControladorEspectaculoPublishService",
                      portName = "ControladorEspectaculoPublishPort",
                      targetNamespace = "http://publicadores/",
                      wsdlLocation = "http://localhost:3030/controladorEsp?wsdl",
                      endpointInterface = "publicadores.ControladorEspectaculoPublish")

public class ControladorEspectaculoPublishPortImpl implements ControladorEspectaculoPublish {

    private static final Logger LOG = Logger.getLogger(ControladorEspectaculoPublishPortImpl.class.getName());

    /* (non-Javadoc)
     * @see publicadores.ControladorEspectaculoPublish#seleccionarFuncion(java.lang.String arg0)*
     */
    public publicadores.DtFuncion seleccionarFuncion(java.lang.String arg0) throws Exception_Exception   {
        LOG.info("Executing operation seleccionarFuncion");
        System.out.println(arg0);
        try {
            publicadores.DtFuncion _return = new publicadores.DtFuncion();
            java.util.List<java.lang.String> _returnArtistasInvitados = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnArtistasInvitadosVal1 = "_returnArtistasInvitadosVal944576408";
            _returnArtistasInvitados.add(_returnArtistasInvitadosVal1);
            _return.getArtistasInvitados().addAll(_returnArtistasInvitados);
            _return.setFecha(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2021-11-02T02:10:27.078-03:00"));
            _return.setFechaReg(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2021-11-02T02:10:27.078-03:00"));
            _return.setFechaRegString("FechaRegString-1664918385");
            _return.setFechaString("FechaString-1655031313");
            _return.setHoraIni(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2021-11-02T02:10:27.079-03:00"));
            _return.setHoraIniString("HoraIniString732764332");
            _return.setNombre("Nombre870102000");
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new Exception_Exception("Exception...");
    }

    /* (non-Javadoc)
     * @see publicadores.ControladorEspectaculoPublish#getDT(java.lang.String arg0)*
     */
    public publicadores.DtEspectaculoCompleto getDT(java.lang.String arg0) throws Exception_Exception   {
        LOG.info("Executing operation getDT");
        System.out.println(arg0);
        try {
            publicadores.DtEspectaculoCompleto _return = new publicadores.DtEspectaculoCompleto();
            _return.setCantMax(1102656219);
            _return.setCantMin(305436640);
            _return.setCosto(0.3562212f);
            _return.setDescripcion("Descripcion-105399010");
            _return.setDuracion(-1986365956);
            _return.setFechaReg(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2021-11-02T02:10:27.082-03:00"));
            _return.setFechaRegString("FechaRegString1606183356");
            _return.setNombre("Nombre130127915");
            _return.setOrganizador("Organizador-1268466094");
            _return.setPlataforma("Plataforma1033484341");
            _return.setURL("URL1072705235");
            java.util.List<java.lang.String> _returnFuncionesAsociadas = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnFuncionesAsociadasVal1 = "_returnFuncionesAsociadasVal-1585708480";
            _returnFuncionesAsociadas.add(_returnFuncionesAsociadasVal1);
            _return.getFuncionesAsociadas().addAll(_returnFuncionesAsociadas);
            java.util.List<java.lang.String> _returnPaquetesAsociados = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnPaquetesAsociadosVal1 = "_returnPaquetesAsociadosVal1600816246";
            _returnPaquetesAsociados.add(_returnPaquetesAsociadosVal1);
            _return.getPaquetesAsociados().addAll(_returnPaquetesAsociados);
            _return.setImagen("Imagen-614926552");
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new Exception_Exception("Exception...");
    }

    /* (non-Javadoc)
     * @see publicadores.ControladorEspectaculoPublish#seleccionarPaquete(java.lang.String arg0)*
     */
    public publicadores.DtPaquete seleccionarPaquete(java.lang.String arg0) throws PaqueteNoValidoException_Exception   {
        LOG.info("Executing operation seleccionarPaquete");
        System.out.println(arg0);
        try {
            publicadores.DtPaquete _return = new publicadores.DtPaquete();
            _return.setDescripcion("Descripcion250779630");
            _return.setDescuento(0.8964147f);
            java.util.List<java.lang.String> _returnEspectaculos = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnEspectaculosVal1 = "_returnEspectaculosVal407828610";
            _returnEspectaculos.add(_returnEspectaculosVal1);
            _return.getEspectaculos().addAll(_returnEspectaculos);
            _return.setFechaFin(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2021-11-02T02:10:27.084-03:00"));
            _return.setFechaInicio(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2021-11-02T02:10:27.085-03:00"));
            _return.setFechaRegistro(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2021-11-02T02:10:27.085-03:00"));
            _return.setNombre("Nombre654576027");
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new PaqueteNoValidoException_Exception("PaqueteNoValidoException...");
    }

    /* (non-Javadoc)
     * @see publicadores.ControladorEspectaculoPublish#ingresarEspectaculo(java.lang.String arg0, java.lang.String arg1, publicadores.DtEspectaculo arg2, byte[] arg3)*
     */
    public void ingresarEspectaculo(java.lang.String arg0, java.lang.String arg1, DtEspectaculo arg2, byte[] arg3) throws PlataformaNoExisteException_Exception,  UsuarioNoExisteException_Exception   {
        LOG.info("Executing operation ingresarEspectaculo");
        System.out.println(arg0);
        System.out.println(arg1);
        System.out.println(arg2);
        System.out.println(arg3);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new PlataformaNoExisteException_Exception("PlataformaNoExisteException...");
        //throw new UsuarioNoExisteException_Exception("UsuarioNoExisteException...");
    }

    /* (non-Javadoc)
     * @see publicadores.ControladorEspectaculoPublish#altaEspectaculo()*
     */
    public void altaEspectaculo() {
        LOG.info("Executing operation altaEspectaculo");
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see publicadores.ControladorEspectaculoPublish#getImagenFuncion(java.lang.String arg0)*
     */
    public java.lang.String getImagenFuncion(java.lang.String arg0) throws Exception_Exception   {
        LOG.info("Executing operation getImagenFuncion");
        System.out.println(arg0);
        try {
            java.lang.String _return = "_return-409379896";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new Exception_Exception("Exception...");
    }

    /* (non-Javadoc)
     * @see publicadores.ControladorEspectaculoPublish#chequearDisponibilidadNombre(java.lang.String arg0)*
     */
    public boolean chequearDisponibilidadNombre(java.lang.String arg0) throws EspectaculoNoValidoException_Exception   {
        LOG.info("Executing operation chequearDisponibilidadNombre");
        System.out.println(arg0);
        try {
            boolean _return = true;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new EspectaculoNoValidoException_Exception("EspectaculoNoValidoException...");
    }

    /* (non-Javadoc)
     * @see publicadores.ControladorEspectaculoPublish#listarEspectaculos(java.lang.String arg0)*
     */
    public net.java.dev.jaxb.array.StringArray listarEspectaculos(java.lang.String arg0) throws PlataformaNoExisteException_Exception   {
        LOG.info("Executing operation listarEspectaculos");
        System.out.println(arg0);
        try {
            net.java.dev.jaxb.array.StringArray _return = new net.java.dev.jaxb.array.StringArray();
            java.util.List<java.lang.String> _returnItem = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnItemVal1 = "_returnItemVal-1527198961";
            _returnItem.add(_returnItemVal1);
            _return.getItem().addAll(_returnItem);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new PlataformaNoExisteException_Exception("PlataformaNoExisteException...");
    }

    /* (non-Javadoc)
     * @see publicadores.ControladorEspectaculoPublish#seleccionarEspectaculo(java.lang.String arg0)*
     */
    public publicadores.DtEspectaculoCompleto seleccionarEspectaculo(java.lang.String arg0) throws Exception_Exception   {
        LOG.info("Executing operation seleccionarEspectaculo");
        System.out.println(arg0);
        try {
            publicadores.DtEspectaculoCompleto _return = new publicadores.DtEspectaculoCompleto();
            _return.setCantMax(-1484937858);
            _return.setCantMin(-105881923);
            _return.setCosto(0.30071813f);
            _return.setDescripcion("Descripcion-397949654");
            _return.setDuracion(2135441964);
            _return.setFechaReg(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2021-11-02T02:10:27.091-03:00"));
            _return.setFechaRegString("FechaRegString-1357176383");
            _return.setNombre("Nombre356275922");
            _return.setOrganizador("Organizador-1767845269");
            _return.setPlataforma("Plataforma-1079747855");
            _return.setURL("URL153726099");
            java.util.List<java.lang.String> _returnFuncionesAsociadas = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnFuncionesAsociadasVal1 = "_returnFuncionesAsociadasVal-1835094336";
            _returnFuncionesAsociadas.add(_returnFuncionesAsociadasVal1);
            _return.getFuncionesAsociadas().addAll(_returnFuncionesAsociadas);
            java.util.List<java.lang.String> _returnPaquetesAsociados = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnPaquetesAsociadosVal1 = "_returnPaquetesAsociadosVal845682757";
            _returnPaquetesAsociados.add(_returnPaquetesAsociadosVal1);
            _return.getPaquetesAsociados().addAll(_returnPaquetesAsociados);
            _return.setImagen("Imagen-219032116");
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new Exception_Exception("Exception...");
    }

}
