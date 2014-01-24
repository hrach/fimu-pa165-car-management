package cz.muni.fi.pa165.carmanagement.impl.dao;

import cz.muni.fi.pa165.carmanagement.impl.model.Vehicle;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
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
    
    public List<Vehicle> findAllSuitableForSelection() {
        final String queryString = "SELECT v FROM Vehicle v WHERE v.tachometer < v.type.maxKm";
        TypedQuery<Vehicle> query = em.createQuery(queryString, Vehicle.class);
                
        return query.getResultList();
    }    
        
}
