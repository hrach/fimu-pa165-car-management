/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.soap;

import cz.muni.fi.pa165.carmanagement.api.dto.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.api.service.EmployeeService;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author zvonicek
 */
@WebService
public class EmployeeManagerImpl {

    @Autowired
    private EmployeeService employeeService;    

    @WebMethod(exclude=true)
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }       
    
    @WebMethod(operationName="createEmployee")        
    public void createEmployee(EmployeeDto employeeDTO) {
        employeeService.create(employeeDTO);
    }

    @WebMethod(operationName="getEmployee")            
    public EmployeeDto getEmployee(Long id) {
        return employeeService.findById(id);
    }

    @WebMethod(operationName="findAllEmployees")                
    public List<EmployeeDto> findAllEmployees() {
        return employeeService.findAll();
    }

    @WebMethod(operationName="updateEmployee")                
    public void updateEmployee(EmployeeDto employeeDTO) {
        employeeService.update(employeeDTO);
    }

    @WebMethod(operationName="removeEmployee")                    
    public void removeEmployee(EmployeeDto employeeDTO) {
        employeeService.delete(employeeDTO.getId());
    }
}
