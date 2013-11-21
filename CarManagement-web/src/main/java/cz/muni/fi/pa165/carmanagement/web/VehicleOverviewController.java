package cz.muni.fi.pa165.carmanagement.web;

import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleService;
import cz.muni.fi.pa165.carmanagement.web.exceptions.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author skrasek
 */
@Controller
@RequestMapping("/overview/vehicle")
public class VehicleOverviewController {
    
    @Autowired
    private VehicleService vehicles;
    
    @RequestMapping(value="/{id}")
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
        return mav;
    }

}
