package com.liangxin.platform.webService.advise;





import com.liangxin.platform.common.entity.advise.generate.pt.ProjectRecord;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://advise.webService.platform.liangxin.com")
public interface IProjectRecordWedService {

    @WebMethod
    OutResult updateOrInsertProjectRecord(@WebParam(name = "pProjectRecord") ProjectRecord pProjectRecord);

}
