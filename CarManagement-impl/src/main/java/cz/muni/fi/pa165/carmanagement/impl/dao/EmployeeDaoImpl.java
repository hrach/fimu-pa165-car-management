package cz.muni.fi.pa165.carmanagement.impl.dao;

import cz.muni.fi.pa165.carmanagement.impl.model.Employee;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;


/**
 * DAO for Employee.
 * @author Jakub Marecek <xmarec at gmail.com>
 */
@Repository
public class EmployeeDaoImpl extends GeneralDaoImpl<Long, Employee> {
    
    public EmployeeDaoImpl(EntityManager em) {
        super(em);        
    }

    public EmployeeDaoImpl() {
        super();
    }       
}
