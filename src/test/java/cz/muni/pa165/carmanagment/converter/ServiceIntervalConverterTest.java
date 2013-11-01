package cz.muni.pa165.carmanagment.converter;

import cz.muni.pa165.carmanagment.dto.ServiceIntervalDto;
import cz.muni.pa165.carmanagment.model.ServiceInterval;
import cz.muni.pa165.carmanagment.model.ServiceType;
import cz.muni.pa165.carmanagment.model.Vehicle;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

/**
 * @author skrasek
 */
public class ServiceIntervalConverterTest extends TestCase {
    private Vehicle vehicle;
    private Date date1;
    private Date date2;
    private Date date3;
    private ServiceType type;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        vehicle = new Vehicle();
        vehicle.setId((long) 2);

        date1 = new Date(2013, 11, 20);
        date1 = new Date(2013, 11, 21);
        date1 = new Date(2013, 11, 22);
        type = new ServiceType("test");
        type.setId((long) 22);
    }

    public void testEntityToDto() {
        ServiceInterval testE = si(4);
        ServiceIntervalDto testEdto = sidto(4);
        ServiceIntervalDto convertedEdto = ServiceIntervalConverter.entityToDto(testE);

        assertEquals(testEdto.getId(), convertedEdto.getId());
        assertEquals(testEdto.getCreatedTime(), convertedEdto.getCreatedTime());
        assertEquals(testEdto.getDoneTime(), convertedEdto.getDoneTime());
        assertEquals(testEdto.getDueTime(), convertedEdto.getDueTime());
        assertEquals(testEdto.getServiceType(), convertedEdto.getServiceType());
        assertEquals(testEdto.getVehicle(), convertedEdto.getVehicle());
    }

    public void testDtoToEntity() {
        ServiceInterval testE = si(4);
        ServiceIntervalDto testEdto = sidto(4);
        ServiceInterval convertedE = ServiceIntervalConverter.dtoToEntity(testEdto);

        assertEquals(testE.getId(), convertedE.getId());
        assertEquals(testE.getCreatedTime(), convertedE.getCreatedTime());
        assertEquals(testE.getDoneTime(), convertedE.getDoneTime());
        assertEquals(testE.getDueTime(), convertedE.getDueTime());
        assertEquals(testE.getServiceType(), convertedE.getServiceType());
        assertEquals(testE.getVehicle(), convertedE.getVehicle());
    }

    public void testListConversions() {
        ServiceInterval e0 = si(1);
        ServiceInterval e1 = si(2);
        ServiceInterval e2 = si(3);

        List<ServiceInterval> list = Arrays.asList(e0, e1, e2);

        List<ServiceInterval> listCheck = ServiceIntervalConverter.dtoToEntity(ServiceIntervalConverter.entityToDto(list));

        assertEquals(listCheck.get(0), e0);
        assertEquals(listCheck.get(1), e1);
        assertEquals(listCheck.get(2), e2);
    }

    private ServiceInterval si(int i) {
        ServiceInterval si = new ServiceInterval(date1, date2, date3, vehicle, type);
        si.setId((long) i);
        return si;
    }
    
    private ServiceIntervalDto sidto(int i) {
        return new ServiceIntervalDto((long) i, date1, date2, date3, VehicleConverter.entityToDto(vehicle), ServiceTypeConverter.entityToDto(type));
    }
    
}
