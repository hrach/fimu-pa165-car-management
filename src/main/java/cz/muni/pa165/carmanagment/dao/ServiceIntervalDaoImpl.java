
package cz.muni.pa165.carmanagment.dao;

import cz.muni.pa165.carmanagment.model.ServiceInterval;
import javax.persistence.EntityManager;


/**
 * DAO for ServiceInterval.
 * @author tomasbobek
 */
public class ServiceIntervalDaoImpl extends GeneralDaoImpl<Long, ServiceInterval> {
    
    public ServiceIntervalDaoImpl(EntityManager em) {
        super(em);
    }

    public ServiceIntervalDaoImpl() {
        super();
    }            
}
