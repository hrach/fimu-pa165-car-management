/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.soap.server;

import cz.muni.fi.pa165.carmanagement.api.dto.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.api.service.EmployeeService;
import java.util.List;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zvonicek
 */
@Component
@WebService(endpointInterface = "cz.muni.fi.pa165.carmanagement.soap.server.EmployeeManager", serviceName = "EmployeeManager")
public class EmployeeManagerImpl implements EmployeeManager {

   @Autowired
   private EmployeeService employeeService;    
    
    public void createEmployee(EmployeeDto employeeDTO) {
        employeeService.create(employeeDTO);
    }

    public EmployeeDto getEmployee(Long id) {
        return employeeService.findById(id);
    }

    public List<EmployeeDto> findAllEmployees() {
        return employeeService.findAll();
    }

    public void updateEmployee(EmployeeDto employeeDTO) {
        employeeService.update(employeeDTO);
    }

    public void removeEmployee(EmployeeDto employeeDTO) {
        employeeService.delete(employeeDTO.getId());
    }
}
