//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.10.05 at 02:15:55 PM ICT 
//


package com.ws.hrms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ktbGetConsentFlagList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ktbGetConsentFlagList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:EmployeeWS/types}hrmSsystem"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="empConsentFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="familyConsentFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="familyNationalId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ktbGetConsentFlagList", propOrder = {
    "empConsentFlag",
    "familyConsentFlag",
    "familyNationalId"
})
public class KtbGetConsentFlagList
    extends HrmSsystem
{

    protected String empConsentFlag;
    protected String familyConsentFlag;
    protected String familyNationalId;

    /**
     * Gets the value of the empConsentFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpConsentFlag() {
        return empConsentFlag;
    }

    /**
     * Sets the value of the empConsentFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpConsentFlag(String value) {
        this.empConsentFlag = value;
    }

    /**
     * Gets the value of the familyConsentFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamilyConsentFlag() {
        return familyConsentFlag;
    }

    /**
     * Sets the value of the familyConsentFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamilyConsentFlag(String value) {
        this.familyConsentFlag = value;
    }

    /**
     * Gets the value of the familyNationalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamilyNationalId() {
        return familyNationalId;
    }

    /**
     * Sets the value of the familyNationalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamilyNationalId(String value) {
        this.familyNationalId = value;
    }

}
