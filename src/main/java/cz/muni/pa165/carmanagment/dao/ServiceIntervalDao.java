
package cz.muni.pa165.carmanagment.dao;

import cz.muni.pa165.carmanagment.model.ServiceInterval;
import javax.persistence.EntityManager;


/**
 * DAO for ServiceInterval.
 * @author tomasbobek
 */
public class ServiceIntervalDao extends GeneralDao<Long, ServiceInterval> {
    
    public ServiceIntervalDao(EntityManager em) {
        super(em);
    }
    
}
