
package cz.muni.fi.pa165.carmanagement.soap;

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
@WebServiceClient(name = "EmployeeManagerImplService", targetNamespace = "http://soap.carmanagement.pa165.fi.muni.cz/", wsdlLocation = "http://localhost:8080/pa165/ws/employeeManager?wsdl")
public class EmployeeManagerImplService
    extends Service
{

    private final static URL EMPLOYEEMANAGERIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException EMPLOYEEMANAGERIMPLSERVICE_EXCEPTION;
    private final static QName EMPLOYEEMANAGERIMPLSERVICE_QNAME = new QName("http://soap.carmanagement.pa165.fi.muni.cz/", "EmployeeManagerImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/pa165/ws/employeeManager?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        EMPLOYEEMANAGERIMPLSERVICE_WSDL_LOCATION = url;
        EMPLOYEEMANAGERIMPLSERVICE_EXCEPTION = e;
    }

    public EmployeeManagerImplService() {
        super(__getWsdlLocation(), EMPLOYEEMANAGERIMPLSERVICE_QNAME);
    }

    public EmployeeManagerImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), EMPLOYEEMANAGERIMPLSERVICE_QNAME, features);
    }

    public EmployeeManagerImplService(URL wsdlLocation) {
        super(wsdlLocation, EMPLOYEEMANAGERIMPLSERVICE_QNAME);
    }

    public EmployeeManagerImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, EMPLOYEEMANAGERIMPLSERVICE_QNAME, features);
    }

    public EmployeeManagerImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EmployeeManagerImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns EmployeeManagerImpl
     */
    @WebEndpoint(name = "EmployeeManagerImplPort")
    public EmployeeManagerImpl getEmployeeManagerImplPort() {
        return super.getPort(new QName("http://soap.carmanagement.pa165.fi.muni.cz/", "EmployeeManagerImplPort"), EmployeeManagerImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EmployeeManagerImpl
     */
    @WebEndpoint(name = "EmployeeManagerImplPort")
    public EmployeeManagerImpl getEmployeeManagerImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://soap.carmanagement.pa165.fi.muni.cz/", "EmployeeManagerImplPort"), EmployeeManagerImpl.class, features);
    }

    private static URL __getWsdlLocation() {
        if (EMPLOYEEMANAGERIMPLSERVICE_EXCEPTION!= null) {
            throw EMPLOYEEMANAGERIMPLSERVICE_EXCEPTION;
        }
        return EMPLOYEEMANAGERIMPLSERVICE_WSDL_LOCATION;
    }

}