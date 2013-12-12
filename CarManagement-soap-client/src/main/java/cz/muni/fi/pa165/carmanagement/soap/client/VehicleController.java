/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.soap.client;

import cz.muni.fi.pa165.carmanagement.soap.VehicleDto;
import cz.muni.fi.pa165.carmanagement.soap.VehicleManagerImpl;
import cz.muni.fi.pa165.carmanagement.soap.VehicleManagerImplService;
import cz.muni.fi.pa165.carmanagement.soap.VehicleTypeManagerImpl;
import cz.muni.fi.pa165.carmanagement.soap.VehicleTypeManagerImplService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        
        VehicleTypeManagerImplService vehicleTypeManagerService = new VehicleTypeManagerImplService();
        VehicleTypeManagerImpl manVehicleType = vehicleTypeManagerService.getVehicleTypeManagerImplPort();
        
        mav.addObject("newVehicle", new VehicleDto());
        mav.addObject("vehicleTypes", manVehicleType.findAllVehicleTypes());
        
        mav.setViewName("addVehicle");
        return mav;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String doAddVehicle(@ModelAttribute("newVehicle") VehicleDto vehicle, RedirectAttributes redirectAttributes) {
        ModelAndView mav = new ModelAndView();        
        
        VehicleManagerImplService vehicleManagerService = new VehicleManagerImplService();
        VehicleManagerImpl manVehicle = vehicleManagerService.getVehicleManagerImplPort();
        
        manVehicle.createVehicle(vehicle);
        
        redirectAttributes.addFlashAttribute("message", "Vehicle was sucessfully added.");
        
        return "redirect:/index.htm";
    }
    
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editVehicle(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();
        
        VehicleManagerImplService vehicleManagerService = new VehicleManagerImplService();
        VehicleManagerImpl manVehicle = vehicleManagerService.getVehicleManagerImplPort();
        VehicleTypeManagerImplService vehicleTypeManagerService = new VehicleTypeManagerImplService();
        VehicleTypeManagerImpl manVehicleType = vehicleTypeManagerService.getVehicleTypeManagerImplPort();
        
        mav.addObject("vehicle", manVehicle.getVehicle(id));
        mav.addObject("vehicleTypes", manVehicleType.findAllVehicleTypes());
        
        mav.setViewName("editVehicle");
        return mav;
    }
    
    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public String doEditVehicle(@ModelAttribute(value="vehicle") VehicleDto vehicle, BindingResult result, @PathVariable Long id, RedirectAttributes redirectAttributes){
        
        VehicleManagerImplService vehicleManagerService = new VehicleManagerImplService();
        VehicleManagerImpl manVehicle = vehicleManagerService.getVehicleManagerImplPort();
        manVehicle.updateVehicle(vehicle);
        
        redirectAttributes.addFlashAttribute("message", "Vehicle (id: " + vehicle.getId().toString() + "was sucessfully edited.");
        
        return "redirect:/index.htm"; 
    }
    
    @RequestMapping(value="/delete/{id}")
    public String deleteVehicle(@PathVariable Long id, RedirectAttributes redirectAttributes){
        
        VehicleManagerImplService vehicleManagerService = new VehicleManagerImplService();
        VehicleManagerImpl manVehicle = vehicleManagerService.getVehicleManagerImplPort();
        manVehicle.removeVehicle(manVehicle.getVehicle(id));
        
        redirectAttributes.addFlashAttribute("message", "Vehicle with id " + id.toString() + " was deleted.");

        return "redirect:/index.htm";
    }
    
}
