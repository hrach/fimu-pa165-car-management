/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.web;

import cz.muni.fi.pa165.carmanagement.api.dto.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.api.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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
    private MessageSource messageSource;
    
    private Locale locale = LocaleContextHolder.getLocale();
    
    @Autowired
    private EmployeeService employeeService;
    
    public EmployeeController(){
        
    }
    
    @RequestMapping(value={"/" , "/list/"})
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
      
        String message = messageSource.getMessage("message.employee.added", null, locale);

        System.out.println("New employee added.");

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
        
        System.out.println("Employee edit:"+id+" - ok.");

        String[] messageParams = {employee.getId().toString()};        
        String message = messageSource.getMessage("message.employee.edited", messageParams, locale);
        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/employee/"; 
    }
    
    @RequestMapping(value="/delete/{id}")
    public String deleteEmployee(@PathVariable Long id, RedirectAttributes redirectAttributes){
        employeeService.delete(id);
        
        String[] messageParams = {id.toString()};        
        String message = messageSource.getMessage("message.employee.deleted", messageParams, locale);
        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/employee/";
    }
    
    @RequestMapping(value="/search/{term}")
    public @ResponseBody List<EmployeeDto> getJsonData(@PathVariable String term, HttpServletResponse response) {
        response.setContentType("application/json");
        final List<EmployeeDto> data = new ArrayList();
        for(EmployeeDto d : employeeService.findAll()) {
            if(d.getName().toLowerCase().contains(term.toLowerCase())) {
/* Delano pres novy objekt typu EmployeeDto protoze se Json dostal az na getKmSum a vyhodil Nullpointer exception */                
                EmployeeDto newE = new EmployeeDto();
                
                newE.setId(d.getId());
                newE.setFirstName(d.getFirstName());
                newE.setFamilyName(d.getFamilyName());
                                
                data.add(newE);

            }
        }
        return data;
    }
}
