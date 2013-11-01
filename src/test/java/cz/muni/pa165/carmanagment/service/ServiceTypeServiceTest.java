/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.pa165.carmanagment.service;

import cz.muni.pa165.carmanagment.dao.ServiceTypeDaoImpl;
import cz.muni.pa165.carmanagment.dto.ServiceTypeDto;
import cz.muni.pa165.carmanagment.model.ServiceType;
import java.util.List;
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
 * @author tomasbobek
 */
@RunWith(MockitoJUnitRunner.class)
public class ServiceTypeServiceTest extends TestCase {
    
    private ServiceTypeServiceImpl serviceTypeService;    
    @Mock private ServiceTypeDaoImpl serviceTypeDao;    
    
    @Before
    public void setUp() throws Exception {
        super.setUp();
        
        serviceTypeService = new ServiceTypeServiceImpl();
        serviceTypeService.setServiceTypeDao(serviceTypeDao);
    }

    @Test
    public void testCreate() {
        ServiceTypeDto t = new ServiceTypeDto((long)1, "Výměna oleje");
                
        serviceTypeService.create(t);
        
        ArgumentCaptor<ServiceType> captor = ArgumentCaptor.forClass(ServiceType.class);        
        Mockito.verify(serviceTypeDao)
               .persist(captor.capture());

    }
    
    @Test
    public void testCreateWithNull() {
        try {
            serviceTypeService.create(null);
            fail();
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }    
    
    @Test
    public void testFindAll() {          
        serviceTypeService.findAll();        
        Mockito.verify(serviceTypeDao).findAll();
    }
    
    @Test
    public void testFindById() {        
        ArgumentCaptor<ServiceType> captor = ArgumentCaptor.forClass(ServiceType.class);
        serviceTypeService.findById((long)2);
        
        Mockito.verify(serviceTypeDao)
               .findById((long)2);
    }
    
    @Test
    public void testUpdate() {
        
        ServiceTypeDto t = new ServiceTypeDto((long) 1, "Výměna oleje");
        
        ArgumentCaptor<ServiceType> captor = ArgumentCaptor.forClass(ServiceType.class);
        serviceTypeService.update(t);
        
        Mockito.verify(serviceTypeDao)
               .update(captor.capture());       
    }
    
    @Test
    public void testDelete() {
        ServiceTypeDto t = new ServiceTypeDto((long) 1, "Výměna oleje");
        
        ArgumentCaptor<ServiceType> captor = ArgumentCaptor.forClass(ServiceType.class);
        serviceTypeService.delete(t.getId());
        
        Mockito.verify(serviceTypeDao)
               .remove(captor.capture());

    }
}
