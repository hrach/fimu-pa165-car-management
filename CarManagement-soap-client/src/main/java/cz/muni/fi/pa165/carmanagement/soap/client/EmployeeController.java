/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.soap.client;

import cz.muni.fi.pa165.carmanagement.soap.server.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.soap.server.EmployeeManager;
import cz.muni.fi.pa165.carmanagement.soap.server.EmployeeManager_Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String doAddVehicle(@ModelAttribute("newVehicle") EmployeeDto employee, RedirectAttributes redirectAttributes) {
        
        EmployeeManager_Service employeeManagerService = new EmployeeManager_Service();
        EmployeeManager manEmployee = employeeManagerService.getEmployeeManagerImplPort();
        
        manEmployee.createEmployee(employee);
        
        redirectAttributes.addFlashAttribute("message", "Employee was sucessfully added.");
        
        return "redirect:/index.htm";
    }
    
}
