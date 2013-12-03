/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import cz.muni.fi.pa165.carmanagement.api.dto.VehicleTypeDto;
import cz.muni.fi.pa165.carmanagement.impl.dao.VehicleDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.dao.VehicleTypeDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.Vehicle;
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
    @Mock private VehicleTypeDaoImpl vehicleTypeDao;
    
    @Before
    public void setUp() throws Exception {
        super.setUp();
        
        vehicleService = new VehicleServiceImpl();
        vehicleService.setVehicleDao(vehicleDao);
        vehicleService.setTypeDao(vehicleTypeDao);
    }    
    
    @Test
    public void testCreate() {
        VehicleTypeDto t = new VehicleTypeDto((long) 95000, "name");
        VehicleDto v = new VehicleDto((long) 4, "Nissan GT-R", (long) 32000, t);
        
        VehicleDto v2 = vehicleService.create(v);
        
        ArgumentCaptor<Vehicle> captor = ArgumentCaptor.forClass(Vehicle.class);        
        Mockito.verify(vehicleDao)
               .persist(captor.capture());        
    }
    
    @Test
    public void testCreateWithNull() {
        try {
            VehicleDto v2 = vehicleService.create(null);
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
        VehicleTypeDto t = new VehicleTypeDto((long) 95000, "name");
        VehicleDto v = new VehicleDto((long) 4, "Nissan GT-R", (long) 32000, t);
        
        ArgumentCaptor<Vehicle> captor = ArgumentCaptor.forClass(Vehicle.class);
        vehicleService.update(v);
        
        Mockito.verify(vehicleDao)
               .update(captor.capture());       
    }
    
    @Test
    public void testDelete() {
        VehicleTypeDto t = new VehicleTypeDto((long) 95000, "name");
        VehicleDto v = new VehicleDto((long) 4, "Nissan GT-R", (long) 32000, t);
        
        ArgumentCaptor<Vehicle> captor = ArgumentCaptor.forClass(Vehicle.class);
        vehicleService.delete(v.getId());
        
        Mockito.verify(vehicleDao)
               .remove(captor.capture());

    }     
}
