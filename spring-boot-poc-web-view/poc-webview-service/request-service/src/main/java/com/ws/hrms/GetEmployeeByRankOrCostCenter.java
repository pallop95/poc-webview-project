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
 * <p>Java class for getEmployeeByRankOrCostCenter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getEmployeeByRankOrCostCenter"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="KtbEmployeeByRankOrCostCenterRq_1" type="{urn:EmployeeWS/types}ktbEmployeeByRankOrCostCenterRq" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getEmployeeByRankOrCostCenter", propOrder = {
    "ktbEmployeeByRankOrCostCenterRq1"
})
public class GetEmployeeByRankOrCostCenter {

    @XmlElement(name = "KtbEmployeeByRankOrCostCenterRq_1")
    protected KtbEmployeeByRankOrCostCenterRq ktbEmployeeByRankOrCostCenterRq1;

    /**
     * Gets the value of the ktbEmployeeByRankOrCostCenterRq1 property.
     * 
     * @return
     *     possible object is
     *     {@link KtbEmployeeByRankOrCostCenterRq }
     *     
     */
    public KtbEmployeeByRankOrCostCenterRq getKtbEmployeeByRankOrCostCenterRq1() {
        return ktbEmployeeByRankOrCostCenterRq1;
    }

    /**
     * Sets the value of the ktbEmployeeByRankOrCostCenterRq1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link KtbEmployeeByRankOrCostCenterRq }
     *     
     */
    public void setKtbEmployeeByRankOrCostCenterRq1(KtbEmployeeByRankOrCostCenterRq value) {
        this.ktbEmployeeByRankOrCostCenterRq1 = value;
    }

}
