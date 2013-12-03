
package cz.muni.fi.pa165.carmanagement.impl.dao;

import cz.muni.fi.pa165.carmanagement.impl.model.Employee;
import cz.muni.fi.pa165.carmanagement.impl.model.Ride;
import cz.muni.fi.pa165.carmanagement.impl.model.Vehicle;
import cz.muni.fi.pa165.carmanagement.impl.model.VehicleType;
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
 * RideDao tests.
 * @author skrasek
 */
public class RideDaoTest extends TestCase 
{

    public EntityManagerFactory emf;

    public RideDaoTest(String testName) {
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

    public void testCreateRide() {
        EntityManager em = emf.createEntityManager();
        RideDaoImpl dao = new RideDaoImpl(em);

        Employee employee = new Employee("test","user");
        Vehicle vehicle = new Vehicle("super car", (long) 0);
        vehicle.setType(new VehicleType((long) 233, "name"));
        Ride ride = new Ride();
        ride.setEmployee(employee);
        ride.setVehicle(vehicle);

        em.getTransaction().begin();
        dao.persist(ride);
        em.getTransaction().commit();
        
        em.clear();
        
        Long id = ride.getId();
        assertNotNull(id);
        
        Ride ride2 = dao.findById(id);
        assertEquals(ride, ride2);
        assertEquals(ride.getEmployee(), ride2.getEmployee());
    } 
    
    public void testGetRide() {
        EntityManager em = emf.createEntityManager();
        RideDaoImpl dao = new RideDaoImpl(em);
        
        Employee employee = new Employee("test","user");
        Vehicle vehicle = new Vehicle("super car", (long) 0);
        vehicle.setType(new VehicleType((long) 233, "name"));
        
        Ride ride1 = new Ride(employee, vehicle);
        Ride ride2 = new Ride(employee, vehicle);
        Ride ride3 = new Ride(employee, vehicle);
        
        em.getTransaction().begin();
        dao.persist(ride1);
        dao.persist(ride2);
        dao.persist(ride3);
        em.getTransaction().commit();
        em.clear();
        
        Long id1 = ride1.getId();
        Long id2 = ride2.getId();
        Long id3 = ride3.getId();
        
        assertNotNull(id1);
        assertNotNull(id2);
        assertNotNull(id3);
        
        Ride newRide = dao.findById(id1);
        assertEquals(ride1, newRide);
        assertEquals(ride1.getEmployee(), newRide.getEmployee());
        assertEquals(ride2, dao.findById(id2));
        assertEquals(ride3, dao.findById(id3));
        
        List<Ride> vehicles = dao.findAll();
        assertEquals(vehicles.size(), 3);
        assertTrue(vehicles.contains(ride1));
        assertTrue(vehicles.contains(ride2));
        assertTrue(vehicles.contains(ride3));
    }

    public void testUpdateRide() {
        Employee employee = new Employee("test","user");
        Vehicle vehicle = new Vehicle("super car", (long) 0);
        vehicle.setType(new VehicleType((long) 233, "name"));
        
        Ride ride1 = new Ride(employee, vehicle);
        
        EntityManager em = emf.createEntityManager();
        RideDaoImpl dao = new RideDaoImpl(em);
                
        em.getTransaction().begin();
        dao.persist(ride1);
        em.getTransaction().commit();
        
        Employee employee2 = new Employee("jan","skrasek");
        ride1.setEmployee(employee2);
                
        em.getTransaction().begin();
        dao.update(ride1);
        em.getTransaction().commit();
        em.clear();

        Ride ride2 = dao.findById(ride1.getId());

        assertEquals(ride1, ride2);
        assertEquals(ride1.getEmployee(), ride2.getEmployee());
    }

    public void testDeleteRide() {
        Employee employee = new Employee("test","user");
        Vehicle vehicle = new Vehicle("super car", (long) 0);
        vehicle.setType(new VehicleType((long) 233, "name"));

        EntityManager em = emf.createEntityManager();
        RideDaoImpl dao = new RideDaoImpl(em);
        
        Ride ride = new Ride();
        ride.setEmployee(employee);
        ride.setVehicle(vehicle);
        
        em.getTransaction().begin();
        dao.persist(ride);
        em.getTransaction().commit();
        
        Long rideId = ride.getId();

        em.getTransaction().begin();
        dao.remove(ride);
        em.getTransaction().commit();
        em.clear();
        
        assertNull(dao.findById(rideId));
    }

}
