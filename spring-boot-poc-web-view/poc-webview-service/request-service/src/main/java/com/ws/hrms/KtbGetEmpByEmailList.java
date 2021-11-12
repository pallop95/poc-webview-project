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
 * <p>Java class for ktbGetEmpByEmailList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ktbGetEmpByEmailList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:EmployeeWS/types}hrmSsystem"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="deptID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descr100" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descrDept" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="empId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="headerRq" type="{urn:EmployeeWS/types}headerRq" minOccurs="0"/&gt;
 *         &lt;element name="ktbFieldMap" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nameTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="rcCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="rcDescr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ktbGetEmpByEmailList", propOrder = {
    "deptID",
    "descr100",
    "descrDept",
    "empId",
    "firstName",
    "headerRq",
    "ktbFieldMap",
    "lastName",
    "nameTitle",
    "rcCode",
    "rcDescr"
})
public class KtbGetEmpByEmailList
    extends HrmSsystem
{

    protected String deptID;
    protected String descr100;
    protected String descrDept;
    protected String empId;
    protected String firstName;
    protected HeaderRq headerRq;
    protected String ktbFieldMap;
    protected String lastName;
    protected String nameTitle;
    protected String rcCode;
    protected String rcDescr;

    /**
     * Gets the value of the deptID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptID() {
        return deptID;
    }

    /**
     * Sets the value of the deptID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptID(String value) {
        this.deptID = value;
    }

    /**
     * Gets the value of the descr100 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescr100() {
        return descr100;
    }

    /**
     * Sets the value of the descr100 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescr100(String value) {
        this.descr100 = value;
    }

    /**
     * Gets the value of the descrDept property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrDept() {
        return descrDept;
    }

    /**
     * Sets the value of the descrDept property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrDept(String value) {
        this.descrDept = value;
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
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the headerRq property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderRq }
     *     
     */
    public HeaderRq getHeaderRq() {
        return headerRq;
    }

    /**
     * Sets the value of the headerRq property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderRq }
     *     
     */
    public void setHeaderRq(HeaderRq value) {
        this.headerRq = value;
    }

    /**
     * Gets the value of the ktbFieldMap property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKtbFieldMap() {
        return ktbFieldMap;
    }

    /**
     * Sets the value of the ktbFieldMap property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKtbFieldMap(String value) {
        this.ktbFieldMap = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the nameTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameTitle() {
        return nameTitle;
    }

    /**
     * Sets the value of the nameTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameTitle(String value) {
        this.nameTitle = value;
    }

    /**
     * Gets the value of the rcCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRcCode() {
        return rcCode;
    }

    /**
     * Sets the value of the rcCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRcCode(String value) {
        this.rcCode = value;
    }

    /**
     * Gets the value of the rcDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRcDescr() {
        return rcDescr;
    }

    /**
     * Sets the value of the rcDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRcDescr(String value) {
        this.rcDescr = value;
    }

}
