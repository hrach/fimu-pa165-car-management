
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
        
        Employee e2 = new Employee("peter", "vomacka", Employee.ROLE_MANAGER);
        assertEquals(Employee.ROLE_MANAGER, e2.getEmployeeRole());
    }
    
    public void testInvalidRoles()
    {
        Employee e1 = new Employee();
        try {
            e1.setEmployeeRole(90934);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            assertEquals("Employee role '90934' is not allowed.", e.getMessage());
        }

        try {
            Employee e2 = new Employee("peter", "quin", 90935);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            assertEquals("Employee role '90935' is not allowed.", e.getMessage());
        }
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
