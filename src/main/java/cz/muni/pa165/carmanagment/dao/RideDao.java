
package cz.muni.pa165.carmanagment.dao;

import cz.muni.pa165.carmanagment.model.Ride;
import javax.persistence.EntityManager;


/**
 * DAO for Ride.
 * @author Jakub Marecek <xmarec at gmail.com>
 */
public class RideDao extends GeneralDao<Long, Ride> {
    
    public RideDao(EntityManager em) {
        super(em);        
    }

}
