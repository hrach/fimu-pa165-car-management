/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pa165.carmanagement.api.service;

import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import cz.muni.fi.pa165.carmanagement.api.dto.ServiceIntervalDto;
import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import java.util.List;

/**
 *
 * @author Jakub Marecek <xmarec at gmail.com>
 */
public interface VehicleService {

    public VehicleDto create(VehicleDto v);

    public void delete(Long id);

    public void update(VehicleDto v);
    
    public VehicleDto findById(Long id);
    
    public List<VehicleDto> findAll();       
    
    public List<RideDto> getRidesForVehicle(Long id);
    
    public List<ServiceIntervalDto> getServiceIntervalsForVehicle(Long id);    
}
