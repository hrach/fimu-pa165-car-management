package cz.muni.fi.pa165.carmanagement.api.service;

import cz.muni.fi.pa165.carmanagement.api.dto.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author Jakub Marecek <xmarec at gmail.com>
 */
@Service
public interface EmployeeService<E> extends ServiceInterface<E, EmployeeDto> {
    
    public EmployeeDto create(EmployeeDto employeeDto);

    public void delete(Long id);

    public void update(EmployeeDto employeeDto);

    public EmployeeDto findById(Long id);

    public List<EmployeeDto> findAll(); 

}
