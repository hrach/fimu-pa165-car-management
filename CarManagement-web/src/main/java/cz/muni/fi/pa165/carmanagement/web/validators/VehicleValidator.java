/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.web.validators;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author zvonicek
 */
@Component("vehicleValidator")
public class VehicleValidator implements Validator {
    @Override
    public boolean supports(Class<?> c) {
        return VehicleDto.class.isAssignableFrom(c);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "vehicle.empty.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tachometer", "vehicle.empty.tachometer");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "vehicle.empty.type");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "constructionYear", "vehicle.empty.constructionYear");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "registrationPlate", "vehicle.empty.registrationPlate");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fuel", "vehicle.empty.fuel");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "VIN", "vehicle.empty.VIN");
        
        VehicleDto dto = (VehicleDto) target;              
        
        if (dto.getFuel() == 0)
            errors.rejectValue("fuel", "vehicle.invalid.fuel");  
        if (dto.getVIN().length() > 17)
            errors.rejectValue("VIN", "vehicle.invalid.VIN.toolong");
    }        
}
