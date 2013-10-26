
package cz.muni.pa165.carmanagment.dao;

import cz.muni.pa165.carmanagment.model.Employee;
import javax.persistence.EntityManager;


/**
 * DAO for Employee.
 * @author Jakub Marecek <xmarec at gmail.com>
 */
public class EmployeeDao extends GeneralDao<Long, Employee> {
    
    public EmployeeDao(EntityManager em) {
        super(em);        
    }

}
