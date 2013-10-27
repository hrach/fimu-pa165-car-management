
package cz.muni.pa165.carmanagment.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Implementation of general DAO interface.
 * @author tomasbobek
 */
@Repository
public abstract class GeneralDao<K, E> implements IGeneralDao<K, E> {
    
    private Class<E> entityClass;

    @PersistenceContext
    private EntityManager em;

    
    public GeneralDao(EntityManager em) {
        if (em == null) {
            throw new IllegalArgumentException("Parameter em is null");
        }
        
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
        this.em = em;
    }

    @Override
    @Transactional
    public void persist(E entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Parameter entity is null");
        }
        
        em.persist(entity);
    }
    
    @Override
    @Transactional
    public void update(E entity) {
        if (em == null) {
            throw new IllegalArgumentException("Parameter entity is null");
        }

        em.merge(entity);
    }
    
    @Override
    @Transactional
    public void remove(E entity) {
        if (em == null) {
            throw new IllegalArgumentException("Parameter entity is null");
        }
        
        em.remove(entity);
    }
    
    @Override
    @Transactional
    public E findById(K id) {
        if (id == null) {
            throw new IllegalArgumentException("Parameter id is null");
        }
        
        return em.find(entityClass, id);
    }
    
    @Override
    @Transactional
    public List<E> findAll() {
        TypedQuery query = em.createQuery("SELECT e FROM " + entityClass.getName() + " e", entityClass);
        return (List<E>) query.getResultList();
    }

}
