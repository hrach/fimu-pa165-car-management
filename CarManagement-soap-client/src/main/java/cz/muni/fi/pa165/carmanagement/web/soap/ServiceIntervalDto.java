
package cz.muni.fi.pa165.carmanagement.web.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for serviceIntervalDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="serviceIntervalDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createdTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="doneTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dueTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="serviceType" type="{http://soap.web.carmanagement.pa165.fi.muni.cz/}serviceTypeDto" minOccurs="0"/>
 *         &lt;element name="vehicle" type="{http://soap.web.carmanagement.pa165.fi.muni.cz/}vehicleDto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serviceIntervalDto", propOrder = {
    "createdTime",
    "doneTime",
    "dueTime",
    "id",
    "serviceType",
    "vehicle"
})
public class ServiceIntervalDto {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdTime;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar doneTime;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dueTime;
    protected Long id;
    protected ServiceTypeDto serviceType;
    protected VehicleDto vehicle;

    /**
     * Gets the value of the createdTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedTime() {
        return createdTime;
    }

    /**
     * Sets the value of the createdTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedTime(XMLGregorianCalendar value) {
        this.createdTime = value;
    }

    /**
     * Gets the value of the doneTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDoneTime() {
        return doneTime;
    }

    /**
     * Sets the value of the doneTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDoneTime(XMLGregorianCalendar value) {
        this.doneTime = value;
    }

    /**
     * Gets the value of the dueTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDueTime() {
        return dueTime;
    }

    /**
     * Sets the value of the dueTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDueTime(XMLGregorianCalendar value) {
        this.dueTime = value;
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
     * Gets the value of the serviceType property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceTypeDto }
     *     
     */
    public ServiceTypeDto getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceTypeDto }
     *     
     */
    public void setServiceType(ServiceTypeDto value) {
        this.serviceType = value;
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
