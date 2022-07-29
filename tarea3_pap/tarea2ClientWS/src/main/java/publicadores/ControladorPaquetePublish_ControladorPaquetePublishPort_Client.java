
package publicadores;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 3.4.4
 * 2021-11-02T02:09:52.612-03:00
 * Generated source version: 3.4.4
 *
 */
public final class ControladorPaquetePublish_ControladorPaquetePublishPort_Client {

    private static final QName SERVICE_NAME = new QName("http://publicadores/", "ControladorPaquetePublishService");

    private ControladorPaquetePublish_ControladorPaquetePublishPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ControladorPaquetePublishService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        ControladorPaquetePublishService ss = new ControladorPaquetePublishService(wsdlURL, SERVICE_NAME);
        ControladorPaquetePublish port = ss.getControladorPaquetePublishPort();

        {
        System.out.println("Invoking chequearDisponibilidadPaquete...");
        java.lang.String _chequearDisponibilidadPaquete_arg0 = "_chequearDisponibilidadPaquete_arg0397020089";
        boolean _chequearDisponibilidadPaquete__return = port.chequearDisponibilidadPaquete(_chequearDisponibilidadPaquete_arg0);
        System.out.println("chequearDisponibilidadPaquete.result=" + _chequearDisponibilidadPaquete__return);


        }
        {
        System.out.println("Invoking agregarEspectaculoAPaquete...");
        java.lang.String _agregarEspectaculoAPaquete_arg0 = "_agregarEspectaculoAPaquete_arg01106595550";
        port.agregarEspectaculoAPaquete(_agregarEspectaculoAPaquete_arg0);


        }
        {
        System.out.println("Invoking listarPaquetesVigentes...");
        net.java.dev.jaxb.array.StringArray _listarPaquetesVigentes__return = port.listarPaquetesVigentes();
        System.out.println("listarPaquetesVigentes.result=" + _listarPaquetesVigentes__return);


        }
        {
        System.out.println("Invoking getImagenPaquete...");
        java.lang.String _getImagenPaquete_arg0 = "_getImagenPaquete_arg0-378412045";
        try {
            java.lang.String _getImagenPaquete__return = port.getImagenPaquete(_getImagenPaquete_arg0);
            System.out.println("getImagenPaquete.result=" + _getImagenPaquete__return);

        } catch (Exception_Exception e) {
            System.out.println("Expected exception: Exception has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking seleccionarEspectaculo...");
        java.lang.String _seleccionarEspectaculo_arg0 = "_seleccionarEspectaculo_arg0221998106";
        try {
            publicadores.DtEspectaculoCompleto _seleccionarEspectaculo__return = port.seleccionarEspectaculo(_seleccionarEspectaculo_arg0);
            System.out.println("seleccionarEspectaculo.result=" + _seleccionarEspectaculo__return);

        } catch (Exception_Exception e) {
            System.out.println("Expected exception: Exception has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking seleccionarPlataforma...");
        java.lang.String _seleccionarPlataforma_arg0 = "_seleccionarPlataforma_arg0-2098597373";
        java.lang.String _seleccionarPlataforma_arg1 = "_seleccionarPlataforma_arg1-666553984";
        try {
            net.java.dev.jaxb.array.StringArray _seleccionarPlataforma__return = port.seleccionarPlataforma(_seleccionarPlataforma_arg0, _seleccionarPlataforma_arg1);
            System.out.println("seleccionarPlataforma.result=" + _seleccionarPlataforma__return);

        } catch (PlataformaNoValidaException_Exception e) {
            System.out.println("Expected exception: PlataformaNoValidaException has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking seleccionarPaquete...");
        java.lang.String _seleccionarPaquete_arg0 = "_seleccionarPaquete_arg0545154075";
        publicadores.DtPaquete _seleccionarPaquete__return = port.seleccionarPaquete(_seleccionarPaquete_arg0);
        System.out.println("seleccionarPaquete.result=" + _seleccionarPaquete__return);


        }
        {
        System.out.println("Invoking comprarPaquete...");
        java.lang.String _comprarPaquete_arg0 = "_comprarPaquete_arg0-668182270";
        java.lang.String _comprarPaquete_arg1 = "_comprarPaquete_arg1945034014";
        try {
            port.comprarPaquete(_comprarPaquete_arg0, _comprarPaquete_arg1);

        } catch (Exception_Exception e) {
            System.out.println("Expected exception: Exception has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking listarPaquetes...");
        net.java.dev.jaxb.array.StringArray _listarPaquetes__return = port.listarPaquetes();
        System.out.println("listarPaquetes.result=" + _listarPaquetes__return);


        }
        {
        System.out.println("Invoking espectaculosDelPaquete...");
        java.lang.String _espectaculosDelPaquete_arg0 = "_espectaculosDelPaquete_arg0938658287";
        net.java.dev.jaxb.array.StringArray _espectaculosDelPaquete__return = port.espectaculosDelPaquete(_espectaculosDelPaquete_arg0);
        System.out.println("espectaculosDelPaquete.result=" + _espectaculosDelPaquete__return);


        }
        {
        System.out.println("Invoking altaPaquete...");
        try {
            port.altaPaquete();

        } catch (PaqueteNoValidoException_Exception e) {
            System.out.println("Expected exception: PaqueteNoValidoException has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking ingresarDatosPaquete...");
        publicadores.DtPaquete _ingresarDatosPaquete_arg0 = new publicadores.DtPaquete();
        _ingresarDatosPaquete_arg0.setDescripcion("Descripcion-267238889");
        _ingresarDatosPaquete_arg0.setDescuento(0.87680197f);
        java.util.List<java.lang.String> _ingresarDatosPaquete_arg0Espectaculos = new java.util.ArrayList<java.lang.String>();
        java.lang.String _ingresarDatosPaquete_arg0EspectaculosVal1 = "_ingresarDatosPaquete_arg0EspectaculosVal930665098";
        _ingresarDatosPaquete_arg0Espectaculos.add(_ingresarDatosPaquete_arg0EspectaculosVal1);
        _ingresarDatosPaquete_arg0.getEspectaculos().addAll(_ingresarDatosPaquete_arg0Espectaculos);
        _ingresarDatosPaquete_arg0.setFechaFin(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2021-11-02T02:09:52.677-03:00"));
        _ingresarDatosPaquete_arg0.setFechaInicio(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2021-11-02T02:09:52.678-03:00"));
        _ingresarDatosPaquete_arg0.setFechaRegistro(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2021-11-02T02:09:52.679-03:00"));
        _ingresarDatosPaquete_arg0.setNombre("Nombre41401476");
        byte[] _ingresarDatosPaquete_arg1 = new byte[] {};
        try {
            port.ingresarDatosPaquete(_ingresarDatosPaquete_arg0, _ingresarDatosPaquete_arg1);

        } catch (PaqueteNoValidoException_Exception e) {
            System.out.println("Expected exception: PaqueteNoValidoException has occurred.");
            System.out.println(e.toString());
        }

            }

        System.exit(0);
    }

}