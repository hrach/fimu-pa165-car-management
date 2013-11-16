/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pa165.carmanagement.impl.converter;

import cz.muni.fi.pa165.carmanagement.api.dto.ServiceTypeDto;
import cz.muni.fi.pa165.carmanagement.impl.model.ServiceType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zvonicek
 */
public class ServiceTypeConverter {

    public static ServiceTypeDto entityToDto(ServiceType entity) {
        if (entity == null)
            return null;
        
        ServiceTypeDto dto = new ServiceTypeDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        
        return dto;      
    }

    public static ServiceType dtoToEntity(ServiceTypeDto dto) {
        if (dto == null)
            return null;
        
        ServiceType entity = new ServiceType();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        
        return entity;     
    }
    

    public static List<ServiceTypeDto> entityToDto(List<ServiceType> entities) {
        if (entities == null)
            return null;
        
        List<ServiceTypeDto> list = new ArrayList<ServiceTypeDto>();
        for (ServiceType type : entities) {
            list.add(ServiceTypeConverter.entityToDto(type));
        }
        
        return list;
    }      
    
    public static List<ServiceType> dtoToEntity(List<ServiceTypeDto> entities) {
        if (entities == null)
            return null;
        
        List<ServiceType> list = new ArrayList<ServiceType>();
        for (ServiceTypeDto type : entities) {
            list.add(ServiceTypeConverter.dtoToEntity(type));
        }
        
        return list;
    }  

}
