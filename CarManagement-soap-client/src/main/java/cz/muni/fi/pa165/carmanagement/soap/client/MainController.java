/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.soap.client;

import cz.muni.fi.pa165.carmanagement.soap.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.soap.EmployeeManagerImpl;
import cz.muni.fi.pa165.carmanagement.soap.EmployeeManagerImplService;
import cz.muni.fi.pa165.carmanagement.soap.VehicleDto;
import cz.muni.fi.pa165.carmanagement.soap.VehicleManagerImpl;
import cz.muni.fi.pa165.carmanagement.soap.VehicleManagerImplService;
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
        
        VehicleManagerImplService vehicleManagerService = new VehicleManagerImplService();
        VehicleManagerImpl manVehicle = vehicleManagerService.getVehicleManagerImplPort();
        List<VehicleDto> vehicles = manVehicle.findAllVehicles();
        
        EmployeeManagerImplService employeeManagerService = new EmployeeManagerImplService();
        EmployeeManagerImpl manEmployee = employeeManagerService.getEmployeeManagerImplPort();
        List<EmployeeDto> employees = manEmployee.findAllEmployees();
        
        mav.addObject("vehicles", vehicles);
        mav.addObject("employees", employees);
        
        System.out.println("Vehicles: " + vehicles.size() + "; Employees: " + employees.size());
        
        mav.setViewName("index");
        return mav;
    }
    
}
