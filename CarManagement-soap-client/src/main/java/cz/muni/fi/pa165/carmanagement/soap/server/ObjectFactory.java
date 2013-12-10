
package cz.muni.fi.pa165.carmanagement.soap.server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cz.muni.fi.pa165.carmanagement.soap.server package. 
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

    private final static QName _GetEmployeeResponse_QNAME = new QName("http://server.soap.carmanagement.pa165.fi.muni.cz/", "getEmployeeResponse");
    private final static QName _UpdateEmployee_QNAME = new QName("http://server.soap.carmanagement.pa165.fi.muni.cz/", "updateEmployee");
    private final static QName _FindAllEmployees_QNAME = new QName("http://server.soap.carmanagement.pa165.fi.muni.cz/", "findAllEmployees");
    private final static QName _CreateEmployeeResponse_QNAME = new QName("http://server.soap.carmanagement.pa165.fi.muni.cz/", "createEmployeeResponse");
    private final static QName _RemoveEmployee_QNAME = new QName("http://server.soap.carmanagement.pa165.fi.muni.cz/", "removeEmployee");
    private final static QName _RemoveEmployeeResponse_QNAME = new QName("http://server.soap.carmanagement.pa165.fi.muni.cz/", "removeEmployeeResponse");
    private final static QName _CreateEmployee_QNAME = new QName("http://server.soap.carmanagement.pa165.fi.muni.cz/", "createEmployee");
    private final static QName _FindAllEmployeesResponse_QNAME = new QName("http://server.soap.carmanagement.pa165.fi.muni.cz/", "findAllEmployeesResponse");
    private final static QName _GetEmployee_QNAME = new QName("http://server.soap.carmanagement.pa165.fi.muni.cz/", "getEmployee");
    private final static QName _UpdateEmployeeResponse_QNAME = new QName("http://server.soap.carmanagement.pa165.fi.muni.cz/", "updateEmployeeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cz.muni.fi.pa165.carmanagement.soap.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RemoveEmployee }
     * 
     */
    public RemoveEmployee createRemoveEmployee() {
        return new RemoveEmployee();
    }

    /**
     * Create an instance of {@link CreateEmployeeResponse }
     * 
     */
    public CreateEmployeeResponse createCreateEmployeeResponse() {
        return new CreateEmployeeResponse();
    }

    /**
     * Create an instance of {@link FindAllEmployees }
     * 
     */
    public FindAllEmployees createFindAllEmployees() {
        return new FindAllEmployees();
    }

    /**
     * Create an instance of {@link UpdateEmployee }
     * 
     */
    public UpdateEmployee createUpdateEmployee() {
        return new UpdateEmployee();
    }

    /**
     * Create an instance of {@link GetEmployeeResponse }
     * 
     */
    public GetEmployeeResponse createGetEmployeeResponse() {
        return new GetEmployeeResponse();
    }

    /**
     * Create an instance of {@link UpdateEmployeeResponse }
     * 
     */
    public UpdateEmployeeResponse createUpdateEmployeeResponse() {
        return new UpdateEmployeeResponse();
    }

    /**
     * Create an instance of {@link GetEmployee }
     * 
     */
    public GetEmployee createGetEmployee() {
        return new GetEmployee();
    }

    /**
     * Create an instance of {@link FindAllEmployeesResponse }
     * 
     */
    public FindAllEmployeesResponse createFindAllEmployeesResponse() {
        return new FindAllEmployeesResponse();
    }

    /**
     * Create an instance of {@link CreateEmployee }
     * 
     */
    public CreateEmployee createCreateEmployee() {
        return new CreateEmployee();
    }

    /**
     * Create an instance of {@link RemoveEmployeeResponse }
     * 
     */
    public RemoveEmployeeResponse createRemoveEmployeeResponse() {
        return new RemoveEmployeeResponse();
    }

    /**
     * Create an instance of {@link VehicleDto }
     * 
     */
    public VehicleDto createVehicleDto() {
        return new VehicleDto();
    }

    /**
     * Create an instance of {@link ServiceTypeDto }
     * 
     */
    public ServiceTypeDto createServiceTypeDto() {
        return new ServiceTypeDto();
    }

    /**
     * Create an instance of {@link VehicleTypeDto }
     * 
     */
    public VehicleTypeDto createVehicleTypeDto() {
        return new VehicleTypeDto();
    }

    /**
     * Create an instance of {@link EmployeeDto }
     * 
     */
    public EmployeeDto createEmployeeDto() {
        return new EmployeeDto();
    }

    /**
     * Create an instance of {@link ServiceIntervalDto }
     * 
     */
    public ServiceIntervalDto createServiceIntervalDto() {
        return new ServiceIntervalDto();
    }

    /**
     * Create an instance of {@link RideDto }
     * 
     */
    public RideDto createRideDto() {
        return new RideDto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.carmanagement.pa165.fi.muni.cz/", name = "getEmployeeResponse")
    public JAXBElement<GetEmployeeResponse> createGetEmployeeResponse(GetEmployeeResponse value) {
        return new JAXBElement<GetEmployeeResponse>(_GetEmployeeResponse_QNAME, GetEmployeeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEmployee }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.carmanagement.pa165.fi.muni.cz/", name = "updateEmployee")
    public JAXBElement<UpdateEmployee> createUpdateEmployee(UpdateEmployee value) {
        return new JAXBElement<UpdateEmployee>(_UpdateEmployee_QNAME, UpdateEmployee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllEmployees }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.carmanagement.pa165.fi.muni.cz/", name = "findAllEmployees")
    public JAXBElement<FindAllEmployees> createFindAllEmployees(FindAllEmployees value) {
        return new JAXBElement<FindAllEmployees>(_FindAllEmployees_QNAME, FindAllEmployees.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateEmployeeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.carmanagement.pa165.fi.muni.cz/", name = "createEmployeeResponse")
    public JAXBElement<CreateEmployeeResponse> createCreateEmployeeResponse(CreateEmployeeResponse value) {
        return new JAXBElement<CreateEmployeeResponse>(_CreateEmployeeResponse_QNAME, CreateEmployeeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveEmployee }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.carmanagement.pa165.fi.muni.cz/", name = "removeEmployee")
    public JAXBElement<RemoveEmployee> createRemoveEmployee(RemoveEmployee value) {
        return new JAXBElement<RemoveEmployee>(_RemoveEmployee_QNAME, RemoveEmployee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveEmployeeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.carmanagement.pa165.fi.muni.cz/", name = "removeEmployeeResponse")
    public JAXBElement<RemoveEmployeeResponse> createRemoveEmployeeResponse(RemoveEmployeeResponse value) {
        return new JAXBElement<RemoveEmployeeResponse>(_RemoveEmployeeResponse_QNAME, RemoveEmployeeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateEmployee }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.carmanagement.pa165.fi.muni.cz/", name = "createEmployee")
    public JAXBElement<CreateEmployee> createCreateEmployee(CreateEmployee value) {
        return new JAXBElement<CreateEmployee>(_CreateEmployee_QNAME, CreateEmployee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllEmployeesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.carmanagement.pa165.fi.muni.cz/", name = "findAllEmployeesResponse")
    public JAXBElement<FindAllEmployeesResponse> createFindAllEmployeesResponse(FindAllEmployeesResponse value) {
        return new JAXBElement<FindAllEmployeesResponse>(_FindAllEmployeesResponse_QNAME, FindAllEmployeesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployee }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.carmanagement.pa165.fi.muni.cz/", name = "getEmployee")
    public JAXBElement<GetEmployee> createGetEmployee(GetEmployee value) {
        return new JAXBElement<GetEmployee>(_GetEmployee_QNAME, GetEmployee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEmployeeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.carmanagement.pa165.fi.muni.cz/", name = "updateEmployeeResponse")
    public JAXBElement<UpdateEmployeeResponse> createUpdateEmployeeResponse(UpdateEmployeeResponse value) {
        return new JAXBElement<UpdateEmployeeResponse>(_UpdateEmployeeResponse_QNAME, UpdateEmployeeResponse.class, null, value);
    }

}
