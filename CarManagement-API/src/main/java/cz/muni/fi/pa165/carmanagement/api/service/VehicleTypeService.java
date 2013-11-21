package cz.muni.fi.pa165.carmanagement.api.service;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleTypeDto;
import java.util.List;

/**
 * @author zvonicek
 */
public interface VehicleTypeService {

    public VehicleTypeDto create(VehicleTypeDto type);

    public void delete(Long id);

    public void update(VehicleTypeDto type);

    public VehicleTypeDto findById(Long id);

    public List<VehicleTypeDto> findAll();   

}
