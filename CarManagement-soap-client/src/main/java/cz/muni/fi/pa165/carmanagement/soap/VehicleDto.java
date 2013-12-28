
package cz.muni.fi.pa165.carmanagement.soap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for vehicleDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="vehicleDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="constructionYear" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="fuel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="registrationPlate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rides" type="{http://soap.carmanagement.pa165.fi.muni.cz/}rideDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="serviceIntervals" type="{http://soap.carmanagement.pa165.fi.muni.cz/}serviceIntervalDto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="tachometer" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="type" type="{http://soap.carmanagement.pa165.fi.muni.cz/}vehicleTypeDto" minOccurs="0"/>
 *         &lt;element name="VIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vehicleDto", propOrder = {
    "constructionYear",
    "fuel",
    "id",
    "name",
    "registrationPlate",
    "rides",
    "serviceIntervals",
    "tachometer",
    "type",
    "vin"
})
public class VehicleDto {

    protected Integer constructionYear;
    protected int fuel;
    protected Long id;
    protected String name;
    protected String registrationPlate;
    @XmlElement(nillable = true)
    protected List<RideDto> rides;
    @XmlElement(nillable = true)
    protected List<ServiceIntervalDto> serviceIntervals;
    protected Long tachometer;
    protected VehicleTypeDto type;
    @XmlElement(name = "VIN")
    protected String vin;

    /**
     * Gets the value of the constructionYear property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getConstructionYear() {
        return constructionYear;
    }

    /**
     * Sets the value of the constructionYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setConstructionYear(Integer value) {
        this.constructionYear = value;
    }

    /**
     * Gets the value of the fuel property.
     * 
     */
    public int getFuel() {
        return fuel;
    }

    /**
     * Sets the value of the fuel property.
     * 
     */
    public void setFuel(int value) {
        this.fuel = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the registrationPlate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrationPlate() {
        return registrationPlate;
    }

    /**
     * Sets the value of the registrationPlate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrationPlate(String value) {
        this.registrationPlate = value;
    }

    /**
     * Gets the value of the rides property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rides property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRides().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RideDto }
     * 
     * 
     */
    public List<RideDto> getRides() {
        if (rides == null) {
            rides = new ArrayList<RideDto>();
        }
        return this.rides;
    }

    /**
     * Gets the value of the serviceIntervals property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceIntervals property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceIntervals().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceIntervalDto }
     * 
     * 
     */
    public List<ServiceIntervalDto> getServiceIntervals() {
        if (serviceIntervals == null) {
            serviceIntervals = new ArrayList<ServiceIntervalDto>();
        }
        return this.serviceIntervals;
    }

    /**
     * Gets the value of the tachometer property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTachometer() {
        return tachometer;
    }

    /**
     * Sets the value of the tachometer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTachometer(Long value) {
        this.tachometer = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleTypeDto }
     *     
     */
    public VehicleTypeDto getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleTypeDto }
     *     
     */
    public void setType(VehicleTypeDto value) {
        this.type = value;
    }

    /**
     * Gets the value of the vin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVIN() {
        return vin;
    }

    /**
     * Sets the value of the vin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVIN(String value) {
        this.vin = value;
    }

}
