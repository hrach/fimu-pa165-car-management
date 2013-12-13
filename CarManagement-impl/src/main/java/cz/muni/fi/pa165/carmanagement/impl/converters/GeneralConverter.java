package cz.muni.fi.pa165.carmanagement.impl.converters;

import java.util.ArrayList;
import java.util.List;

/**
 * @author skrasek
 */
public abstract class GeneralConverter<E, D> implements Converter {

    abstract public D entityToDto(E entity, Converter parent);
    
    public D entityToDto(E entity) {
        return this.entityToDto(entity, null);
    }

    public List<D> entityToDto(List<E> entities) {
        return this.entityToDto(entities, null);
    }

    public List<D> entityToDto(List<E> entities, Converter parent) {
        if (entities == null){
            return null;
        }
        
        List<D> list = new ArrayList<D>();
        for (E e : entities) {
            list.add(this.entityToDto(e, parent));
        }

        return list;
    }

    abstract public E dtoToEntity(D dto, Converter parent);
    
    public E dtoToEntity(D dto) {
        return this.dtoToEntity(dto, null);
    }

    public List<E> dtoToEntity(List<D> dtos) {
        return this.dtoToEntity(dtos, null);
    }
    
    public List<E> dtoToEntity(List<D> dtos, Converter parent) {
        if (dtos == null){
            return null;
        }
        
        List<E> list = new ArrayList<E>();
        for (D dto : dtos) {
            list.add(this.dtoToEntity(dto, parent));
        }
        
        return list;
    }

}
