package cz.muni.fi.pa165.carmanagement.impl.converters;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import cz.muni.fi.pa165.carmanagement.impl.model.Vehicle;

/**
 * @author skraksek
 */
public class VehicleConverter extends GeneralConverter<Vehicle, VehicleDto> {
    
    public VehicleDto entityToDto(Vehicle entity, ConverterInterface parent) {
        if (entity == null) {
            return null;
        }
        
        VehicleDto dto = new VehicleDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setTachometer(entity.getTachometer());
        
        VehicleTypeConverter vtc = ConverterContainer.getVehicleTypeConverter();
        if (!(parent == vtc)) {
            dto.setType(vtc.entityToDto(entity.getType(), this));
        }

        return dto;    
    }

    public Vehicle dtoToEntity(VehicleDto dto, ConverterInterface parent) {
        if (dto == null) {
            return null;
        }
        
        Vehicle entity = new Vehicle();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setTchometer(dto.getTachometer());
        
        VehicleTypeConverter vtc = ConverterContainer.getVehicleTypeConverter();
        if (!(parent == vtc)) {
            entity.setType(vtc.dtoToEntity(dto.getType(), this));
        }
        
        return entity;        
    }


}
