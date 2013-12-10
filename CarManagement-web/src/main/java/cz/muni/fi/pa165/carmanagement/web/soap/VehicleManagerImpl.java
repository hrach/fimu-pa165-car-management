/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.web.soap;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleService;
import java.util.List;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zvonicek
 */
@Component
@WebService(endpointInterface = "cz.muni.fi.pa165.carmanagement.web.soap.VehicleManager", serviceName = "VehicleManager")
public class VehicleManagerImpl implements VehicleManager {

    @Autowired
    private VehicleService vehicleService;
    
    public String sayHi()
    {
        return "hi";
    } 

    public void createVehicle(VehicleDto vehicleDTO) {
        vehicleService.create(vehicleDTO);
    }

    public VehicleDto getVehicle(Long id) {
        return vehicleService.findById(id);
    }

    public List<VehicleDto> findAllVehicles() {
        return vehicleService.findAll();
    }

    public void updateVehicle(VehicleDto vehicleDTO) {
        vehicleService.update(vehicleDTO);
    }

    public void removeVehicle(VehicleDto vehicleDTO) {
        vehicleService.delete(vehicleDTO.getId());
    }
}
