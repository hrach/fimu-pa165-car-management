
package cz.muni.fi.pa165.carmanagement.impl.dao;

import cz.muni.fi.pa165.carmanagement.impl.model.VehicleType;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;


/**
 * DAO for VehticleType.
 * @author tomasbobek
 */
@Repository
public class VehicleTypeDaoImpl extends GeneralDaoImpl<Long, VehicleType> {
    
    public VehicleTypeDaoImpl(EntityManager em) {
        super(em);
    }
    
    public VehicleTypeDaoImpl() {
        super();
    }
    
}
