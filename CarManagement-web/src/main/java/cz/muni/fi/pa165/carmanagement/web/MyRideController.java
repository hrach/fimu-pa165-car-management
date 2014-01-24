/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.web;

import cz.muni.fi.pa165.carmanagement.api.dto.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import cz.muni.fi.pa165.carmanagement.api.service.EmployeeService;
import cz.muni.fi.pa165.carmanagement.api.service.RideService;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleService;
import cz.muni.fi.pa165.carmanagement.impl.adapter.EmployeeDetailsAdapter;
import cz.muni.fi.pa165.carmanagement.impl.service.EmployeeUserDetailsService;
import cz.muni.fi.pa165.carmanagement.web.exceptions.ResourceNotFoundException;
import cz.muni.fi.pa165.carmanagement.web.validators.RideValidator;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
@RequestMapping("/myride/")
public class MyRideController {
    
    @Autowired
    private MessageSource messageSource;
    
    private Locale locale = LocaleContextHolder.getLocale();
    
    @Autowired
    private RideService rideService;
    
    @Autowired
    private VehicleService vehicleService;
    
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private EmployeeUserDetailsService employeeUDS;
    
    @Autowired
    @Qualifier("rideValidator")
    private RideValidator rideValidator;     
    
    
    public MyRideController(){
        
    }
    
    @InitBinder
    public void bind(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            
            @Override
            public void setAsText(String value) {
                try {
                    setValue(new SimpleDateFormat("dd/MM/yyyy").parse(value));
                } catch (ParseException ex) {
                    setValue(null);
                }
            }
            
            @Override
            public String getAsText() {
                if (getValue() == null) {
                    return null;
                }
                return new SimpleDateFormat("dd/MM/yyyy").format((Date) getValue());
            }
            
        });
    }
    
    @RequestMapping(value={"/" , "/list/"})
    public ModelAndView listMyRides(Authentication authentication) {
        
        String username = authentication.getName();
        
        EmployeeDetailsAdapter eda  = (EmployeeDetailsAdapter) this.employeeUDS.loadUserByUsername(username);
     
        ModelAndView mav = new ModelAndView();        
        EmployeeDto e = this.employeeService.findById((long) eda.getId());
        if (e == null) {
            throw new ResourceNotFoundException();
        }

        mav.addObject("employee", e);

        System.out.println("Listing rides for employee: "+e.getName()+"\n");
        
        mav.setViewName("listMyRides");
        return mav;
    }
    

    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView addMyRide(Authentication authentication) {
        String username = authentication.getName();
        
        EmployeeDetailsAdapter eda  = (EmployeeDetailsAdapter) this.employeeUDS.loadUserByUsername(username);
        
        ModelAndView mav = new ModelAndView();
        
        EmployeeDto e = employeeService.findById(eda.getId());
        
        if (e == null) {
            System.out.println("Employee with id "+eda.getId()+" not found");
            throw new ResourceNotFoundException();
        }
        
        System.out.println("Adding new ride for employee #"+e.getId());
        
        RideDto newRide = new RideDto();
        
        newRide.setEmployee(e);
        
        mav.addObject("newRide", newRide);
        mav.addObject("vehicles", vehicleService.findAllSuitableForSelection());
        
        mav.setViewName("addMyRide");
        return mav;
    }
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView doAddMyRide(@ModelAttribute("newRide") RideDto ride, BindingResult result, RedirectAttributes redirectAttributes) {
        
        rideValidator.validate(ride, result);        
        
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();        
            mav.addObject("vehicles", vehicleService.findAllSuitableForSelection());
            mav.addObject("employees", employeeService.findAll());            
            mav.setViewName("addMyRide");
            
            return mav;
        } else {       
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

            String message = messageSource.getMessage("message.ride.added", null, locale);
            redirectAttributes.addFlashAttribute("message", message);

            return new ModelAndView("redirect:/myride/list/");
        }
    }
    
    @RequestMapping(value="/detail/{id}", method=RequestMethod.GET)
    public ModelAndView detailRide(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();  
        
        RideDto ride = this.rideService.findById((long) id);
        if (ride == null) {
            throw new ResourceNotFoundException();
        }
        
        mav.addObject("ride", ride);
        mav.addObject("vehicles", vehicleService.findAllSuitableForSelection());
        mav.addObject("employees", employeeService.findAll());
        
        mav.setViewName("detailMyRide");
        return mav;
    }
    
}
