/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.pa165.carmanagment;

import javax.persistence.EntityManager;

/**
 *
 * @author Jakub Marecek <xmarec at gmail.com>
 */
public class EmployeeDao extends GeneralDao<Long, Employee>{
    
    public EmployeeDao (EntityManager em){
        super(em);        
    }
}
