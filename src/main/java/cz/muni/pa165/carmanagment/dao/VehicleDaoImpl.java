
package cz.muni.pa165.carmanagment.dao;

import cz.muni.pa165.carmanagment.model.Vehicle;
import javax.persistence.EntityManager;


/**
 * DAO for Vehicle.
 * @author tomasbobek
 */
public class VehicleDaoImpl extends GeneralDaoImpl<Long, Vehicle> {
    
    public VehicleDaoImpl(EntityManager em) {
        super(em);
    }
    
}
