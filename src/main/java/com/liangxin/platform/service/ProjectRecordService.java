package com.liangxin.platform.service;

import com.liangxin.platform.common.entity.advise.generate.pt.ProjectRecord;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.mapper.advise.generate.pt.ProjectRecordMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectRecordService {

    private final Logger gLog = LogManager.getLogger(ProjectRecordService.class);
    @Autowired
    private ProjectRecordMapper gProjectRecordMapper;

    /**
     * 更新或增加营销数据
     * @param pProjectRecord
     * @return
     */
    public OutResult updateOrInsertProjectRecord(ProjectRecord pProjectRecord) {
        OutResult mOutResult = new OutResult();
        Integer mRValue = 0;
        try {
            if (null != gProjectRecordMapper.selectByPrimaryKey(pProjectRecord.getId())) {
                mRValue = gProjectRecordMapper.updateByPrimaryKeySelective(pProjectRecord);
            } else {
                mRValue = gProjectRecordMapper.insertSelective(pProjectRecord);
            }
            mOutResult.setData(null);
            mOutResult.setIsSuccess(true);
            mOutResult.setMsg("success");
            mOutResult.setCode(1);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(0);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }
}
