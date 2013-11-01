/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.pa165.carmanagment.converter;

import cz.muni.pa165.carmanagment.dto.RideDto;
import cz.muni.pa165.carmanagment.model.Ride;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Jakub Marecek <xmarec at gmail.com>
 */
public class RideConverter {
    
    public static RideDto entityToDto (Ride entity){
        
        if (entity == null){
            return null;
        }
        
        RideDto dto = new RideDto();
        
        dto.setId(entity.getId());
        dto.setStartTime(entity.getStartTime());
        dto.setEndTime(entity.getEndTime());
        dto.setTachometerStart(entity.getTachometerStart());
        dto.setTachometerEnd(entity.getTachometerEnd());
        dto.setDescription(entity.getDescription());

        dto.setEmployee(EmployeeConverter.entityToDto(entity.getEmployee()));

        dto.setVehicle(VehicleConverter.entityToDto(entity.getVehicle()));
               
        return dto;
    }
    
    public static List<RideDto> entityToDto (List<Ride> entities){
        if (entities == null){
            return null;
        }
        
        List<RideDto> list = new ArrayList<RideDto>();
        for (Ride ride : entities) {
            list.add(RideConverter.entityToDto(ride));
        }
        
        return list;
    }
    
    public static Ride dtoToEntity(RideDto dto){
        if (dto == null){
            return null;
        }
        
        Ride entity = new Ride();
        
        entity.setId(dto.getId());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());
        entity.setTachometerStart(dto.getTachometerStart());
        entity.setTachometerEnd(dto.getTachometerEnd());
        entity.setDescription(dto.getDescription());
        
        entity.setEmployee(EmployeeConverter.dtoToEntity(dto.getEmployee()));
        
        entity.setVehicle(VehicleConverter.dtoToEntity(dto.getVehicle()));
        
        return entity;
    }
    
    public static List<Ride> dtoToEntity (List<RideDto> dtos){
        if (dtos == null){
            return null;
        }
        
        List<Ride> list = new ArrayList<Ride>();
        for (RideDto rideDto : dtos) {
            list.add(RideConverter.dtoToEntity(rideDto));
        }
        
        return list;
    }
}
