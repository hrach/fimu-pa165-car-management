/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.web.validators;

import cz.muni.fi.pa165.carmanagement.api.dto.EmployeeDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author zvonicek
 */
@Component("employeeValidator")
public class EmployeeValidator implements Validator {

    @Override
    public boolean supports(Class<?> c) {
        return EmployeeDto.class.isAssignableFrom(c);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "employee.empty.firstname");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "familyName", "employee.empty.familyname");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeRole", "employee.empty.role");
                
        EmployeeDto dto = (EmployeeDto) target;      
        
        if (dto.getEmployeeRole() == 0)
            errors.rejectValue("employeeRole", "employee.empty.role");
    }        
}
