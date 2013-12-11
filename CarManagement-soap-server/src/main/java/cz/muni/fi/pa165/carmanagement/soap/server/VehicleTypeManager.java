/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.soap.server;

import cz.muni.fi.pa165.carmanagement.api.dto.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.api.dto.VehicleTypeDto;
import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author tomasbobek
 */

@WebService
public interface VehicleTypeManager {
    
    public VehicleTypeDto getVehicleType(@WebParam(name = "id")Long id);
    
    public List<VehicleTypeDto> findAllVehicleTypes();
    
}
