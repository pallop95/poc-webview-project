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
 * <p>Java class for consentInsertrq complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consentInsertrq"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:EmployeeWS/types}hrmSsystem"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="consentFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="empId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="questionNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="versionNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consentInsertrq", propOrder = {
    "consentFlag",
    "empId",
    "questionNum",
    "versionNo"
})
public class ConsentInsertrq
    extends HrmSsystem
{

    protected String consentFlag;
    protected String empId;
    protected String questionNum;
    protected String versionNo;

    /**
     * Gets the value of the consentFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsentFlag() {
        return consentFlag;
    }

    /**
     * Sets the value of the consentFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsentFlag(String value) {
        this.consentFlag = value;
    }

    /**
     * Gets the value of the empId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * Sets the value of the empId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpId(String value) {
        this.empId = value;
    }

    /**
     * Gets the value of the questionNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuestionNum() {
        return questionNum;
    }

    /**
     * Sets the value of the questionNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuestionNum(String value) {
        this.questionNum = value;
    }

    /**
     * Gets the value of the versionNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionNo() {
        return versionNo;
    }

    /**
     * Sets the value of the versionNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionNo(String value) {
        this.versionNo = value;
    }

}
