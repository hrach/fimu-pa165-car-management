/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.web;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleService;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleTypeService;
import cz.muni.fi.pa165.carmanagement.web.validators.VehicleValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/admin/vehicle/")
public class VehicleController {
    
    @Autowired
    private MessageSource messageSource;
    
    private Locale locale = LocaleContextHolder.getLocale();

    @Autowired
    private VehicleService vehicleService;
    
    @Autowired
    private VehicleTypeService vehicleTypeService;
    
    @Autowired
    @Qualifier("vehicleValidator")
    private VehicleValidator vehicleValidator;     
    
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
    public ModelAndView doAddVehicle(@ModelAttribute("newVehicle") VehicleDto vehicle, BindingResult result, RedirectAttributes redirectAttributes) {
        
        vehicleValidator.validate(vehicle, result);        
        
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();        
            mav.addObject("vehicleTypes", vehicleTypeService.findAll());
            mav.setViewName("addVehicle");
            
            return mav;
        } else {
            VehicleDto vd = new VehicleDto();
            vd.setId(vehicle.getId());
            vd.setName(vehicle.getName());
            vd.setTachometer(vehicle.getTachometer());
            vd.setConstructionYear(vehicle.getConstructionYear());
            vd.setVIN(vehicle.getVIN());
            vd.setRegistrationPlate(vehicle.getRegistrationPlate());
            vd.setFuel(vehicle.getFuel());
            if (vehicle.getType() != null)
            {
                 vd.setType(vehicleTypeService.findById(vehicle.getType().getId()));
            }
            vehicleService.create(vd);

            String message = messageSource.getMessage("message.vehicle.added", null, locale);
            redirectAttributes.addFlashAttribute("message", message);

            return new ModelAndView("redirect:/admin/vehicle/"); 
        }
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
    public ModelAndView doEditVehicle(@ModelAttribute(value="vehicle") VehicleDto vehicle, BindingResult result, @PathVariable Long id, RedirectAttributes redirectAttributes){
        
        vehicleValidator.validate(vehicle, result);        
        
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();        
            mav.addObject("vehicleTypes", vehicleTypeService.findAll());
            mav.setViewName("editVehicle");
            
            return mav;
        } else {        
            VehicleDto vd = new VehicleDto();
            vd.setId(vehicle.getId());
            vd.setName(vehicle.getName());
            vd.setTachometer(vehicle.getTachometer());
            vd.setConstructionYear(vehicle.getConstructionYear());
            vd.setVIN(vehicle.getVIN());
            vd.setRegistrationPlate(vehicle.getRegistrationPlate());
            vd.setFuel(vehicle.getFuel());
            if (vehicle.getType() != null)
            {
                vd.setType(vehicleTypeService.findById(vehicle.getType().getId()));
            }
            vehicleService.update(vd);

            String[] messageParams = {id.toString()};        
            String message = messageSource.getMessage("message.vehicle.edited", messageParams, locale);
            redirectAttributes.addFlashAttribute("message", message);

            return new ModelAndView("redirect:/admin/vehicle/"); 
        }
    }
    
    @RequestMapping(value="/delete/{id}")
    public String deleteVehicle(@PathVariable Long id, RedirectAttributes redirectAttributes){
        
        vehicleService.delete(id);
        
        String[] messageParams = {id.toString()};        
        String message = messageSource.getMessage("message.vehicle.deleted", messageParams, locale);
        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/admin/vehicle/";
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
