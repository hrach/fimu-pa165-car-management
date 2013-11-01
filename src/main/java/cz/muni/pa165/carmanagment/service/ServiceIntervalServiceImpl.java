/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.pa165.carmanagment.service;

import cz.muni.pa165.carmanagment.converter.ServiceIntervalConverter;
import cz.muni.pa165.carmanagment.converter.VehicleConverter;
import cz.muni.pa165.carmanagment.dao.ServiceIntervalDaoImpl;
import cz.muni.pa165.carmanagment.dto.ServiceIntervalDto;
import cz.muni.pa165.carmanagment.dto.VehicleDto;
import cz.muni.pa165.carmanagment.model.ServiceInterval;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ServiceIntervalServiceImpl implements ServiceIntervalService {
    
    private ServiceIntervalDaoImpl dao;

    public void create(ServiceIntervalDto serviceIntervalDto) {
        if (serviceIntervalDto == null) {
            throw new NullPointerException("serviceIntervalDto");
        }
        
        ServiceInterval entity = ServiceIntervalConverter.dtoToEntity(serviceIntervalDto);
        
        dao.persist(entity);
    }

    public void delete(Long id) {
        if (id == null){
            throw new NullPointerException("id");
        }
        
        dao.remove(dao.findById(id));
    }

    public void update(ServiceIntervalDto serviceIntervalDto) {
        if (serviceIntervalDto == null) {
            throw new NullPointerException("serviceIntervalDto");
        }
        
        dao.update(ServiceIntervalConverter.dtoToEntity(serviceIntervalDto));
    }

    public ServiceIntervalDto findById(Long id) {
        if (id == null){
            throw new NullPointerException("id");
        }
        
        return ServiceIntervalConverter.entityToDto(dao.findById(id));
    }

    public List<ServiceIntervalDto> findAll() {
        return ServiceIntervalConverter.entityToDto(dao.findAll());
    }

    public void setIntervalAsDoneForId(Long id) {
        if (id == null){
            throw new NullPointerException("id");
        }

        ServiceInterval sid = dao.findById(id);
        Date actualDate = new Date();
        sid.setDoneTime(actualDate);
        
        dao.update(sid);
    }
    
}
