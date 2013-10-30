/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.pa165.carmanagment.converter;

import cz.muni.pa165.carmanagment.dto.ServiceTypeDto;
import cz.muni.pa165.carmanagment.model.ServiceType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zvonicek
 */
class ServiceTypeConverter {

    static ServiceTypeDto entityToDto(ServiceType entity) {
        if (entity == null)
            throw new IllegalArgumentException("attribute entity is null");
        
        ServiceTypeDto dto = new ServiceTypeDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        
        return dto;      
    }

    static ServiceType dtoToEntity(ServiceTypeDto dto) {
        if (dto == null)
            throw new IllegalArgumentException("attribute dto is null");
        
        ServiceType entity = new ServiceType();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        
        return entity;     
    }
    

    public static List<ServiceTypeDto> entityToDto(List<ServiceType> entities) {
        if (entities == null)
            throw new IllegalArgumentException("attribute entities is null");
        
        List<ServiceTypeDto> list = new ArrayList<ServiceTypeDto>();
        for (ServiceType type : entities) {
            list.add(ServiceTypeConverter.entityToDto(type));
        }
        
        return list;
    }        
}
