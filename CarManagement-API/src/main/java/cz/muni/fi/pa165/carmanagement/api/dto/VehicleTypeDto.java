package cz.muni.fi.pa165.carmanagement.api.dto;

/**
 * VehicleType data transfer object
 * 
 * @author zvonicek
 */
public class VehicleTypeDto
{
    private Long id;
    
    private Long maxKm;
    
    private String name;
        
    public VehicleTypeDto(Long id, Long maxKm, String name) {
        this.id = id;
        this.maxKm = maxKm;
        this.name = name;
    }

    public VehicleTypeDto(Long maxKm, String name) {
        this.maxKm = maxKm;
        this.name = name;
    }
    
    public VehicleTypeDto() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMaxKm() {
        return maxKm;
    }

    public void setMaxKm(Long maxKm) {
        this.maxKm = maxKm;
    }        

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }        

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VehicleTypeDto other = (VehicleTypeDto) obj;
        return this.id == other.id || (this.id != null && this.id.equals(other.id));
    }

}
