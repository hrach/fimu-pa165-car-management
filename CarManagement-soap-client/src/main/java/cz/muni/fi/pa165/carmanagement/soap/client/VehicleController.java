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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author zvonicek
 */

@Controller
@RequestMapping("/vehicle/")
public class VehicleController {

    public VehicleController() {

    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView addVehicle() {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("newVehicle", new VehicleDto());
        //mav.addObject("vehicleTypes", vehicleTypeService.findAll());
        
        mav.setViewName("addVehicle");
        return mav;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView doAddVehicle(@ModelAttribute("newVehicle") VehicleDto vehicle, RedirectAttributes redirectAttributes) {
        ModelAndView mav = new ModelAndView();        
        
        VehicleManager_Service vehicleManagerService = new VehicleManager_Service();
        VehicleManager manVehicle = vehicleManagerService.getVehicleManagerImplPort();
        
        manVehicle.createVehicle(vehicle);
        
        redirectAttributes.addFlashAttribute("message", "Vehicle was sucessfully added.");
        
        mav.setViewName("addVehicle");
        return mav;
    }
    
    
}
