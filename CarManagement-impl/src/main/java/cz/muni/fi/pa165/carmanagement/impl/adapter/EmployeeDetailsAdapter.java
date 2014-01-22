/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.impl.adapter;

import cz.muni.fi.pa165.carmanagement.impl.model.Employee;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author zvonicek
 */
public class EmployeeDetailsAdapter extends User {
    private final Long employeeId;
    private String employeeName;

    public String getEmployeeName() {
        return employeeName;
    }        
    
    public EmployeeDetailsAdapter(Employee employee) {        
        super(employee.getUsername(), employee.getPassword(), roleToAuthorities(employee.getStringRole()));
        this.employeeId = employee.getId();
        this.employeeName = employee.getFirstName()+" "+employee.getFamilyName();
    }
    
    private static Set<GrantedAuthority> roleToAuthorities(List<String> roles) {
        Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
        for (String role : roles) {
            auths.add(new SimpleGrantedAuthority(role));
        }
        // every logged user has role USER
        auths.add(new SimpleGrantedAuthority("ROLE_USER"));
        return auths;
    }
    
    public Long getId() {
        return employeeId;
    }
}
