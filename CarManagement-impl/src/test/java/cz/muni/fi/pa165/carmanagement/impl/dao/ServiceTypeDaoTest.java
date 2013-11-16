package cz.muni.fi.pa165.carmanagement.impl.dao;

import cz.muni.fi.pa165.carmanagement.impl.model.ServiceType;
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
 * ServiceTypeDao Test
 * @author zvonicek
 */
public class ServiceTypeDaoTest extends TestCase {

    public EntityManagerFactory emf;

    public ServiceTypeDaoTest(String testName) {
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

    public void testCreateServiceType()
    {
        EntityManager em = emf.createEntityManager();
        ServiceTypeDaoImpl dao = new ServiceTypeDaoImpl(em);
        
        ServiceType type = new ServiceType("Typ 1");
        
        em.getTransaction().begin();
        dao.persist(type);
        em.getTransaction().commit();
        em.clear();
        
        Long id = type.getId();
        assertNotNull(id);
        
        ServiceType type2 = dao.findById(id);
        assertEquals(type, type2);
    }     
    
    public void testGetServiceType() {
        EntityManager em = emf.createEntityManager();
        ServiceTypeDaoImpl dao = new ServiceTypeDaoImpl(em);

        ServiceType t1 = new ServiceType("Typ 1");
        ServiceType t2 = new ServiceType("Typ 2");
        ServiceType t3 = new ServiceType("Typ 3");

        em.getTransaction().begin();
        dao.persist(t1);
        dao.persist(t2);
        dao.persist(t3);
        em.getTransaction().commit();
        em.clear();

        Long id = t1.getId();
        Long id2 = t2.getId();
        Long id3 = t3.getId();

        assertNotNull(id);
        assertNotNull(id2);
        assertNotNull(id3);

        assertEquals(t1, dao.findById(id));
        assertEquals(t2, dao.findById(id2));
        assertEquals(t3, dao.findById(id3));

        List<ServiceType> types = dao.findAll();
        assertEquals(types.size(), 3);
        assertTrue(types.contains(t1));
        assertTrue(types.contains(t2));
        assertTrue(types.contains(t3));
    }

    public void testUpdateServiceType() {
        ServiceType t1 = new ServiceType("Typ 1");

        EntityManager em = emf.createEntityManager();
        ServiceTypeDaoImpl dao = new ServiceTypeDaoImpl(em);

        em.getTransaction().begin();
        dao.persist(t1);
        em.getTransaction().commit();
        em.clear();

        t1.setName("Typ 22");

        em.getTransaction().begin();
        dao.update(t1);
        em.getTransaction().commit();
        em.clear();

        ServiceType t2 = dao.findById(t1.getId());

        assertEquals(t1, t2);
        assertEquals(t1.getName(), t2.getName());
    }

    public void testDeleteServiceType() {
        EntityManager em = emf.createEntityManager();
        ServiceTypeDaoImpl dao = new ServiceTypeDaoImpl(em);

        ServiceType t1 = new ServiceType("Typ 1");

        em.getTransaction().begin();
        dao.persist(t1);
        em.getTransaction().commit();

        Long id = t1.getId();

        em.getTransaction().begin();
        dao.remove(t1);
        em.getTransaction().commit();
        em.clear();

        assertNull(dao.findById(id));
    }

}
