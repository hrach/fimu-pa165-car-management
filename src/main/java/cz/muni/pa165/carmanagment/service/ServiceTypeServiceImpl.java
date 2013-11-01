/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.pa165.carmanagment.service;

import cz.muni.pa165.carmanagment.converter.ServiceTypeConverter;
import cz.muni.pa165.carmanagment.dao.ServiceTypeDaoImpl;
import cz.muni.pa165.carmanagment.dto.ServiceTypeDto;
import cz.muni.pa165.carmanagment.model.ServiceType;
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
    public ServiceType create(ServiceTypeDto type) {
        if (type == null)
            throw new IllegalArgumentException("attribute type is null");
        
        ServiceType entity = ServiceTypeConverter.dtoToEntity(type);
        dao.persist(entity);
        
        return entity;
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
    public void update(ServiceTypeDto type) {
        if (type == null)
            throw new IllegalArgumentException("attribute type is null");
        
        ServiceType entity = ServiceTypeConverter.dtoToEntity(type);
        dao.update(entity);
    }

    @Transactional
    @Override    
    public ServiceTypeDto findById(Long id) {
        if (id == null)
            throw new IllegalArgumentException("attribute id is null");
        
        return ServiceTypeConverter.entityToDto(dao.findById(id));
    }

    @Transactional
    @Override        
    public List<ServiceTypeDto> findAll() {
        return ServiceTypeConverter.entityToDto(dao.findAll());
    }
    
}
