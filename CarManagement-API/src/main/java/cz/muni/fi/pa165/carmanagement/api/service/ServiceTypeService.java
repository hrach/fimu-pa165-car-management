package cz.muni.fi.pa165.carmanagement.api.service;

import cz.muni.fi.pa165.carmanagement.api.dto.ServiceTypeDto;
import java.util.List;

/**
 * @author zvonicek
 */
public interface ServiceTypeService {

    public ServiceTypeDto create(ServiceTypeDto type);

    public void delete(Long id);

    public void update(ServiceTypeDto type);

    public ServiceTypeDto findById(Long id);

    public List<ServiceTypeDto> findAll();

}
