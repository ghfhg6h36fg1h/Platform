package com.liangxin.platform.webService.advise;

import com.liangxin.platform.common.entity.advise.generate.pt.StrategyAccord;
import com.liangxin.platform.common.entity.advise.inputParam.strategyAccord.StrategyAccordWebserviceInput;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.StrategyAccordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service
@WebService(targetNamespace = "http://advise.webService.platform.liangxin.com", serviceName = "IStrategyAccordWebService", endpointInterface = "com.liangxin.platform.webService.advise.IStrategyAccordWebService")
public class StrategyAccordWebServiceImpl implements IStrategyAccordWebService{

    @Autowired
    private StrategyAccordService gStrategyAccordService;

    @Override
    public OutResult updateOrInsertStrategyAccord(StrategyAccordWebserviceInput pStrategyAccordWebserviceInput) {
        OutResult mRvalue = gStrategyAccordService.updateOrInsertStrategyAccordPreInstruct(pStrategyAccordWebserviceInput);
        return mRvalue;
    }
}
