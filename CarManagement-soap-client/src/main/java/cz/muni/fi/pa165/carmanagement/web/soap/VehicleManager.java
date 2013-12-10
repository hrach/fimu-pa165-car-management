
package cz.muni.fi.pa165.carmanagement.web.soap;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "VehicleManager", targetNamespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface VehicleManager {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHi", targetNamespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", className = "cz.muni.fi.pa165.carmanagement.web.soap.SayHi")
    @ResponseWrapper(localName = "sayHiResponse", targetNamespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", className = "cz.muni.fi.pa165.carmanagement.web.soap.SayHiResponse")
    @Action(input = "http://soap.web.carmanagement.pa165.fi.muni.cz/VehicleManager/sayHiRequest", output = "http://soap.web.carmanagement.pa165.fi.muni.cz/VehicleManager/sayHiResponse")
    public String sayHi();

    /**
     * 
     * @param vehicleDto
     */
    @WebMethod
    @RequestWrapper(localName = "createVehicle", targetNamespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", className = "cz.muni.fi.pa165.carmanagement.web.soap.CreateVehicle")
    @ResponseWrapper(localName = "createVehicleResponse", targetNamespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", className = "cz.muni.fi.pa165.carmanagement.web.soap.CreateVehicleResponse")
    @Action(input = "http://soap.web.carmanagement.pa165.fi.muni.cz/VehicleManager/createVehicleRequest", output = "http://soap.web.carmanagement.pa165.fi.muni.cz/VehicleManager/createVehicleResponse")
    public void createVehicle(
        @WebParam(name = "vehicleDto", targetNamespace = "")
        VehicleDto vehicleDto);

    /**
     * 
     * @param id
     * @return
     *     returns cz.muni.fi.pa165.carmanagement.web.soap.VehicleDto
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getVehicle", targetNamespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", className = "cz.muni.fi.pa165.carmanagement.web.soap.GetVehicle")
    @ResponseWrapper(localName = "getVehicleResponse", targetNamespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", className = "cz.muni.fi.pa165.carmanagement.web.soap.GetVehicleResponse")
    @Action(input = "http://soap.web.carmanagement.pa165.fi.muni.cz/VehicleManager/getVehicleRequest", output = "http://soap.web.carmanagement.pa165.fi.muni.cz/VehicleManager/getVehicleResponse")
    public VehicleDto getVehicle(
        @WebParam(name = "id", targetNamespace = "")
        Long id);

    /**
     * 
     * @return
     *     returns java.util.List<cz.muni.fi.pa165.carmanagement.web.soap.VehicleDto>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findAllVehicles", targetNamespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", className = "cz.muni.fi.pa165.carmanagement.web.soap.FindAllVehicles")
    @ResponseWrapper(localName = "findAllVehiclesResponse", targetNamespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", className = "cz.muni.fi.pa165.carmanagement.web.soap.FindAllVehiclesResponse")
    @Action(input = "http://soap.web.carmanagement.pa165.fi.muni.cz/VehicleManager/findAllVehiclesRequest", output = "http://soap.web.carmanagement.pa165.fi.muni.cz/VehicleManager/findAllVehiclesResponse")
    public List<VehicleDto> findAllVehicles();

    /**
     * 
     * @param vehicleDto
     */
    @WebMethod
    @RequestWrapper(localName = "updateVehicle", targetNamespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", className = "cz.muni.fi.pa165.carmanagement.web.soap.UpdateVehicle")
    @ResponseWrapper(localName = "updateVehicleResponse", targetNamespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", className = "cz.muni.fi.pa165.carmanagement.web.soap.UpdateVehicleResponse")
    @Action(input = "http://soap.web.carmanagement.pa165.fi.muni.cz/VehicleManager/updateVehicleRequest", output = "http://soap.web.carmanagement.pa165.fi.muni.cz/VehicleManager/updateVehicleResponse")
    public void updateVehicle(
        @WebParam(name = "vehicleDto", targetNamespace = "")
        VehicleDto vehicleDto);

    /**
     * 
     * @param vehicleDto
     */
    @WebMethod
    @RequestWrapper(localName = "removeVehicle", targetNamespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", className = "cz.muni.fi.pa165.carmanagement.web.soap.RemoveVehicle")
    @ResponseWrapper(localName = "removeVehicleResponse", targetNamespace = "http://soap.web.carmanagement.pa165.fi.muni.cz/", className = "cz.muni.fi.pa165.carmanagement.web.soap.RemoveVehicleResponse")
    @Action(input = "http://soap.web.carmanagement.pa165.fi.muni.cz/VehicleManager/removeVehicleRequest", output = "http://soap.web.carmanagement.pa165.fi.muni.cz/VehicleManager/removeVehicleResponse")
    public void removeVehicle(
        @WebParam(name = "vehicleDto", targetNamespace = "")
        VehicleDto vehicleDto);

}
