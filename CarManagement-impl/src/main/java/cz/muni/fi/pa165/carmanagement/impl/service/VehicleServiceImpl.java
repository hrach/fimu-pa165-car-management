/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import cz.muni.fi.pa165.carmanagement.api.dto.ServiceIntervalDto;
import cz.muni.fi.pa165.carmanagement.api.dto.VehicleDto;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleService;
import cz.muni.fi.pa165.carmanagement.impl.converter.RideConverter;
import cz.muni.fi.pa165.carmanagement.impl.converter.ServiceIntervalConverter;
import cz.muni.fi.pa165.carmanagement.impl.converter.VehicleConverter;
import cz.muni.fi.pa165.carmanagement.impl.dao.VehicleDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.dao.VehicleTypeDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.Vehicle;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
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
    
    @Transactional
    @Override
    public VehicleDto create(VehicleDto v) {
        if (v == null) {
            throw new NullPointerException("v");
        }
        
        Vehicle entity = VehicleConverter.dtoToEntity(v);
        entity.setId(null);
        entity.setType(typeDao.findById(entity.getType().getId()));
        
        dao.persist(entity);        
        
        return VehicleConverter.entityToDto(entity);
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
        
        Vehicle entity = VehicleConverter.dtoToEntity(v);
        dao.update(entity);
    }

    @Transactional
    @Override    
    public VehicleDto findById(Long id) {
        if (id == null)
            throw new NullPointerException("id");
        
        return VehicleConverter.entityToDto(dao.findById(id));    
    }
    
    @Transactional
    @Override
    public List<VehicleDto> findAll() {
        return VehicleConverter.entityToDto(dao.findAll());
    }

    @Transactional
    @Override    
    public List<RideDto> getRidesForVehicle(Long id) {
        if (id == null)
            throw new NullPointerException("id");
        
        Vehicle v = dao.findById(id);
        
        if (v == null)
            return null;
        
        return RideConverter.entityToDto(v.getRides());        
    }   

    public List<ServiceIntervalDto> getServiceIntervalsForVehicle(Long id) {
        if (id == null)
            throw new NullPointerException("id");
        
        Vehicle v = dao.findById(id);
        
        if (v == null)
            return null;
        
        return ServiceIntervalConverter.entityToDto(v.getServiceIntervals());        
    }
}
