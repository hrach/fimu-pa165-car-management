package cz.muni.fi.pa165.carmanagement.impl.converter;

import cz.muni.fi.pa165.carmanagement.api.dto.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.impl.converters.ConverterContainer;
import cz.muni.fi.pa165.carmanagement.impl.model.Employee;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;

/**
 * @author skrasek
 */
public class EmployeeConverterTest extends TestCase {

    public void testEntityToDto() {
        Employee testE = e(5, "Jan", "Skrasek");

        EmployeeDto testEdto = new EmployeeDto((long) 5, "Jan", "Skrasek", Employee.ROLE_MANAGER);
        EmployeeDto convertedEdto = ConverterContainer.getEmployeeConverter().entityToDto(testE);

        assertEquals(testEdto.getId(), convertedEdto.getId());
        assertEquals(testEdto.getFirstName(), convertedEdto.getFirstName());
        assertEquals(testEdto.getFamilyName(), convertedEdto.getFamilyName());
        assertEquals(testEdto.getEmployeeRole(), convertedEdto.getEmployeeRole());
        assertEquals(testEdto.getRides().size(), convertedEdto.getRides().size());
    }

    public void testDtoToEntity() {
        Employee testE = e(5, "Jan", "Skrasek");

        EmployeeDto testEdto = new EmployeeDto((long) 5, "Jan", "Skrasek", Employee.ROLE_MANAGER);
        Employee convertedE = ConverterContainer.getEmployeeConverter().dtoToEntity(testEdto);

        assertEquals(testE.getId(), convertedE.getId());
        assertEquals(testE.getFirstName(), convertedE.getFirstName());
        assertEquals(testE.getFamilyName(), convertedE.getFamilyName());
        assertEquals(testE.getEmployeeRole(), convertedE.getEmployeeRole());
        assertEquals(testE.getRides().size(), convertedE.getRides().size());
    }

    public void testListConversions() {
        Employee e0 = e(1, "Jan", "Skrasek");
        Employee e1 = e(2, "Petr", "Zvonicek");
        Employee e2 = e(3, "Jon", "Snow");

        List<Employee> list = Arrays.asList(e0, e1, e2);

        List<Employee> listCheck = ConverterContainer.getEmployeeConverter().dtoToEntity(ConverterContainer.getEmployeeConverter().entityToDto(list));
        
        assertEquals(listCheck.get(0), e0);
        assertEquals(listCheck.get(1), e1);
        assertEquals(listCheck.get(2), e2);
    }

    private Employee e (int i, String f, String l) {
        Employee e = new Employee(f, l, Employee.ROLE_MANAGER);
        e.setId((long) i);
        return e;
    }
}
