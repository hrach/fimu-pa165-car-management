/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.pa165.carmanagment.service;

import cz.muni.pa165.carmanagment.dao.ServiceTypeDaoImpl;
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
    
}
