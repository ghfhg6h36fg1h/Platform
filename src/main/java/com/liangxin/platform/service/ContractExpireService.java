package com.liangxin.platform.service;

import com.liangxin.platform.common.entity.advise.generate.pt.ContractExpireRecord;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.mapper.advise.generate.pt.ContractExpireRecordMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ContractExpireService {
    private final Logger gLog = LogManager.getLogger(ContractExpireService.class);
    @Autowired
    private ContractExpireRecordMapper gContractExpireRecordMapper;
    /**
     * 更新
     *
     * @param pContractExpireRecord
     * @return
     */
    public OutResult update(ContractExpireRecord pContractExpireRecord) {
        OutResult mOutResult = new OutResult();
        try {
            if (gContractExpireRecordMapper.updateByPrimaryKeySelective(pContractExpireRecord) > 0) {
                mOutResult.setIsSuccess(true);
            } else {
                mOutResult.setIsSuccess(false);
            }
            mOutResult.setData(null);
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
    /**
     * 新增
     *
     * @param pContractExpireRecord
     * @return
     */
    public OutResult insert(ContractExpireRecord pContractExpireRecord) {
        OutResult mOutResult = new OutResult();
        try {
            if (gContractExpireRecordMapper.insertSelective(pContractExpireRecord) > 0) {
                mOutResult.setIsSuccess(true);
            } else {
                mOutResult.setIsSuccess(false);
            }
            mOutResult.setData(null);
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
