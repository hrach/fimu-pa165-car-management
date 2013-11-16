/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pa165.carmanagement.api.service;

import cz.muni.fi.pa165.carmanagement.api.dto.ServiceIntervalDto;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jakub Marecek <xmarec at gmail.com>
 */

@Service
public interface ServiceIntervalService {
    
    public ServiceIntervalDto create(ServiceIntervalDto serviceIntervalDto);

    public void delete(Long id);

    public void update(ServiceIntervalDto serviceIntervalDto);

    public ServiceIntervalDto findById(Long id);

    public List<ServiceIntervalDto> findAll(); 
        
    public void setIntervalAsDoneForId(Long id);
}
