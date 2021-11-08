
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
 * 2021-11-02T02:10:10.819-03:00
 * Generated source version: 3.4.4
 *
 */
public final class ControladorPlataformaPublish_ControladorPlataformaPublishPort_Client {

    private static final QName SERVICE_NAME = new QName("http://publicadores/", "ControladorPlataformaPublishService");

    private ControladorPlataformaPublish_ControladorPlataformaPublishPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ControladorPlataformaPublishService.WSDL_LOCATION;
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

        ControladorPlataformaPublishService ss = new ControladorPlataformaPublishService(wsdlURL, SERVICE_NAME);
        ControladorPlataformaPublish port = ss.getControladorPlataformaPublishPort();

        {
        System.out.println("Invoking altaPlataforma...");
        try {
            port.altaPlataforma();

        } catch (PlataformaNoValidaException_Exception e) {
            System.out.println("Expected exception: PlataformaNoValidaException has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking listaPlataformas...");
        net.java.dev.jaxb.array.StringArray _listaPlataformas__return = port.listaPlataformas();
        System.out.println("listaPlataformas.result=" + _listaPlataformas__return);


        }
        {
        System.out.println("Invoking chequearDisponibilidadPlataforma...");
        java.lang.String _chequearDisponibilidadPlataforma_arg0 = "_chequearDisponibilidadPlataforma_arg0992530040";
        try {
            boolean _chequearDisponibilidadPlataforma__return = port.chequearDisponibilidadPlataforma(_chequearDisponibilidadPlataforma_arg0);
            System.out.println("chequearDisponibilidadPlataforma.result=" + _chequearDisponibilidadPlataforma__return);

        } catch (PlataformaNoValidaException_Exception e) {
            System.out.println("Expected exception: PlataformaNoValidaException has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking ingresarDatosPlataforma...");
        publicadores.DtPlataforma _ingresarDatosPlataforma_arg0 = new publicadores.DtPlataforma();
        try {
            port.ingresarDatosPlataforma(_ingresarDatosPlataforma_arg0);

        } catch (PlataformaNoValidaException_Exception e) {
            System.out.println("Expected exception: PlataformaNoValidaException has occurred.");
            System.out.println(e.toString());
        }

            }

        System.exit(0);
    }

}
