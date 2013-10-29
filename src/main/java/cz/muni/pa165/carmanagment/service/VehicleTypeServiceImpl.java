
package cz.muni.pa165.carmanagment.service;

import cz.muni.pa165.carmanagment.converter.VehicleTypeConverter;
import cz.muni.pa165.carmanagment.dao.VehicleTypeDaoImpl;
import cz.muni.pa165.carmanagment.dto.VehicleTypeDto;
import cz.muni.pa165.carmanagment.model.VehicleType;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author zvonicek
 */
@Service
public class VehicleTypeServiceImpl implements VehicleTypeService
{
    private VehicleTypeDaoImpl dao;

    @Transactional
    @Override    
    public void create(VehicleTypeDto type) {
        if (type == null)
            throw new IllegalArgumentException("attribute type is null");
        
        VehicleType entity = VehicleTypeConverter.dtoToEntity(type);
        dao.persist(entity);
    }

    @Transactional
    @Override    
    public void delete(Long id) {
        if (id == null)
            throw new IllegalArgumentException("attribute id is null");
        
        dao.remove(dao.findById(id));
    }

    @Transactional
    @Override    
    public void update(VehicleTypeDto type) {
        if (type == null)
            throw new IllegalArgumentException("attribute type is null");
        
        VehicleType entity = VehicleTypeConverter.dtoToEntity(type);
        dao.update(entity);
    }

    @Transactional
    @Override    
    public VehicleTypeDto findById(Long id) {
        if (id == null)
            throw new IllegalArgumentException("attribute id is null");
        
        return VehicleTypeConverter.entityToDto(dao.findById(id));
    }

    @Transactional
    @Override    
    public List<VehicleTypeDto> findAll() {
        return VehicleTypeConverter.entityToDto(dao.findAll());
    }        
}
