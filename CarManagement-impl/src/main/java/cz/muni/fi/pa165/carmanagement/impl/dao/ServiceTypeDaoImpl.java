
package cz.muni.fi.pa165.carmanagement.impl.dao;

import cz.muni.fi.pa165.carmanagement.impl.model.ServiceType;
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
