package cz.muni.fi.pa165.carmanagement.impl.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;


/**
 * Implementation of general DAO interface.
 * @author tomasbobek
 */
@Repository
public abstract class GeneralDaoImpl<K, E> implements GeneralDao<K, E> {
    
    private Class<E> entityClass;

    @PersistenceContext
    protected EntityManager em;

    public GeneralDaoImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];        
    }    
    
    public GeneralDaoImpl(EntityManager em) {        
        this();
        
        if (em == null) {
            throw new IllegalArgumentException("Parameter em is null");
        }
        
        this.em = em;        
    }

    @Override
    public void persist(E entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Parameter entity is null");
        }
        
        em.persist(entity);
    }
    
    @Override
    public void update(E entity) {
        if (em == null) {
            throw new IllegalArgumentException("Parameter entity is null");
        }

        em.merge(entity);
    }
    
    @Override
    public void remove(E entity) {
        if (em == null) {
            throw new IllegalArgumentException("Parameter entity is null");
        }
        
        em.remove(entity);
    }
    
    @Override
    public E findById(K id) {
        if (id == null) {
            throw new IllegalArgumentException("Parameter id is null");
        }
        
        return em.find(entityClass, id);
    }
    
    @Override
    public List<E> findAll() {
        TypedQuery query = em.createQuery("SELECT e FROM " + entityClass.getName() + " e", entityClass);
        return (List<E>) query.getResultList();
    }

}
