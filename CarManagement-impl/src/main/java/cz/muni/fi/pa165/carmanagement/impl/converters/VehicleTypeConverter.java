package cz.muni.fi.pa165.carmanagement.impl.converters;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleTypeDto;
import cz.muni.fi.pa165.carmanagement.impl.model.VehicleType;

/**
 * @author skrasek
 */
public class VehicleTypeConverter extends GeneralConverter<VehicleType, VehicleTypeDto> {
    
    
    public VehicleTypeDto entityToDto(VehicleType entity, ConverterInterface parent) {
        if (entity == null) {
            return null;
        }
        
        VehicleTypeDto dto = new VehicleTypeDto();
        dto.setId(entity.getId());
        dto.setMaxKm(entity.getMaxKm());
        
        return dto;
    }

    public VehicleType dtoToEntity(VehicleTypeDto dto, ConverterInterface parent) {
        if (dto == null) {
            return null;
        }
        
        VehicleType entity = new VehicleType();
        entity.setId(dto.getId());
        entity.setMaxKm(dto.getMaxKm());
        
        return entity;
    }

}
