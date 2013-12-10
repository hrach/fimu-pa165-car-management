
package cz.muni.fi.pa165.carmanagement.web.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cz.muni.fi.pa165.carmanagement.web.soap package. 
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

    private final static QName _CreateVehicleResponse_QNAME = new QName("http://soap.web.carmanagement.pa165.fi.muni.cz/", "createVehicleResponse");
    private final static QName _RemoveVehicleResponse_QNAME = new QName("http://soap.web.carmanagement.pa165.fi.muni.cz/", "removeVehicleResponse");
    private final static QName _CreateVehicle_QNAME = new QName("http://soap.web.carmanagement.pa165.fi.muni.cz/", "createVehicle");
    private final static QName _FindAllVehicles_QNAME = new QName("http://soap.web.carmanagement.pa165.fi.muni.cz/", "findAllVehicles");
    private final static QName _SayHi_QNAME = new QName("http://soap.web.carmanagement.pa165.fi.muni.cz/", "sayHi");
    private final static QName _FindAllVehiclesResponse_QNAME = new QName("http://soap.web.carmanagement.pa165.fi.muni.cz/", "findAllVehiclesResponse");
    private final static QName _GetVehicle_QNAME = new QName("http://soap.web.carmanagement.pa165.fi.muni.cz/", "getVehicle");
    private final static QName _RemoveVehicle_QNAME = new QName("http://soap.web.carmanagement.pa165.fi.muni.cz/", "removeVehicle");
    private final static QName _UpdateVehicleResponse_QNAME = new QName("http://soap.web.carmanagement.pa165.fi.muni.cz/", "updateVehicleResponse");
    private final static QName _UpdateVehicle_QNAME = new QName("http://soap.web.carmanagement.pa165.fi.muni.cz/", "updateVehicle");
    private final static QName _GetVehicleResponse_QNAME = new QName("http://soap.web.carmanagement.pa165.fi.muni.cz/", "getVehicleResponse");
    private final static QName _SayHiResponse_QNAME = new QName("http://soap.web.carmanagement.pa165.fi.muni.cz/", "sayHiResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cz.muni.fi.pa165.carmanagement.web.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RemoveVehicle }
     * 
     */
    public RemoveVehicle createRemoveVehicle() {
        return new RemoveVehicle();
    }

    /**
     * Create an instance of {@link SayHiResponse }
     * 
     */
    public SayHiResponse createSayHiResponse() {
        return new SayHiResponse();
    }

    /**
     * Create an instance of {@link GetVehicleResponse }
     * 
     */
    public GetVehicleResponse createGetVehicleResponse() {
        return new GetVehicleResponse();
    }

    /**
     * Create an instance of {@link UpdateVehicle }
     * 
     */
    public UpdateVehicle createUpdateVehicle() {
        return new UpdateVehicle();
    }

    /**
     * Create an instance of {@link UpdateVehicleResponse }
     * 
     */
    public UpdateVehicleResponse createUpdateVehicleResponse() {
        return new UpdateVehicleResponse();
    }

    /**
     * Create an instance of {@link FindAllVehicles }
     * 
     */
    public FindAllVehicles createFindAllVehicles() {
        return new FindAllVehicles();
    }

    /**
     * Create an instance of {@link CreateVehicle }
     * 
     */
    public CreateVehicle createCreateVehicle() {
        return new CreateVehicle();
    }

    /**
     * Create an instance of {@link RemoveVehicleResponse }
     * 
     */
    public RemoveVehicleResponse createRemoveVehicleResponse() {
        return new RemoveVehicleResponse();
    }

    /**
     * Create an instance of {@link CreateVehicleResponse }
     * 
     */
    public CreateVehicleResponse createCreateVehicleResponse() {
        return new CreateVehicleResponse();
    }

    /**
     * Create an instance of {@link GetVehicle }
     * 
     */
    public GetVehicle createGetVehicle() {
        return new GetVehicle();
    }

    /**
     * Create an instance of {@link FindAllVehiclesResponse }
     * 
     */
    public FindAllVehiclesResponse createFindAllVehiclesResponse() {
        return new FindAllVehiclesResponse();
    }

    /**
     * Create an instance of {@link SayHi }
     * 
     */
    public SayHi createSayHi() {
        return new SayHi();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateVehicleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", name = "createVehicleResponse")
    public JAXBElement<CreateVehicleResponse> createCreateVehicleResponse(CreateVehicleResponse value) {
        return new JAXBElement<CreateVehicleResponse>(_CreateVehicleResponse_QNAME, CreateVehicleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveVehicleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", name = "removeVehicleResponse")
    public JAXBElement<RemoveVehicleResponse> createRemoveVehicleResponse(RemoveVehicleResponse value) {
        return new JAXBElement<RemoveVehicleResponse>(_RemoveVehicleResponse_QNAME, RemoveVehicleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateVehicle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", name = "createVehicle")
    public JAXBElement<CreateVehicle> createCreateVehicle(CreateVehicle value) {
        return new JAXBElement<CreateVehicle>(_CreateVehicle_QNAME, CreateVehicle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllVehicles }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", name = "findAllVehicles")
    public JAXBElement<FindAllVehicles> createFindAllVehicles(FindAllVehicles value) {
        return new JAXBElement<FindAllVehicles>(_FindAllVehicles_QNAME, FindAllVehicles.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", name = "sayHi")
    public JAXBElement<SayHi> createSayHi(SayHi value) {
        return new JAXBElement<SayHi>(_SayHi_QNAME, SayHi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllVehiclesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", name = "findAllVehiclesResponse")
    public JAXBElement<FindAllVehiclesResponse> createFindAllVehiclesResponse(FindAllVehiclesResponse value) {
        return new JAXBElement<FindAllVehiclesResponse>(_FindAllVehiclesResponse_QNAME, FindAllVehiclesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVehicle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", name = "getVehicle")
    public JAXBElement<GetVehicle> createGetVehicle(GetVehicle value) {
        return new JAXBElement<GetVehicle>(_GetVehicle_QNAME, GetVehicle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveVehicle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", name = "removeVehicle")
    public JAXBElement<RemoveVehicle> createRemoveVehicle(RemoveVehicle value) {
        return new JAXBElement<RemoveVehicle>(_RemoveVehicle_QNAME, RemoveVehicle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateVehicleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", name = "updateVehicleResponse")
    public JAXBElement<UpdateVehicleResponse> createUpdateVehicleResponse(UpdateVehicleResponse value) {
        return new JAXBElement<UpdateVehicleResponse>(_UpdateVehicleResponse_QNAME, UpdateVehicleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateVehicle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", name = "updateVehicle")
    public JAXBElement<UpdateVehicle> createUpdateVehicle(UpdateVehicle value) {
        return new JAXBElement<UpdateVehicle>(_UpdateVehicle_QNAME, UpdateVehicle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVehicleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", name = "getVehicleResponse")
    public JAXBElement<GetVehicleResponse> createGetVehicleResponse(GetVehicleResponse value) {
        return new JAXBElement<GetVehicleResponse>(_GetVehicleResponse_QNAME, GetVehicleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", name = "sayHiResponse")
    public JAXBElement<SayHiResponse> createSayHiResponse(SayHiResponse value) {
        return new JAXBElement<SayHiResponse>(_SayHiResponse_QNAME, SayHiResponse.class, null, value);
    }

}
