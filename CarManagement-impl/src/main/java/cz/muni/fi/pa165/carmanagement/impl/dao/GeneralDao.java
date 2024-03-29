package cz.muni.fi.pa165.carmanagement.impl.dao;

import java.util.List;


/**
 * General DAO interface - involves all shared DAO methods.
 * @author tomasbobek
 */
public interface GeneralDao<K, E> {
    
    /**
     * Creates or updates selected entity in database.
     * 
     * @param entity 
     */
    void persist(E entity);
    
    /**
     * Updates selected entity in database.
     * 
     * @param entity 
     */
    void update(E entity);
    
    /**
     * Removes selected entity in database.
     * 
     * @param entity 
     */
    void remove(E entity);
    
    /**
     * Finds and returns an entity by its ID.
     * 
     * @param id
     * @return Entity
     */
    E findById(K id);
    
    /**
     * Finds all entites of selected type and returns them in a list.
     * 
     * @return List<Entity>
     */
    List<E> findAll();

}
