/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.pa165.carmanagment.service;

import cz.muni.pa165.carmanagment.converter.RideConverter;
import cz.muni.pa165.carmanagment.converter.VehicleConverter;
import cz.muni.pa165.carmanagment.dao.GeneralDao;
import cz.muni.pa165.carmanagment.dao.VehicleDaoImpl;
import cz.muni.pa165.carmanagment.dto.RideDto;
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
    public void create(VehicleDto v) {
        if (v == null) {
            throw new IllegalArgumentException("attribute v is null");
        }

        Vehicle entity = VehicleConverter.dtoToEntity(v);
        dao.persist(entity);
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
    public void update(VehicleDto v) {
        if (v == null)
            throw new IllegalArgumentException("attribute type is null");
        
        Vehicle entity = VehicleConverter.dtoToEntity(v);
        dao.update(entity);    
    }

    @Transactional
    @Override    
    public VehicleDto findById(Long id) {
        if (id == null)
            throw new IllegalArgumentException("attribute id is null");
        
        return VehicleConverter.entityToDto(dao.findById(id));    }
    
    @Transactional
    @Override
    public List<VehicleDto> findAll() {
        return VehicleConverter.entityToDto(dao.findAll());
    }

    @Transactional
    @Override    
    public List<RideDto> getRidesForVehicle(Long id) {
        if (id == null)
            throw new IllegalArgumentException("attribute id is null");        
        
        Vehicle v = dao.findById(id);
        return RideConverter.entityToDto(v.getRides());        
    }   
}
