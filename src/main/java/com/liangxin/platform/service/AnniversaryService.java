package com.liangxin.platform.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.liangxin.platform.common.entity.advise.generate.pt.Anniversary;
import com.liangxin.platform.common.entity.advise.inputParam.anniversary.AnniversaryInput;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.mapper.advise.IAnniversaryMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnniversaryService {
    private final Logger gLog = LogManager.getLogger(AnniversaryService.class);
    @Autowired
    private IAnniversaryMapper gIAnniversaryMapper;

    public OutResult getAnniversaryAll(AnniversaryInput pAnniversaryInput){
        OutResult mOutResult = new OutResult();
        try {
            Page mPage = PageHelper.startPage(pAnniversaryInput.getPageIndex(), pAnniversaryInput.getPageSize(),true);
            List<Anniversary> mAnniversary = gIAnniversaryMapper.getAnniversaryAll(pAnniversaryInput);
            mOutResult.setData(mAnniversary);
            mOutResult.setTotalCount(mPage.getTotal());
            mOutResult.setIsSuccess(true);
            mOutResult.setCode(0);
            mOutResult.setMsg("成功");
        }catch (Exception e){
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg("失败：" + e.toString());
            gLog.error(e.toString());
        }
        return mOutResult;
    }

    public OutResult ignoreById(Anniversary pAnniversary) {
        OutResult mOutResult = new OutResult();
        try {
            if (gIAnniversaryMapper.ignoreById(pAnniversary) > 0) {
                mOutResult.setIsSuccess(true);
                mOutResult.setMsg("success");
            } else {
                mOutResult.setIsSuccess(false);
                mOutResult.setMsg("no rows has ignored.");
            }
            mOutResult.setCode(0);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

}
