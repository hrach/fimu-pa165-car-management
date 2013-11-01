/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.pa165.carmanagment.service;

import cz.muni.pa165.carmanagment.dao.VehicleDaoImpl;
import cz.muni.pa165.carmanagment.dao.VehicleTypeDaoImpl;
import cz.muni.pa165.carmanagment.dto.VehicleDto;
import cz.muni.pa165.carmanagment.dto.VehicleTypeDto;
import cz.muni.pa165.carmanagment.model.VehicleType;
import java.util.List;
import static org.mockito.Mockito.*;
import static junit.framework.Assert.*;
import junit.framework.TestCase;

/**
 *
 * @author tomasbobek
 */
public class VehicleTypeServiceTest extends TestCase {
    
    private VehicleTypeDaoImpl vehicleTypeDao;
    private VehicleTypeServiceImpl vehicleTypeService;
    
    private VehicleDaoImpl vehicleDao;
    private VehicleServiceImpl vehicleService;
    
    @Override
    public void setUp() throws Exception {
        super.setUp();
        
        vehicleTypeDao = mock(VehicleTypeDaoImpl.class);
        vehicleTypeService = new VehicleTypeServiceImpl();
        vehicleTypeService.setVehicleTypeDao(vehicleTypeDao);
        
        vehicleDao = mock(VehicleDaoImpl.class);
        vehicleService = new VehicleServiceImpl();
        vehicleService.setVehicleDao(vehicleDao);
    }
    
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testCreateVehicleType() {
        VehicleTypeDto t = new VehicleTypeDto((long) 3, (long) 200000);
        
        VehicleType type = vehicleTypeService.create(t);
        
        assertNotNull(type.getId());
        assertEquals(t.getId(), type.getId());
    }
    
    public void testGetVehicleType() {
        VehicleTypeDto t = new VehicleTypeDto((long) 95000);
        VehicleTypeDto t1 = new VehicleTypeDto((long) 125000);
        VehicleTypeDto t2 = new VehicleTypeDto((long) 150000);
        
        vehicleTypeService.create(t);
        vehicleTypeService.create(t1);
        vehicleTypeService.create(t2);
        
        assertEquals(t, vehicleTypeService.findById(t.getId()));
        assertEquals(t1.getId(), vehicleTypeService.findById(t1.getId()).getId());
        assertEquals(t2.getMaxKm(), vehicleTypeService.findById(t2.getId()).getMaxKm());
        
        List<VehicleTypeDto> types = vehicleTypeService.findAll();
        assertEquals(3, types.size());
        assertTrue(types.contains(t));
        assertTrue(types.contains(t1));
        assertTrue(types.contains(t2));
    }
    
    public void testGetTypeVehicles() {
        VehicleTypeDto t = new VehicleTypeDto((long) 3, (long) 200000);
        VehicleDto v = new VehicleDto((long) 4, "Nissan GT-R", (long) 32000, t);
        VehicleDto v1 = new VehicleDto((long) 7, "Mercedes CLS AMG", (long) 14300, t);
        
        vehicleTypeService.create(t);
        vehicleService.create(v);
        vehicleService.create(v1);
        
        List<VehicleDto> vehicles = vehicleTypeService.getVehiclesForType(t.getId());
        assertEquals(2, vehicles.size());
        assertTrue(vehicles.contains(v));
        assertTrue(vehicles.contains(v1));
    }
    
    public void testUpdateVehicleType() {
        VehicleTypeDto t = new VehicleTypeDto((long) 3, (long) 200000);
        
        vehicleTypeService.create(t);
        t.setMaxKm((long) 300000);
        vehicleTypeService.update(t);
        VehicleTypeDto t1 = vehicleTypeService.findById(t.getId());
        
        assertEquals(t, t1);
        assertEquals(t.getMaxKm(), t1.getMaxKm());
    }
    
    public void testDeleteVehicleType() {
        VehicleTypeDto t = new VehicleTypeDto((long) 3, (long) 200000);
        
        VehicleType type = vehicleTypeService.create(t);
        Long typeId = type.getId();
        vehicleTypeService.delete(typeId);
        
        assertNull(vehicleTypeService.findById(typeId));
    }
}
