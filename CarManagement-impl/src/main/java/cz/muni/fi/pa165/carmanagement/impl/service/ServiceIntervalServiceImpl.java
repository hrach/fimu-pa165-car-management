/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.dto.ServiceIntervalDto;
import cz.muni.fi.pa165.carmanagement.api.service.ServiceIntervalService;
import cz.muni.fi.pa165.carmanagement.impl.converters.ConverterContainer;
import cz.muni.fi.pa165.carmanagement.impl.dao.ServiceIntervalDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.ServiceInterval;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceIntervalServiceImpl implements ServiceIntervalService {
    
    @Autowired    
    private ServiceIntervalDaoImpl dao;
    
    public void setDao(ServiceIntervalDaoImpl dao) {
        this.dao = dao;
    }
    
    @Transactional
    @Override        
    public ServiceIntervalDto create(ServiceIntervalDto serviceIntervalDto) {
        if (serviceIntervalDto == null) {
            throw new NullPointerException("serviceIntervalDto");
        }
        
        serviceIntervalDto.setId(null);
        
        ServiceInterval entity = ConverterContainer.getServiceIntervalConverter().dtoToEntity(serviceIntervalDto);
        
        dao.persist(entity);
        
        return ConverterContainer.getServiceIntervalConverter().entityToDto(entity);
    }

    public void delete(Long id) {
        if (id == null){
            throw new NullPointerException("id");
        }
        
        dao.remove(dao.findById(id));
    }

    @Transactional
    @Override    
    public void update(ServiceIntervalDto serviceIntervalDto) {
        if (serviceIntervalDto == null) {
            throw new NullPointerException("serviceIntervalDto");
        }
        
        dao.update(ConverterContainer.getServiceIntervalConverter().dtoToEntity(serviceIntervalDto));
    }

    @Transactional
    @Override        
    public ServiceIntervalDto findById(Long id) {
        if (id == null){
            throw new NullPointerException("id");
        }
        
        return ConverterContainer.getServiceIntervalConverter().entityToDto(dao.findById(id));
    }

    @Transactional
    @Override        
    public List<ServiceIntervalDto> findAll() {
        return ConverterContainer.getServiceIntervalConverter().entityToDto(dao.findAll());
    }

    @Transactional
    @Override        
    public void setIntervalAsDoneForId(Long id) {
        if (id == null){
            throw new NullPointerException("id");
        }

        ServiceInterval sid = dao.findById(id);
        Date actualDate = new Date();
        sid.setDoneTime(actualDate);
        
        dao.update(sid);
    }

}
