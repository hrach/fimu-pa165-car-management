/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.pa165.carmanagment.service;

import cz.muni.pa165.carmanagment.converter.RideConverter;
import cz.muni.pa165.carmanagment.dao.RideDaoImpl;
import cz.muni.pa165.carmanagment.dto.RideDto;
import cz.muni.pa165.carmanagment.model.Ride;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RideServiceImpl implements RideService {
    
    private RideDaoImpl dao;

    public void create(RideDto rideDto) {
        if (rideDto == null) {
            throw new IllegalArgumentException("Attribute rideDto is null");
        }
        
        Ride entity = RideConverter.dtoToEntity(rideDto);
        
        dao.persist(entity);
    }

    public void delete(Long id) {
        if (id == null){
            throw new IllegalArgumentException("ID is null");
        }
        
        dao.remove(dao.findById(id));
    }

    public void update(RideDto rideDto) {
        if (rideDto == null) {
            throw new IllegalArgumentException("Attribute rideDto is null");
        }
        
        dao.update(RideConverter.dtoToEntity(rideDto));
    }

    public RideDto findById(Long id) {
        if (id == null){
            throw new IllegalArgumentException("ID is null");
        }
        
        return RideConverter.entityToDto(dao.findById(id));
    }

    public List<RideDto> findAll() {
        return RideConverter.entityToDto(dao.findAll());
    }
    
}
