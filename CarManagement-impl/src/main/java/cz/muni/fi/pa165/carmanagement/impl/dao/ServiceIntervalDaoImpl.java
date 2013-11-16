
package cz.muni.fi.pa165.carmanagement.impl.dao;

import cz.muni.fi.pa165.carmanagement.impl.model.ServiceInterval;
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
