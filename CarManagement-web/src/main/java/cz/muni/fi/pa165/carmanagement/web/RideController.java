/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.web;

import cz.muni.fi.pa165.carmanagement.api.dto.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import cz.muni.fi.pa165.carmanagement.api.service.EmployeeService;
import cz.muni.fi.pa165.carmanagement.api.service.RideService;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleService;
import cz.muni.fi.pa165.carmanagement.web.exceptions.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    
    @RequestMapping(value={"/" , "/list/"})
    public ModelAndView listRides() {
        ModelAndView mav = new ModelAndView();        
        List<RideDto> rides = new ArrayList<RideDto>();
        rides = rideService.findAll();
        
        mav.addObject("rides", rides);
        System.out.println("Number of listed rides: "+rideService.findAll().size()+"\n");
        
        mav.setViewName("listRides");
        return mav;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView addRide() {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("newRide", new RideDto());
        mav.addObject("vehicles", vehicleService.findAll());
        mav.addObject("employees", employeeService.findAll());
        
        mav.setViewName("addRide");
        return mav;
    }
    
    @RequestMapping(value="/add/{id}", method=RequestMethod.GET)
    public ModelAndView addRideForEmployee(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();
        
        EmployeeDto e = employeeService.findById(id);
        
        if (e == null) {
            System.out.println("Employee with id "+id+" not found");
            throw new ResourceNotFoundException();
        }
        
        System.out.println("Adding new ride for employee #"+e.getId());
        
        RideDto newRide = new RideDto();
        
        newRide.setEmployee(e);
        
        mav.addObject("newRide", newRide);
        mav.addObject("vehicles", vehicleService.findAll());
   //     mav.addObject("employees", employeeService.findAll());
        
        mav.setViewName("addRideForEmployee");
        return mav;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String doAddRide(@ModelAttribute("newRide") RideDto ride, RedirectAttributes redirectAttributes) {
        
        RideDto rd = new RideDto();
        rd.setId(ride.getId());
        rd.setStartTime(ride.getStartTime());
        rd.setEndTime(ride.getEndTime());
        rd.setTachometerStart(ride.getTachometerStart());
        rd.setTachometerEnd(ride.getTachometerEnd());
        rd.setDescription(ride.getDescription());
        rd.setEmployee(employeeService.findById(ride.getEmployee().getId()));
        rd.setVehicle(vehicleService.findById(ride.getVehicle().getId()));
        
        rideService.create(rd);
                
        String message = "Ride was successfully added."; 

        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/ride/";  
    }
    
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editRide(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();  
        
        RideDto ride = this.rideService.findById((long) id);
        if (ride == null) {
            throw new ResourceNotFoundException();
        }
        
        mav.addObject("ride", ride);
        mav.addObject("vehicles", vehicleService.findAll());
        mav.addObject("employees", employeeService.findAll());

        System.out.println("Ride edit:"+id+"\n");
        
        mav.setViewName("editRide");
        return mav;
    }
    
    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public String doEditRide(@ModelAttribute("ride") RideDto ride, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        
        RideDto rd = new RideDto();
        rd.setId(ride.getId());
        rd.setStartTime(ride.getStartTime());
        rd.setEndTime(ride.getEndTime());
        rd.setTachometerStart(ride.getTachometerStart());
        rd.setTachometerEnd(ride.getTachometerEnd());
        rd.setDescription(ride.getDescription());
        rd.setEmployee(employeeService.findById(ride.getEmployee().getId()));
        rd.setVehicle(vehicleService.findById(ride.getVehicle().getId()));
        
        rideService.update(rd);
                
        String message = "Ride #" + id + " was successfully modified."; 

        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/ride/"; 
    }
    
    @RequestMapping(value="/delete/{id}")
    public String deleteRide(@PathVariable Long id, RedirectAttributes redirectAttributes){
        
        RideDto ride = this.rideService.findById((long) id);
        if (ride == null) {
            throw new ResourceNotFoundException();
        }
        
        rideService.delete(id);
        
        String message = "Ride #"+id+" was successfully deleted."; 

        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/ride/";
    }
    
    @RequestMapping(value="/detail/{id}", method=RequestMethod.GET)
    public ModelAndView detailRide(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();  
        
        RideDto ride = this.rideService.findById((long) id);
        if (ride == null) {
            throw new ResourceNotFoundException();
        }
        
        mav.addObject("ride", ride);
        mav.addObject("vehicles", vehicleService.findAll());
        mav.addObject("employees", employeeService.findAll());
        
        mav.setViewName("detailRide");
        return mav;
    }
    
}
