
package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import cz.muni.fi.pa165.carmanagement.api.dto.VehicleTypeDto;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleTypeService;
import cz.muni.fi.pa165.carmanagement.impl.converter.VehicleConverter;
import cz.muni.fi.pa165.carmanagement.impl.converter.VehicleTypeConverter;
import cz.muni.fi.pa165.carmanagement.impl.dao.VehicleTypeDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.Vehicle;
import cz.muni.fi.pa165.carmanagement.impl.model.VehicleType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
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
    public void create(VehicleTypeDto type) {
        if (type == null)
            throw new NullPointerException("type");
        
        VehicleType entity = VehicleTypeConverter.dtoToEntity(type);
        dao.persist(entity);
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
        
        VehicleType entity = VehicleTypeConverter.dtoToEntity(type);
        dao.update(entity);
    }

    @Transactional
    @Override    
    public VehicleTypeDto findById(Long id) {
        if (id == null)
            throw new NullPointerException("id");
        
        return VehicleTypeConverter.entityToDto(dao.findById(id));
    }

    @Transactional
    @Override    
    public List<VehicleTypeDto> findAll() {
        return VehicleTypeConverter.entityToDto(dao.findAll());
    }     
    
    @Transactional
    @Override
    public List<VehicleDto> getVehiclesForType(Long id)
    {
        if (id == null)
            throw new NullPointerException("id");
        
        VehicleType t = dao.findById(id);
        
        if (t == null)
            return null;
            
        List<Vehicle> vehicles = t.getVehicles();
        
        return VehicleConverter.entityToDto(vehicles);
    }
}
