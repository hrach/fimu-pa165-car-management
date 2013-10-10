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
public class VehicleTypeDao extends GeneralDao<Long, VehicleType> {
    
    public VehicleTypeDao(EntityManager em) {
        super(em);
    }
    
}
