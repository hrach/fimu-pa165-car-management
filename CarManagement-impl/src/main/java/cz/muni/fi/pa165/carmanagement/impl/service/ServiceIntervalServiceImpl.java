/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.dto.ServiceIntervalDto;
import cz.muni.fi.pa165.carmanagement.api.service.ServiceInterface;
import cz.muni.fi.pa165.carmanagement.api.service.ServiceIntervalService;
import cz.muni.fi.pa165.carmanagement.api.service.ServiceTypeService;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleService;
import cz.muni.fi.pa165.carmanagement.impl.dao.ServiceIntervalDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.ServiceInterval;
import cz.muni.fi.pa165.carmanagement.impl.model.ServiceType;
import cz.muni.fi.pa165.carmanagement.impl.model.Vehicle;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceIntervalServiceImpl extends GeneralService<ServiceInterval, ServiceIntervalDto> implements ServiceIntervalService<ServiceInterval> {
    
    @Autowired    
    private ServiceIntervalDaoImpl dao;
    
    public void setDao(ServiceIntervalDaoImpl dao) {
        this.dao = dao;
    }
    
    @Autowired
    private VehicleService<Vehicle> vehicleService;
    
    @Autowired
    private ServiceTypeService<ServiceType> serviceTypeService;

    @Transactional
    @Override        
    public ServiceIntervalDto create(ServiceIntervalDto serviceIntervalDto) {
        if (serviceIntervalDto == null) {
            throw new NullPointerException("serviceIntervalDto");
        }
        
        serviceIntervalDto.setId(null);
        
        ServiceInterval entity = this.dtoToEntity(serviceIntervalDto);
        
        dao.persist(entity);
        
        return this.entityToDto(entity);
    }

    public void delete(Long id) {
        if (id == null){
            throw new NullPointerException("id");
        }
        
        dao.remove(dao.findById(id));
    }

    @Transactional
    @Override    
    public void update(ServiceIntervalDto serviceIntervalDto) {
        if (serviceIntervalDto == null) {
            throw new NullPointerException("serviceIntervalDto");
        }
        
        dao.update(this.dtoToEntity(serviceIntervalDto));
    }

    @Transactional
    @Override        
    public ServiceIntervalDto findById(Long id) {
        if (id == null){
            throw new NullPointerException("id");
        }
        
        return this.entityToDto(dao.findById(id));
    }

    @Transactional
    @Override        
    public List<ServiceIntervalDto> findAll() {
        return this.entityToDto(dao.findAll());
    }

    @Transactional
    @Override        
    public void setIntervalAsDoneForId(Long id) {
        if (id == null){
            throw new NullPointerException("id");
        }

        ServiceInterval sid = dao.findById(id);
        Date actualDate = new Date();
        sid.setDoneTime(actualDate);
        
        dao.update(sid);
    }
    
    public ServiceIntervalDto entityToDto(ServiceInterval entity, ServiceInterface parent) {
        if (entity == null){
            return null;
        }
        
        ServiceIntervalDto dto = new ServiceIntervalDto();
        
        dto.setId(entity.getId());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setDueTime(entity.getDueTime());
        dto.setDoneTime(entity.getDoneTime());

        if (!(parent instanceof ServiceTypeService)) {
            dto.setServiceType(this.serviceTypeService.entityToDto(entity.getServiceType(), this));
        } else if (!(parent instanceof VehicleService)) {
            dto.setVehicle(this.vehicleService.entityToDto(entity.getVehicle(), this));
        }

        return dto;
    }
    
    public ServiceInterval dtoToEntity(ServiceIntervalDto dto, ServiceInterface parent) {
        if (dto == null) {
            return null;
        }
        
        ServiceInterval entity = new ServiceInterval();
        
        entity.setId(dto.getId());
        entity.setCreatedTime(dto.getCreatedTime());
        entity.setDueTime(dto.getDueTime());
        entity.setDoneTime(dto.getDoneTime());

        if (!(parent instanceof ServiceTypeService)) {
            entity.setServiceType(this.serviceTypeService.dtoToEntity(dto.getServiceType(), this));
        } else if (!(parent instanceof VehicleService)) {
            entity.setVehicle(this.vehicleService.dtoToEntity(dto.getVehicle(), this));
        }

        return entity;
    }

}
