package cz.muni.pa165.carmanagment.service;

import cz.muni.pa165.carmanagment.dto.VehicleDto;
import cz.muni.pa165.carmanagment.dto.VehicleTypeDto;
import java.util.List;

/**
 *
 * @author zvonicek
 */

public interface VehicleTypeService
{

    public void create(VehicleTypeDto type);

    public void delete(Long id);

    public void update(VehicleTypeDto type);

    public VehicleTypeDto findById(Long id);

    public List<VehicleTypeDto> findAll();   
    
    public List<VehicleDto> getVehiclesForType(Long id);
}
