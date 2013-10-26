
package cz.muni.pa165.carmanagment.dao;

import cz.muni.pa165.carmanagment.model.Vehicle;
import javax.persistence.EntityManager;


/**
 * DAO for Vehicle.
 * @author tomasbobek
 */
public class VehicleDao extends GeneralDao<Long, Vehicle> {
    
    public VehicleDao(EntityManager em) {
        super(em);
    }
    
}
