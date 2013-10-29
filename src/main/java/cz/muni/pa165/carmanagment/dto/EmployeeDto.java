/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.pa165.carmanagment.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jakub Marecek <xmarec at gmail.com>
 */
public class EmployeeDto {
    private Long id;
    
    private String firstName;
    
    private String familyName;
    
    private int employeeRole;
    
    private List<RideDto> rides;

    public EmployeeDto() {
        this.rides = new ArrayList<RideDto>();
    }

    public EmployeeDto(Long id, String firstName, String familyName, int employeeRole) {
        this.rides = new ArrayList<RideDto>();
        this.id = id;
        this.firstName = firstName;
        this.familyName = familyName;
        this.employeeRole = employeeRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(int employeeRole) {
        this.employeeRole = employeeRole;
    }

    public List<RideDto> getRides() {
        return rides;
    }

    public void setRides(List<RideDto> rides) {
        this.rides = rides;
    }
    
    
}
