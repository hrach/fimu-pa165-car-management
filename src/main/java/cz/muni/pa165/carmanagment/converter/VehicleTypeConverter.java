package cz.muni.pa165.carmanagment.converter;

import cz.muni.pa165.carmanagment.dto.VehicleTypeDto;
import cz.muni.pa165.carmanagment.model.VehicleType;
import java.util.ArrayList;
import java.util.List;

/**
 * Class converts entity to DTO and DTO to entity
 * 
 * @author zvonicek
 */
public class VehicleTypeConverter {

    public static VehicleTypeDto entityToDto(VehicleType entity) {
        if (entity == null)
            return null;
        
        VehicleTypeDto dto = new VehicleTypeDto();
        dto.setId(entity.getId());
        dto.setMaxKm(entity.getMaxKm());
        
        return dto;
    }
    
    public static List<VehicleTypeDto> entityToDto(List<VehicleType> entities) {
        if (entities == null)
            return null;
        
        List<VehicleTypeDto> list = new ArrayList<VehicleTypeDto>();
        for (VehicleType vehicleType : entities) {
            list.add(VehicleTypeConverter.entityToDto(vehicleType));
        }
        
        return list;
    }
    
    public static VehicleType dtoToEntity(VehicleTypeDto dto) {
        if (dto == null)
            return null;
        
        VehicleType entity = new VehicleType();
        entity.setId(dto.getId());
        entity.setMaxKm(dto.getMaxKm());
        
        return entity;
    }
}
