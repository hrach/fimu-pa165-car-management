
package cz.muni.fi.pa165.carmanagement.impl.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;


/**
 * Ride entity.
 * @author Jakub Marecek <xmarec at gmail.com>
 */
@Entity
public class Ride implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startTime;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endTime;
    
    private Long tachometerStart;
    
    private Long tachometerEnd;
    
    @Column(length = 255)
    private String description;
    
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    private Vehicle vehicle;  
    
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    private Employee employee;


    public Ride() {
    }

    public Ride(Employee employee, Vehicle vehicle) {
        this.employee = employee;
        this.vehicle = vehicle;
    }
            
    public Ride(Date startTime, Date endTime, Long tachometerStart, Long tachometerEnd, String description, Vehicle vehicle, Employee employee) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.tachometerStart = tachometerStart;
        this.tachometerEnd = tachometerEnd;
        this.description = description;
        this.vehicle = vehicle;
        this.employee = employee;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getTachometerStart() {
        return tachometerStart;
    }

    public void setTachometerStart(Long tachometerStart) {
        this.tachometerStart = tachometerStart;
    }

    public Long getTachometerEnd() {
        return tachometerEnd;
    }

    public void setTachometerEnd(Long tachometerEnd) {
        this.tachometerEnd = tachometerEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public Long getRideLength() {
        if (this.tachometerStart == null) {
            throw new IllegalStateException("Tachometer start value is not set.");
        }
        if (this.tachometerEnd == null) {
            throw new IllegalStateException("Tachometer end value is not set.");
        }
        return this.tachometerEnd - this.tachometerStart;
    }
    
    @Override
    public String toString() {
        String output = "";
        
        output = "Ride: " + this.id + ", from: " + this.startTime.toString() + " to: " + this.endTime.toString() + ", ";
        output = output + "length: " + this.getRideLength() + " km, vehicle: " + this.vehicle.getName() + ", employee: " + this.employee.getFullName();
        
        return output;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ride)) {
            return false;
        }
        Ride other = (Ride) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
