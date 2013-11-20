package cz.muni.fi.pa165.carmanagement.api.service;

import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import cz.muni.fi.pa165.carmanagement.api.dto.ServiceIntervalDto;
import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import java.util.List;

/**
 * @author Jakub Marecek <xmarec at gmail.com>
 */
public interface VehicleService<E> extends ServiceInterface<E, VehicleDto> {

    public VehicleDto create(VehicleDto v);

    public void delete(Long id);

    public void update(VehicleDto v);
    
    public VehicleDto findById(Long id);
    
    public List<VehicleDto> findAll();       

}
