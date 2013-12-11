/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.soap.client;

import cz.muni.fi.pa165.carmanagement.soap.server.EmployeeDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author tomasbobek
 */

@Controller
@RequestMapping("/employee/")
public class EmployeeController {
    
    public EmployeeController() {

    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView addEmployee() {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("newEmployee", new EmployeeDto());
        
        mav.setViewName("addEmployee");
        return mav;
    }
    
}
