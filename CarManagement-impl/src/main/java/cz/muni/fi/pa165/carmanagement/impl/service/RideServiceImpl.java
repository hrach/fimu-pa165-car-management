/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import cz.muni.fi.pa165.carmanagement.api.service.RideService;
import cz.muni.fi.pa165.carmanagement.impl.converter.RideConverter;
import cz.muni.fi.pa165.carmanagement.impl.dao.RideDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.Ride;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RideServiceImpl implements RideService {
    
    private RideDaoImpl dao;
    
    public void setRideDao(RideDaoImpl rideDao) {
        this.dao = rideDao;
    }

    public void create(RideDto rideDto) {
        if (rideDto == null) {
            throw new NullPointerException("rideDto");
        }
        
        Ride entity = RideConverter.dtoToEntity(rideDto);
        
        dao.persist(entity);
    }

    public void delete(Long id) {
        if (id == null){
            throw new NullPointerException("id");
        }
        
        dao.remove(dao.findById(id));
    }

    public void update(RideDto rideDto) {
        if (rideDto == null) {
            throw new NullPointerException("rideDto");
        }
        
        dao.update(RideConverter.dtoToEntity(rideDto));
    }

    public RideDto findById(Long id) {
        if (id == null){
            throw new NullPointerException("id");
        }
        
        return RideConverter.entityToDto(dao.findById(id));
    }

    public List<RideDto> findAll() {
        return RideConverter.entityToDto(dao.findAll());
    }
    
}
