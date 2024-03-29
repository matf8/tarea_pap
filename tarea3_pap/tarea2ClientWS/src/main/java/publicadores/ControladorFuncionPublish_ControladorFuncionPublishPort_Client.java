
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
 * 2021-11-02T02:10:41.777-03:00
 * Generated source version: 3.4.4
 *
 */
public final class ControladorFuncionPublish_ControladorFuncionPublishPort_Client {

    private static final QName SERVICE_NAME = new QName("http://publicadores/", "ControladorFuncionPublishService");

    private ControladorFuncionPublish_ControladorFuncionPublishPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ControladorFuncionPublishService.WSDL_LOCATION;
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

        ControladorFuncionPublishService ss = new ControladorFuncionPublishService(wsdlURL, SERVICE_NAME);
        ControladorFuncionPublish port = ss.getControladorFuncionPublishPort();

        {
        System.out.println("Invoking seleccionarFuncion...");
        java.lang.String _seleccionarFuncion_arg0 = "_seleccionarFuncion_arg01203366028";
        try {
            publicadores.DtFuncion _seleccionarFuncion__return = port.seleccionarFuncion(_seleccionarFuncion_arg0);
            System.out.println("seleccionarFuncion.result=" + _seleccionarFuncion__return);

        } catch (FuncionNoValidaException_Exception e) {
            System.out.println("Expected exception: FuncionNoValidaException has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking listarRegistros...");
        java.lang.String _listarRegistros_arg0 = "_listarRegistros_arg0-969295955";
        try {
            publicadores.DtRegistroCompletoArray _listarRegistros__return = port.listarRegistros(_listarRegistros_arg0);
            System.out.println("listarRegistros.result=" + _listarRegistros__return);

        } catch (Exception_Exception e) {
            System.out.println("Expected exception: Exception has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking altaRegistroPaquete...");
        java.lang.String _altaRegistroPaquete_arg0 = "_altaRegistroPaquete_arg01471013175";
        java.lang.String _altaRegistroPaquete_arg1 = "_altaRegistroPaquete_arg11505071447";
        java.lang.String _altaRegistroPaquete_arg2 = "_altaRegistroPaquete_arg21389224990";
        java.lang.String _altaRegistroPaquete_arg3 = "_altaRegistroPaquete_arg3-321067387";
        try {
            port.altaRegistroPaquete(_altaRegistroPaquete_arg0, _altaRegistroPaquete_arg1, _altaRegistroPaquete_arg2, _altaRegistroPaquete_arg3);

        } catch (Exception_Exception e) {
            System.out.println("Expected exception: Exception has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking chequearDisponibilidadNombreFuncion...");
        java.lang.String _chequearDisponibilidadNombreFuncion_arg0 = "_chequearDisponibilidadNombreFuncion_arg02062814375";
        try {
            boolean _chequearDisponibilidadNombreFuncion__return = port.chequearDisponibilidadNombreFuncion(_chequearDisponibilidadNombreFuncion_arg0);
            System.out.println("chequearDisponibilidadNombreFuncion.result=" + _chequearDisponibilidadNombreFuncion__return);

        } catch (FuncionNoValidaException_Exception e) {
            System.out.println("Expected exception: FuncionNoValidaException has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking listarFuncionesEspectador...");
        java.lang.String _listarFuncionesEspectador_arg0 = "_listarFuncionesEspectador_arg0689171120";
        publicadores.DtFuncionArray _listarFuncionesEspectador__return = port.listarFuncionesEspectador(_listarFuncionesEspectador_arg0);
        System.out.println("listarFuncionesEspectador.result=" + _listarFuncionesEspectador__return);


        }
        {
        System.out.println("Invoking altaFuncion...");
        port.altaFuncion();


        }
        {
        System.out.println("Invoking listarEspectaculos...");
        java.lang.String _listarEspectaculos_arg0 = "_listarEspectaculos_arg098075086";
        try {
            net.java.dev.jaxb.array.StringArray _listarEspectaculos__return = port.listarEspectaculos(_listarEspectaculos_arg0);
            System.out.println("listarEspectaculos.result=" + _listarEspectaculos__return);

        } catch (PlataformaNoExisteException_Exception e) {
            System.out.println("Expected exception: PlataformaNoExisteException has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking seleccionarEspectaculo...");
        java.lang.String _seleccionarEspectaculo_arg0 = "_seleccionarEspectaculo_arg0-722687231";
        try {
            port.seleccionarEspectaculo(_seleccionarEspectaculo_arg0);

        } catch (EspectaculoNoValidoException_Exception e) {
            System.out.println("Expected exception: EspectaculoNoValidoException has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking listarEspectaculosPorArtista...");
        java.lang.String _listarEspectaculosPorArtista_arg0 = "_listarEspectaculosPorArtista_arg0-1996780427";
        try {
            net.java.dev.jaxb.array.StringArray _listarEspectaculosPorArtista__return = port.listarEspectaculosPorArtista(_listarEspectaculosPorArtista_arg0);
            System.out.println("listarEspectaculosPorArtista.result=" + _listarEspectaculosPorArtista__return);

        } catch (Exception_Exception e) {
            System.out.println("Expected exception: Exception has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking altaRegistro...");
        net.java.dev.jaxb.array.IntArray _altaRegistro_arg0 = new net.java.dev.jaxb.array.IntArray();
        java.util.List<java.lang.Integer> _altaRegistro_arg0Item = new java.util.ArrayList<java.lang.Integer>();
        java.lang.Integer _altaRegistro_arg0ItemVal1 = Integer.valueOf(388746011);
        _altaRegistro_arg0Item.add(_altaRegistro_arg0ItemVal1);
        _altaRegistro_arg0.getItem().addAll(_altaRegistro_arg0Item);
        try {
            port.altaRegistro(_altaRegistro_arg0);

        } catch (Exception_Exception e) {
            System.out.println("Expected exception: Exception has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking listarFunciones...");
        net.java.dev.jaxb.array.StringArray _listarFunciones__return = port.listarFunciones();
        System.out.println("listarFunciones.result=" + _listarFunciones__return);


        }
        {
        System.out.println("Invoking listarEspectadores...");
        net.java.dev.jaxb.array.StringArray _listarEspectadores__return = port.listarEspectadores();
        System.out.println("listarEspectadores.result=" + _listarEspectadores__return);


        }
        {
        System.out.println("Invoking listarPaquetes...");
        java.lang.String _listarPaquetes_arg0 = "_listarPaquetes_arg01394853239";
        net.java.dev.jaxb.array.StringArray _listarPaquetes__return = port.listarPaquetes(_listarPaquetes_arg0);
        System.out.println("listarPaquetes.result=" + _listarPaquetes__return);


        }
        {
        System.out.println("Invoking ingresarFuncion...");
        publicadores.DtFuncion _ingresarFuncion_arg0 = new publicadores.DtFuncion();
        java.util.List<java.lang.String> _ingresarFuncion_arg0ArtistasInvitados = new java.util.ArrayList<java.lang.String>();
        java.lang.String _ingresarFuncion_arg0ArtistasInvitadosVal1 = "_ingresarFuncion_arg0ArtistasInvitadosVal713422974";
        _ingresarFuncion_arg0ArtistasInvitados.add(_ingresarFuncion_arg0ArtistasInvitadosVal1);
        _ingresarFuncion_arg0.getArtistasInvitados().addAll(_ingresarFuncion_arg0ArtistasInvitados);
        _ingresarFuncion_arg0.setFecha(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2021-11-02T02:10:41.854-03:00"));
        _ingresarFuncion_arg0.setFechaReg(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2021-11-02T02:10:41.856-03:00"));
        _ingresarFuncion_arg0.setFechaRegString("FechaRegString1072160560");
        _ingresarFuncion_arg0.setFechaString("FechaString-1071508729");
        _ingresarFuncion_arg0.setHoraIni(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2021-11-02T02:10:41.856-03:00"));
        _ingresarFuncion_arg0.setHoraIniString("HoraIniString-865232286");
        _ingresarFuncion_arg0.setNombre("Nombre247251028");
        byte[] _ingresarFuncion_arg1 = new byte[] {};
        try {
            port.ingresarFuncion(_ingresarFuncion_arg0, _ingresarFuncion_arg1);

        } catch (FuncionNoValidaException_Exception e) {
            System.out.println("Expected exception: FuncionNoValidaException has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking ingresarArtista...");
        java.lang.String _ingresarArtista_arg0 = "_ingresarArtista_arg0-737608558";
        try {
            port.ingresarArtista(_ingresarArtista_arg0);

        } catch (Exception_Exception e) {
            System.out.println("Expected exception: Exception has occurred.");
            System.out.println(e.toString());
        } catch (UsuarioNoExisteException_Exception e) {
            System.out.println("Expected exception: UsuarioNoExisteException has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking listarFuncionesVigentes...");
        net.java.dev.jaxb.array.StringArray _listarFuncionesVigentes__return = port.listarFuncionesVigentes();
        System.out.println("listarFuncionesVigentes.result=" + _listarFuncionesVigentes__return);


        }

        System.exit(0);
    }

}
