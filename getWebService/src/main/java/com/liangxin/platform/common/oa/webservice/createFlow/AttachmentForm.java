
package com.liangxin.platform.common.oa.webservice.createFlow;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>attachmentForm complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="attachmentForm"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fdKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fdFileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fdAttachment" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attachmentForm", propOrder = {
    "fdKey",
    "fdFileName",
    "fdAttachment"
})
public class AttachmentForm {

    protected String fdKey;
    protected String fdFileName;
    protected byte[] fdAttachment;

    /**
     * 获取fdKey属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFdKey() {
        return fdKey;
    }

    /**
     * 设置fdKey属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFdKey(String value) {
        this.fdKey = value;
    }

    /**
     * 获取fdFileName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFdFileName() {
        return fdFileName;
    }

    /**
     * 设置fdFileName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFdFileName(String value) {
        this.fdFileName = value;
    }

    /**
     * 获取fdAttachment属性的值。
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getFdAttachment() {
        return fdAttachment;
    }

    /**
     * 设置fdAttachment属性的值。
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setFdAttachment(byte[] value) {
        this.fdAttachment = value;
    }

}
