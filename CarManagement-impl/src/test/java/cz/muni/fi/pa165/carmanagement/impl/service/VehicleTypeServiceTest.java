/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleTypeDto;
import cz.muni.fi.pa165.carmanagement.impl.dao.VehicleTypeDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.VehicleType;
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
public class VehicleTypeServiceTest extends TestCase {

    private VehicleTypeServiceImpl vehicleTypeService;    
    @Mock private VehicleTypeDaoImpl vehicleTypeDao;    

    @Before
    public void setUp() throws Exception {
        super.setUp();
        
        vehicleTypeService = new VehicleTypeServiceImpl();
        vehicleTypeService.setVehicleTypeDao(vehicleTypeDao);
    }        
    
    @Test
    public void testCreate() {
        VehicleTypeDto t = new VehicleTypeDto((long) 3, (long) 200000);
        
        VehicleTypeDto t2 = vehicleTypeService.create(t);
        
        ArgumentCaptor<VehicleType> captor = ArgumentCaptor.forClass(VehicleType.class);        
        Mockito.verify(vehicleTypeDao)
               .persist(captor.capture());        
    }
    
    @Test
    public void testCreateWithNull() {
        try {
            VehicleTypeDto t2 = vehicleTypeService.create(null);
            fail();
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }    
    
    @Test
    public void testFindAll() {          
        vehicleTypeService.findAll();        
        Mockito.verify(vehicleTypeDao).findAll();
    }
    
    @Test
    public void testFindById() {        
        vehicleTypeService.findById((long)2);
        
        Mockito.verify(vehicleTypeDao)
               .findById((long)2);
    }
    
    @Test
    public void testUpdate() {        
        VehicleTypeDto t = new VehicleTypeDto((long) 3, (long) 200000);
        
        ArgumentCaptor<VehicleType> captor = ArgumentCaptor.forClass(VehicleType.class);
        vehicleTypeService.update(t);
        
        Mockito.verify(vehicleTypeDao)
               .update(captor.capture());       
    }
    
    @Test
    public void testDelete() {
        VehicleTypeDto t = new VehicleTypeDto((long) 3, (long) 200000);
        
        ArgumentCaptor<VehicleType> captor = ArgumentCaptor.forClass(VehicleType.class);
        vehicleTypeService.delete(t.getId());
        
        Mockito.verify(vehicleTypeDao)
               .remove(captor.capture());

    }                
}
