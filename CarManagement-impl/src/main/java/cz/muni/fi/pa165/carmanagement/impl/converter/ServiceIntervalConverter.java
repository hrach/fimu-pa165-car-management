/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pa165.carmanagement.impl.converter;

import cz.muni.fi.pa165.carmanagement.api.dto.ServiceIntervalDto;
import cz.muni.fi.pa165.carmanagement.impl.model.ServiceInterval;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jakub Marecek <xmarec at gmail.com>
 */
public class ServiceIntervalConverter {
    
    public static ServiceIntervalDto entityToDto(ServiceInterval entity) {
        if (entity == null){
            return null;
        }
        
        ServiceIntervalDto dto = new ServiceIntervalDto();
        
        dto.setId(entity.getId());
        dto.setServiceType(ServiceTypeConverter.entityToDto(entity.getServiceType()));
        dto.setVehicle(VehicleConverter.entityToDto(entity.getVehicle()));
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setDueTime(entity.getDueTime());
        dto.setDoneTime(entity.getDoneTime());
               
        return dto;
    }
    
    public static List<ServiceIntervalDto> entityToDto(List<ServiceInterval> entities) {
        if (entities == null){
            return null;
        }
        
        List<ServiceIntervalDto> list = new ArrayList<ServiceIntervalDto>();
        for (ServiceInterval serviceInterval : entities) {
            list.add(ServiceIntervalConverter.entityToDto(serviceInterval));
        }
        
        return list;
    }

    public static ServiceInterval dtoToEntity(ServiceIntervalDto dto) {
        if (dto == null){
            return null;
        }
        
        ServiceInterval entity = new ServiceInterval();
        
        entity.setId(dto.getId());
        entity.setServiceType(ServiceTypeConverter.dtoToEntity(dto.getServiceType()));
        entity.setVehicle(VehicleConverter.dtoToEntity(dto.getVehicle()));
        entity.setCreatedTime(dto.getCreatedTime());
        entity.setDueTime(dto.getDueTime());
        entity.setDoneTime(dto.getDoneTime());
        
        return entity;
    }
    
    public static List<ServiceInterval> dtoToEntity (List<ServiceIntervalDto> dtos){
        if (dtos == null){
            return null;
        }
        
        List<ServiceInterval> list = new ArrayList<ServiceInterval>();
        for (ServiceIntervalDto serviceIntervalDto : dtos) {
            list.add(ServiceIntervalConverter.dtoToEntity(serviceIntervalDto));
        }
        
        return list;
    }
    
    

    
}
