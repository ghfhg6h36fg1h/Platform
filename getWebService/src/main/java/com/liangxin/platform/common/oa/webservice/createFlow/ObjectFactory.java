
package com.liangxin.platform.common.oa.webservice.createFlow;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.liangxin.platform.common.oa.webservice.createFlow package. 
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

    private final static QName _Exception_QNAME = new QName("http://webservice.review.km.kmss.landray.com/", "Exception");
    private final static QName _AddReviewResponse_QNAME = new QName("http://webservice.review.km.kmss.landray.com/", "addReviewResponse");
    private final static QName _AddReview_QNAME = new QName("http://webservice.review.km.kmss.landray.com/", "addReview");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.liangxin.platform.common.oa.webservice.createFlow
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link AddReviewResponse }
     * 
     */
    public AddReviewResponse createAddReviewResponse() {
        return new AddReviewResponse();
    }

    /**
     * Create an instance of {@link AddReview }
     * 
     */
    public AddReview createAddReview() {
        return new AddReview();
    }

    /**
     * Create an instance of {@link KmReviewParamterForm }
     * 
     */
    public KmReviewParamterForm createKmReviewParamterForm() {
        return new KmReviewParamterForm();
    }

    /**
     * Create an instance of {@link AttachmentForm }
     * 
     */
    public AttachmentForm createAttachmentForm() {
        return new AttachmentForm();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.review.km.kmss.landray.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddReviewResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.review.km.kmss.landray.com/", name = "addReviewResponse")
    public JAXBElement<AddReviewResponse> createAddReviewResponse(AddReviewResponse value) {
        return new JAXBElement<AddReviewResponse>(_AddReviewResponse_QNAME, AddReviewResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddReview }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.review.km.kmss.landray.com/", name = "addReview")
    public JAXBElement<AddReview> createAddReview(AddReview value) {
        return new JAXBElement<AddReview>(_AddReview_QNAME, AddReview.class, null, value);
    }

}
