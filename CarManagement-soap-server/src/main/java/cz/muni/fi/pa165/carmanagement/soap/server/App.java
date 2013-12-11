package cz.muni.fi.pa165.carmanagement.soap.server;

import javax.xml.ws.Endpoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        EmployeeManager employeeManager = ctx.getBean(EmployeeManagerImpl.class);
        VehicleManager vehicleManager = ctx.getBean(VehicleManagerImpl.class);
        VehicleTypeManager vehicleTypeManager = ctx.getBean(VehicleTypeManagerImpl.class);
        
        String employeeAddress = "http://localhost:9000/employeeManager";
        String vehicleAddress = "http://localhost:9000/vehicleManager";
        String vehicleTypeAddress = "http://localhost:9000/vehicleTypeManager";
        
        Endpoint.publish(employeeAddress, employeeManager);
        Endpoint.publish(vehicleAddress, vehicleManager);
        Endpoint.publish(vehicleTypeAddress, vehicleTypeManager);
        
        System.out.println("Server is ready now.");    }
}
