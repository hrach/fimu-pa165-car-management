
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
import javax.persistence.OneToMany;


/**
 * Employee entity.
 * @author Jakub Marecek <xmarec at gmail.com>
 */
@Entity
public class Employee implements Serializable {

    public static final int ROLE_STAFF = 1;
    public static final int ROLE_MANAGER = 2;

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column (length = 30, nullable = false)
    private String firstName;
    
    @Column (length = 40, nullable = false)
    private String familyName;
    
    private int employeeRole; // "role" is reserved word..:-/
    
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Ride> rides = new ArrayList<Ride>();


    public Employee() {
    }

    public Employee(String firstName, String familyName) {
        this.setFirstName(firstName);
        this.setFamilyName(familyName);
    }

    public Employee(String firstName, String familyName, int employeeRole) {
        this.setFirstName(firstName);
        this.setFamilyName(familyName);
        this.setEmployeeRole(employeeRole);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(int employeeRole) {
        if (employeeRole != ROLE_STAFF && employeeRole != ROLE_MANAGER) {
            throw new IllegalArgumentException("Employee role '" + employeeRole + "' is not allowed.");
        }
        this.employeeRole = employeeRole;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }
    
    public String getFullName(){
        return this.firstName + " " + this.getFamilyName();
    }
    
    @Override
    public String toString() {
        return "Employee: " + this.id + ", "+ this.firstName + " " + this.familyName + ", " + this.employeeRole;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}