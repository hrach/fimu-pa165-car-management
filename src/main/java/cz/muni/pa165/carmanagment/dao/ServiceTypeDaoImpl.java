
package cz.muni.pa165.carmanagment.dao;

import cz.muni.pa165.carmanagment.model.ServiceType;
import javax.persistence.EntityManager;


/**
 * DAO for ServiceType.
 * @author tomasbobek
 */
public class ServiceTypeDaoImpl extends GeneralDaoImpl<Long, ServiceType> {
    
    public ServiceTypeDaoImpl(EntityManager em) {
        super(em);
    }

    public ServiceTypeDaoImpl() {
        super();
    }
    
}
