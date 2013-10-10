/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.pa165.carmanagment;

import javax.persistence.EntityManager;

/**
 *
 * @author tomasbobek
 */
public class VehicleDao extends GeneralDao<Long, Vehicle> {
    
    public VehicleDao(EntityManager em) {
        super(em);
    }
    
}
