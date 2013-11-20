package cz.muni.fi.pa165.carmanagement.api.service;

import java.util.List;

/**
 * @author skrasek
 */
public interface ServiceInterface<E, D> {
    
    public D entityToDto(E entity, ServiceInterface parent);
    
    public D entityToDto(E entity);

    public List<D> entityToDto(List<E> entities);

    public List<D> entityToDto(List<E> entities, ServiceInterface parent);

    public E dtoToEntity(D dto, ServiceInterface parent);
    
    public E dtoToEntity(D dto);

    public List<E> dtoToEntity(List<D> dtos);
    
    public List<E> dtoToEntity(List<D> dtos, ServiceInterface parent);
    
}
