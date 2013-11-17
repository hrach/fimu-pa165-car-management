/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.web;

import cz.muni.fi.pa165.carmanagement.api.service.VehicleTypeService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private VehicleTypeService vehicleType;
    
    public HomeController() {
    }
    
    @RequestMapping("/test")
    public ModelAndView renderHome() {
        ModelAndView mav = new ModelAndView();        
        mav.addObject("items", vehicleType.findAll());
        System.out.println(vehicleType.findAll().size());
        
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/test2")
    public String renderHome2() {
        return "index";
    }    
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}