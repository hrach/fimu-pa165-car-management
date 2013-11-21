package cz.muni.fi.pa165.carmanagement.impl.converters;

import cz.muni.fi.pa165.carmanagement.api.dto.ServiceTypeDto;
import cz.muni.fi.pa165.carmanagement.impl.model.ServiceType;

/**
 * @author skrasek
 */
public class ServiceTypeConverter extends GeneralConverter<ServiceType, ServiceTypeDto> {
    
    public ServiceTypeDto entityToDto(ServiceType entity, ConverterInterface parent) {
        if (entity == null)
            return null;
        
        ServiceTypeDto dto = new ServiceTypeDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        
        return dto;      
    }

    public ServiceType dtoToEntity(ServiceTypeDto dto, ConverterInterface parent) {
        if (dto == null)
            return null;

        ServiceType entity = new ServiceType();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        
        return entity;     
    }


}
