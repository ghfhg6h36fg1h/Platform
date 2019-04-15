package com.liangxin.platform.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.liangxin.platform.common.entity.advise.generate.pt.Birthday;
import com.liangxin.platform.common.entity.advise.inputParam.birthday.BirthdayInput;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.mapper.advise.IBirthdayMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirthdayService {
    private final Logger gLog = LogManager.getLogger(BirthdayService.class);
    @Autowired
    private IBirthdayMapper gIBirthdayMapper;

    public OutResult getBirthdayAll(BirthdayInput pBirthdayInput){
        OutResult mOutResult = new OutResult();
        try {
            Page mPage = PageHelper.startPage(pBirthdayInput.getPageIndex(), pBirthdayInput.getPageSize(),true);
            List<Birthday> mBirthday = gIBirthdayMapper.getBirthdayAll(pBirthdayInput);
            mOutResult.setData(mBirthday);
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

    public OutResult ignoreById(Birthday pBirthday) {
        OutResult mOutResult = new OutResult();
        try {
            if (gIBirthdayMapper.ignoreById(pBirthday) > 0) {
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
