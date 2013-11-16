package cz.muni.fi.pa165.carmanagement.impl;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleTypeDto;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleTypeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"META-INF/applicationContext.xml"});
         
        VehicleTypeService service = (VehicleTypeService)context.getBean("vehicleTypeService");
        service.create(new VehicleTypeDto((long)320));        
        
        System.out.println("Size: "+service.findAll().size());   

    }
}
