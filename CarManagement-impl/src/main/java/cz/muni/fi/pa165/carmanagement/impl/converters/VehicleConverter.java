package cz.muni.fi.pa165.carmanagement.impl.converters;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import cz.muni.fi.pa165.carmanagement.impl.model.Vehicle;

/**
 * @author skraksek
 */
public class VehicleConverter extends GeneralConverter<Vehicle, VehicleDto> {
    
    public VehicleDto entityToDto(Vehicle entity, Converter parent) {
        if (entity == null) {
            return null;
        }
        
        VehicleDto dto = new VehicleDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setTachometer(entity.getTachometer());
        dto.setConstructionYear(entity.getConstructionYear());
        dto.setFuel(entity.getFuel());
        dto.setRegistrationPlate(entity.getRegistrationPlate());
        dto.setVIN(entity.getVIN());
        
        VehicleTypeConverter vtc     = ConverterContainer.getVehicleTypeConverter();
        RideConverter rc             = ConverterContainer.getRideConverter();
        ServiceIntervalConverter sic = ConverterContainer.getServiceIntervalConverter();
        if (!(parent == vtc)) {
            dto.setType(vtc.entityToDto(entity.getType(), this));
        }
        if (!(parent == rc)) {
            dto.setRides(rc.entityToDto(entity.getRides(), this));
        }
        if (!(parent == sic)) {
            dto.setServiceIntervals(sic.entityToDto(entity.getServiceIntervals(), this));
        }

        return dto;    
    }

    public Vehicle dtoToEntity(VehicleDto dto, Converter parent) {
        if (dto == null) {
            return null;
        }
        
        Vehicle entity = new Vehicle();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setTchometer(dto.getTachometer());
        entity.setConstructionYear(dto.getConstructionYear());
        entity.setFuel(dto.getFuel());
        entity.setRegistrationPlate(dto.getRegistrationPlate());
        entity.setVIN(dto.getVIN());
        
        VehicleTypeConverter vtc     = ConverterContainer.getVehicleTypeConverter();
        RideConverter rc             = ConverterContainer.getRideConverter();
        ServiceIntervalConverter sic = ConverterContainer.getServiceIntervalConverter();
        if (!(parent == vtc)) {
            entity.setType(vtc.dtoToEntity(dto.getType(), this));
        }
        if (!(parent == rc)) {
            entity.setRides(rc.dtoToEntity(dto.getRides(), this));
        }
        if (!(parent == sic)) {
            entity.setServiceIntervals(sic.dtoToEntity(dto.getServiceIntervals(), this));
        }
        
        return entity;        
    }

}
