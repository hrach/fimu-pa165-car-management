
package cz.muni.fi.pa165.carmanagement.soap.server;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "VehicleManager", targetNamespace = "http://server.soap.carmanagement.pa165.fi.muni.cz/", wsdlLocation = "http://localhost:9000/vehicleManager?wsdl")
public class VehicleManager_Service
    extends Service
{

    private final static URL VEHICLEMANAGER_WSDL_LOCATION;
    private final static WebServiceException VEHICLEMANAGER_EXCEPTION;
    private final static QName VEHICLEMANAGER_QNAME = new QName("http://server.soap.carmanagement.pa165.fi.muni.cz/", "VehicleManager");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9000/vehicleManager?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        VEHICLEMANAGER_WSDL_LOCATION = url;
        VEHICLEMANAGER_EXCEPTION = e;
    }

    public VehicleManager_Service() {
        super(__getWsdlLocation(), VEHICLEMANAGER_QNAME);
    }

    public VehicleManager_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), VEHICLEMANAGER_QNAME, features);
    }

    public VehicleManager_Service(URL wsdlLocation) {
        super(wsdlLocation, VEHICLEMANAGER_QNAME);
    }

    public VehicleManager_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, VEHICLEMANAGER_QNAME, features);
    }

    public VehicleManager_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public VehicleManager_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns VehicleManager
     */
    @WebEndpoint(name = "VehicleManagerImplPort")
    public VehicleManager getVehicleManagerImplPort() {
        return super.getPort(new QName("http://server.soap.carmanagement.pa165.fi.muni.cz/", "VehicleManagerImplPort"), VehicleManager.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns VehicleManager
     */
    @WebEndpoint(name = "VehicleManagerImplPort")
    public VehicleManager getVehicleManagerImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://server.soap.carmanagement.pa165.fi.muni.cz/", "VehicleManagerImplPort"), VehicleManager.class, features);
    }

    private static URL __getWsdlLocation() {
        if (VEHICLEMANAGER_EXCEPTION!= null) {
            throw VEHICLEMANAGER_EXCEPTION;
        }
        return VEHICLEMANAGER_WSDL_LOCATION;
    }

}
