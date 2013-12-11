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
 * @author zvonicek
 */

@Controller
@RequestMapping("/vehicle/")
public class VehicleController {

    private VehicleManager vehicleManager;
    
    public VehicleController() {
        VehicleManager_Service vehicleManagerService = new VehicleManager_Service();
        VehicleManager vehicleManager = vehicleManagerService.getVehicleManagerImplPort();
        

    }    
    
    @RequestMapping("/")
    public ModelAndView listVehicles() {
        ModelAndView mav = new ModelAndView();        
        List<VehicleDto> vehicles = vehicleManager.findAllVehicles();
        
        mav.addObject("vehicles", vehicles);
        System.out.println(vehicles.size());
        
        mav.setViewName("listVehicles");
        return mav;
    }
    
    
}
