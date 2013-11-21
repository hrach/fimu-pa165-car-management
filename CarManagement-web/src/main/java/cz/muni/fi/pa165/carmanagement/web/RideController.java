/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.web;

import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import cz.muni.fi.pa165.carmanagement.api.service.EmployeeService;
import cz.muni.fi.pa165.carmanagement.api.service.RideService;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jakub Marecek <xmarec at gmail.com>
 */

@Controller
@RequestMapping("/ride/")
public class RideController {
    
    @Autowired
    private RideService rideService;
    
    @Autowired
    private VehicleService vehicleService;
    
    @Autowired
    private EmployeeService employeeService;
    
    public RideController(){
        
    }
    
    @RequestMapping("/")
    public ModelAndView listRides() {
        ModelAndView mav = new ModelAndView();        
        List<RideDto> rides = new ArrayList<RideDto>();
        rides = rideService.findAll();
        
        mav.addObject("rides", rides);
        System.out.println("Number of listed rides: "+rideService.findAll().size()+"\n");
        
        mav.setViewName("listRides");
        return mav;
    }
    
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editRide(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();  
        
        mav.addObject("ride", rideService.findById(id));
        mav.addObject("vehicles", vehicleService.findAll());
        mav.addObject("employees", employeeService.findAll());

        System.out.println("Ride edit:"+id+"\n");
        
        mav.setViewName("editRide");
        return mav;
    }
    
    @RequestMapping(value="/detail/{id}", method=RequestMethod.GET)
    public ModelAndView detailRide(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();  
        
        mav.addObject("ride", rideService.findById(id));
        mav.addObject("vehicles", vehicleService.findAll());
        mav.addObject("employees", employeeService.findAll());
        
        mav.setViewName("detailRide");
        return mav;
    }
    
}
