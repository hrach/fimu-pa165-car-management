package cz.muni.fi.pa165.carmanagement.impl.dao;

import cz.muni.fi.pa165.carmanagement.impl.model.ServiceInterval;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;


/**
 * DAO for ServiceInterval.
 * @author tomasbobek
 */
@Repository
public class ServiceIntervalDaoImpl extends GeneralDaoImpl<Long, ServiceInterval> {
    
    public ServiceIntervalDaoImpl(EntityManager em) {
        super(em);
    }

    public ServiceIntervalDaoImpl() {
        super();
    }

}
