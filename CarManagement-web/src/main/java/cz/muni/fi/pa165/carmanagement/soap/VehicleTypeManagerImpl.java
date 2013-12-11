/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.soap;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleTypeDto;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleTypeService;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author zvonicek
 */
@WebService
public class VehicleTypeManagerImpl {
    
    @Autowired
    private VehicleTypeService vehicleTypeService;

    @WebMethod(exclude=true)
    public void setVehicleTypeService(VehicleTypeService vehicleTypeService) {
        this.vehicleTypeService = vehicleTypeService;
    }
    
    @WebMethod(operationName="getVehicleType")            
    public VehicleTypeDto getVehicleType(Long id) {
        return vehicleTypeService.findById(id);
    }

    @WebMethod(operationName="findAllVehicleTypes")                
    public List<VehicleTypeDto> findAllVehicleTypes() {
        return vehicleTypeService.findAll();
    }    
}
