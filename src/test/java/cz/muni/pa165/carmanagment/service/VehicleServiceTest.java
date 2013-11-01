/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.pa165.carmanagment.service;

import cz.muni.pa165.carmanagment.dao.RideDaoImpl;
import cz.muni.pa165.carmanagment.dao.VehicleDaoImpl;
import cz.muni.pa165.carmanagment.dto.RideDto;
import cz.muni.pa165.carmanagment.dto.VehicleDto;
import cz.muni.pa165.carmanagment.dto.VehicleTypeDto;
import cz.muni.pa165.carmanagment.model.Vehicle;
import java.util.Date;
import java.util.List;
import static org.mockito.Mockito.*;
import static junit.framework.Assert.*;
import junit.framework.TestCase;

/**
 *
 * @author tomasbobek
 */
public class VehicleServiceTest extends TestCase {
    
    private VehicleDaoImpl vehicleDao;
    private VehicleServiceImpl vehicleService;
    
    private RideDaoImpl rideDao;
    private RideServiceImpl rideService;
    
    @Override
    public void setUp() throws Exception {
        super.setUp();
        
        vehicleDao = mock(VehicleDaoImpl.class);
        vehicleService = new VehicleServiceImpl();
        vehicleService.setVehicleDao(vehicleDao);
        
        rideDao = mock(RideDaoImpl.class);
        rideService = new RideServiceImpl();
        rideService.setRideDao(rideDao);
    }
    
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testCreateVehicle() {
        VehicleTypeDto t = new VehicleTypeDto((long) 95000);
        VehicleDto v = new VehicleDto((long) 4, "Nissan GT-R", (long) 32000, t);
        
        Vehicle vehicle = vehicleService.create(v);
        
        assertNotNull(vehicle.getId());
        assertEquals(4, (long) vehicle.getId());
    }
    
    public void testGetVehicle() {
        VehicleTypeDto t = new VehicleTypeDto((long) 95000);
        VehicleTypeDto t1 = new VehicleTypeDto((long) 125000);
        VehicleTypeDto t2 = new VehicleTypeDto((long) 150000);
        VehicleDto v = new VehicleDto((long) 4, "Nissan GT-R", (long) 32000, t);
        VehicleDto v1 = new VehicleDto((long) 7, "Mercedes CLS AMG", (long) 14300, t1);
        VehicleDto v2 = new VehicleDto((long) 7, "Porsche 911 Carerra S", (long) 14300, t2);
        
        vehicleService.create(v);
        vehicleService.create(v1);
        vehicleService.create(v2);
        
        assertEquals(v, vehicleService.findById(v.getId()));
        assertEquals(v1.getType(), vehicleService.findById(v1.getId()).getType());
        assertEquals(v2.getName(), vehicleService.findById(v2.getId()).getName());
        
        List<VehicleDto> vehicles = vehicleService.findAll();
        assertEquals(3, vehicles.size());
        assertTrue(vehicles.contains(v));
        assertTrue(vehicles.contains(v1));
        assertTrue(vehicles.contains(v2));  
    }
    
    public void testGetVehicleRides() {
        VehicleTypeDto t = new VehicleTypeDto((long) 95000);
        VehicleDto v = new VehicleDto((long) 4, "Nissan GT-R", (long) 32000, t);
        RideDto r1 = new RideDto((long) 1, new Date(2013,10,3), new Date(2013,10,5), (long) 5000, (long) 5200, "Short ride.", v, null);
        RideDto r2 = new RideDto((long) 2, new Date(2013,9,7), new Date(2013,9,17), (long) 3000, (long) 3800, "Long ride.", v, null);
        
        vehicleService.create(v);
        rideService.create(r1);
        rideService.create(r2);
        
        List<RideDto> rides = vehicleService.getRidesForVehicle(v.getId());
        assertEquals(2, rides.size());
        assertTrue(rides.contains(r1));
        assertTrue(rides.contains(r2));
    }
    
    public void testUpdateVehicle() {
        VehicleTypeDto t = new VehicleTypeDto((long) 95000);
        VehicleDto v = new VehicleDto((long) 4, "Nissan GT-R", (long) 32000, t);
        
        vehicleService.create(v);
        v.setName("Mercedes CLS AMG");
        vehicleService.update(v);
        VehicleDto v2 = vehicleService.findById(v.getId());
        
        assertEquals(v, v2);
        assertEquals(v.getName(), v2.getName());
    }
    
    public void testDeleteVehicle() {
        VehicleTypeDto t = new VehicleTypeDto((long) 95000);
        VehicleDto v = new VehicleDto((long) 4, "Nissan GT-R", (long) 32000, t);
        
        Vehicle vehicle = vehicleService.create(v);
        Long vehicleId = vehicle.getId();
        vehicleService.delete(vehicleId);
        
        assertNull(vehicleService.findById(vehicleId));
    }
    
}
