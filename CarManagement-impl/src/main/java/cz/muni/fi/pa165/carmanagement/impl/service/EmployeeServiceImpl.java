
package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.dto.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.api.service.EmployeeService;
import cz.muni.fi.pa165.carmanagement.api.service.RideService;
import cz.muni.fi.pa165.carmanagement.impl.converters.ConverterContainer;
import cz.muni.fi.pa165.carmanagement.impl.dao.EmployeeDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.Employee;
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
        
        Employee entity = ConverterContainer.getEmployeeConverter().dtoToEntity(employeeDto);
        dao.persist(entity);   
        
        return ConverterContainer.getEmployeeConverter().entityToDto(entity);
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
        
        dao.update(ConverterContainer.getEmployeeConverter().dtoToEntity(employeeDto));        
    }

    @Transactional
    @Override        
    public EmployeeDto findById(Long id) {
        if (id == null){
            throw new NullPointerException("id");
        }
        
        return ConverterContainer.getEmployeeConverter().entityToDto(dao.findById(id));
    }

    @Transactional
    @Override        
    public List<EmployeeDto> findAll() {
        return ConverterContainer.getEmployeeConverter().entityToDto(dao.findAll());
    }

}
