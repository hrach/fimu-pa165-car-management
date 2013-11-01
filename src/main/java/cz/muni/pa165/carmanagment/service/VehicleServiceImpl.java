/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.pa165.carmanagment.service;

import cz.muni.pa165.carmanagment.converter.RideConverter;
import cz.muni.pa165.carmanagment.converter.ServiceIntervalConverter;
import cz.muni.pa165.carmanagment.converter.VehicleConverter;
import cz.muni.pa165.carmanagment.dao.VehicleDaoImpl;
import cz.muni.pa165.carmanagment.dto.RideDto;
import cz.muni.pa165.carmanagment.dto.ServiceIntervalDto;
import cz.muni.pa165.carmanagment.dto.VehicleDto;
import cz.muni.pa165.carmanagment.model.Vehicle;
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
    
    public void setVehicleDao(VehicleDaoImpl vehicleDao) {
        this.dao = vehicleDao;
    }
    
    @Transactional
    @Override
    public Vehicle create(VehicleDto v) {
        if (v == null) {
            throw new NullPointerException("v");
        }

        Vehicle entity = VehicleConverter.dtoToEntity(v);
        dao.persist(entity);
        
        return entity;
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
