package cz.muni.pa165.carmanagment.dto;

/**
 *
 * @author zvonicek
 */
public class VehicleTypeDto
{
    private Long id;
    
    private Long maxKm;
        

    public VehicleTypeDto(Long id, Long maxKm)
    {
        this.id = id;
        this.maxKm = maxKm;
    }

    public VehicleTypeDto()
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

    public Long getMaxKm()
    {
        return maxKm;
    }

    public void setMaxKm(Long maxKm)
    {
        this.maxKm = maxKm;
    }        
}
