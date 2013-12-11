
package cz.muni.fi.pa165.carmanagement.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for rideDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rideDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="employee" type="{http://soap.carmanagement.pa165.fi.muni.cz/}employeeDto" minOccurs="0"/>
 *         &lt;element name="endTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="startTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="tachometerEnd" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="tachometerStart" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="vehicle" type="{http://soap.carmanagement.pa165.fi.muni.cz/}vehicleDto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rideDto", propOrder = {
    "description",
    "employee",
    "endTime",
    "id",
    "startTime",
    "tachometerEnd",
    "tachometerStart",
    "vehicle"
})
public class RideDto {

    protected String description;
    protected EmployeeDto employee;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endTime;
    protected Long id;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startTime;
    protected Long tachometerEnd;
    protected Long tachometerStart;
    protected VehicleDto vehicle;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the employee property.
     * 
     * @return
     *     possible object is
     *     {@link EmployeeDto }
     *     
     */
    public EmployeeDto getEmployee() {
        return employee;
    }

    /**
     * Sets the value of the employee property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmployeeDto }
     *     
     */
    public void setEmployee(EmployeeDto value) {
        this.employee = value;
    }

    /**
     * Gets the value of the endTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndTime() {
        return endTime;
    }

    /**
     * Sets the value of the endTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndTime(XMLGregorianCalendar value) {
        this.endTime = value;
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
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartTime(XMLGregorianCalendar value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the tachometerEnd property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTachometerEnd() {
        return tachometerEnd;
    }

    /**
     * Sets the value of the tachometerEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTachometerEnd(Long value) {
        this.tachometerEnd = value;
    }

    /**
     * Gets the value of the tachometerStart property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTachometerStart() {
        return tachometerStart;
    }

    /**
     * Sets the value of the tachometerStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTachometerStart(Long value) {
        this.tachometerStart = value;
    }

    /**
     * Gets the value of the vehicle property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleDto }
     *     
     */
    public VehicleDto getVehicle() {
        return vehicle;
    }

    /**
     * Sets the value of the vehicle property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleDto }
     *     
     */
    public void setVehicle(VehicleDto value) {
        this.vehicle = value;
    }

}
