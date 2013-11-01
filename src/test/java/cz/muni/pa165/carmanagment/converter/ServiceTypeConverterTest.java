package cz.muni.pa165.carmanagment.converter;

import cz.muni.pa165.carmanagment.dto.ServiceTypeDto;
import cz.muni.pa165.carmanagment.model.ServiceType;
import java.util.Arrays;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

/**
 * @author skrasek
 */
public class ServiceTypeConverterTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testEntityToDto() {
        ServiceType testE = new ServiceType("testa");
        testE.setId((long) 2);
        ServiceTypeDto testEdto = new ServiceTypeDto((long) 2, "testa");
        ServiceTypeDto convertedEdto = ServiceTypeConverter.entityToDto(testE);

        assertEquals(testEdto.getId(), convertedEdto.getId());
        assertEquals(testEdto.getName(), convertedEdto.getName());
    }

    public void testDtoToEntity() {
        ServiceType testE = new ServiceType("testa");
        testE.setId((long) 2);
        ServiceTypeDto testEdto = new ServiceTypeDto((long) 2, "testa");
        ServiceType convertedE = ServiceTypeConverter.dtoToEntity(testEdto);

        assertEquals(testE.getId(), convertedE.getId());
        assertEquals(testE.getName(), convertedE.getName());
    }

    public void testListConversions() {
        ServiceType e0 = new ServiceType("A"); e0.setId((long) 1);
        ServiceType e1 = new ServiceType("B"); e1.setId((long) 2);
        ServiceType e2 = new ServiceType("C"); e2.setId((long) 3);

        List<ServiceType> list = Arrays.asList(e0, e1, e2);

        List<ServiceType> listCheck = ServiceTypeConverter.dtoToEntity(ServiceTypeConverter.entityToDto(list));

        assertEquals(listCheck.get(0), e0);
        assertEquals(listCheck.get(1), e1);
        assertEquals(listCheck.get(2), e2);
    }
    
}
