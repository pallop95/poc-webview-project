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
 * <p>Java class for getEmpAbsence complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getEmpAbsence"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="KtbEmpAbsRq_1" type="{urn:EmployeeWS/types}ktbEmpAbsRq" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getEmpAbsence", propOrder = {
    "ktbEmpAbsRq1"
})
public class GetEmpAbsence {

    @XmlElement(name = "KtbEmpAbsRq_1")
    protected KtbEmpAbsRq ktbEmpAbsRq1;

    /**
     * Gets the value of the ktbEmpAbsRq1 property.
     * 
     * @return
     *     possible object is
     *     {@link KtbEmpAbsRq }
     *     
     */
    public KtbEmpAbsRq getKtbEmpAbsRq1() {
        return ktbEmpAbsRq1;
    }

    /**
     * Sets the value of the ktbEmpAbsRq1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link KtbEmpAbsRq }
     *     
     */
    public void setKtbEmpAbsRq1(KtbEmpAbsRq value) {
        this.ktbEmpAbsRq1 = value;
    }

}
