/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.dto.ServiceIntervalDto;
import cz.muni.fi.pa165.carmanagement.api.dto.ServiceTypeDto;
import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import cz.muni.fi.pa165.carmanagement.api.dto.VehicleTypeDto;
import cz.muni.fi.pa165.carmanagement.impl.dao.ServiceIntervalDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.ServiceInterval;
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
public class ServiceIntervalServiceTest extends TestCase {
    
    private ServiceIntervalServiceImpl serviceIntervalService;    
    @Mock private ServiceIntervalDaoImpl serviceIntervalDao;    
    
    @Before
    public void setUp() throws Exception {
        super.setUp();
        
        serviceIntervalService = new ServiceIntervalServiceImpl();
        serviceIntervalService.setDao(serviceIntervalDao);
    }

    @Test
    public void testCreate() {
        VehicleTypeDto t = new VehicleTypeDto((long) 95000);
        VehicleDto v = new VehicleDto((long) 4, "Nissan GT-R", (long) 32000, t);        
        ServiceTypeDto st = new ServiceTypeDto((long)1, "Výměna oleje");        
        ServiceIntervalDto i = new ServiceIntervalDto((long)1, null, null, null, v, st);
                
        ServiceIntervalDto i2 = serviceIntervalService.create(i);
        
        ArgumentCaptor<ServiceInterval> captor = ArgumentCaptor.forClass(ServiceInterval.class);        
        Mockito.verify(serviceIntervalDao)
               .persist(captor.capture());

    }
    
    @Test
    public void testCreateWithNull() {
        try {
            ServiceIntervalDto i2 = serviceIntervalService.create(null);
            fail();
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }    
    
    @Test
    public void testFindAll() {          
        serviceIntervalService.findAll();        
        Mockito.verify(serviceIntervalDao).findAll();
    }
    
    @Test
    public void testFindById() {        
        serviceIntervalService.findById((long)2);
        
        Mockito.verify(serviceIntervalDao)
               .findById((long)2);
    }
    
    @Test
    public void testUpdate() {        
        VehicleTypeDto t = new VehicleTypeDto((long) 95000);
        VehicleDto v = new VehicleDto((long) 4, "Nissan GT-R", (long) 32000, t);        
        ServiceTypeDto st = new ServiceTypeDto((long)1, "Výměna oleje");        
        ServiceIntervalDto i = new ServiceIntervalDto((long)1, null, null, null, v, st);
        
        ArgumentCaptor<ServiceInterval> captor = ArgumentCaptor.forClass(ServiceInterval.class);
        serviceIntervalService.update(i);
        
        Mockito.verify(serviceIntervalDao)
               .update(captor.capture());       
    }
    
    @Test
    public void testDelete() {
        VehicleTypeDto t = new VehicleTypeDto((long) 95000);
        VehicleDto v = new VehicleDto((long) 4, "Nissan GT-R", (long) 32000, t);        
        ServiceTypeDto st = new ServiceTypeDto((long)1, "Výměna oleje");        
        ServiceIntervalDto i = new ServiceIntervalDto((long)1, null, null, null, v, st);
        
        ArgumentCaptor<ServiceInterval> captor = ArgumentCaptor.forClass(ServiceInterval.class);
        serviceIntervalService.delete(i.getId());
        
        Mockito.verify(serviceIntervalDao)
               .remove(captor.capture());

    }
}
