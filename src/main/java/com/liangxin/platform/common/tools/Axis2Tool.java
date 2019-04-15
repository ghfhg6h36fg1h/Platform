package com.liangxin.platform.common.tools;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import javax.xml.namespace.QName;

public class Axis2Tool {
    /**
     * 调用webservice的主方法。
     * @param pUrl
     * @param pNamespace
     * @param pMethod
     * @param pParas
     * @return
     * @throws Exception
     */
    public Object[] mainProcess(String pUrl, String pNamespace, String pMethod, Object[] pParas) throws Exception{
        Object[] mRValue;
        RPCServiceClient serviceClient = new RPCServiceClient();
        Options options = serviceClient.getOptions();
        EndpointReference targetEPR = new EndpointReference(pUrl);
        options.setTo(targetEPR);
        Class[] classes = new Class[]{Object.class};
        QName opAddEntry = new QName(pNamespace, pMethod);
        mRValue = serviceClient.invokeBlocking(opAddEntry, pParas, classes);
        return mRValue;
    }
}
