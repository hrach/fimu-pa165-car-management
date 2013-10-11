
package cz.muni.pa165.carmanagment;

import junit.framework.TestCase;


/**
 * Employee entity test.
 * @author skrasek
 */
public class EmployeeTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testEmployeeSettersGetters() {
        Employee e = new Employee();
        e.setFirstName("jan");
        e.setFamilyName("skrasek");

        assertEquals("jan", e.getFirstName());
        assertEquals("skrasek", e.getFamilyName());
        assertEquals("jan skrasek", e.getFullName());
        
        e.setFirstName("peter");
        
        assertEquals("peter skrasek", e.getFullName());
    }

    public void testEmployeeContructor()
    {
        Employee e = new Employee("jan", "skrasek");
        
        assertEquals("jan", e.getFirstName());
        assertEquals("skrasek", e.getFamilyName());
        assertEquals("jan skrasek", e.getFullName());
        
        e.setFirstName("peter");
        
        assertEquals("peter skrasek", e.getFullName());
    }

    public void testEmployeeIds()
    {
        Employee n = new Employee();
        
        assertNull(n.getId());

        Employee one = new Employee();
        Employee two = new Employee();
        
        one.setId(new Long(1));
        two.setId(new Long(1));
        
        assertEquals(one, two);
        
        two.setId(null);
        
        assertFalse(one.equals(two));
        assertFalse(two.equals(one));
        
        two.setId(new Long(2));
        
        assertFalse(one.equals(two));
        assertFalse(two.equals(one));
    }
    
}
