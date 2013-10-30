
package cz.muni.pa165.carmanagment.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * Vehicle entity.
 * @author tomasbobek
 */
@Entity
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 50, nullable = false)
    private String name;
    
    private Long tachometer;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private VehicleType type;
    
    @OneToMany(mappedBy = "ride", cascade = CascadeType.ALL)
    private List<Ride> rides = new ArrayList<Ride>();    

    @OneToMany(mappedBy = "serviceInterval", cascade = CascadeType.ALL)
    private List<ServiceInterval> serviceIntervals = new ArrayList<ServiceInterval>();        
    
    public Vehicle() {
        
    }
    
    public Vehicle(String name, Long tachometer) {
        this.name = name;
        this.tachometer = tachometer;
    }
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Long getTachometer() {
        return tachometer;
    }
    
    public void setTchometer(Long tachometer) {
        this.tachometer = tachometer;
    }
    
    public VehicleType getType() {
        return type;
    }
    
    public void setType(VehicleType type) {
        this.type = type;
    }
    
    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }    

    public List<ServiceInterval> getServiceIntervals() {
        return serviceIntervals;
    }

    public void setServiceIntervals(List<ServiceInterval> serviceIntervals) {
        this.serviceIntervals = serviceIntervals;
    }        
    
    @Override
    public String toString() {
        return this.name + " (" + this.tachometer.toString() + " km)";
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
        final Vehicle other = (Vehicle) obj;
        return this.id != null && this.id.equals(other.id);
    }

}
