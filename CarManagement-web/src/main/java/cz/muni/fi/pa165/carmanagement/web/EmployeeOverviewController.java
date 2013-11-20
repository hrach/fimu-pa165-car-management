/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.web;

import cz.muni.fi.pa165.carmanagement.api.dto.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import cz.muni.fi.pa165.carmanagement.api.service.EmployeeService;
import cz.muni.fi.pa165.carmanagement.api.service.RideService;
import cz.muni.fi.pa165.carmanagement.web.exceptions.ResourceNotFoundException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author skrasek
 */
@Controller
@RequestMapping("/overview/employee")
public class EmployeeOverviewController {
    
    @Autowired
    private EmployeeService employees;

    @Autowired
    private RideService rides;

    public EmployeeOverviewController() {
    }
    
    @RequestMapping(value="/{id}")
    public ModelAndView renderHome(@PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView();        
        System.out.println((long) id);
        EmployeeDto e = this.employees.findById((long) id);
        if (e == null) {
            throw new ResourceNotFoundException();
        }
        mav.addObject("employee", e);

        List<RideDto> ridesList = e.getRides();
        mav.addObject("rides", ridesList);
        mav.setViewName("employee-overview");
        return mav;
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }
   
}