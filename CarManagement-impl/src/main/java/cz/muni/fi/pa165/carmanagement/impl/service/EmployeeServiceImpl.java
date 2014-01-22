package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.dto.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.api.service.EmployeeService;
import cz.muni.fi.pa165.carmanagement.impl.converters.ConverterContainer;
import cz.muni.fi.pa165.carmanagement.impl.dao.EmployeeDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;


/**
 * @author Jakub Marecek <xmarec at gmail.com>
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDaoImpl dao;
    
    @Autowired
    private ShaPasswordEncoder passwordEncoder;   
    
    public void setDao(EmployeeDaoImpl dao) {
        this.dao = dao;
    }

    public void setPasswordEncoder(ShaPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }    

    @Transactional
    @Override
    @Secured({"ROLE_MANAGER", "ROLE_SOAP"})
    public EmployeeDto create(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            throw new NullPointerException("employeeDto");
        }
               
        employeeDto.setId(null);
                
        Employee entity = ConverterContainer.getEmployeeConverter().dtoToEntity(employeeDto);                
        entity.setPassword(passwordEncoder.encodePassword(entity.getPassword(), null));

        dao.persist(entity);   
        
        return ConverterContainer.getEmployeeConverter().entityToDto(entity);
    }

    @Transactional
    @Override     
    @Secured({"ROLE_MANAGER", "ROLE_SOAP"})    
    public void delete(Long id) {
        if (id == null) {
            throw new NullPointerException("id");
        }
        
        dao.remove(dao.findById(id));
    }

    @Transactional
    @Override        
    @Secured({"ROLE_STAFF", "ROLE_SOAP"})    
    public void update(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            throw new NullPointerException("employeeDto");
        }
        
        Employee entity = ConverterContainer.getEmployeeConverter().dtoToEntity(employeeDto);
        entity.setPassword(passwordEncoder.encodePassword(entity.getPassword(), null));
        
        dao.update(entity);        
    }

    @Transactional
    @Override        
    @Secured({"ROLE_STAFF", "ROLE_SOAP"})    
    public EmployeeDto findById(Long id) {
        if (id == null) {
            throw new NullPointerException("id");
        }
        
        return ConverterContainer.getEmployeeConverter().entityToDto(dao.findById(id));
    }

    @Transactional
    @Override     
    @Secured({"ROLE_STAFF", "ROLE_SOAP"})        
    public List<EmployeeDto> findAll() {
        return ConverterContainer.getEmployeeConverter().entityToDto(dao.findAll());
    }
}
