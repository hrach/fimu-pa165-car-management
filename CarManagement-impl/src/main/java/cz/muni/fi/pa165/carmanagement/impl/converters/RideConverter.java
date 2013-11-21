package cz.muni.fi.pa165.carmanagement.impl.converters;

import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import cz.muni.fi.pa165.carmanagement.impl.model.Ride;

/**
 * @author skrasek
 */
public class RideConverter extends GeneralConverter<Ride, RideDto> {
     
    public RideDto entityToDto(Ride entity, ConverterInterface parent) {
        if (entity == null) {
            return null;
        }

        RideDto dto = new RideDto();
        
        dto.setId(entity.getId());
        dto.setStartTime(entity.getStartTime());
        dto.setEndTime(entity.getEndTime());
        dto.setTachometerStart(entity.getTachometerStart());
        dto.setTachometerEnd(entity.getTachometerEnd());
        dto.setDescription(entity.getDescription());

        EmployeeConverter ec = ConverterContainer.getEmployeeConverter();
        VehicleConverter vc  = ConverterContainer.getVehicleConverter();
        if (!(parent == ec)) {
            dto.setEmployee(ec.entityToDto(entity.getEmployee(), this));
        }
        if (!(parent == vc)) {
            dto.setVehicle(vc.entityToDto(entity.getVehicle(), this));
        }

        return dto;
    }
    
    public Ride dtoToEntity(RideDto dto, ConverterInterface parent) {
        if (dto == null) {
            return null;
        }

        Ride entity = new Ride();
        
        entity.setId(dto.getId());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());
        entity.setTachometerStart(dto.getTachometerStart());
        entity.setTachometerEnd(dto.getTachometerEnd());
        entity.setDescription(dto.getDescription());
        
        EmployeeConverter ec = ConverterContainer.getEmployeeConverter();
        VehicleConverter vc  = ConverterContainer.getVehicleConverter();
        if (!(parent == ec)) {
            entity.setEmployee(ec.dtoToEntity(dto.getEmployee(), this));
        } 
        if (!(parent == vc)) {        
            entity.setVehicle(vc.dtoToEntity(dto.getVehicle(), this));
        }

        return entity;
    }

}
