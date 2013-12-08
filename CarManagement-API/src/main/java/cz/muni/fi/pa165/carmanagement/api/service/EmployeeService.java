package cz.muni.fi.pa165.carmanagement.api.service;

import cz.muni.fi.pa165.carmanagement.api.dto.EmployeeDto;
import java.util.List;

/**
 * @author Jakub Marecek <xmarec at gmail.com>
 */
public interface EmployeeService {
    
    public EmployeeDto create(EmployeeDto employeeDto);

    public void delete(Long id);

    public void update(EmployeeDto employeeDto);

    public EmployeeDto findById(Long id);

    public List<EmployeeDto> findAll(); 

}
