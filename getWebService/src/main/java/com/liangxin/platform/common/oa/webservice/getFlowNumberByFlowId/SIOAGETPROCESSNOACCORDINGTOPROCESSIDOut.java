package com.liangxin.platform.common.oa.webservice.getFlowNumberByFlowId;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-05-16T09:53:41.655+08:00
 * Generated source version: 3.2.4
 *
 */
@WebService(targetNamespace = "urn:nader:com/MOBILE", name = "SI_OA_GET_PROCESSNO_ACCORDINGTO_PROCESSID_Out")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface SIOAGETPROCESSNOACCORDINGTOPROCESSIDOut {

    @WebMethod(operationName = "SI_OA_GET_PROCESSNO_ACCORDINGTO_PROCESSID_Out", action = "http://sap.com/xi/WebService/soap1.1")
    @WebResult(name = "findReviewResponse", targetNamespace = "http://webservice.lx.kmss.landray.com/", partName = "parameters")
    public FindReviewResponse siOAGETPROCESSNOACCORDINGTOPROCESSIDOut(
            @WebParam(partName = "parameters", name = "findReview", targetNamespace = "http://webservice.lx.kmss.landray.com/")
                    FindReview parameters
    ) throws P2Exception;
}