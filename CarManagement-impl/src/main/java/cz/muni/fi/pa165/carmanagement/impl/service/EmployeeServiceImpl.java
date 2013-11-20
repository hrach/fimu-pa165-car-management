
package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.service.ServiceInterface;
import cz.muni.fi.pa165.carmanagement.api.dto.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.api.service.EmployeeService;
import cz.muni.fi.pa165.carmanagement.api.service.RideService;
import cz.muni.fi.pa165.carmanagement.impl.dao.EmployeeDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.Employee;
import cz.muni.fi.pa165.carmanagement.impl.model.Ride;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jakub Marecek <xmarec at gmail.com>
 */
@Service
public class EmployeeServiceImpl extends GeneralService<Employee, EmployeeDto> implements EmployeeService<Employee> {

    @Autowired
    private EmployeeDaoImpl dao;

    public void setDao(EmployeeDaoImpl dao) {
        this.dao = dao;
    }

    
    @Autowired
    private RideService<Ride> rideService;


    @Transactional
    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            throw new NullPointerException("employeeDto");
        }
        
        employeeDto.setId(null);
        
        Employee entity = this.dtoToEntity(employeeDto);
        dao.persist(entity);   
        
        return this.entityToDto(entity);
    }

    @Transactional
    @Override        
    public void delete(Long id) {
        if (id == null){
            throw new NullPointerException("id");
        }
        
        dao.remove(dao.findById(id));
    }

    @Transactional
    @Override        
    public void update(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            throw new NullPointerException("employeeDto");
        }
        
        dao.update(this.dtoToEntity(employeeDto));        
    }

    @Transactional
    @Override        
    public EmployeeDto findById(Long id) {
        if (id == null){
            throw new NullPointerException("id");
        }
        
        return this.entityToDto(dao.findById(id));
    }

    @Transactional
    @Override        
    public List<EmployeeDto> findAll() {
        return this.entityToDto(dao.findAll());
    }
    

    public EmployeeDto entityToDto(Employee entity, ServiceInterface parent) {
        if (entity == null){
            return null;
        }
        
        EmployeeDto dto = new EmployeeDto();
        
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setFamilyName(entity.getFamilyName());
        dto.setEmployeeRole(entity.getEmployeeRole());
        
        if (!(parent instanceof RideService)) {
            dto.setRides(this.rideService.entityToDto(entity.getRides(), this));
        }

        return dto;
    }

    public Employee dtoToEntity(EmployeeDto dto, ServiceInterface parent) {
        if (dto == null) {
            return null;
        }

        Employee entity = new Employee();
        
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setFamilyName(dto.getFamilyName());
        entity.setEmployeeRole(dto.getEmployeeRole());
        
        if (!(parent instanceof RideService)) {
            entity.setRides(this.rideService.dtoToEntity(dto.getRides(), this));
        }

        return entity;
    }
    
}
