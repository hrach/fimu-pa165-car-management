package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleTypeDto;
import cz.muni.fi.pa165.carmanagement.api.service.ServiceInterface;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleTypeService;
import cz.muni.fi.pa165.carmanagement.impl.dao.VehicleTypeDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.VehicleType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zvonicek
 */
@Service
public class VehicleTypeServiceImpl extends GeneralService<VehicleType, VehicleTypeDto> implements VehicleTypeService<VehicleType>
{
    @Autowired
    private VehicleTypeDaoImpl dao;
    
    public void setVehicleTypeDao(VehicleTypeDaoImpl vehicleTypeDao) {
        this.dao = vehicleTypeDao;
    }
    
    @Transactional
    @Override    
    public VehicleTypeDto create(VehicleTypeDto type) {
        if (type == null)
            throw new NullPointerException("type");
        
        type.setId(null);
        
        VehicleType entity = this.dtoToEntity(type);
        
        dao.persist(entity);
        
        return this.entityToDto(entity);
    }

    @Transactional
    @Override    
    public void delete(Long id) {
        if (id == null)
            throw new NullPointerException("id");
        
        dao.remove(dao.findById(id));
    }

    @Transactional
    @Override    
    public void update(VehicleTypeDto type) {
        if (type == null)
            throw new NullPointerException("type");
        
        VehicleType entity = this.dtoToEntity(type);
        dao.update(entity);
    }

    @Transactional
    @Override    
    public VehicleTypeDto findById(Long id) {
        if (id == null)
            throw new NullPointerException("id");
        
        return this.entityToDto(dao.findById(id));
    }

    @Transactional
    @Override    
    public List<VehicleTypeDto> findAll() {
        return this.entityToDto(dao.findAll());
    }     

    public VehicleTypeDto entityToDto(VehicleType entity, ServiceInterface parent) {
        if (entity == null) {
            return null;
        }
        
        VehicleTypeDto dto = new VehicleTypeDto();
        dto.setId(entity.getId());
        dto.setMaxKm(entity.getMaxKm());
        
        return dto;
    }

    public VehicleType dtoToEntity(VehicleTypeDto dto, ServiceInterface parent) {
        if (dto == null) {
            return null;
        }
        
        VehicleType entity = new VehicleType();
        entity.setId(dto.getId());
        entity.setMaxKm(dto.getMaxKm());
        
        return entity;
    }

}
