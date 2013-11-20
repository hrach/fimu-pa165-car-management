package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.dto.ServiceTypeDto;
import cz.muni.fi.pa165.carmanagement.api.service.ServiceInterface;
import cz.muni.fi.pa165.carmanagement.api.service.ServiceTypeService;
import cz.muni.fi.pa165.carmanagement.impl.dao.ServiceTypeDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.ServiceType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zvonicek
 */
public class ServiceTypeServiceImpl extends GeneralService<ServiceType, ServiceTypeDto> implements ServiceTypeService<ServiceType> {

    @Autowired
    private ServiceTypeDaoImpl dao;
    
    public void setServiceTypeDao(ServiceTypeDaoImpl serviceTypeDao) {
        this.dao = serviceTypeDao;
    }
    
    @Transactional
    @Override        
    public ServiceTypeDto create(ServiceTypeDto type) {
        if (type == null)
            throw new NullPointerException("type");
        
        type.setId(null);
        
        ServiceType entity = this.dtoToEntity(type);
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
    public void update(ServiceTypeDto type) {
        if (type == null)
            throw new NullPointerException("type");
        
        ServiceType entity = this.dtoToEntity(type);
        dao.update(entity);
    }

    @Transactional
    @Override    
    public ServiceTypeDto findById(Long id) {
        if (id == null)
            throw new NullPointerException("id");
        
        return this.entityToDto(dao.findById(id));
    }

    @Transactional
    @Override        
    public List<ServiceTypeDto> findAll() {
        return this.entityToDto(dao.findAll());
    }
    
    
    public ServiceTypeDto entityToDto(ServiceType entity, ServiceInterface parent) {
        if (entity == null)
            return null;
        
        ServiceTypeDto dto = new ServiceTypeDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        
        return dto;      
    }

    public ServiceType dtoToEntity(ServiceTypeDto dto, ServiceInterface parent) {
        if (dto == null)
            return null;

        ServiceType entity = new ServiceType();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        
        return entity;     
    }

}
