//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.10.05 at 02:15:55 PM ICT 
//


package com.ws.hrms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getEmployeeAll complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getEmployeeAll"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="KtbEmployeeWS_1" type="{urn:EmployeeWS/types}ktbEmployeeWS" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getEmployeeAll", propOrder = {
    "ktbEmployeeWS1"
})
public class GetEmployeeAll {

    @XmlElement(name = "KtbEmployeeWS_1")
    protected KtbEmployeeWS ktbEmployeeWS1;

    /**
     * Gets the value of the ktbEmployeeWS1 property.
     * 
     * @return
     *     possible object is
     *     {@link KtbEmployeeWS }
     *     
     */
    public KtbEmployeeWS getKtbEmployeeWS1() {
        return ktbEmployeeWS1;
    }

    /**
     * Sets the value of the ktbEmployeeWS1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link KtbEmployeeWS }
     *     
     */
    public void setKtbEmployeeWS1(KtbEmployeeWS value) {
        this.ktbEmployeeWS1 = value;
    }

}
