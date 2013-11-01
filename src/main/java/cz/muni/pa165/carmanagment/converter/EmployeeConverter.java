/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.pa165.carmanagment.converter;

import cz.muni.pa165.carmanagment.dto.EmployeeDto;
import cz.muni.pa165.carmanagment.model.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jakub Marecek <xmarec at gmail.com>
 */
public class EmployeeConverter {
    
    public static EmployeeDto entityToDto(Employee entity) {
        if (entity == null){
            return null;
        }
        
        EmployeeDto dto = new EmployeeDto();
        
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setFamilyName(entity.getFamilyName());
        dto.setEmployeeRole(entity.getEmployeeRole());
        
        dto.setRides(RideConverter.entityToDto(entity.getRides()));
                
        return dto;
    }
    
    public static List<EmployeeDto> entityToDto (List<Employee> entities){
        if (entities == null){
            return null;
        }
        
        List<EmployeeDto> list = new ArrayList<EmployeeDto>();
        for (Employee employee : entities) {
            list.add(EmployeeConverter.entityToDto(employee));
        }
        
        return list;
    }
    
    public static Employee dtoToEntity(EmployeeDto dto){
        if (dto == null){
            return null;
        }
        
        Employee entity = new Employee();
        
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setFamilyName(dto.getFamilyName());
        entity.setEmployeeRole(dto.getEmployeeRole());
        entity.setRides(RideConverter.dtoToEntity(dto.getRides()));
        
        return entity;
    }
    
    public static List<Employee> dtoToEntity (List<EmployeeDto> dtos){
        if (dtos == null){
            return null;
        }
        
        List<Employee> list = new ArrayList<Employee>();
        for (EmployeeDto employeeDto : dtos) {
            list.add(EmployeeConverter.dtoToEntity(employeeDto));
        }
        
        return list;
    }
}
