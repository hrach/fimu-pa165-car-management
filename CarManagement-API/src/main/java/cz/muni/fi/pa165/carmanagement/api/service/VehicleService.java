package cz.muni.fi.pa165.carmanagement.api.service;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import java.util.List;

/**
 * @author Jakub Marecek <xmarec at gmail.com>
 */
public interface VehicleService {

    public VehicleDto create(VehicleDto v);

    public void delete(Long id);

    public void update(VehicleDto v);
    
    public VehicleDto findById(Long id);
    
    public List<VehicleDto> findAll();       

}
