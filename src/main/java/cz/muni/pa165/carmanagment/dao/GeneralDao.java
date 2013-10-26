
package cz.muni.pa165.carmanagment.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


/**
 * Implementation of general DAO interface.
 * @author tomasbobek
 */
public abstract class GeneralDao<K, E> implements IGeneralDao<K, E> {
    
    private Class<E> entityClass;

    @PersistenceContext
    private EntityManager em;

    
    public GeneralDao(EntityManager em) {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
        this.em = em;
    }


    public void persist(E entity) {
        em.persist(entity);
    }
    
    public void update(E entity) {
        em.merge(entity);
    }
    
    public void remove(E entity) {
        em.remove(entity);
    }
    
    public E findById(K id) {
        return em.find(entityClass, id);
    }
    
    public List<E> findAll() {
        TypedQuery query = em.createQuery("SELECT e FROM " + entityClass.getName() + " e", entityClass);
        return (List<E>) query.getResultList();
    }

}
