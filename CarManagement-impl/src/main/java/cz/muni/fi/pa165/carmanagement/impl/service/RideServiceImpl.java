/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.api.dto.RideDto;
import cz.muni.fi.pa165.carmanagement.api.service.EmployeeService;
import cz.muni.fi.pa165.carmanagement.api.service.RideService;
import cz.muni.fi.pa165.carmanagement.api.service.ServiceInterface;
import cz.muni.fi.pa165.carmanagement.api.service.VehicleService;
import cz.muni.fi.pa165.carmanagement.impl.dao.EmployeeDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.dao.RideDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.dao.VehicleDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.Employee;
import cz.muni.fi.pa165.carmanagement.impl.model.Ride;
import cz.muni.fi.pa165.carmanagement.impl.model.Vehicle;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RideServiceImpl extends GeneralService<Ride, RideDto> implements RideService<Ride> {
    
    @Autowired
    private RideDaoImpl dao;
    
    @Autowired
    private EmployeeDaoImpl employeeDao;
    
    @Autowired
    private EmployeeService<Employee> employeeService;
    
    @Autowired
    private VehicleDaoImpl vehicleDao;
    
    @Autowired
    private VehicleService<Vehicle> vehicleService;
    
    public void setRideDao(RideDaoImpl rideDao) {
        this.dao = rideDao;
    }

    public void setEmployeeDao(EmployeeDaoImpl employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setVehicleDao(VehicleDaoImpl vehicleDao) {
        this.vehicleDao = vehicleDao;
    }        

    @Transactional
    @Override        
    public RideDto create(RideDto rideDto) {
        if (rideDto == null) {
            throw new NullPointerException("rideDto");
        }
                
        Ride entity = this.dtoToEntity(rideDto);
        entity.setId(null);
        entity.setEmployee(employeeDao.findById(rideDto.getEmployee().getId()));
        entity.setVehicle(vehicleDao.findById(rideDto.getVehicle().getId()));
                
        dao.persist(entity);
        
        return this.entityToDto(entity);
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
        
        dao.update(this.dtoToEntity(rideDto));
    }

    @Transactional
    @Override        
    public RideDto findById(Long id) {
        if (id == null){
            throw new NullPointerException("id");
        }
        
        return this.entityToDto(dao.findById(id));
    }

    @Transactional
    @Override        
    public List<RideDto> findAll() {
        return this.entityToDto(dao.findAll());
    }
    
    public RideDto entityToDto(Ride entity, ServiceInterface parent) {
        if (entity == null) {
            return null;
        }

        RideDto dto = new RideDto();
        
        dto.setId(entity.getId());
        dto.setStartTime(entity.getStartTime());
        dto.setEndTime(entity.getEndTime());
        dto.setTachometerStart(entity.getTachometerStart());
        dto.setTachometerEnd(entity.getTachometerEnd());
        dto.setDescription(entity.getDescription());

        if (!(parent instanceof EmployeeService)) {
            dto.setEmployee(this.employeeService.entityToDto(entity.getEmployee(), this));
        } else if (!(parent instanceof VehicleService)) {
            dto.setVehicle(this.vehicleService.entityToDto(entity.getVehicle(), this));
        }

        return dto;
    }
    
    public Ride dtoToEntity(RideDto dto, ServiceInterface parent) {
        if (dto == null) {
            return null;
        }

        Ride entity = new Ride();
        
        entity.setId(dto.getId());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());
        entity.setTachometerStart(dto.getTachometerStart());
        entity.setTachometerEnd(dto.getTachometerEnd());
        entity.setDescription(dto.getDescription());
        
        if (!(parent instanceof EmployeeService)) {
            entity.setEmployee(this.employeeService.dtoToEntity(dto.getEmployee(), this));
        } else if (!(parent instanceof VehicleService)) {        
            entity.setVehicle(this.vehicleService.dtoToEntity(dto.getVehicle(), this));
        }

        return entity;
    }

}
