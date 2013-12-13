package cz.muni.fi.pa165.carmanagement.api.dto;

/**
 * @author zvonicek
 */
public class ServiceTypeDto {

    private Long id;
    
    private String name;

    public ServiceTypeDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ServiceTypeDto(String name) {
        this.name = name;
    }

    public ServiceTypeDto() {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final ServiceTypeDto other = (ServiceTypeDto) obj;
        return this.id == other.id || (this.id != null && this.id.equals(other.id));
    }

}
