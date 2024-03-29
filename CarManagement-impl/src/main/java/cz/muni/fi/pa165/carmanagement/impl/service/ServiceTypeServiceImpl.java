package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.dto.ServiceTypeDto;
import cz.muni.fi.pa165.carmanagement.api.service.ServiceTypeService;
import cz.muni.fi.pa165.carmanagement.impl.converters.ConverterContainer;
import cz.muni.fi.pa165.carmanagement.impl.dao.ServiceTypeDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.ServiceType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zvonicek
 */
@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {

    @Autowired
    private ServiceTypeDaoImpl dao;
    
    public void setServiceTypeDao(ServiceTypeDaoImpl serviceTypeDao) {
        this.dao = serviceTypeDao;
    }
    
    @Transactional
    @Override        
    @Secured("ROLE_MANAGER")                    
    public ServiceTypeDto create(ServiceTypeDto type) {
        if (type == null) {
            throw new NullPointerException("type");
        }
        
        type.setId(null);
        ServiceType entity = ConverterContainer.getServiceTypeConverter().dtoToEntity(type);
        dao.persist(entity);        
        return ConverterContainer.getServiceTypeConverter().entityToDto(entity);
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
    public void update(ServiceTypeDto type) {
        if (type == null) {
            throw new NullPointerException("type");
        }
        
        ServiceType entity = ConverterContainer.getServiceTypeConverter().dtoToEntity(type);
        dao.update(entity);
    }

    @Transactional
    @Override    
    @Secured("ROLE_STAFF")                    
    public ServiceTypeDto findById(Long id) {
        if (id == null) {
            throw new NullPointerException("id");
        }
        
        return ConverterContainer.getServiceTypeConverter().entityToDto(dao.findById(id));
    }

    @Transactional
    @Override        
    @Secured("ROLE_STAFF")                    
    public List<ServiceTypeDto> findAll() {
        return ConverterContainer.getServiceTypeConverter().entityToDto(dao.findAll());
    }
    
}
