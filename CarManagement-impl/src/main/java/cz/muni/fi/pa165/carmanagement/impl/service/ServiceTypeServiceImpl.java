/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.dto.ServiceTypeDto;
import cz.muni.fi.pa165.carmanagement.api.service.ServiceTypeService;
import cz.muni.fi.pa165.carmanagement.impl.converter.ServiceTypeConverter;
import cz.muni.fi.pa165.carmanagement.impl.dao.ServiceTypeDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.ServiceType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author zvonicek
 */
public class ServiceTypeServiceImpl implements ServiceTypeService {

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
        
        ServiceType entity = ServiceTypeConverter.dtoToEntity(type);
        dao.persist(entity);        
        
        return ServiceTypeConverter.entityToDto(entity);
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
        
        ServiceType entity = ServiceTypeConverter.dtoToEntity(type);
        dao.update(entity);
    }

    @Transactional
    @Override    
    public ServiceTypeDto findById(Long id) {
        if (id == null)
            throw new NullPointerException("id");
        
        return ServiceTypeConverter.entityToDto(dao.findById(id));
    }

    @Transactional
    @Override        
    public List<ServiceTypeDto> findAll() {
        return ServiceTypeConverter.entityToDto(dao.findAll());
    }
    
}
