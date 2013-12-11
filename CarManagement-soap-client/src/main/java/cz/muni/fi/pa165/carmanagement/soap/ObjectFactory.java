
package cz.muni.fi.pa165.carmanagement.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cz.muni.fi.pa165.carmanagement.soap package. 
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

    private final static QName _FindAllVehicleTypesResponse_QNAME = new QName("http://soap.carmanagement.pa165.fi.muni.cz/", "findAllVehicleTypesResponse");
    private final static QName _FindAllVehicleTypes_QNAME = new QName("http://soap.carmanagement.pa165.fi.muni.cz/", "findAllVehicleTypes");
    private final static QName _GetVehicleTypeResponse_QNAME = new QName("http://soap.carmanagement.pa165.fi.muni.cz/", "getVehicleTypeResponse");
    private final static QName _GetVehicleType_QNAME = new QName("http://soap.carmanagement.pa165.fi.muni.cz/", "getVehicleType");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cz.muni.fi.pa165.carmanagement.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindAllVehicleTypesResponse }
     * 
     */
    public FindAllVehicleTypesResponse createFindAllVehicleTypesResponse() {
        return new FindAllVehicleTypesResponse();
    }

    /**
     * Create an instance of {@link FindAllVehicleTypes }
     * 
     */
    public FindAllVehicleTypes createFindAllVehicleTypes() {
        return new FindAllVehicleTypes();
    }

    /**
     * Create an instance of {@link GetVehicleTypeResponse }
     * 
     */
    public GetVehicleTypeResponse createGetVehicleTypeResponse() {
        return new GetVehicleTypeResponse();
    }

    /**
     * Create an instance of {@link GetVehicleType }
     * 
     */
    public GetVehicleType createGetVehicleType() {
        return new GetVehicleType();
    }

    /**
     * Create an instance of {@link VehicleTypeDto }
     * 
     */
    public VehicleTypeDto createVehicleTypeDto() {
        return new VehicleTypeDto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllVehicleTypesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.carmanagement.pa165.fi.muni.cz/", name = "findAllVehicleTypesResponse")
    public JAXBElement<FindAllVehicleTypesResponse> createFindAllVehicleTypesResponse(FindAllVehicleTypesResponse value) {
        return new JAXBElement<FindAllVehicleTypesResponse>(_FindAllVehicleTypesResponse_QNAME, FindAllVehicleTypesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllVehicleTypes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.carmanagement.pa165.fi.muni.cz/", name = "findAllVehicleTypes")
    public JAXBElement<FindAllVehicleTypes> createFindAllVehicleTypes(FindAllVehicleTypes value) {
        return new JAXBElement<FindAllVehicleTypes>(_FindAllVehicleTypes_QNAME, FindAllVehicleTypes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVehicleTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.carmanagement.pa165.fi.muni.cz/", name = "getVehicleTypeResponse")
    public JAXBElement<GetVehicleTypeResponse> createGetVehicleTypeResponse(GetVehicleTypeResponse value) {
        return new JAXBElement<GetVehicleTypeResponse>(_GetVehicleTypeResponse_QNAME, GetVehicleTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVehicleType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.carmanagement.pa165.fi.muni.cz/", name = "getVehicleType")
    public JAXBElement<GetVehicleType> createGetVehicleType(GetVehicleType value) {
        return new JAXBElement<GetVehicleType>(_GetVehicleType_QNAME, GetVehicleType.class, null, value);
    }

}
