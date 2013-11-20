package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import cz.muni.fi.pa165.carmanagement.api.service.ServiceInterface;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleService;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleTypeService;
import cz.muni.fi.pa165.carmanagement.impl.dao.VehicleDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.dao.VehicleTypeDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.Vehicle;
import cz.muni.fi.pa165.carmanagement.impl.model.VehicleType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zvonicek
 */
@Service
public class VehicleServiceImpl extends GeneralService<Vehicle, VehicleDto> implements VehicleService<Vehicle> {

    @Autowired
    private VehicleDaoImpl dao;
    
    @Autowired
    private VehicleTypeDaoImpl typeDao;
    
    public void setVehicleDao(VehicleDaoImpl vehicleDao) {
        this.dao = vehicleDao;
    }

    public void setTypeDao(VehicleTypeDaoImpl typeDao) {
        this.typeDao = typeDao;
    }        
    
    @Autowired
    private VehicleTypeService<VehicleType> vehicleTypeService;

    
    @Transactional
    @Override
    public VehicleDto create(VehicleDto v) {
        if (v == null) {
            throw new NullPointerException("v");
        }
        
        Vehicle entity = this.dtoToEntity(v);
        entity.setId(null);
        entity.setType(typeDao.findById(entity.getType().getId()));
        
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
    public void update(VehicleDto v) {
        if (v == null)
            throw new NullPointerException("v");
        
        Vehicle entity = this.dtoToEntity(v);
        dao.update(entity);
    }

    @Transactional
    @Override    
    public VehicleDto findById(Long id) {
        if (id == null)
            throw new NullPointerException("id");
        
        return this.entityToDto(dao.findById(id));    
    }
    
    @Transactional
    @Override
    public List<VehicleDto> findAll() {
        return this.entityToDto(dao.findAll());
    }

    public VehicleDto entityToDto(Vehicle entity, ServiceInterface parent) {
        if (entity == null) {
            return null;
        }
        
        VehicleDto dto = new VehicleDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setTachometer(entity.getTachometer());
        
        if (!(parent instanceof VehicleTypeService)) {
            dto.setType(this.vehicleTypeService.entityToDto(entity.getType(), this));
        }

        return dto;    
    }

    public Vehicle dtoToEntity(VehicleDto dto, ServiceInterface parent) {
        if (dto == null) {
            return null;
        }
        
        Vehicle entity = new Vehicle();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setTchometer(dto.getTachometer());
        
        if (!(parent instanceof VehicleTypeService)) {
            entity.setType(this.vehicleTypeService.dtoToEntity(dto.getType(), this));
        }
        
        return entity;        
    }

}
