
package cz.muni.pa165.carmanagment;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNull;
import junit.framework.TestCase;


/**
 * Ride entity test.
 * @author skrasek
 */
public class RideTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testRideIds()
    {
        Ride n = new Ride();
        
        assertNull(n.getId());

        Ride one = new Ride();
        Ride two = new Ride();
        
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
