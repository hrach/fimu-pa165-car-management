/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.pa165.carmanagment.service;

import cz.muni.pa165.carmanagment.converter.EmployeeConverter;
import cz.muni.pa165.carmanagment.converter.RideConverter;
import cz.muni.pa165.carmanagment.dao.EmployeeDaoImpl;
import cz.muni.pa165.carmanagment.dto.EmployeeDto;
import cz.muni.pa165.carmanagment.dto.RideDto;
import cz.muni.pa165.carmanagment.model.Employee;
import cz.muni.pa165.carmanagment.model.Ride;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jakub Marecek <xmarec at gmail.com>
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {
     
    private EmployeeDaoImpl dao;

    public void create(EmployeeDto employeeDto) {
        
        if (employeeDto == null) {
            throw new IllegalArgumentException("Attribute employeeDto is null");
        }
        
        Employee entity = EmployeeConverter.dtoToEntity(employeeDto);
        
        dao.persist(entity);        
    }

    public void delete(Long id) {
        if (id == null){
            throw new IllegalArgumentException("ID is null");
        }
        
        dao.remove(dao.findById(id));
    }

    public void update(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            throw new IllegalArgumentException("Attribute employeeDto is null");
        }
        
        dao.update(EmployeeConverter.dtoToEntity(employeeDto));        
    }

    public EmployeeDto findById(Long id) {
        if (id == null){
            throw new IllegalArgumentException("ID is null");
        }
        
        return EmployeeConverter.entityToDto(dao.findById(id));
    }

    public List<EmployeeDto> findAll() {
        return EmployeeConverter.entityToDto(dao.findAll());
    }
    
    public List<RideDto> getRidesForEmployee(Long id) {
        Employee e = dao.findById(id);
        
        List<Ride> rides = e.getRides();
        
        return RideConverter.entityToDto(rides);        
    }
    
}
