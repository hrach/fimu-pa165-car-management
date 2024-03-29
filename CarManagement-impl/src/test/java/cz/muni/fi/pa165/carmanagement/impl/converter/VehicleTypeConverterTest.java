package cz.muni.fi.pa165.carmanagement.impl.converter;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleTypeDto;
import cz.muni.fi.pa165.carmanagement.impl.converters.ConverterContainer;
import cz.muni.fi.pa165.carmanagement.impl.model.VehicleType;
import java.util.Arrays;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

/**
 * @author skrasek
 */
public class VehicleTypeConverterTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testEntityToDto() {
        VehicleType testE = new VehicleType((long) 22, "name");
        testE.setId((long) 2);
        VehicleTypeDto testEdto = new VehicleTypeDto((long) 2, (long) 22, "name");
        VehicleTypeDto convertedEdto = ConverterContainer.getVehicleTypeConverter().entityToDto(testE);

        assertEquals(testEdto.getId(), convertedEdto.getId());
        assertEquals(testEdto.getMaxKm(), convertedEdto.getMaxKm());
    }

    public void testDtoToEntity() {
        VehicleType testE = new VehicleType((long) 22, "name");
        testE.setId((long) 2);
        VehicleTypeDto testEdto = new VehicleTypeDto((long) 2, (long) 22, "name");
        VehicleType convertedE = ConverterContainer.getVehicleTypeConverter().dtoToEntity(testEdto);

        assertEquals(testE.getId(), convertedE.getId());
        assertEquals(testE.getMaxKm(), convertedE.getMaxKm());
    }

    public void testListConversions() {
        VehicleType e0 = new VehicleType((long) 11, "name 1"); e0.setId((long) 1);
        VehicleType e1 = new VehicleType((long) 22, "name 2"); e1.setId((long) 2);
        VehicleType e2 = new VehicleType((long) 33, "name 3"); e2.setId((long) 3);

        List<VehicleType> list = Arrays.asList(e0, e1, e2);

        List<VehicleType> listCheck = ConverterContainer.getVehicleTypeConverter().dtoToEntity(ConverterContainer.getVehicleTypeConverter().entityToDto(list));

        assertEquals(listCheck.get(0), e0);
        assertEquals(listCheck.get(1), e1);
        assertEquals(listCheck.get(2), e2);
    }
    
}
