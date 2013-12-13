package cz.muni.fi.pa165.carmanagement.impl.converters;

import cz.muni.fi.pa165.carmanagement.api.dto.ServiceIntervalDto;
import cz.muni.fi.pa165.carmanagement.impl.model.ServiceInterval;

/**
 * @author skrasek
 */
public class ServiceIntervalConverter extends GeneralConverter<ServiceInterval, ServiceIntervalDto> {
    
    public ServiceIntervalDto entityToDto(ServiceInterval entity, Converter parent) {
        if (entity == null) {
            return null;
        }
        
        ServiceIntervalDto dto = new ServiceIntervalDto();
        
        dto.setId(entity.getId());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setDueTime(entity.getDueTime());
        dto.setDoneTime(entity.getDoneTime());

        ServiceTypeConverter stc = ConverterContainer.getServiceTypeConverter();
        VehicleConverter vc      = ConverterContainer.getVehicleConverter();
        if (!(parent == stc)) {
            dto.setServiceType(stc.entityToDto(entity.getServiceType(), this));
        }
        if (!(parent == vc)) {
            dto.setVehicle(vc.entityToDto(entity.getVehicle(), this));
        }

        return dto;
    }
    
    public ServiceInterval dtoToEntity(ServiceIntervalDto dto, Converter parent) {
        if (dto == null) {
            return null;
        }
        
        ServiceInterval entity = new ServiceInterval();
        
        entity.setId(dto.getId());
        entity.setCreatedTime(dto.getCreatedTime());
        entity.setDueTime(dto.getDueTime());
        entity.setDoneTime(dto.getDoneTime());

        ServiceTypeConverter stc = ConverterContainer.getServiceTypeConverter();
        VehicleConverter vc      = ConverterContainer.getVehicleConverter();
        if (!(parent == stc)) {
            entity.setServiceType(stc.dtoToEntity(dto.getServiceType(), this));
        }
        if (!(parent == vc)) {
            entity.setVehicle(vc.dtoToEntity(dto.getVehicle(), this));
        }

        return entity;
    }
    
}
