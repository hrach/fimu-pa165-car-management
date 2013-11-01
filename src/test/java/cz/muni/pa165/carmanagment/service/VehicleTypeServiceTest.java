/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.pa165.carmanagment.service;

import cz.muni.pa165.carmanagment.dao.VehicleTypeDaoImpl;
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
    
    @Override
    public void setUp() throws Exception {
        super.setUp();
        
        vehicleTypeDao = mock(VehicleTypeDaoImpl.class);
        vehicleTypeService = new VehicleTypeServiceImpl();
        vehicleTypeService.setVehicleTypeDao(vehicleTypeDao);
    }
    
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
    
}
