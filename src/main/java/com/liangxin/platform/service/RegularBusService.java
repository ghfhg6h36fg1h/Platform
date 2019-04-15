package com.liangxin.platform.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liangxin.platform.common.entity.advise.generate.pt.RegularBus;
import com.liangxin.platform.common.entity.advise.inputParam.regularBus.RegularBusInputForGetAllList;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.mapper.advise.IRegularBusMapper;
import com.liangxin.platform.mapper.advise.generate.pt.RegularBusMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegularBusService {

    private final Logger gLog = LogManager.getLogger(RegularBusService.class);

    @Autowired
    private IRegularBusMapper gIRegularBusMapper;
    @Autowired
    private RegularBusMapper gRegularBusMapper;

    public OutResult getAll(RegularBusInputForGetAllList pRegularBusInputForGetAllList) {
        OutResult mOutResult = new OutResult();
        try {
            PageHelper.startPage(1, 10000, true);
            List<RegularBus> mRvalue = gIRegularBusMapper.getAll(pRegularBusInputForGetAllList);
            PageInfo<RegularBus> pageInfo = new PageInfo<>(mRvalue);
            mOutResult.setTotalCount(pageInfo.getTotal());
            mOutResult.setCode(1);
            mOutResult.setIsSuccess(true);
            mOutResult.setData(pageInfo.getList());
            mOutResult.setMsg("成功！");
        } catch (Exception ex) {
            mOutResult.setCode(0);
            mOutResult.setIsSuccess(false);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    public OutResult getMaxUpdateTime() {
        OutResult mOutResult = new OutResult();
        try {
            List<String> mLastUpdateTimeList = new ArrayList<>();
            String mRvalue = gIRegularBusMapper.getMaxUpdateTime();
            mLastUpdateTimeList.add(mRvalue);
            mOutResult.setCode(1);
            mOutResult.setIsSuccess(true);
            mOutResult.setData(mLastUpdateTimeList);
            mOutResult.setMsg("成功！");
        } catch (Exception ex) {
            mOutResult.setCode(0);
            mOutResult.setIsSuccess(false);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    public OutResult update(RegularBus pRegularBus) {
        OutResult mRValue = new OutResult();
        try {
            if (gRegularBusMapper.updateByPrimaryKeySelective(pRegularBus) > 0) {
                mRValue.setIsSuccess(true);
                mRValue.setMsg("success.");
            } else {
                mRValue.setIsSuccess(false);
                mRValue.setMsg("no row has changed.");
            }
            mRValue.setCode(1);
        } catch (Exception ex) {
            mRValue.setIsSuccess(false);
            mRValue.setMsg(ex.getMessage());
            mRValue.setCode(0);
            gLog.error("更新班车出错！", ex);
        }
        return mRValue;
    }
}
