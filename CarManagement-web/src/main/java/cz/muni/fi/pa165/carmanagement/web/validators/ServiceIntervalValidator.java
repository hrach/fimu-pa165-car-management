/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.web.validators;

import cz.muni.fi.pa165.carmanagement.api.dto.EmployeeDto;
import cz.muni.fi.pa165.carmanagement.api.dto.ServiceIntervalDto;
import java.util.Date;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author zvonicek
 */
@Component("serviceIntervalValidator")
public class ServiceIntervalValidator implements Validator {
    @Override
    public boolean supports(Class<?> c) {
        return ServiceIntervalDto.class.isAssignableFrom(c);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "serviceType.id", "serviceInterval.empty.serviceType");                
        
        ServiceIntervalDto dto = (ServiceIntervalDto) target;    
        
        if (dto.getDueTime() != null && dto.getDueTime().before(new Date()))
            errors.rejectValue("dueTime", "serviceInterval.invalid.dueTime");
    }        
    
}
