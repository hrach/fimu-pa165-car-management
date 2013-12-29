package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleTypeDto;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleTypeService;
import cz.muni.fi.pa165.carmanagement.impl.converters.ConverterContainer;
import cz.muni.fi.pa165.carmanagement.impl.dao.VehicleTypeDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.VehicleType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zvonicek
 */
@Service
public class VehicleTypeServiceImpl implements VehicleTypeService
{
    @Autowired
    private VehicleTypeDaoImpl dao;
    
    public void setVehicleTypeDao(VehicleTypeDaoImpl vehicleTypeDao) {
        this.dao = vehicleTypeDao;
    }
    
    @Transactional
    @Override    
    @Secured({"ROLE_MANAGER", "ROLE_SOAP"})                            
    public VehicleTypeDto create(VehicleTypeDto type) {
        if (type == null) {
            throw new NullPointerException("type");
        }

        type.setId(null);
        VehicleType entity = ConverterContainer.getVehicleTypeConverter().dtoToEntity(type);
        dao.persist(entity);
        return ConverterContainer.getVehicleTypeConverter().entityToDto(entity);
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
    public void update(VehicleTypeDto type) {
        if (type == null) {
            throw new NullPointerException("type");
        }
        
        VehicleType entity = ConverterContainer.getVehicleTypeConverter().dtoToEntity(type);
        dao.update(entity);
    }

    @Transactional
    @Override    
    @Secured({"ROLE_STAFF", "ROLE_SOAP"})                            
    public VehicleTypeDto findById(Long id) {
        if (id == null) {
            throw new NullPointerException("id");
        }
        
        return ConverterContainer.getVehicleTypeConverter().entityToDto(dao.findById(id));
    }

    @Transactional
    @Override    
    @Secured({"ROLE_STAFF", "ROLE_SOAP"})                            
    public List<VehicleTypeDto> findAll() {
        return ConverterContainer.getVehicleTypeConverter().entityToDto(dao.findAll());
    }     

}
