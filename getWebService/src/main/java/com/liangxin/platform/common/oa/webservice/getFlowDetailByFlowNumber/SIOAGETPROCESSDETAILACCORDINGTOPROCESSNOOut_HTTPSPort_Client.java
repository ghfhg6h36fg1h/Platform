
package com.liangxin.platform.common.oa.webservice.getFlowDetailByFlowNumber;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import java.net.URL;
import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-05-16T08:58:36.645+08:00
 * Generated source version: 3.2.4
 */
public final class SIOAGETPROCESSDETAILACCORDINGTOPROCESSNOOut_HTTPSPort_Client {


    private final QName SERVICE_NAME = new QName("urn:nader:com/MOBILE", "SI_OA_GET_PROCESSDETAIL_ACCORDINGTO_PROCESSNO_OutService");

    public SIOAGETPROCESSDETAILACCORDINGTOPROCESSNOOut_HTTPSPort_Client() {
    }


    public String mainProcess(String pBaseFloderPath, String pNumber, String pUser, String pPassWord) throws java.lang.Exception {
//        URL wsdlURL = SIOAGETPROCESSDETAILACCORDINGTOPROCESSNOOutService.WSDL_LOCATION;
        URL wsdlURL = new URL("classpath:" + pBaseFloderPath + "getFlowDetailByFlowNumber.wsdl");
        SIOAGETPROCESSDETAILACCORDINGTOPROCESSNOOutService ss = new SIOAGETPROCESSDETAILACCORDINGTOPROCESSNOOutService(wsdlURL, SERVICE_NAME);
        SIOAGETPROCESSDETAILACCORDINGTOPROCESSNOOut port = ss.getHTTPSPort();

        Client client = ClientProxy.getClient(port);
        HTTPConduit http = (HTTPConduit) client.getConduit();
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(36000);
        httpClientPolicy.setAllowChunking(false);
        http.setClient(httpClientPolicy);
        http.getAuthorization().setAuthorizationType("NTLM");
        http.getAuthorization().setUserName(pUser);
        http.getAuthorization().setPassword(pPassWord);

        FindHlh _siOAGETPROCESSDETAILACCORDINGTOPROCESSNOOut_parameters = new FindHlh();
        _siOAGETPROCESSDETAILACCORDINGTOPROCESSNOOut_parameters.setArg0(pNumber);

        FindHlhResponse _siOAGETPROCESSDETAILACCORDINGTOPROCESSNOOut__return = null;

        _siOAGETPROCESSDETAILACCORDINGTOPROCESSNOOut__return = port.siOAGETPROCESSDETAILACCORDINGTOPROCESSNOOut(_siOAGETPROCESSDETAILACCORDINGTOPROCESSNOOut_parameters);

        return _siOAGETPROCESSDETAILACCORDINGTOPROCESSNOOut__return.getReturn();
    }

}
