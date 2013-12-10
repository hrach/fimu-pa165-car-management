
package cz.muni.fi.pa165.carmanagement.web.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for removeVehicle complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="removeVehicle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vehicleDto" type="{http://soap.web.carmanagement.pa165.fi.muni.cz/}vehicleDto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "removeVehicle", propOrder = {
    "vehicleDto"
})
public class RemoveVehicle {

    protected VehicleDto vehicleDto;

    /**
     * Gets the value of the vehicleDto property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleDto }
     *     
     */
    public VehicleDto getVehicleDto() {
        return vehicleDto;
    }

    /**
     * Sets the value of the vehicleDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleDto }
     *     
     */
    public void setVehicleDto(VehicleDto value) {
        this.vehicleDto = value;
    }

}
