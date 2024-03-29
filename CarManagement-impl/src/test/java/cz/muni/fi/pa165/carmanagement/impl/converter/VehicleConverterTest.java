package cz.muni.fi.pa165.carmanagement.impl.converter;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import cz.muni.fi.pa165.carmanagement.impl.converters.ConverterContainer;
import cz.muni.fi.pa165.carmanagement.impl.model.Vehicle;
import cz.muni.fi.pa165.carmanagement.impl.model.VehicleType;
import java.util.Arrays;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

/**
 * @author skrasek
 */
public class VehicleConverterTest extends TestCase {
    private VehicleType type;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        type = new VehicleType();
        type.setId((long) 123);
    }

    public void testEntityToDto() {
        Vehicle testE = v(1, "test", 2000);
        VehicleDto testEdto = vdto(1, "test", 2000);
        VehicleDto convertedEdto = ConverterContainer.getVehicleConverter().entityToDto(testE);

        assertEquals(testEdto.getId(), convertedEdto.getId());
        assertEquals(testEdto.getName(), convertedEdto.getName());
        assertEquals(testEdto.getTachometer(), convertedEdto.getTachometer());
        assertEquals(testEdto.getType(), convertedEdto.getType());
    }

    public void testDtoToEntity() {
        Vehicle testE = v(1, "test", 2000);
        VehicleDto testEdto = vdto(1, "test", 2000);
        Vehicle convertedE = ConverterContainer.getVehicleConverter().dtoToEntity(testEdto);

        assertEquals(testE.getId(), convertedE.getId());
        assertEquals(testE.getName(), convertedE.getName());
        assertEquals(testE.getTachometer(), convertedE.getTachometer());
        assertEquals(testE.getType(), convertedE.getType());
    }

    public void testListConversions() {
        Vehicle e0 = v(1, "a", 11);
        Vehicle e1 = v(2, "b", 22);
        Vehicle e2 = v(3, "c", 33);

        List<Vehicle> list = Arrays.asList(e0, e1, e2);

        List<Vehicle> listCheck = ConverterContainer.getVehicleConverter().dtoToEntity(ConverterContainer.getVehicleConverter().entityToDto(list));

        assertEquals(listCheck.get(0), e0);
        assertEquals(listCheck.get(1), e1);
        assertEquals(listCheck.get(2), e2);
    }
    
    private Vehicle v(int i, String name, int km) {
        Vehicle v = new Vehicle(name, (long) km);
        v.setId((long) i);
        v.setType(type);
        return v;
    }

    private VehicleDto vdto(int i, String name, int km) {
        return new VehicleDto((long) i, name, (long) km, ConverterContainer.getVehicleTypeConverter().entityToDto(type));
    }
}
