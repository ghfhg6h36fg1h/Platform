package com.liangxin.platform.webService.advise;

import com.liangxin.platform.common.entity.advise.generate.pt.ProjectRecord;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.ProjectRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service
@WebService(targetNamespace = "http://advise.webService.platform.liangxin.com", serviceName = "IProjectRecordWebService", endpointInterface = "com.liangxin.platform.webService.advise.IProjectRecordWedService")
public class ProjectRecordWedServiceImpl implements IProjectRecordWedService {

    @Autowired
    private ProjectRecordService gProjectRecordService;

    @Override
    public OutResult updateOrInsertProjectRecord(ProjectRecord pProjectRecord) {
        OutResult mRvalue = gProjectRecordService.updateOrInsertProjectRecord(pProjectRecord);
        return mRvalue;
    }

}
