/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pa165.carmanagement.api.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Jakub Marecek <xmarec at gmail.com>
 */
public class EmployeeDto {
    private Long id;
    
    private String firstName;
    
    private String familyName;
    
    private String username;
    
    private String password;
    
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

    public EmployeeDto(Long id, String firstName, String familyName, int employeeRole, String username, String password) {
        this.rides = new ArrayList<RideDto>();
        this.id = id;
        this.firstName = firstName;
        this.familyName = familyName;
        this.employeeRole = employeeRole;
        this.username = username;
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        
    public String getName() {
        return this.firstName + ' ' + this.familyName;
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
    
    public int getRideKmSum() {
        int sum = 0;
        for (RideDto r : this.getRides()) {
            sum += r.getTachometerEnd() - r.getTachometerStart();
        }
        
        return sum;
    }
    
    public int getUniqueVehicleSum() {
        Set<Long> ids = new HashSet<Long>();
        for (RideDto r : this.getRides()) {
            ids.add(r.getVehicle().getId());
        }
        
        return ids.size();
    }
    
}
