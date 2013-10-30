/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.pa165.carmanagment.service;

import cz.muni.pa165.carmanagment.dto.ServiceTypeDto;
import java.util.List;

/**
 *
 * @author zvonicek
 */
interface ServiceTypeService {

    public void create(ServiceTypeDto type);

    public void delete(Long id);

    public void update(ServiceTypeDto type);

    public ServiceTypeDto findById(Long id);

    public List<ServiceTypeDto> findAll();
}
