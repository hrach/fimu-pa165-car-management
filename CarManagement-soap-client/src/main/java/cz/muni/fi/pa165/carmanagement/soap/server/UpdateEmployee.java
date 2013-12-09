
package cz.muni.fi.pa165.carmanagement.soap.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateEmployee complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateEmployee">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="employeeDto" type="{http://server.soap.carmanagement.pa165.fi.muni.cz/}employeeDto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateEmployee", propOrder = {
    "employeeDto"
})
public class UpdateEmployee {

    protected EmployeeDto employeeDto;

    /**
     * Gets the value of the employeeDto property.
     * 
     * @return
     *     possible object is
     *     {@link EmployeeDto }
     *     
     */
    public EmployeeDto getEmployeeDto() {
        return employeeDto;
    }

    /**
     * Sets the value of the employeeDto property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmployeeDto }
     *     
     */
    public void setEmployeeDto(EmployeeDto value) {
        this.employeeDto = value;
    }

}