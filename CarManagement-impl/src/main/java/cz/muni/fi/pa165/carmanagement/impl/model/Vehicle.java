
package cz.muni.fi.pa165.carmanagement.impl.model;

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
import javax.persistence.PreRemove;


/**
 * Vehicle entity.
 * @author tomasbobek
 */
@Entity
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final int FUEL_GAS = 1;
    public static final int FUEL_OIL = 2;
    public static final int FUEL_LPG = 3;
    public static final int FUEL_CNG = 4;
    public static final int FUEL_ELECTRIC = 5;
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 50, nullable = false)
    private String name;
    
    @Column (nullable = true)
    private Integer constructionYear;
    
    @Column (length = 17, nullable = true)
    private String VIN;
    
    @Column (length = 20, nullable = true)
    private String registrationPlate;
    
    private int fuel;
    
    private Long tachometer;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private VehicleType type;
    
    @OneToMany(mappedBy = "vehicle", orphanRemoval = false)
    private List<Ride> rides = new ArrayList<Ride>();    

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<ServiceInterval> serviceIntervals = new ArrayList<ServiceInterval>();        
    
    public Vehicle() {
        
    }
    
    public Vehicle(String name, Long tachometer) {
        this.name = name;
        this.tachometer = tachometer;
    }

    public Vehicle(String name, Long tachometer, VehicleType type, Integer constructionYear, String VIN, String registrationPlate, int fuel) {
        this.name = name;
        this.constructionYear = constructionYear;
        this.VIN = VIN;
        this.registrationPlate = registrationPlate;
        this.fuel = fuel;
        this.tachometer = tachometer;
        this.type = type;
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

    public Integer getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(Integer constructionYear) {
        this.constructionYear = constructionYear;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public void setRegistrationPlate(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
         if (fuel != 0 && fuel != FUEL_OIL && fuel != FUEL_GAS && fuel != FUEL_CNG && fuel != FUEL_LPG && fuel != FUEL_ELECTRIC) {
            throw new IllegalArgumentException("Vehicle fuel '" + fuel + "' is not allowed.");
        }
        this.fuel = fuel;
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
        return this.name + " (" + this.tachometer.toString() + " km), " + this.VIN + ", " + this.registrationPlate + ", " + this.constructionYear + ", " + this.fuel;
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

    @PreRemove
    private void preRemove() {
        for (Ride r : rides) {
            r.setVehicle(null);
        }
    }        
    
}
