package publicadores;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.4.4
 * 2021-11-02T02:10:10.907-03:00
 * Generated source version: 3.4.4
 *
 */
@WebServiceClient(name = "ControladorPlataformaPublishService",
                  wsdlLocation = "http://localhost:3030/controladorPlat?wsdl",
                  targetNamespace = "http://publicadores/")
public class ControladorPlataformaPublishService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://publicadores/", "ControladorPlataformaPublishService");
    public final static QName ControladorPlataformaPublishPort = new QName("http://publicadores/", "ControladorPlataformaPublishPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:3030/controladorPlat?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ControladorPlataformaPublishService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:3030/controladorPlat?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ControladorPlataformaPublishService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ControladorPlataformaPublishService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ControladorPlataformaPublishService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public ControladorPlataformaPublishService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ControladorPlataformaPublishService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ControladorPlataformaPublishService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns ControladorPlataformaPublish
     */
    @WebEndpoint(name = "ControladorPlataformaPublishPort")
    public ControladorPlataformaPublish getControladorPlataformaPublishPort() {
        return super.getPort(ControladorPlataformaPublishPort, ControladorPlataformaPublish.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ControladorPlataformaPublish
     */
    @WebEndpoint(name = "ControladorPlataformaPublishPort")
    public ControladorPlataformaPublish getControladorPlataformaPublishPort(WebServiceFeature... features) {
        return super.getPort(ControladorPlataformaPublishPort, ControladorPlataformaPublish.class, features);
    }

}
