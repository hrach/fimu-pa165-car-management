package cz.muni.fi.pa165.carmanagement.impl.dao;

import cz.muni.fi.pa165.carmanagement.impl.model.Employee;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
    
    public Employee findByUsername(String username) {
        final String queryString = "SELECT e FROM Employee e WHERE e.username = :name";
        TypedQuery<Employee> query = em.createQuery(queryString, Employee.class);
        query.setParameter("name", username);
                
        return query.getSingleResult();
    }
}
