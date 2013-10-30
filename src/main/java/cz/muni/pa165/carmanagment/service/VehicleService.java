/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.pa165.carmanagment.service;

import cz.muni.pa165.carmanagment.dto.RideDto;
import cz.muni.pa165.carmanagment.dto.VehicleDto;
import java.util.List;

/**
 *
 * @author Jakub Marecek <xmarec at gmail.com>
 */
public interface VehicleService {

    public void create(VehicleDto v);

    public void delete(Long id);

    public void update(VehicleDto v);
    
    public VehicleDto findById(Long id);
    
    public List<VehicleDto> findAll();   
    
    public List<VehicleDto> getAvailableVehicles();
    
    public List<RideDto> getRidesForVehicle(Long id);
}
