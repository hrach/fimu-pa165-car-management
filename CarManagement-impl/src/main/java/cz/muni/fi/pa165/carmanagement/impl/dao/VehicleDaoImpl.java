package cz.muni.fi.pa165.carmanagement.impl.dao;

import cz.muni.fi.pa165.carmanagement.impl.model.Vehicle;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;


/**
 * DAO for Vehicle.
 * @author tomasbobek
 */
@Repository
public class VehicleDaoImpl extends GeneralDaoImpl<Long, Vehicle> {
    
    public VehicleDaoImpl(EntityManager em) {
        super(em);
    }

    public VehicleDaoImpl() {
        super();
    }
        
}
