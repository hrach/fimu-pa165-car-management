/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.web;

import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import cz.muni.fi.pa165.carmanagement.api.service.RideService;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleTypeService;
import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author zvonicek
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private VehicleTypeService vehicleType;
    
    @Autowired
    private RideService rideService;
    
    public AdminController() {
    }
    
    @RequestMapping("/")
    public ModelAndView renderAdmin() {
        ModelAndView mav = new ModelAndView();        
        mav.addObject("items", vehicleType.findAll());
        
        List<RideDto> rides = rideService.findAll();
        System.out.println(rides.size());
        
        mav.setViewName("adminIndex");
        return mav;
    }
}