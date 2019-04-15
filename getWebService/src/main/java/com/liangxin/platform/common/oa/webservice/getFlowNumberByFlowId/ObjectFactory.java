
package com.liangxin.platform.common.oa.webservice.getFlowNumberByFlowId;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.liangxin.platform.common.oa.webservice.getFlowNumberByFlowId package. 
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

    private final static QName _FindReview_QNAME = new QName("http://webservice.lx.kmss.landray.com/", "findReview");
    private final static QName _FindReviewResponse_QNAME = new QName("http://webservice.lx.kmss.landray.com/", "findReviewResponse");
    private final static QName _Exception_QNAME = new QName("http://webservice.lx.kmss.landray.com/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.liangxin.platform.common.oa.webservice.getFlowNumberByFlowId
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindReview }
     * 
     */
    public FindReview createFindReview() {
        return new FindReview();
    }

    /**
     * Create an instance of {@link FindReviewResponse }
     * 
     */
    public FindReviewResponse createFindReviewResponse() {
        return new FindReviewResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindReview }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lx.kmss.landray.com/", name = "findReview")
    public JAXBElement<FindReview> createFindReview(FindReview value) {
        return new JAXBElement<FindReview>(_FindReview_QNAME, FindReview.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindReviewResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lx.kmss.landray.com/", name = "findReviewResponse")
    public JAXBElement<FindReviewResponse> createFindReviewResponse(FindReviewResponse value) {
        return new JAXBElement<FindReviewResponse>(_FindReviewResponse_QNAME, FindReviewResponse.class, null, value);
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
