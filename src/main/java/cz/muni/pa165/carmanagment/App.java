package cz.muni.pa165.carmanagment;

import cz.muni.pa165.carmanagment.dao.VehicleTypeDaoImpl;
import cz.muni.pa165.carmanagment.dto.VehicleTypeDto;
import cz.muni.pa165.carmanagment.model.VehicleType;
import cz.muni.pa165.carmanagment.service.VehicleTypeService;
import cz.muni.pa165.carmanagment.service.VehicleTypeServiceImpl;
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
