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
 * <p>Java class for getEmpBusinessCard complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getEmpBusinessCard"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="KtbEmpBusinessCardWS_1" type="{urn:EmployeeWS/types}ktbEmpBussinessCardRq" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getEmpBusinessCard", propOrder = {
    "ktbEmpBusinessCardWS1"
})
public class GetEmpBusinessCard {

    @XmlElement(name = "KtbEmpBusinessCardWS_1")
    protected KtbEmpBussinessCardRq ktbEmpBusinessCardWS1;

    /**
     * Gets the value of the ktbEmpBusinessCardWS1 property.
     * 
     * @return
     *     possible object is
     *     {@link KtbEmpBussinessCardRq }
     *     
     */
    public KtbEmpBussinessCardRq getKtbEmpBusinessCardWS1() {
        return ktbEmpBusinessCardWS1;
    }

    /**
     * Sets the value of the ktbEmpBusinessCardWS1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link KtbEmpBussinessCardRq }
     *     
     */
    public void setKtbEmpBusinessCardWS1(KtbEmpBussinessCardRq value) {
        this.ktbEmpBusinessCardWS1 = value;
    }

}
