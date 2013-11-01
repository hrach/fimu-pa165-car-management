/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.pa165.carmanagment.service;

import cz.muni.pa165.carmanagment.dao.VehicleDaoImpl;
import cz.muni.pa165.carmanagment.dto.RideDto;
import cz.muni.pa165.carmanagment.dto.VehicleDto;
import cz.muni.pa165.carmanagment.dto.VehicleTypeDto;
import cz.muni.pa165.carmanagment.model.ServiceType;
import cz.muni.pa165.carmanagment.model.Vehicle;
import java.util.Date;
import java.util.List;
import static junit.framework.Assert.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author tomasbobek
 */
@RunWith(MockitoJUnitRunner.class)
public class VehicleServiceTest extends TestCase {

    private VehicleServiceImpl vehicleService;    
    @Mock private VehicleDaoImpl vehicleDao;    

    @Before
    public void setUp() throws Exception {
        super.setUp();
        
        vehicleService = new VehicleServiceImpl();
        vehicleService.setVehicleDao(vehicleDao);
    }    
    
    @Test
    public void testCreate() {
        VehicleTypeDto t = new VehicleTypeDto((long) 95000);
        VehicleDto v = new VehicleDto((long) 4, "Nissan GT-R", (long) 32000, t);
        
        Vehicle vehicle = vehicleService.create(v);
        
        ArgumentCaptor<Vehicle> captor = ArgumentCaptor.forClass(Vehicle.class);        
        Mockito.verify(vehicleDao)
               .persist(captor.capture());        
    }
    
    @Test
    public void testCreateWithNull() {
        try {
            vehicleService.create(null);
            fail();
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }    
    
    @Test
    public void testFindAll() {          
        vehicleService.findAll();        
        Mockito.verify(vehicleDao).findAll();
    }
    
    @Test
    public void testFindById() {        
        vehicleService.findById((long)2);
        
        Mockito.verify(vehicleDao)
               .findById((long)2);
    }
    
    @Test
    public void testUpdate() {        
        VehicleTypeDto t = new VehicleTypeDto((long) 95000);
        VehicleDto v = new VehicleDto((long) 4, "Nissan GT-R", (long) 32000, t);
        
        ArgumentCaptor<Vehicle> captor = ArgumentCaptor.forClass(Vehicle.class);
        vehicleService.update(v);
        
        Mockito.verify(vehicleDao)
               .update(captor.capture());       
    }
    
    @Test
    public void testDelete() {
        VehicleTypeDto t = new VehicleTypeDto((long) 95000);
        VehicleDto v = new VehicleDto((long) 4, "Nissan GT-R", (long) 32000, t);
        
        ArgumentCaptor<Vehicle> captor = ArgumentCaptor.forClass(Vehicle.class);
        vehicleService.delete(v.getId());
        
        Mockito.verify(vehicleDao)
               .remove(captor.capture());

    }     
}
