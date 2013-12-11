/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.soap;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleService;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 *
 * @author zvonicek
 */
@WebService
public class VehicleManagerImpl {

    @Autowired
    private VehicleService vehicleService;

    @WebMethod(exclude=true)
    public void setVehicleService(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }       

    @WebMethod(operationName="createVehicle")    
    public void createVehicle(VehicleDto vehicleDTO) {
        vehicleService.create(vehicleDTO);
    }

    @WebMethod(operationName="getVehicle")        
    public VehicleDto getVehicle(Long id) {
        return vehicleService.findById(id);
    }

    @WebMethod(operationName="findAllVehicles")
    public List<VehicleDto> findAllVehicles() {
        return vehicleService.findAll();
    }

    @WebMethod(operationName="updateVehicle")    
    public void updateVehicle(VehicleDto vehicleDTO) {
        vehicleService.update(vehicleDTO);
    }

    @WebMethod(operationName="removeVehicle")        
    public void removeVehicle(VehicleDto vehicleDTO) {
        vehicleService.delete(vehicleDTO.getId());
    }
}
