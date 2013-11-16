/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.dto.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import cz.muni.fi.pa165.carmanagement.api.dto.VehicleTypeDto;
import cz.muni.fi.pa165.carmanagement.impl.dao.RideDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.Ride;
import static junit.framework.Assert.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 *
 * @author zvonicek
 */
@RunWith(MockitoJUnitRunner.class)
public class RideServiceTest extends TestCase {
    
    private RideServiceImpl rideService;    
    @Mock private RideDaoImpl rideDao;    
    
    @Before
    public void setUp() throws Exception {
        super.setUp();
        
        rideService = new RideServiceImpl();
        rideService.setRideDao(rideDao);
    }

    @Test
    public void testCreate() {
        EmployeeDto e = new EmployeeDto((long)1, "John", "Doe", 1);
        VehicleTypeDto t = new VehicleTypeDto((long) 95000);
        VehicleDto v = new VehicleDto((long) 4, "Nissan GT-R", (long) 32000, t);        
        RideDto r = new RideDto((long)1, null, null, (long)150000, (long)151000, "Pracovní cesta", v, e);
                
        rideService.create(r);
        
        ArgumentCaptor<Ride> captor = ArgumentCaptor.forClass(Ride.class);        
        Mockito.verify(rideDao)
               .persist(captor.capture());

    }
    
    @Test
    public void testCreateWithNull() {
        try {
            rideService.create(null);
            fail();
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }    
    
    @Test
    public void testFindAll() {          
        rideService.findAll();        
        Mockito.verify(rideDao).findAll();
    }
    
    @Test
    public void testFindById() {        
        rideService.findById((long)2);
        
        Mockito.verify(rideDao)
               .findById((long)2);
    }
    
    @Test
    public void testUpdate() {        
        EmployeeDto e = new EmployeeDto((long)1, "John", "Doe", 1);
        VehicleTypeDto t = new VehicleTypeDto((long) 95000);
        VehicleDto v = new VehicleDto((long) 4, "Nissan GT-R", (long) 32000, t);        
        RideDto r = new RideDto((long)1, null, null, (long)150000, (long)151000, "Pracovní cesta", v, e);
        
        ArgumentCaptor<Ride> captor = ArgumentCaptor.forClass(Ride.class);
        rideService.update(r);
        
        Mockito.verify(rideDao)
               .update(captor.capture());       
    }
    
    @Test
    public void testDelete() {
        EmployeeDto e = new EmployeeDto((long)1, "John", "Doe", 1);
        VehicleTypeDto t = new VehicleTypeDto((long) 95000);
        VehicleDto v = new VehicleDto((long) 4, "Nissan GT-R", (long) 32000, t);        
        RideDto r = new RideDto((long)1, null, null, (long)150000, (long)151000, "Pracovní cesta", v, e);
        
        ArgumentCaptor<Ride> captor = ArgumentCaptor.forClass(Ride.class);
        rideService.delete(r.getId());
        
        Mockito.verify(rideDao)
               .remove(captor.capture());

    }
}
