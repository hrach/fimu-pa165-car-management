/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pa165.carmanagement.api.dto;

import java.util.Date;

/**
 *
 * @author Jakub Marecek <xmarec at gmail.com>
 */
public class ServiceIntervalDto {
    private Long id;
    
    private Date createdTime;
    
    private Date dueTime;
    
    private Date doneTime;
    
    private VehicleDto vehicle;
    
    private ServiceTypeDto serviceType;

    public ServiceIntervalDto() {
    }

    public ServiceIntervalDto(Long id, Date createdTime, Date dueTime, Date doneTime, VehicleDto vehicle, ServiceTypeDto serviceType) {
        this.id = id;
        this.createdTime = createdTime;
        this.dueTime = dueTime;
        this.doneTime = doneTime;
        this.vehicle = vehicle;
        this.serviceType = serviceType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getDueTime() {
        return dueTime;
    }

    public void setDueTime(Date dueTime) {
        this.dueTime = dueTime;
    }

    public Date getDoneTime() {
        return doneTime;
    }

    public void setDoneTime(Date doneTime) {
        this.doneTime = doneTime;
    }

    public VehicleDto getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDto vehicle) {
        this.vehicle = vehicle;
    }

    public ServiceTypeDto getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceTypeDto serviceType) {
        this.serviceType = serviceType;
    }
    
    
}
