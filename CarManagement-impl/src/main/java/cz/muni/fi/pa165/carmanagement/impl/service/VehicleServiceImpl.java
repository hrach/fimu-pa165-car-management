package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleService;
import cz.muni.fi.pa165.carmanagement.impl.converters.ConverterContainer;
import cz.muni.fi.pa165.carmanagement.impl.dao.VehicleDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.dao.VehicleTypeDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.Vehicle;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zvonicek
 */
@Service
public class VehicleServiceImpl implements VehicleService {

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
    
    
    @Transactional
    @Override
    @Secured({"ROLE_MANAGER", "ROLE_SOAP"})                    
    public VehicleDto create(VehicleDto v) {
        if (v == null) {
            throw new NullPointerException("v");
        }
        
        Vehicle entity = ConverterContainer.getVehicleConverter().dtoToEntity(v);
        entity.setId(null);
        if (entity.getType() != null) {
            entity.setType(typeDao.findById(entity.getType().getId()));
        }
        
        dao.persist(entity);        
        
        return ConverterContainer.getVehicleConverter().entityToDto(entity);
    }

    @Transactional
    @Override    
    @Secured({"ROLE_MANAGER", "ROLE_SOAP"})                        
    public void delete(Long id) {
        if (id == null) {
            throw new NullPointerException("id");
        }
        
        dao.remove(dao.findById(id));
    }
    
    @Transactional
    @Override
    @Secured({"ROLE_MANAGER", "ROLE_SOAP"})                        
    public void update(VehicleDto v) {
        if (v == null) {
            throw new NullPointerException("v");
        }
        
        Vehicle entity = ConverterContainer.getVehicleConverter().dtoToEntity(v);
        dao.update(entity);
    }

    @Transactional
    @Override    
    @Secured({"ROLE_STAFF", "ROLE_SOAP"})                        
    public VehicleDto findById(Long id) {
        if (id == null) {
            throw new NullPointerException("id");
        }
        
        return ConverterContainer.getVehicleConverter().entityToDto(dao.findById(id));    
    }
    
    @Transactional
    @Override
    @Secured({"ROLE_STAFF", "ROLE_SOAP"})                        
    public List<VehicleDto> findAll() {
        return ConverterContainer.getVehicleConverter().entityToDto(dao.findAll());
    }

}
