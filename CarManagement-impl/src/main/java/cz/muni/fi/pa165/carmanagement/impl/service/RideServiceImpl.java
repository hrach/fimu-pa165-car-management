/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import cz.muni.fi.pa165.carmanagement.api.service.RideService;
import cz.muni.fi.pa165.carmanagement.impl.converter.RideConverter;
import cz.muni.fi.pa165.carmanagement.impl.dao.EmployeeDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.dao.RideDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.dao.VehicleDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.Ride;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RideServiceImpl implements RideService {
    
    @Autowired
    private RideDaoImpl dao;
    
    @Autowired
    private EmployeeDaoImpl employeeDao;
    
    @Autowired
    private VehicleDaoImpl vehicleDao;
    
    public void setRideDao(RideDaoImpl rideDao) {
        this.dao = rideDao;
    }

    @Transactional
    @Override        
    public RideDto create(RideDto rideDto) {
        if (rideDto == null) {
            throw new NullPointerException("rideDto");
        }
                
        Ride entity = RideConverter.dtoToEntity(rideDto);
        entity.setId(null);
        entity.setEmployee(employeeDao.findById(rideDto.getEmployee().getId()));
        entity.setVehicle(vehicleDao.findById(rideDto.getVehicle().getId()));
                
        dao.persist(entity);
        
        return RideConverter.entityToDto(entity);
    }

    @Transactional
    @Override        
    public void delete(Long id) {
        if (id == null){
            throw new NullPointerException("id");
        }
        
        dao.remove(dao.findById(id));
    }

    @Transactional
    @Override     
    public void update(RideDto rideDto) {
        if (rideDto == null) {
            throw new NullPointerException("rideDto");
        }
        
        dao.update(RideConverter.dtoToEntity(rideDto));
    }

    @Transactional
    @Override        
    public RideDto findById(Long id) {
        if (id == null){
            throw new NullPointerException("id");
        }
        
        return RideConverter.entityToDto(dao.findById(id));
    }

    @Transactional
    @Override        
    public List<RideDto> findAll() {
        return RideConverter.entityToDto(dao.findAll());
    }
    
}
