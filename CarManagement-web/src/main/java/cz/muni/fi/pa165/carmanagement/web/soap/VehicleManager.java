package cz.muni.fi.pa165.carmanagement.web.soap;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author zvonicek
 */

@WebService
public interface VehicleManager {
    
    String sayHi();
    
    void createVehicle(@WebParam(name = "vehicleDto")VehicleDto vehicleDTO);
    
    public VehicleDto getVehicle(@WebParam(name = "id")Long id);
    
    public List<VehicleDto> findAllVehicles();
    
    void updateVehicle(@WebParam(name = "vehicleDto")VehicleDto vehicleDTO);
    
    void removeVehicle(@WebParam(name = "vehicleDto")VehicleDto vehicleDTO);       
}