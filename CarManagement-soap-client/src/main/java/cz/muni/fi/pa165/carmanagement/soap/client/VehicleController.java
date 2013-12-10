/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.soap.client;

import cz.muni.fi.pa165.carmanagement.web.soap.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.web.soap.EmployeeManager;
import cz.muni.fi.pa165.carmanagement.web.soap.EmployeeManager_Service;
import cz.muni.fi.pa165.carmanagement.web.soap.VehicleDto;
import cz.muni.fi.pa165.carmanagement.web.soap.VehicleManager;
import cz.muni.fi.pa165.carmanagement.web.soap.VehicleManager_Service;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author zvonicek
 */

@Controller
@RequestMapping("/vehicle/")
public class VehicleController {

    private EmployeeManager employeeManager;
    
    public VehicleController() {
        EmployeeManager_Service managerService = new EmployeeManager_Service();
        employeeManager = managerService.getEmployeeManagerImplPort();
        

    }    
    
    @RequestMapping("/index")
    public ModelAndView renderIndex() {
        ModelAndView mav = new ModelAndView();        
                
        List<EmployeeDto> employees = employeeManager.findAllEmployees();
        
        VehicleManager_Service vehicleManagerService = new VehicleManager_Service();
        VehicleManager man = vehicleManagerService.getVehicleManagerImplPort();
        List<VehicleDto> vehicles = man.findAllVehicles();
        
        System.out.println("test!"+employees.size()+" "+vehicles.size());
        
        mav.setViewName("index");
        return mav;
    }
    
    
}
