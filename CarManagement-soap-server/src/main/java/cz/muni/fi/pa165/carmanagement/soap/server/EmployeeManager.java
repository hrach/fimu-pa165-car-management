package cz.muni.fi.pa165.carmanagement.soap.server;

import cz.muni.fi.pa165.carmanagement.api.dto.EmployeeDto;
import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author zvonicek
 */

@WebService
public interface EmployeeManager {
    void createEmployee(@WebParam(name = "employeeDto")EmployeeDto employeeDTO);
    
    public EmployeeDto getEmployee(@WebParam(name = "id")Long id);
    
    public List<EmployeeDto> findAllEmployees();
    
    void updateEmployee(@WebParam(name = "employeeDto")EmployeeDto employeeDTO);
    
    void removeEmployee(@WebParam(name = "employeeDto")EmployeeDto employeeDTO);    
}
