/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.pa165.carmanagment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author tomasbobek
 */

@Entity
public class Vehicle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String name;
    
    private Long tachometer;
    
    @OneToOne
    private VehicleType type;
    
    public Vehicle() {
        
    }
    
    public Vehicle(String name, Long tachometer) {
        this.name = name;
        this.tachometer = tachometer;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Long getTachometer() {
        return this.tachometer;
    }
    
    public void setTchometer(Long tachometer) {
        this.tachometer = tachometer;
    }
    
    public VehicleType getType() {
        return this.type;
    }
    
    public void setType(VehicleType type) {
        this.type = type;
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
        if (this.id == null || !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
}
