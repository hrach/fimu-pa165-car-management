package cz.muni.fi.pa165.carmanagement.impl.dao;

import cz.muni.fi.pa165.carmanagement.impl.model.ServiceInterval;
import cz.muni.fi.pa165.carmanagement.impl.model.ServiceType;
import cz.muni.fi.pa165.carmanagement.impl.model.Vehicle;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.TestCase;

/**
 * ServiceIntervalDao Test
 * @author zvonicek
 */
public class ServiceIntervalDaoTest extends TestCase {

    public EntityManagerFactory emf;

    public ServiceIntervalDaoTest(String testName) {
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

    public void testCreateServiceInterval() {
        EntityManager em = emf.createEntityManager();
        ServiceIntervalDaoImpl dao = new ServiceIntervalDaoImpl(em);
        VehicleDaoImpl vehicleDao = new VehicleDaoImpl(em);
        ServiceTypeDaoImpl sevTypeDao = new ServiceTypeDaoImpl(em);

        Vehicle vehicle = new Vehicle("Skoda Octavia", (long) 100000);
        ServiceType type = new ServiceType("Type 1");
        ServiceInterval interval = new ServiceInterval(new GregorianCalendar(2013, 10, 10).getTime(), new GregorianCalendar(2013, 12, 01).getTime(), null, vehicle, type);

        em.getTransaction().begin();
        vehicleDao.persist(vehicle);
        sevTypeDao.persist(type);
        dao.persist(interval);
        em.getTransaction().commit();
        em.clear();

        Long id = vehicle.getId();
        assertNotNull(id);

        ServiceInterval interval2 = dao.findById(id);
        assertEquals(interval, interval2);
        
        // test the relation
        ServiceType t = sevTypeDao.findById(type.getId());
        List<ServiceInterval> intervals = t.getServices();
        
        assertEquals(intervals.size(), 1);
        assertTrue(intervals.contains(interval));
    }

    public void testGetServiceInterval() {
        EntityManager em = emf.createEntityManager();
        ServiceIntervalDaoImpl dao = new ServiceIntervalDaoImpl(em);

        ServiceInterval interval = new ServiceInterval(new GregorianCalendar(2011, 10, 10).getTime(), new GregorianCalendar(2012, 10, 01).getTime(), new GregorianCalendar(1012, 10, 10).getTime(), null, null);
        ServiceInterval interval2 = new ServiceInterval(new GregorianCalendar(2012, 10, 10).getTime(), new GregorianCalendar(2013, 10, 01).getTime(), new GregorianCalendar(1013, 10, 10).getTime(), null, null);
        ServiceInterval interval3 = new ServiceInterval(new GregorianCalendar(2013, 10, 10).getTime(), new GregorianCalendar(2014, 10, 01).getTime(), null, null, null);

        em.getTransaction().begin();
        dao.persist(interval);
        dao.persist(interval2);
        dao.persist(interval3);
        em.getTransaction().commit();
        em.clear();

        Long id = interval.getId();
        Long id2 = interval2.getId();
        Long id3 = interval3.getId();

        assertNotNull(id);
        assertNotNull(id2);
        assertNotNull(id3);

        assertEquals(interval, dao.findById(id));
        assertEquals(interval2, dao.findById(id2));
        assertEquals(interval3, dao.findById(id3));

        List<ServiceInterval> intervals = dao.findAll();
        assertEquals(intervals.size(), 3);
        assertTrue(intervals.contains(interval));
        assertTrue(intervals.contains(interval2));
        assertTrue(intervals.contains(interval3));
    }

    public void testUpdateServiceInterval() {
        ServiceInterval interval = new ServiceInterval(new GregorianCalendar(2013, 10, 10).getTime(), new GregorianCalendar(2013, 12, 01).getTime(), null, null, null);

        EntityManager em = emf.createEntityManager();
        ServiceIntervalDaoImpl dao = new ServiceIntervalDaoImpl(em);

        em.getTransaction().begin();
        dao.persist(interval);
        em.getTransaction().commit();
        em.clear();

        interval.setDoneTime(new GregorianCalendar(2013, 10, 11).getTime());

        em.getTransaction().begin();
        dao.update(interval);
        em.getTransaction().commit();
        em.clear();

        ServiceInterval interval2 = dao.findById(interval.getId());

        assertEquals(interval, interval2);
        assertEquals(interval.getDoneTime(), interval2.getDoneTime());
    }

    public void testDeleteServiceInterval() {
        EntityManager em = emf.createEntityManager();
        ServiceIntervalDaoImpl dao = new ServiceIntervalDaoImpl(em);

        ServiceInterval interval = new ServiceInterval(new GregorianCalendar(2013, 10, 10).getTime(), new GregorianCalendar(2013, 12, 01).getTime(), null, null, null);

        em.getTransaction().begin();
        dao.persist(interval);
        em.getTransaction().commit();

        Long intervalId = interval.getId();

        em.getTransaction().begin();
        dao.remove(interval);
        em.getTransaction().commit();
        em.clear();

        assertNull(dao.findById(intervalId));
    }
}
