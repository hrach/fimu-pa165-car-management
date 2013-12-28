/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.impl.adapter;

import cz.muni.fi.pa165.carmanagement.impl.model.Employee;
import java.util.HashSet;
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
    
    public EmployeeDetailsAdapter(Employee employee) {        
        super(employee.getUsername(), employee.getPassword(), roleToAuthorities(employee.getStringRole()));
        this.employeeId = employee.getId();
    }
    
    private static Set<GrantedAuthority> roleToAuthorities(String role) {
        Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
        auths.add(new SimpleGrantedAuthority(role));
        // every logged user has role USER
        auths.add(new SimpleGrantedAuthority("ROLE_USER"));
        return auths;
    }
    
    public Long getId() {
        return employeeId;
    }
}
