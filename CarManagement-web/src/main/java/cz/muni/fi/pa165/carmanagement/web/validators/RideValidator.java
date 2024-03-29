/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.web.validators;

import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author zvonicek
 */
@Component("rideValidator")
public class RideValidator implements Validator {

    @Override
    public boolean supports(Class<?> c) {
        return RideDto.class.isAssignableFrom(c);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startTime", "ride.empty.startTime");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endTime", "ride.empty.endTime");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tachometerStart", "ride.empty.tachometerStart");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tachometerEnd", "ride.empty.tachometerEnd");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vehicle.id", "ride.empty.vehicle");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employee.id", "ride.empty.employee");
                
        RideDto dto = (RideDto) target;     
        
        if (dto.getTachometerStart() != null && dto.getTachometerStart() < 0)
            errors.rejectValue("tachometerStart", "ride.negative.tachometerStart");            
        
        if (dto.getTachometerEnd() != null && dto.getTachometerEnd() < 0)
            errors.rejectValue("tachometerEnd", "ride.negative.tachometerEnd");                    
        
        if (dto.getTachometerStart() != null && dto.getTachometerEnd() != null && dto.getTachometerStart() > dto.getTachometerEnd())
            errors.rejectValue("tachometerEnd", "ride.invalid.tachometerEnd");     
        
        if (dto.getStartTime() != null && dto.getEndTime() != null && dto.getStartTime().after(dto.getEndTime()))
            errors.rejectValue("endTime", "ride.invalid.endTime");     
    }        
}

