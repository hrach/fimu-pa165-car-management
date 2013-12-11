/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.soap.server;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleTypeDto;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleTypeService;
import java.util.List;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author tomasbobek
 */
@Component
@WebService(endpointInterface = "cz.muni.fi.pa165.carmanagement.soap.server.VehicleTypeManager", serviceName = "VehicleTypeManager")
public class VehicleTypeManagerImpl implements VehicleTypeManager {
    @Autowired
    private VehicleTypeService vehicleTypeService;
    
    public VehicleTypeDto getVehicleType(Long id) {
        return vehicleTypeService.findById(id);
    }

    public List<VehicleTypeDto> findAllVehicleTypes() {
        return vehicleTypeService.findAll();
    }
}
