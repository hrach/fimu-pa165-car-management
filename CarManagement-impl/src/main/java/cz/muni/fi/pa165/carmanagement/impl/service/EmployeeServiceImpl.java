
package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.dto.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import cz.muni.fi.pa165.carmanagement.api.service.EmployeeService;
import cz.muni.fi.pa165.carmanagement.impl.converter.EmployeeConverter;
import cz.muni.fi.pa165.carmanagement.impl.converter.RideConverter;
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
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    private EmployeeDaoImpl dao;

    public void setDao(EmployeeDaoImpl dao) {
        this.dao = dao;
    }

    @Transactional
    @Override        
    public EmployeeDto create(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            throw new NullPointerException("employeeDto");
        }
        
        employeeDto.setId(null);
        
        Employee entity = EmployeeConverter.dtoToEntity(employeeDto);
        dao.persist(entity);   
        
        return EmployeeConverter.entityToDto(entity);
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
        
        dao.update(EmployeeConverter.dtoToEntity(employeeDto));        
    }

    @Transactional
    @Override        
    public EmployeeDto findById(Long id) {
        if (id == null){
            throw new NullPointerException("id");
        }
        
        return EmployeeConverter.entityToDto(dao.findById(id));
    }

    @Transactional
    @Override        
    public List<EmployeeDto> findAll() {
        return EmployeeConverter.entityToDto(dao.findAll());
    }
    
    @Transactional
    @Override        
    public List<RideDto> getRidesForEmployee(Long id) {
        Employee e = dao.findById(id);
        
        List<Ride> rides = e.getRides();
        
        return RideConverter.entityToDto(rides);        
    }
    
}
