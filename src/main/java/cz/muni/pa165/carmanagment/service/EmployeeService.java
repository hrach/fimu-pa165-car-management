/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.pa165.carmanagment.service;

import cz.muni.pa165.carmanagment.dto.EmployeeDto;
import java.util.List;

/**
 *
 * @author Jakub Marecek <xmarec at gmail.com>
 */
public interface EmployeeService {
    
    public void create(EmployeeDto type);

    public void delete(Long id);

    public void update(EmployeeDto type);

    public EmployeeDto findById(Long id);

    public List<EmployeeDto> findAll(); 
}
