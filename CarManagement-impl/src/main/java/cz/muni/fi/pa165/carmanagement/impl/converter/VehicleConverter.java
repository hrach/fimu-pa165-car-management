/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pa165.carmanagement.impl.converter;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import cz.muni.fi.pa165.carmanagement.impl.model.Vehicle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zvonicek
 */
public class VehicleConverter {

    public static Vehicle dtoToEntity(VehicleDto dto) {
        if (dto == null)
            return null;
        
        Vehicle entity = new Vehicle();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setTchometer(dto.getTachometer());
        entity.setType(VehicleTypeConverter.dtoToEntity(dto.getType()));
        
        return entity;        
    }

    public static VehicleDto entityToDto(Vehicle entity) {
        if (entity == null)
            return null;
        
        VehicleDto dto = new VehicleDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setTachometer(entity.getTachometer());
        dto.setType(VehicleTypeConverter.entityToDto(entity.getType()));
        
        return dto;    
    }

    public static List<VehicleDto> entityToDto(List<Vehicle> entities) {
        if (entities == null)
            return null;
        
        List<VehicleDto> list = new ArrayList<VehicleDto>();
        for (Vehicle vehicle : entities) {
            list.add(VehicleConverter.entityToDto(vehicle));
        }
        
        return list;
    }    
    
    public static List<Vehicle> dtoToEntity(List<VehicleDto> entities) {
        if (entities == null)
            return null;
        
        List<Vehicle> list = new ArrayList<Vehicle>();
        for (VehicleDto vehicle : entities) {
            list.add(VehicleConverter.dtoToEntity(vehicle));
        }
        
        return list;
    }
}
