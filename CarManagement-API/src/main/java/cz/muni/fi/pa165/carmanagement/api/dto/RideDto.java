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
public class RideDto {
    private Long id;
    
    private Date startTime;
    
    private Date endTime;
    
    private Long tachometerStart;
    
    private Long tachometerEnd;
    
    private String description;
    
    private VehicleDto vehicle;  
    
    private EmployeeDto employee;

    public RideDto() {
    }

    public RideDto(Long id, Date startTime, Date endTime, Long tachometerStart, Long tachometerEnd, String description, VehicleDto vehicle, EmployeeDto employee) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.tachometerStart = tachometerStart;
        this.tachometerEnd = tachometerEnd;
        this.description = description;
        this.vehicle = vehicle;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getTachometerStart() {
        return tachometerStart;
    }

    public void setTachometerStart(Long tachometerStart) {
        this.tachometerStart = tachometerStart;
    }

    public Long getTachometerEnd() {
        return tachometerEnd;
    }

    public void setTachometerEnd(Long tachometerEnd) {
        this.tachometerEnd = tachometerEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VehicleDto getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDto vehicle) {
        this.vehicle = vehicle;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }
    
    
}
