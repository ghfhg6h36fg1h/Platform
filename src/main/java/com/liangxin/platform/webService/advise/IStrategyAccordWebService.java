package com.liangxin.platform.webService.advise;

import com.liangxin.platform.common.entity.advise.inputParam.strategyAccord.StrategyAccordWebserviceInput;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://advise.webService.platform.liangxin.com")
public interface IStrategyAccordWebService {

    @WebMethod
    OutResult updateOrInsertStrategyAccord(@WebParam(name = "pStrategyAccordWebserviceInput") StrategyAccordWebserviceInput pStrategyAccordWebserviceInput);

}
