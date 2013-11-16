package cz.muni.fi.pa165.carmanagement.impl.dao;

import cz.muni.fi.pa165.carmanagement.impl.model.Vehicle;
import cz.muni.fi.pa165.carmanagement.impl.model.VehicleType;
import java.util.Arrays;
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
 * VehicleTypeDao tests
 * @author zvonicek
 */
public class VehicleTypeDaoTest extends TestCase {

    public EntityManagerFactory emf;

    public VehicleTypeDaoTest(String testName) {
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
    
    public void testCreateVehicleType()
    {
        EntityManager em = emf.createEntityManager();
        
        VehicleDaoImpl vehicleDao = new VehicleDaoImpl(em);
        Vehicle v1 = new Vehicle("Skoda Octavia", (long) 8888);
        Vehicle v2 = new Vehicle("Skoda Fabia", (long) 11111);
        em.getTransaction().begin();
        vehicleDao.persist(v1);
        vehicleDao.persist(v2);
        em.getTransaction().commit();
        
        VehicleTypeDaoImpl dao = new VehicleTypeDaoImpl(em);
        
        VehicleType type = new VehicleType((long)500000);
        type.setVehicles(Arrays.asList(v1, v2));
        
        em.getTransaction().begin();
        dao.persist(type);
        em.getTransaction().commit();
        em.clear();
        
        Long id = type.getId();
        assertNotNull(id);
        
        VehicleType type2 = dao.findById(id);
        assertEquals(type, type2);
    }     

    public void testGetVehicleType() {
        EntityManager em = emf.createEntityManager();
        VehicleTypeDaoImpl dao = new VehicleTypeDaoImpl(em);

        VehicleType vehicle = new VehicleType((long) 500000);
        VehicleType vehicle2 = new VehicleType((long) 600000);
        VehicleType vehicle3 = new VehicleType((long) 450000);

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

        List<VehicleType> types = dao.findAll();
        assertEquals(types.size(), 3);
        assertTrue(types.contains(vehicle));
        assertTrue(types.contains(vehicle2));
        assertTrue(types.contains(vehicle3));
    }

    public void testUpdateVehicleType() {
        VehicleType vehicle = new VehicleType((long) 400000);

        EntityManager em = emf.createEntityManager();
        VehicleTypeDaoImpl dao = new VehicleTypeDaoImpl(em);

        em.getTransaction().begin();
        dao.persist(vehicle);
        em.getTransaction().commit();
        em.clear();

        vehicle.setMaxKm((long) 450000);

        em.getTransaction().begin();
        dao.update(vehicle);
        em.getTransaction().commit();
        em.clear();

        VehicleType vehicle2 = dao.findById(vehicle.getId());

        assertEquals(vehicle, vehicle2);
        assertEquals(vehicle.getMaxKm(), vehicle2.getMaxKm());
    }

    public void testDeleteVehicleType() {
        EntityManager em = emf.createEntityManager();
        VehicleTypeDaoImpl dao = new VehicleTypeDaoImpl(em);

        VehicleType vehicle = new VehicleType((long) 400000);

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
