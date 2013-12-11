/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.soap.client;

import cz.muni.fi.pa165.carmanagement.soap.server.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.soap.server.EmployeeManager;
import cz.muni.fi.pa165.carmanagement.soap.server.EmployeeManager_Service;
import cz.muni.fi.pa165.carmanagement.soap.server.VehicleDto;
import cz.muni.fi.pa165.carmanagement.soap.server.VehicleManager;
import cz.muni.fi.pa165.carmanagement.soap.server.VehicleManager_Service;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author tomasbobek
 */

@Controller
@RequestMapping("/")
public class MainController {
    
    public MainController() {

    }    
    
    @RequestMapping("/index")
    public ModelAndView renderMain() {
        ModelAndView mav = new ModelAndView();        
        
        VehicleManager_Service vehicleManagerService = new VehicleManager_Service();
        VehicleManager manVehicle = vehicleManagerService.getVehicleManagerImplPort();
        List<VehicleDto> vehicles = manVehicle.findAllVehicles();
        
        EmployeeManager_Service employeeManagerService = new EmployeeManager_Service();
        EmployeeManager manEmployee = employeeManagerService.getEmployeeManagerImplPort();
        List<EmployeeDto> employees = manEmployee.findAllEmployees();
        
        mav.addObject("vehicles", vehicles);
        mav.addObject("employees", employees);
        
        System.out.println("Vehicles: " + vehicles.size() + "; Employees: " + employees.size());
        
        mav.setViewName("index");
        return mav;
    }
    
}
