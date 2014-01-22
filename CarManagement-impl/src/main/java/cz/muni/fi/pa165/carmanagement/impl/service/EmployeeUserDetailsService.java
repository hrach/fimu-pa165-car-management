/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.impl.service;

import cz.muni.fi.pa165.carmanagement.impl.adapter.EmployeeDetailsAdapter;
import cz.muni.fi.pa165.carmanagement.impl.dao.EmployeeDaoImpl;
import cz.muni.fi.pa165.carmanagement.impl.model.Employee;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author zvonicek
 */
@Service(value = "employeeUserDetailsService")
public class EmployeeUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeDaoImpl dao;

    public void setDao(EmployeeDaoImpl dao) {
        this.dao = dao;
    }    
    
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        try {
            Employee e = dao.findByUsername(string);
            
            if(e == null)
                throw new UsernameNotFoundException("Employee not found");
            
            return new EmployeeDetailsAdapter(e);
        } catch (NoResultException ex) {
            throw new UsernameNotFoundException("Employee not found");
        }                
    }    
}
