package cz.muni.fi.pa165.carmanagement.api.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Vehicle data transfer object
 * 
 * @author zvonicek
 */
public class VehicleDto {

    private Long id;

    private String name;
    
    private Integer constructionYear;
    
    private String VIN;
    
    private String registrationPlate;
    
    private int fuel; 
    
    private Long tachometer;

    private VehicleTypeDto type;
    
    private List<RideDto> rides;
    
    private List<ServiceIntervalDto> serviceIntervals;


    public VehicleDto(Long id, String name, Long tachometer, VehicleTypeDto type) {
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

    public VehicleDto(String name, Integer constructionYear, String VIN, String registrationPlate, int fuel, Long tachometer, VehicleTypeDto type) {
        this.name = name;
        this.constructionYear = constructionYear;
        this.VIN = VIN;
        this.registrationPlate = registrationPlate;
        this.fuel = fuel;
        this.tachometer = tachometer;
        this.type = type;
    }
        
    public VehicleDto() {
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

    public void setTachometer(Long tachometer) {
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
        this.fuel = fuel;
    }
    
    public VehicleTypeDto getType() {
        return type;
    }

    public void setType(VehicleTypeDto type) {
        this.type = type;
    }

    public List<RideDto> getRides() {
        return rides;
    }

    public void setRides(List<RideDto> rides) {
        this.rides = rides;
    }

    public List<ServiceIntervalDto> getServiceIntervals() {
        return serviceIntervals;
    }

    public void setServiceIntervals(List<ServiceIntervalDto> serviceIntervals) {
        this.serviceIntervals = serviceIntervals;
    }
    
    public int getSumKm() {
        int sum = 0;
        for (RideDto r : this.getRides()) {
            sum += r.getTachometerEnd() - r.getTachometerStart();
        }
        
        return sum;
    }
    
    public int getSumDrivers() {
        Set<Long> ids = new HashSet<Long>();
        for (RideDto r : this.getRides()) {
            ids.add(r.getEmployee().getId());
        }
        
        return ids.size();
    }
   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final VehicleDto other = (VehicleDto) obj;
        return this.id == other.id || (this.id != null && this.id.equals(other.id));
    }

}
