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
 * <p>Java class for GetEmpConsentFlag complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetEmpConsentFlag"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="KtbConsentWS_1" type="{urn:EmployeeWS/types}consentRetrieveFlagRq" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetEmpConsentFlag", propOrder = {
    "ktbConsentWS1"
})
public class GetEmpConsentFlag {

    @XmlElement(name = "KtbConsentWS_1")
    protected ConsentRetrieveFlagRq ktbConsentWS1;

    /**
     * Gets the value of the ktbConsentWS1 property.
     * 
     * @return
     *     possible object is
     *     {@link ConsentRetrieveFlagRq }
     *     
     */
    public ConsentRetrieveFlagRq getKtbConsentWS1() {
        return ktbConsentWS1;
    }

    /**
     * Sets the value of the ktbConsentWS1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsentRetrieveFlagRq }
     *     
     */
    public void setKtbConsentWS1(ConsentRetrieveFlagRq value) {
        this.ktbConsentWS1 = value;
    }

}
