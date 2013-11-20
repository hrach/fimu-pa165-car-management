package cz.muni.fi.pa165.carmanagement.impl;

import cz.muni.fi.pa165.carmanagement.api.dto.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import cz.muni.fi.pa165.carmanagement.api.dto.ServiceIntervalDto;
import cz.muni.fi.pa165.carmanagement.api.dto.ServiceTypeDto;
import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import cz.muni.fi.pa165.carmanagement.api.dto.VehicleTypeDto;
import cz.muni.fi.pa165.carmanagement.api.service.EmployeeService;
import cz.muni.fi.pa165.carmanagement.api.service.RideService;
import cz.muni.fi.pa165.carmanagement.api.service.ServiceIntervalService;
import cz.muni.fi.pa165.carmanagement.api.service.ServiceTypeService;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleService;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleTypeService;
import java.util.Date;
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
        
        VehicleTypeService vehicleTypeService = (VehicleTypeService)context.getBean("vehicleTypeService");
        VehicleService vehicleService = (VehicleService)context.getBean("vehicleService");
        ServiceTypeService serviceTypeService = (ServiceTypeService)context.getBean("serviceTypeService");
        ServiceIntervalService serviceIntervalService = (ServiceIntervalService)context.getBean("serviceIntervalService");
        RideService rideService = (RideService)context.getBean("rideService");
        EmployeeService employeeService = (EmployeeService)context.getBean("employeeService");
        
        EmployeeDto employee = new EmployeeDto((long)1, "John", "Doe", 1);       
        employee = employeeService.create(employee);
        
        VehicleTypeDto vehicleType = new VehicleTypeDto((long)320);        
        vehicleType = vehicleTypeService.create(vehicleType);
        
        VehicleDto vehicle = new VehicleDto("Audi A4", (long)50000, vehicleType);
        vehicle = vehicleService.create(vehicle);
                
        ServiceTypeDto serviceType = new ServiceTypeDto("Výměna oleje");
        serviceType = serviceTypeService.create(serviceType);
        
        ServiceIntervalDto serviceInterval = new ServiceIntervalDto((long)1, new Date(), new Date(), new Date(), vehicle, serviceType);
        serviceInterval = serviceIntervalService.create(serviceInterval);
        
        RideDto ride = new RideDto((long)1, new Date(), new Date(), (long)123, (long)456, "abc", vehicle, employee);        
        ride = rideService.create(ride);
        
        
        System.out.println("Size: "+vehicleTypeService.findAll().size());   

    }
}
