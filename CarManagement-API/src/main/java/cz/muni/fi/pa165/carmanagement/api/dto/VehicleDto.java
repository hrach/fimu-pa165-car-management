/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.api.dto;

/**
 * Vehicle data transfer object
 * 
 * @author zvonicek
 */
public class VehicleDto
{
    private Long id;

    private String name;
    
    private Long tachometer;

    private VehicleTypeDto type;

    public VehicleDto(Long id, String name, Long tachometer, VehicleTypeDto type)
    {
        this.id = id;
        this.name = name;
        this.tachometer = tachometer;
        this.type = type;
    }

    public VehicleDto(String name, Long tachometer, VehicleTypeDto type) {
        this.name = name;
        this.tachometer = tachometer;
        this.type = type;
    }
        
    public VehicleDto()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getTachometer()
    {
        return tachometer;
    }

    public void setTachometer(Long tachometer)
    {
        this.tachometer = tachometer;
    }

    public VehicleTypeDto getType()
    {
        return type;
    }

    public void setType(VehicleTypeDto type)
    {
        this.type = type;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VehicleDto other = (VehicleDto) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }        
}
