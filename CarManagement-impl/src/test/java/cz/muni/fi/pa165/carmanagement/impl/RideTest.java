
package cz.muni.fi.pa165.carmanagement.impl;

import cz.muni.fi.pa165.carmanagement.impl.model.Ride;
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


    public void testRideLength()
    {
        Ride r = new Ride();
        r.setTachometerStart(new Long(23));
        r.setTachometerEnd(new Long(34));
        
        assertEquals(new Long(23), r.getTachometerStart());
        assertEquals(new Long(11), r.getRideLength());
    }
    
    public void testRideLengthWithWrongState()
    {
        Ride r1 = new Ride();
        r1.setTachometerStart(new Long(23));

        try {
            r1.getRideLength();
            fail("Expected an IllegalStateException to be thrown.");
        } catch (IllegalStateException e) {
            assertEquals("Tachometer end value is not set.", e.getMessage());
        }

        Ride r2 = new Ride();
        r2.setTachometerEnd(new Long(23));

        try {
            r2.getRideLength();
            fail("Expected an IllegalStateException to be thrown.");
        } catch (IllegalStateException e) {
            assertEquals("Tachometer start value is not set.", e.getMessage());
        }
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
