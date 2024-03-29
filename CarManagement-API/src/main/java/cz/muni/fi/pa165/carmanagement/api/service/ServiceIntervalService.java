package cz.muni.fi.pa165.carmanagement.api.service;

import cz.muni.fi.pa165.carmanagement.api.dto.ServiceIntervalDto;
import cz.muni.fi.pa165.carmanagement.api.dto.ServiceTypeDto;
import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import java.util.List;

/**
 * @author Jakub Marecek <xmarec at gmail.com>
 */
public interface ServiceIntervalService {
    
    public ServiceIntervalDto create(ServiceIntervalDto serviceIntervalDto);

    public void delete(Long id);

    public void update(ServiceIntervalDto serviceIntervalDto);

    public ServiceIntervalDto findById(Long id);

    public List<ServiceIntervalDto> findAll(); 
        
    public void setIntervalAsDoneForId(Long id);
    
    public ServiceIntervalDto updateServiceIntervalAsDone(VehicleDto vehicle, ServiceTypeDto newServiceType);

}
