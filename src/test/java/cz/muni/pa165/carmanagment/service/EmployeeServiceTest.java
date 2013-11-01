/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.pa165.carmanagment.service;

import cz.muni.pa165.carmanagment.dao.EmployeeDaoImpl;
import cz.muni.pa165.carmanagment.dto.EmployeeDto;
import cz.muni.pa165.carmanagment.model.Employee;
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
 * @author zvonicek
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest extends TestCase {
    
    private EmployeeServiceImpl employeeService;    
    @Mock private EmployeeDaoImpl employeeDao;    
    
    @Before
    public void setUp() throws Exception {
        super.setUp();
        
        employeeService = new EmployeeServiceImpl();
        employeeService.setDao(employeeDao);
    }

    @Test
    public void testCreate() {
        EmployeeDto t = new EmployeeDto((long)1, "John", "Doe", 1);
                
        employeeService.create(t);
        
        ArgumentCaptor<Employee> captor = ArgumentCaptor.forClass(Employee.class);        
        Mockito.verify(employeeDao)
               .persist(captor.capture());

    }
    
    @Test
    public void testCreateWithNull() {
        try {
            employeeService.create(null);
            fail();
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }    
    
    @Test
    public void testFindAll() {          
        employeeService.findAll();        
        Mockito.verify(employeeDao).findAll();
    }
    
    @Test
    public void testFindById() {        
        employeeService.findById((long)2);
        
        Mockito.verify(employeeDao)
               .findById((long)2);
    }
    
    @Test
    public void testUpdate() {
        
        EmployeeDto t = new EmployeeDto((long)1, "John", "Doe", 1);
        
        ArgumentCaptor<Employee> captor = ArgumentCaptor.forClass(Employee.class);
        employeeService.update(t);
        
        Mockito.verify(employeeDao)
               .update(captor.capture());       
    }
    
    @Test
    public void testDelete() {
        EmployeeDto t = new EmployeeDto((long)1, "John", "Doe", 1);
        
        ArgumentCaptor<Employee> captor = ArgumentCaptor.forClass(Employee.class);
        employeeService.delete(t.getId());
        
        Mockito.verify(employeeDao)
               .remove(captor.capture());

    }
}
