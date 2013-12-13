package cz.muni.fi.pa165.carmanagement.impl.converters;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleTypeDto;
import cz.muni.fi.pa165.carmanagement.impl.model.VehicleType;

/**
 * @author skrasek
 */
public class VehicleTypeConverter extends GeneralConverter<VehicleType, VehicleTypeDto> {
    
    public VehicleTypeDto entityToDto(VehicleType entity, Converter parent) {
        if (entity == null) {
            return null;
        }
        
        VehicleTypeDto dto = new VehicleTypeDto();
        dto.setId(entity.getId());
        dto.setMaxKm(entity.getMaxKm());
        dto.setName(entity.getName());
        
        return dto;
    }

    public VehicleType dtoToEntity(VehicleTypeDto dto, Converter parent) {
        if (dto == null) {
            return null;
        }
        
        VehicleType entity = new VehicleType();
        entity.setId(dto.getId());
        entity.setMaxKm(dto.getMaxKm());
        entity.setName(dto.getName());
        
        return entity;
    }

}
