
package cz.muni.pa165.carmanagment.dao;

import cz.muni.pa165.carmanagment.model.ServiceType;
import javax.persistence.EntityManager;


/**
 * DAO for ServiceType.
 * @author tomasbobek
 */
public class ServiceTypeDao extends GeneralDao<Long, ServiceType> {
    
    public ServiceTypeDao(EntityManager em) {
        super(em);
    }
    
}
