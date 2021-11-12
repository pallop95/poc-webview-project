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
 * <p>Java class for ktbGetConsentRes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ktbGetConsentRes"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="itemFlagList" type="{urn:EmployeeWS/types}ktbGetConsentFlagList" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="itemList" type="{urn:EmployeeWS/types}ktbGetConsentList" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="itemMsgList" type="{urn:EmployeeWS/types}ktbGetConsentMsgList" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="responseCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="responseDescr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ktbGetConsentRes", propOrder = {
    "itemFlagList",
    "itemList",
    "itemMsgList",
    "responseCode",
    "responseDescr"
})
public class KtbGetConsentRes {

    @XmlElement(nillable = true)
    protected List<KtbGetConsentFlagList> itemFlagList;
    @XmlElement(nillable = true)
    protected List<KtbGetConsentList> itemList;
    @XmlElement(nillable = true)
    protected List<KtbGetConsentMsgList> itemMsgList;
    protected String responseCode;
    protected String responseDescr;

    /**
     * Gets the value of the itemFlagList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemFlagList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemFlagList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KtbGetConsentFlagList }
     * 
     * 
     */
    public List<KtbGetConsentFlagList> getItemFlagList() {
        if (itemFlagList == null) {
            itemFlagList = new ArrayList<KtbGetConsentFlagList>();
        }
        return this.itemFlagList;
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
     * {@link KtbGetConsentList }
     * 
     * 
     */
    public List<KtbGetConsentList> getItemList() {
        if (itemList == null) {
            itemList = new ArrayList<KtbGetConsentList>();
        }
        return this.itemList;
    }

    /**
     * Gets the value of the itemMsgList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemMsgList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemMsgList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KtbGetConsentMsgList }
     * 
     * 
     */
    public List<KtbGetConsentMsgList> getItemMsgList() {
        if (itemMsgList == null) {
            itemMsgList = new ArrayList<KtbGetConsentMsgList>();
        }
        return this.itemMsgList;
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

}
