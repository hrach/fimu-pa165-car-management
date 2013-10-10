/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.pa165.carmanagment;

import java.util.List;

/**
 * General DAO interface - involves all shared DAO methods.
 * 
 * @author tomasbobek
 */
public interface IGeneralDao<K, E> {
    
    /**
     * Creates or updates selected entity in database.
     * 
     * @param entity 
     */
    void persist(E entity);
    
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
     * @param entity
     * @return List<Entity>
     */
    List<E> findAll(E entity);
}
