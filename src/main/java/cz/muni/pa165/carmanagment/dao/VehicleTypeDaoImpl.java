
package cz.muni.pa165.carmanagment.dao;

import cz.muni.pa165.carmanagment.model.VehicleType;
import javax.persistence.EntityManager;


/**
 * DAO for VehticleType.
 * @author tomasbobek
 */
public class VehicleTypeDaoImpl extends GeneralDaoImpl<Long, VehicleType> {
    
    public VehicleTypeDaoImpl(EntityManager em) {
        super(em);
    }
    
    public VehicleTypeDaoImpl() {
        super();
    }
    
}
