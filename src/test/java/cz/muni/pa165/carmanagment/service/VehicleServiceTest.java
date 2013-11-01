/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.pa165.carmanagment.service;

import cz.muni.pa165.carmanagment.dao.VehicleDaoImpl;
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
    
}
