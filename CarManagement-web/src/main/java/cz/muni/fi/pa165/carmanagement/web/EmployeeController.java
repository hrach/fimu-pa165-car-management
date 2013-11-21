/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.web;

import cz.muni.fi.pa165.carmanagement.api.dto.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.api.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Jakub Marecek <xmarec at gmail.com>
 */
@Controller
@RequestMapping("/employee/")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    public EmployeeController(){
        
    }
    
    @RequestMapping("/")
    public ModelAndView listEmployees() {
        ModelAndView mav = new ModelAndView();        
        mav.addObject("employees", employeeService.findAll());
        System.out.println(employeeService.findAll().size());
        
        mav.setViewName("listEmployees");
        return mav;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView addEmployee() {
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("newEmployee", new EmployeeDto());
        
        mav.setViewName("addEmployee");
        return mav;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String doAddEmployee(@ModelAttribute("newEmployee") EmployeeDto employee, RedirectAttributes redirectAttributes) {
        
        employeeService.create(employee);
                
        String message = "New employee was successfully added."; 
        System.out.println("New employee added\n");


        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/employee/";  
    }    
    
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editEmployee(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();  
        
        mav.addObject("employee", employeeService.findById(id));
        System.out.println("Employee edit:"+id+"\n");
        
        mav.setViewName("editEmployee");
        return mav;
    }
    
    @RequestMapping(value="/edit/{id}", method= RequestMethod.POST)
    public String doEditEmployee(@ModelAttribute(value="employee") EmployeeDto employee, @PathVariable Long id, RedirectAttributes redirectAttributes){
        
        employeeService.update(employee);
        
        System.out.println("Employee edit:"+id+" - ok\n");

        String message = "Employee #"+employee.getId()+" was successfully edited."; 

        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/employee/"; 
    }
    
    @RequestMapping(value="/delete/{id}")
    public String deleteEmployee(@PathVariable Long id, RedirectAttributes redirectAttributes){
        employeeService.delete(id);
        
        String message = "Employee #"+id+" was successfully deleted."; 
        message = "Employee #"+id+" was successfully deleted."; 

        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/employee/";
    }
    
    @RequestMapping(value="/search", method= RequestMethod.POST)
    public @ResponseBody List<EmployeeDto> getJsonData() {
        final List<EmployeeDto> data = new ArrayList();
        data.addAll(employeeService.findAll());
        return data;
    }
}
