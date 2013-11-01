package cz.muni.pa165.carmanagment.converter;
import cz.muni.pa165.carmanagment.dto.RideDto;
import cz.muni.pa165.carmanagment.model.Employee;
import cz.muni.pa165.carmanagment.model.Ride;
import cz.muni.pa165.carmanagment.model.Vehicle;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

/**
 * @author skrasek
 */
public class RideConverterTest extends TestCase {
    private Vehicle vehicle;
    private Date date;
    private Employee employee;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        vehicle = new Vehicle();
        date = new Date(2013, 11, 20);
        employee = e(1, "Jan", "Skrasek");
    }

    public void testEntityToDto() {
        Ride testE = r(4, 22, 122);
        RideDto testEdto = rdto(4, 22, 122);
        RideDto convertedEdto = RideConverter.entityToDto(testE);

        assertEquals(testEdto.getId(), convertedEdto.getId());
        assertEquals(testEdto.getStartTime(), convertedEdto.getStartTime());
        assertEquals(testEdto.getEndTime(), convertedEdto.getEndTime());
        assertEquals(testEdto.getTachometerStart(), convertedEdto.getTachometerStart());
        assertEquals(testEdto.getTachometerEnd(), convertedEdto.getTachometerEnd());
    }

    public void testDtoToEntity() {
        Ride testE = r(4, 22, 122);
        RideDto testEdto = rdto(4, 22, 122);
        Ride convertedE = RideConverter.dtoToEntity(testEdto);

        assertEquals(testE.getId(), convertedE.getId());
        assertEquals(testE.getStartTime(), convertedE.getStartTime());
        assertEquals(testE.getEndTime(), convertedE.getEndTime());
        assertEquals(testE.getTachometerStart(), convertedE.getTachometerStart());
        assertEquals(testE.getTachometerEnd(), convertedE.getTachometerEnd());
    }

    public void testListConversions() {
        
        Ride e0 = r(1, 1, 3);
        Ride e1 = r(2, 3, 8);
        Ride e2 = r(3, 9, 22);

        List<Ride> list = Arrays.asList(e0, e1, e2);

        List<Ride> listCheck = RideConverter.dtoToEntity(RideConverter.entityToDto(list));
        
        assertEquals(listCheck.get(0), e0);
        assertEquals(listCheck.get(1), e1);
        assertEquals(listCheck.get(2), e2);
    }

    private Ride r (int i, int s, int e) {
        Ride r = new Ride(date, date, (long) s, (long) e, "", vehicle, employee);
        r.setId((long) i);
        return r;
    }
    
    private RideDto rdto (int i, int s, int e) {
        return new RideDto((long) i, date, date, (long) s, (long) e, "", VehicleConverter.entityToDto(vehicle), EmployeeConverter.entityToDto(employee));
    }

    private Employee e (int i, String f, String l) {
        Employee e = new Employee(f, l, Employee.ROLE_MANAGER);
        e.setId((long) i);
        return e;
    }
}
