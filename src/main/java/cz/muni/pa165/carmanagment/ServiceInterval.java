/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.pa165.carmanagment;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author tomasbobek
 */

@Entity
public class ServiceInterval {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdTime;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dueTime;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date doneTime;
    
    @ManyToOne
    private Vehicle vehicle;
    
    @ManyToOne
    private ServiceType serviceType;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Date getCreatedTime() {
        return createdTime;
    }
    
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    
    public Date getDueTime() {
        return dueTime;
    }
    
    public void setDueTime(Date dueTime) {
        this.dueTime = dueTime;
    }
    
    public Date getDoneTime() {
        return doneTime;
    }
    
    public void setDoneTime(Date doneTime) {
        this.doneTime = doneTime;
    }
    
    public Vehicle getVehicle() {
        return vehicle;
    }
    
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    
    public ServiceType getServiceTyp() {
        return this.serviceType;
    }
    
    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
    
    @Override
    public String toString() {
        return "Service [type: " + this.serviceType + ", for vehicle: " + this.vehicle + ", created: " + this.createdTime.toString() + ", due to: " + this.dueTime.toString() + ", done: " + this.doneTime.toString() + "]";
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
        final ServiceInterval other = (ServiceInterval) obj;
        if (this.id == null || !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
}
