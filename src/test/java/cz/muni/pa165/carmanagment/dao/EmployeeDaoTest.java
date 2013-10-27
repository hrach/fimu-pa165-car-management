package cz.muni.pa165.carmanagment.dao;

import cz.muni.pa165.carmanagment.model.Employee;
import cz.muni.pa165.carmanagment.dao.EmployeeDaoImpl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;


/**
 * EmployeeDao tests.
 * @author skrasek
 */
public class EmployeeDaoTest extends TestCase 
{

    public EntityManagerFactory emf;

    public EmployeeDaoTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.emf = Persistence.createEntityManagerFactory("testPU");
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testCreateEmployee() {
        EntityManager em = emf.createEntityManager();
        EmployeeDaoImpl emDao = new EmployeeDaoImpl(em);

        Employee employee = new Employee("jan", "skrasek", Employee.ROLE_MANAGER);
        em.getTransaction().begin();
        emDao.persist(employee);
        em.getTransaction().commit();
        
        em.clear();
        
        Long id = employee.getId();
        assertNotNull(id);
        
        Employee employee2 = emDao.findById(id);
        assertEquals(employee, employee2);
    } 
    
    public void testGetEmployee() {
        EntityManager em = emf.createEntityManager();
        EmployeeDaoImpl dao = new EmployeeDaoImpl(em);
        
        Employee employee1 = new Employee("user","one");
        Employee employee2 = new Employee("user","two");
        Employee employee3 = new Employee("user","three");
        
        em.getTransaction().begin();
        dao.persist(employee1);
        dao.persist(employee2);
        dao.persist(employee3);
        em.getTransaction().commit();
        em.clear();
        
        Long id1 = employee1.getId();
        Long id2 = employee2.getId();
        Long id3 = employee3.getId();
        
        assertNotNull(id1);
        assertNotNull(id2);
        assertNotNull(id3);
        
        assertEquals(employee1, dao.findById(id1));
        assertEquals(employee2, dao.findById(id2));
        assertEquals(employee3, dao.findById(id3));
        
        List<Employee> vehicles = dao.findAll();
        assertEquals(vehicles.size(), 3);
        assertTrue(vehicles.contains(employee1));
        assertTrue(vehicles.contains(employee2));
        assertTrue(vehicles.contains(employee3));
    }

    public void testUpdateEmployee() {
        Employee employee = new Employee("user", "name");
        
        EntityManager em = emf.createEntityManager();
        EmployeeDaoImpl dao = new EmployeeDaoImpl(em);
                
        em.getTransaction().begin();
        dao.persist(employee);
        em.getTransaction().commit();
        em.clear();
        
        employee.setFamilyName("secondname");
                
        em.getTransaction().begin();
        dao.update(employee);
        em.getTransaction().commit();
        em.clear();

        Employee employee2 = dao.findById(employee.getId());

        assertEquals(employee, employee2);
        assertEquals(employee.getFullName(), employee2.getFullName());
    }

    public void testDeleteEmployee() {
        EntityManager em = emf.createEntityManager();
        EmployeeDaoImpl dao = new EmployeeDaoImpl(em);
        
        Employee employee = new Employee("martin", "dent");
        
        em.getTransaction().begin();
        dao.persist(employee);
        em.getTransaction().commit();
        
        Long employeeId = employee.getId();

        em.getTransaction().begin();
        dao.remove(employee);
        em.getTransaction().commit();
        em.clear();
        
        assertNull(dao.findById(employeeId));
    }

}
