/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.web;

import cz.muni.fi.pa165.carmanagement.api.dto.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import cz.muni.fi.pa165.carmanagement.api.service.EmployeeService;
import cz.muni.fi.pa165.carmanagement.api.service.RideService;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleTypeService;
import cz.muni.fi.pa165.carmanagement.impl.adapter.EmployeeDetailsAdapter;
import cz.muni.fi.pa165.carmanagement.impl.service.EmployeeUserDetailsService;
import cz.muni.fi.pa165.carmanagement.web.exceptions.ResourceNotFoundException;
import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author zvonicek
 */
@Controller
@RequestMapping("/")
public class HomeController {
    
    @Autowired
    private EmployeeService employees;
    
    @Autowired
    private EmployeeUserDetailsService employeeUDS;
    
    public HomeController() {
    }
    
    @RequestMapping("/index.htm")
    public ModelAndView renderHome(Authentication authentication) {
        
        String username = authentication.getName();
        
        EmployeeDetailsAdapter eda  = (EmployeeDetailsAdapter) this.employeeUDS.loadUserByUsername(username);
     
        ModelAndView mav = new ModelAndView();        
        EmployeeDto e = this.employees.findById((long) eda.getId());
        if (e == null) {
            throw new ResourceNotFoundException();
        }
        
        mav.addObject("employee", e);
        
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/login")
    public String renderLogin() {
        return "login";
    }    
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}