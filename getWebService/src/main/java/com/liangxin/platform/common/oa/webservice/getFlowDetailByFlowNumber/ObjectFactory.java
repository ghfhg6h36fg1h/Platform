
package com.liangxin.platform.common.oa.webservice.getFlowDetailByFlowNumber;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.liangxin.platform.common.oa.webservice.getFlowDetailByFlowNumber package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindHlh_QNAME = new QName("http://webservice.lx.kmss.landray.com/", "findHlh");
    private final static QName _FindHlhResponse_QNAME = new QName("http://webservice.lx.kmss.landray.com/", "findHlhResponse");
    private final static QName _Exception_QNAME = new QName("http://webservice.lx.kmss.landray.com/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.liangxin.platform.common.oa.webservice.getFlowDetailByFlowNumber
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindHlh }
     * 
     */
    public FindHlh createFindHlh() {
        return new FindHlh();
    }

    /**
     * Create an instance of {@link FindHlhResponse }
     * 
     */
    public FindHlhResponse createFindHlhResponse() {
        return new FindHlhResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindHlh }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lx.kmss.landray.com/", name = "findHlh")
    public JAXBElement<FindHlh> createFindHlh(FindHlh value) {
        return new JAXBElement<FindHlh>(_FindHlh_QNAME, FindHlh.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindHlhResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lx.kmss.landray.com/", name = "findHlhResponse")
    public JAXBElement<FindHlhResponse> createFindHlhResponse(FindHlhResponse value) {
        return new JAXBElement<FindHlhResponse>(_FindHlhResponse_QNAME, FindHlhResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lx.kmss.landray.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

}
