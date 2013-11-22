/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.web;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleService;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleTypeService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Jakub Marecek <xmarec at gmail.com>
 */
@Controller
@RequestMapping("/vehicle/")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    
    @Autowired
    private VehicleTypeService vehicleTypeService;
    
    public VehicleController(){
        
    }
    
    @RequestMapping(value={"/" , "/list/"})
    public ModelAndView listVehicles() {
        ModelAndView mav = new ModelAndView();        
        mav.addObject("vehicles", vehicleService.findAll());
        System.out.println(vehicleService.findAll().size());
        
        mav.setViewName("listVehicles");
        return mav;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView addVehicle() {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("newVehicle", new VehicleDto());
        mav.addObject("vehicleTypes", vehicleTypeService.findAll());
        
        mav.setViewName("addVehicle");
        return mav;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String doAddVehicle(@ModelAttribute("newVehicle") VehicleDto vehicle, RedirectAttributes redirectAttributes) {
        
        VehicleDto vd = new VehicleDto();
        vd.setId(vehicle.getId());
        vd.setName(vehicle.getName());
        vd.setTachometer(vehicle.getTachometer());
        vd.setType(vehicleTypeService.findById(vehicle.getType().getId()));
        
        vehicleService.create(vd);
                
        String message = "Vehicle was successfully added."; 

        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/vehicle/";  
    }
    
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editVehicle(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();  
        
        mav.addObject("vehicle", vehicleService.findById(id));
        mav.addObject("vehicleTypes", vehicleTypeService.findAll());
        System.out.println("Vehicle edit:"+id+"\n");
        
        mav.setViewName("editVehicle");
        return mav;
    }
    
    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public String doEditVehicle(@ModelAttribute(value="vehicle") VehicleDto vehicle, @PathVariable Long id, RedirectAttributes redirectAttributes){
        
        VehicleDto vd = new VehicleDto();
        vd.setId(vehicle.getId());
        vd.setName(vehicle.getName());
        vd.setTachometer(vehicle.getTachometer());
        vd.setType(vehicleTypeService.findById(vehicle.getType().getId()));
        
        vehicleService.update(vd);
                
        String message = "Vehicle #"+id+" was successfully edited."; 

        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/vehicle/";        

    }
    
    @RequestMapping(value="/delete/{id}")
    public String deleteVehicle(@PathVariable Long id, RedirectAttributes redirectAttributes){
        
        vehicleService.delete(id);
        
        String message = "Vehicle #"+id+" was successfully deleted."; 
        message = "Vehicle #"+id+" was successfully deleted."; 

        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/vehicle/";
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    @RequestMapping(value="/search/{term}")
    public @ResponseBody List<VehicleDto> getJsonData(@PathVariable String term, HttpServletResponse response) {
        response.setContentType("application/json");
        final List<VehicleDto> data = new ArrayList();
        for(VehicleDto d : vehicleService.findAll()) {
            if(d.getName().toLowerCase().contains(term.toLowerCase())) {
                data.add(d);
            }
        }
        return data;
    }
    
}
