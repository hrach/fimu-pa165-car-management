package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.dto.ServiceIntervalDto;
import cz.muni.fi.pa165.carmanagement.api.dto.ServiceTypeDto;
import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import cz.muni.fi.pa165.carmanagement.api.service.ServiceIntervalService;
import cz.muni.fi.pa165.carmanagement.impl.converters.ConverterContainer;
import cz.muni.fi.pa165.carmanagement.impl.dao.ServiceIntervalDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.ServiceInterval;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
    @Secured("ROLE_MANAGER")                
    public ServiceIntervalDto create(ServiceIntervalDto serviceIntervalDto) {
        if (serviceIntervalDto == null) {
            throw new NullPointerException("serviceIntervalDto");
        }
        
        serviceIntervalDto.setId(null);
        ServiceInterval entity = ConverterContainer.getServiceIntervalConverter().dtoToEntity(serviceIntervalDto);
        dao.persist(entity);
        return ConverterContainer.getServiceIntervalConverter().entityToDto(entity);
    }

    @Transactional
    @Override
    @Secured("ROLE_MANAGER")                
    public void delete(Long id) {
        if (id == null) {
            throw new NullPointerException("id");
        }
        
        dao.remove(dao.findById(id));
    }

    @Transactional
    @Override    
    @Secured("ROLE_MANAGER")                
    public void update(ServiceIntervalDto serviceIntervalDto) {
        if (serviceIntervalDto == null) {
            throw new NullPointerException("serviceIntervalDto");
        }
        
        dao.update(ConverterContainer.getServiceIntervalConverter().dtoToEntity(serviceIntervalDto));
    }

    @Transactional
    @Override        
    @Secured("ROLE_STAFF")                
    public ServiceIntervalDto findById(Long id) {
        if (id == null) {
            throw new NullPointerException("id");
        }
        
        return ConverterContainer.getServiceIntervalConverter().entityToDto(dao.findById(id));
    }

    @Transactional
    @Override     
    @Secured("ROLE_STAFF")                
    public List<ServiceIntervalDto> findAll() {
        return ConverterContainer.getServiceIntervalConverter().entityToDto(dao.findAll());
    }

    @Transactional
    @Override        
    @Secured("ROLE_STAFF")                
    public void setIntervalAsDoneForId(Long id) {
        if (id == null) {
            throw new NullPointerException("id");
        }

        ServiceInterval sid = dao.findById(id);
        Date actualDate = new Date();
        sid.setDoneTime(actualDate);
        
        dao.update(sid);
    }
    
    @Transactional
    @Override
    @Secured("ROLE_MANAGER")                
    public ServiceIntervalDto updateServiceIntervalAsDone(VehicleDto vehicle, ServiceTypeDto newServiceType) {
        for (ServiceIntervalDto s : vehicle.getServiceIntervals()) {
            if (s.getDoneTime() == null && s.getServiceType().equals(newServiceType)) {
                s.setDoneTime(new Date());
                return s;
            }
        }
        
        return null;
    }

}
