package cz.muni.fi.pa165.carmanagement.api.service;

import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import java.util.List;

/**
 * @author Jakub Marecek <xmarec at gmail.com>
 */
public interface RideService {
    
    public RideDto create(RideDto rideDto);

    public void delete(Long id);

    public void update(RideDto rideDto);

    public RideDto findById(Long id);

    public List<RideDto> findAll(); 

}
