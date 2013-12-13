package cz.muni.fi.pa165.carmanagement.impl.converters;

import cz.muni.fi.pa165.carmanagement.api.dto.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.impl.model.Employee;

/**
 * @author skrasek
 */
public class EmployeeConverter extends GeneralConverter<Employee, EmployeeDto> {
    
    public EmployeeDto entityToDto(Employee entity, Converter parent) {
        if (entity == null) {
            return null;
        }
        
        EmployeeDto dto = new EmployeeDto();
        
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setFamilyName(entity.getFamilyName());
        dto.setEmployeeRole(entity.getEmployeeRole());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        
        RideConverter rc = ConverterContainer.getRideConverter();
        if (!(parent == rc)) {
            dto.setRides(rc.entityToDto(entity.getRides(), this));
        }

        return dto;
    }

    public Employee dtoToEntity(EmployeeDto dto, Converter parent) {
        if (dto == null) {
            return null;
        }

        Employee entity = new Employee();
        
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setFamilyName(dto.getFamilyName());
        entity.setEmployeeRole(dto.getEmployeeRole());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        
        RideConverter rc = ConverterContainer.getRideConverter();
        if (!(parent == rc)) {
            entity.setRides(rc.dtoToEntity(dto.getRides(), this));
        }

        return entity;
    }

}
