/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.pa165.carmanagment.service;

import cz.muni.pa165.carmanagment.dao.ServiceTypeDaoImpl;
import cz.muni.pa165.carmanagment.dto.ServiceTypeDto;
import cz.muni.pa165.carmanagment.model.ServiceType;
import java.util.List;
import static org.mockito.Mockito.*;
import static junit.framework.Assert.*;
import junit.framework.TestCase;

/**
 *
 * @author tomasbobek
 */
public class ServiceTypeServiceTest extends TestCase {
    
    private ServiceTypeDaoImpl serviceTypeDao;
    private ServiceTypeServiceImpl serviceTypeService;
    
    @Override
    public void setUp() throws Exception {
        super.setUp();
        
        serviceTypeDao = mock(ServiceTypeDaoImpl.class);
        serviceTypeService = new ServiceTypeServiceImpl();
        serviceTypeService.setServiceTypeDao(serviceTypeDao);
    }
    
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testCreateServiceType() {
        ServiceTypeDto t = new ServiceTypeDto((long) 1, "Výměna oleje");
        
        ServiceType type = serviceTypeService.create(t);
        
        assertNotNull(type.getId());
        assertEquals(t.getId(), type.getId());
    }
    
    public void testGetServiceType() {
        ServiceTypeDto t = new ServiceTypeDto((long) 1, "Výměna oleje");
        ServiceTypeDto t1 = new ServiceTypeDto((long) 2, "Výměna brzdových destiček");
        ServiceTypeDto t2 = new ServiceTypeDto((long) 3, "Kontrola chladící kapaliny");
        
        serviceTypeService.create(t);
        serviceTypeService.create(t1);
        serviceTypeService.create(t2);
        
        assertEquals(t, serviceTypeService.findById(t.getId()));
        assertEquals(t1.getId(), serviceTypeService.findById(t1.getId()).getId());
        assertEquals(t2.getName(), serviceTypeService.findById(t2.getId()).getName());
        
        List<ServiceTypeDto> types = serviceTypeService.findAll();
        assertEquals(3, types.size());
        assertTrue(types.contains(t));
        assertTrue(types.contains(t1));
        assertTrue(types.contains(t2));
    }
    
    public void testUpdateServiceType() {
        ServiceTypeDto t = new ServiceTypeDto((long) 1, "Výměna oleje");
        
        serviceTypeService.create(t);
        t.setName("Výměna brzdových destiček");
        serviceTypeService.update(t);
        ServiceTypeDto t1 = serviceTypeService.findById(t.getId());
        
        assertEquals(t, t1);
        assertEquals(t.getName(), t1.getName());
    }
    
    public void testDeleteServiceType() {
        ServiceTypeDto t = new ServiceTypeDto((long) 1, "Výměna oleje");
        
        ServiceType type = serviceTypeService.create(t);
        Long typeId = type.getId();
        serviceTypeService.delete(typeId);
        
        assertNull(serviceTypeService.findById(typeId));
    }
}
