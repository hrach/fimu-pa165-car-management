/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.pa165.carmanagment.service;

import cz.muni.pa165.carmanagment.dao.VehicleDaoImpl;
import cz.muni.pa165.carmanagment.dto.VehicleDto;
import cz.muni.pa165.carmanagment.dto.VehicleTypeDto;
import cz.muni.pa165.carmanagment.model.Vehicle;
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
    
    @Override
    public void setUp() throws Exception {
        super.setUp();
        
        vehicleDao = mock(VehicleDaoImpl.class);
        vehicleService = new VehicleServiceImpl();
        vehicleService.setVehicleDao(vehicleDao);
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
    
    public void testUpdateVehicle() {
        VehicleTypeDto t = new VehicleTypeDto((long) 95000);
        VehicleDto v = new VehicleDto((long) 4, "Nissan GT-R", (long) 32000, t);
        
        Vehicle vehicle = vehicleService.create(v);
        v.setName("Mercedes CLS AMG");
        vehicleService.update(v);
        VehicleDto v2 = vehicleService.findById(vehicle.getId());
        
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
