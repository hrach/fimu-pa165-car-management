package cz.muni.fi.pa165.carmanagement.web;

import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import cz.muni.fi.pa165.carmanagement.api.dto.ServiceIntervalDto;
import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import cz.muni.fi.pa165.carmanagement.api.service.ServiceIntervalService;
import cz.muni.fi.pa165.carmanagement.api.service.ServiceTypeService;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleService;
import cz.muni.fi.pa165.carmanagement.web.exceptions.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/overview/vehicle")
public class VehicleOverviewController {
    
    @Autowired
    private VehicleService vehicles;
    
    @Autowired
    private ServiceTypeService serviceTypes;
    
    @Autowired
    private ServiceIntervalService serviceIntervals;


    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ModelAndView renderHome(@PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView();        
        VehicleDto v = this.vehicles.findById((long) id);
        if (v == null) {
            throw new ResourceNotFoundException();
        }
        mav.addObject("vehicle", v);
        
        List<RideDto> rides = new ArrayList<RideDto>(v.getRides());
        Collections.reverse(rides);
        mav.addObject("rides", rides);
        mav.setViewName("vehicle-overview");
        mav.addObject("newServiceInterval", new ServiceIntervalDto());
        mav.addObject("allTypes", this.serviceTypes.findAll());
        return mav;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.POST)
    public String doAddEmployee(@PathVariable("id") int id, @ModelAttribute("newServiceInterval") ServiceIntervalDto si, RedirectAttributes redirectAttributes) {

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

        return "redirect:/overview/vehicle/" + id;
    }    
}
