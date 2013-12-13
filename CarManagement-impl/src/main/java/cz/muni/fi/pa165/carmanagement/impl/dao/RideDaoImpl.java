package cz.muni.fi.pa165.carmanagement.impl.dao;

import cz.muni.fi.pa165.carmanagement.impl.model.Ride;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;


/**
 * DAO for Ride.
 * @author Jakub Marecek <xmarec at gmail.com>
 */
@Repository
public class RideDaoImpl extends GeneralDaoImpl<Long, Ride> {
    
    public RideDaoImpl(EntityManager em) {
        super(em);        
    }

    public RideDaoImpl() {
        super();
    }   
}
