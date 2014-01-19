package cz.muni.fi.pa165.carmanagement.web;

import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import cz.muni.fi.pa165.carmanagement.api.dto.ServiceIntervalDto;
import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import cz.muni.fi.pa165.carmanagement.api.service.ServiceIntervalService;
import cz.muni.fi.pa165.carmanagement.api.service.ServiceTypeService;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleService;
import cz.muni.fi.pa165.carmanagement.web.exceptions.ResourceNotFoundException;
import cz.muni.fi.pa165.carmanagement.web.validators.ServiceIntervalValidator;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author skrasek
 */
@Controller
@RequestMapping("/admin/overview/vehicle")
public class VehicleOverviewController {
    
    @Autowired
    private VehicleService vehicles;
    
    @Autowired
    private ServiceTypeService serviceTypes;
    
    @Autowired
    private ServiceIntervalService serviceIntervals;

    @Autowired
    @Qualifier("serviceIntervalValidator")
    private ServiceIntervalValidator intervalValidator;        
    
    @InitBinder
    public void bind(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            
            @Override
            public void setAsText(String value) {
                try {
                    setValue(new SimpleDateFormat("dd/MM/yyyy").parse(value));
                } catch (ParseException ex) {
                    setValue(null);
                }
            }
            
            @Override
            public String getAsText() {
                if (getValue() == null) {
                    return null;
                }
                return new SimpleDateFormat("dd/MM/yyyy").format((Date) getValue());
            }
            
        });
    }    
    
    private ModelAndView getHomeView(int id)
    {
        ModelAndView mav = new ModelAndView();        
        VehicleDto v = this.vehicles.findById((long) id);
        if (v == null) {
            throw new ResourceNotFoundException();
        }
        mav.addObject("vehicle", v);
        
        List<RideDto> rides = new ArrayList<RideDto>(v.getRides());
        Collections.reverse(rides);
        mav.addObject("rides", rides);
        mav.addObject("allTypes", this.serviceTypes.findAll());
        
        mav.setViewName("vehicle-overview");
        
        return mav;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ModelAndView renderHome(@PathVariable("id") int id) {
        ModelAndView mav = this.getHomeView(id);
        
        mav.addObject("newServiceInterval", new ServiceIntervalDto());
        return mav;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.POST)
    public ModelAndView doAddEmployee(@PathVariable("id") int id, @ModelAttribute("newServiceInterval") ServiceIntervalDto si, BindingResult result, RedirectAttributes redirectAttributes) {
        
        intervalValidator.validate(si, result);    
                        
        if (result.hasErrors()) { 
            ModelAndView mav = this.getHomeView(id);
            
            mav.addObject("newServiceInterval", si);
            
            return mav;
        } else {
            VehicleDto vehicle = this.vehicles.findById((long) id);
            if (vehicle == null) {
                throw new ResourceNotFoundException();
            }

            ServiceIntervalDto updateServiceInterval = this.serviceIntervals.updateServiceIntervalAsDone(vehicle, si.getServiceType());
            if (updateServiceInterval != null) {
                updateServiceInterval.setVehicle(vehicle);
                this.serviceIntervals.update(updateServiceInterval);
            }

            si.setCreatedTime(new Date());
            si.setVehicle(vehicle);
            this.serviceIntervals.create(si);
            
            return new ModelAndView("redirect:/admin/overview/vehicle/" + id);        
        }
    }    
}
