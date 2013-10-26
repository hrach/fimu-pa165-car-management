
package cz.muni.pa165.carmanagment.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * VehicleType entity.
 * @author tomasbobek
 */
@Entity
public class VehicleType implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Long maxKm;
    
    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<Vehicle> vehicles = new ArrayList<Vehicle>();

   
    public VehicleType() {
        
    }

    public VehicleType(Long maxKm) {
        this.maxKm = maxKm;
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
    
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
    
    @Override
    public String toString() {
        return "Type: " + this.id.toString() + ", max km: " + this.maxKm.toString();
    }
    
    @Override
    public int hashCode() {
        return (this.id != null ? this.id.hashCode() : 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final VehicleType other = (VehicleType) obj;
        return this.id != null && this.id.equals(other.id);
    }

}
