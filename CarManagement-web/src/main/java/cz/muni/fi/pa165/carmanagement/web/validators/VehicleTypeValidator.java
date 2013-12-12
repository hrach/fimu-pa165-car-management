/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.web.validators;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleTypeDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author tomasbobek
 */

@Component("vehicleValidator")
public class VehicleTypeValidator implements Validator {
    @Override
    public boolean supports(Class<?> c) {
        return VehicleTypeDto.class.isAssignableFrom(c);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "vehicle.empty.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "maxkm", "vehicle.empty.maxkm");
                
        VehicleTypeDto dto = (VehicleTypeDto) target;              
    }
}
