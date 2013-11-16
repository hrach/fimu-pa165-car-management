/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pa165.carmanagement.api.service;

import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jakub Marecek <xmarec at gmail.com>
 */

@Service
public interface RideService {
    
    public void create(RideDto rideDto);

    public void delete(Long id);

    public void update(RideDto rideDto);

    public RideDto findById(Long id);

    public List<RideDto> findAll(); 
    
}
