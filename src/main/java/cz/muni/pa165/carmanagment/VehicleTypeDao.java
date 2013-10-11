
package cz.muni.pa165.carmanagment;

import javax.persistence.EntityManager;


/**
 * DAO for VehticleType.
 * @author tomasbobek
 */
public class VehicleTypeDao extends GeneralDao<Long, VehicleType> {
    
    public VehicleTypeDao(EntityManager em) {
        super(em);
    }
    
}
