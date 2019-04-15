package com.liangxin.platform.service;

import com.liangxin.platform.common.entity.advise.generate.pt.ReadyToMemberRecord;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.mapper.advise.generate.pt.ReadyToMemberRecordMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReadeyToMemberService {
    private final Logger gLog = LogManager.getLogger(ReadeyToMemberService.class);

    @Autowired
    private ReadyToMemberRecordMapper gReadyToMemberRecordMapper;

    /**
     * 更新
     * @param pReadyToMemberRecord
     * @return
     */
    public OutResult update(ReadyToMemberRecord pReadyToMemberRecord) {
        OutResult mOutResult = new OutResult();
        try {
            if (gReadyToMemberRecordMapper.updateByPrimaryKeySelective(pReadyToMemberRecord) > 0) {
                mOutResult.setIsSuccess(true);
            } else {
                mOutResult.setIsSuccess(false);
            }
            mOutResult.setData(null);
            mOutResult.setCode(1);
            mOutResult.setMsg("success");
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(0);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }
    /**
     * 新增
     * @param pReadyToMemberRecord
     * @return
     */
    public OutResult insert(ReadyToMemberRecord pReadyToMemberRecord) {
        OutResult mOutResult = new OutResult();
        try {
            if (gReadyToMemberRecordMapper.insertSelective(pReadyToMemberRecord) > 0) {
                mOutResult.setIsSuccess(true);
            } else {
                mOutResult.setIsSuccess(false);
            }
            mOutResult.setData(null);
            mOutResult.setCode(1);
            mOutResult.setMsg("success");
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(0);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }
}
