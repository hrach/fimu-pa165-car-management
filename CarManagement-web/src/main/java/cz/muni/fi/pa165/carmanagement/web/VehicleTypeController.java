/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.web;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleTypeDto;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleTypeService;
import cz.muni.fi.pa165.carmanagement.web.validators.VehicleTypeValidator;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author tomasbobek
 */

@Controller
@RequestMapping("/admin/vehicle-type/")
public class VehicleTypeController {
    @Autowired
    private MessageSource messageSource;
    
    private Locale locale = LocaleContextHolder.getLocale();
    
    @Autowired
    private VehicleTypeService vehicleTypeService;
    
    @Autowired
    @Qualifier("vehicleTypeValidator")
    private VehicleTypeValidator vehicleTypeValidator;     
    
    public VehicleTypeController(){
        
    }
    
    @RequestMapping(value={"/" , "/list/"})
    public ModelAndView listVehicleTypes() {
        ModelAndView mav = new ModelAndView();        
        mav.addObject("vehicleTypes", vehicleTypeService.findAll());
        System.out.println(vehicleTypeService.findAll().size());
        
        mav.setViewName("listVehicleTypes");
        return mav;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView addVehicleType() {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("newVehicleType", new VehicleTypeDto());
        
        mav.setViewName("addVehicleType");
        return mav;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView doAddVehicleType(@ModelAttribute("newVehicleType") VehicleTypeDto vehicleType, BindingResult result, RedirectAttributes redirectAttributes) {
        
        vehicleTypeValidator.validate(vehicleType, result);        
        
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();        
            mav.setViewName("addVehicleType");
            return mav;
        } else {
            VehicleTypeDto vtd = new VehicleTypeDto();
            vtd.setId(vehicleType.getId());
            vtd.setName(vehicleType.getName());
            vtd.setMaxKm(vehicleType.getMaxKm());
            
            vehicleTypeService.create(vtd);

            String message = messageSource.getMessage("message.vehicletype.added", null, locale);
            redirectAttributes.addFlashAttribute("message", message);

            return new ModelAndView("redirect:/admin/vehicle-type/"); 
        }
    }
    
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editVehicleType(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();  
        
        mav.addObject("vehicleType", vehicleTypeService.findById(id));
        System.out.println("VehicleType edit:"+id+"\n");
        
        mav.setViewName("editVehicleType");
        return mav;
    }
    
    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public ModelAndView doEditVehicleType(@ModelAttribute(value="vehicleType") VehicleTypeDto vehicleType, BindingResult result, @PathVariable Long id, RedirectAttributes redirectAttributes){
        
        vehicleTypeValidator.validate(vehicleType, result);        
        
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();        
            mav.setViewName("editVehicleType");
            
            return mav;
        } else {        
            VehicleTypeDto vtd = new VehicleTypeDto();
            vtd.setId(vehicleType.getId());
            vtd.setName(vehicleType.getName());
            vtd.setMaxKm(vehicleType.getMaxKm());

            vehicleTypeService.update(vtd);

            String[] messageParams = {id.toString()};        
            String message = messageSource.getMessage("message.vehicletype.edited", messageParams, locale);
            redirectAttributes.addFlashAttribute("message", message);

            return new ModelAndView("redirect:/admin/vehicle-type/"); 
        }
    }
    
    @RequestMapping(value="/delete/{id}")
    public String deleteVehicleType(@PathVariable Long id, RedirectAttributes redirectAttributes){
        
        vehicleTypeService.delete(id);
        
        String[] messageParams = {id.toString()};        
        String message = messageSource.getMessage("message.vehicletype.deleted", messageParams, locale);
        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/admin/vehicle-type/";
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
