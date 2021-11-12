//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.10.05 at 02:15:55 PM ICT 
//


package com.ws.hrms;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ktbLicenseInfoRes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ktbLicenseInfoRes"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="headerRs" type="{urn:EmployeeWS/types}headerRs" minOccurs="0"/&gt;
 *         &lt;element name="itemList" type="{urn:EmployeeWS/types}ktbLicenseInfoList" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="responseCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="responseDescr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="responseFullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="responseLicenseNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="responseLicenseType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ktbLicenseInfoRes", propOrder = {
    "firstName",
    "headerRs",
    "itemList",
    "lastName",
    "responseCode",
    "responseDescr",
    "responseFullName",
    "responseLicenseNo",
    "responseLicenseType"
})
public class KtbLicenseInfoRes {

    protected String firstName;
    protected HeaderRs headerRs;
    @XmlElement(nillable = true)
    protected List<KtbLicenseInfoList> itemList;
    protected String lastName;
    protected String responseCode;
    protected String responseDescr;
    protected String responseFullName;
    protected String responseLicenseNo;
    protected String responseLicenseType;

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
     * Gets the value of the headerRs property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderRs }
     *     
     */
    public HeaderRs getHeaderRs() {
        return headerRs;
    }

    /**
     * Sets the value of the headerRs property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderRs }
     *     
     */
    public void setHeaderRs(HeaderRs value) {
        this.headerRs = value;
    }

    /**
     * Gets the value of the itemList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KtbLicenseInfoList }
     * 
     * 
     */
    public List<KtbLicenseInfoList> getItemList() {
        if (itemList == null) {
            itemList = new ArrayList<KtbLicenseInfoList>();
        }
        return this.itemList;
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
     * Gets the value of the responseCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseCode(String value) {
        this.responseCode = value;
    }

    /**
     * Gets the value of the responseDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseDescr() {
        return responseDescr;
    }

    /**
     * Sets the value of the responseDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseDescr(String value) {
        this.responseDescr = value;
    }

    /**
     * Gets the value of the responseFullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseFullName() {
        return responseFullName;
    }

    /**
     * Sets the value of the responseFullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseFullName(String value) {
        this.responseFullName = value;
    }

    /**
     * Gets the value of the responseLicenseNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseLicenseNo() {
        return responseLicenseNo;
    }

    /**
     * Sets the value of the responseLicenseNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseLicenseNo(String value) {
        this.responseLicenseNo = value;
    }

    /**
     * Gets the value of the responseLicenseType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseLicenseType() {
        return responseLicenseType;
    }

    /**
     * Sets the value of the responseLicenseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseLicenseType(String value) {
        this.responseLicenseType = value;
    }

}
