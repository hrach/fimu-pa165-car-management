package cz.muni.pa165.carmanagment;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.TestCase;

/**
 *
 * @author zvonicek
 */
public class VehicleDaoTest extends TestCase 
{

    EntityManagerFactory emf;

    public VehicleDaoTest(String testName)
    {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        this.emf = Persistence.createEntityManagerFactory("testPU");
    }

    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();
    }

    public void testCreateVehicle()
    {
        EntityManager em = emf.createEntityManager();
        VehicleDao dao = new VehicleDao(em);
        
        Vehicle vehicle = new Vehicle("Skoda Octavia", (long)100000);
        
        em.getTransaction().begin();
        dao.persist(vehicle);
        em.getTransaction().commit();
        em.clear();
        
        Long id = vehicle.getId();
        assertNotNull(id);
        
        Vehicle vehicle2 = dao.findById(id);
        assertEquals(vehicle, vehicle2);
    } 
    
    public void testGetVehicle()
    {
        EntityManager em = emf.createEntityManager();
        VehicleDao dao = new VehicleDao(em);
        
        Vehicle vehicle = new Vehicle("Skoda Octavia", (long)100000);
        Vehicle vehicle2 = new Vehicle("Skoda Fabia", (long)80000);
        Vehicle vehicle3 = new Vehicle("Skoda Superb", (long)0);
        
        em.getTransaction().begin();
        dao.persist(vehicle);
        dao.persist(vehicle2);
        dao.persist(vehicle3);
        em.getTransaction().commit();
        em.clear();
        
        Long id = vehicle.getId();
        Long id2 = vehicle2.getId();
        Long id3 = vehicle3.getId();
        
        assertNotNull(id);
        assertNotNull(id2);
        assertNotNull(id3);
        
        assertEquals(vehicle, dao.findById(id));
        assertEquals(vehicle2, dao.findById(id2));
        assertEquals(vehicle3, dao.findById(id3));
        
        List<Vehicle> vehicles = dao.findAll();
        assertEquals(vehicles.size(), 3);
        assertTrue(vehicles.contains(vehicle));
        assertTrue(vehicles.contains(vehicle2));
        assertTrue(vehicles.contains(vehicle3));
    }
    
    public void testUpdateVehicle()
    {
        Vehicle vehicle = new Vehicle("Audi A4 Allroad", (long)130500);
        
        EntityManager em = emf.createEntityManager();
        VehicleDao dao = new VehicleDao(em);
                
        em.getTransaction().begin();
        dao.persist(vehicle);
        em.getTransaction().commit();
        em.clear();
        
        vehicle.setName("Audi A6");
        vehicle.setTchometer((long)131500);
        
        em.getTransaction().begin();
        dao.update(vehicle);
        em.getTransaction().commit();
        em.clear();
        
        Vehicle vehicle2 = dao.findById(vehicle.getId());
        
        assertEquals(vehicle, vehicle2);
        assertEquals(vehicle.getName(), vehicle2.getName());
        assertEquals(vehicle.getTachometer(), vehicle2.getTachometer());        
    }
    
    public void testDeleteVehicle()
    {
        EntityManager em = emf.createEntityManager();
        VehicleDao dao = new VehicleDao(em);
        
        Vehicle vehicle = new Vehicle("Skoda Octavia", (long)100000);
        
        em.getTransaction().begin();
        dao.persist(vehicle);
        em.getTransaction().commit();
        
        Long vehicleId = vehicle.getId();
        
        em.getTransaction().begin();
        dao.remove(vehicle);
        em.getTransaction().commit();
        em.clear();
        
        assertNull(dao.findById(vehicleId));
    }
           
}
