package com.liangxin.platform.service.LXYKT;

import com.liangxin.platform.common.entity.LXYKT.DayoffInfo;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.common.tools.StringUtils;
import com.liangxin.platform.mapper.LXYKT.IDayoffMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayoffService {
    private final Logger gLog = LogManager.getLogger(TripService.class);
    @Autowired
    private IDayoffMapper gIDayoffMapper;
    public OutResult getDayoffInfo(String empno,String startdate,String enddate){
        OutResult mOutResult = new OutResult();
        try {
            if (StringUtils.isNotEmpty(empno)){
                if (StringUtils.isNotEmpty(startdate) && StringUtils.isNotEmpty(enddate)){
                    List<DayoffInfo> mDayoffInfo =  gIDayoffMapper.getDayoffInfo(empno, startdate, enddate);
                    mOutResult.setData(mDayoffInfo);
                    mOutResult.setCode(0);
                    mOutResult.setMsg("成功");
                }
                else {
                    List<DayoffInfo> mDayoffInfo =  gIDayoffMapper.getDayoffInitalInfo(empno);
                    mOutResult.setData(mDayoffInfo);
                    mOutResult.setCode(0);
                    mOutResult.setMsg("成功");
                }
            }
            else {
                mOutResult.setCode(1);
                mOutResult.setMsg("失败,工号不能为空");
                gLog.error("request error empno is null,please check it!");
            }
        }catch (Exception e){
            mOutResult.setCode(1);
            mOutResult.setMsg("失败：" + e.toString());
            gLog.error(e.toString());
        }
        return mOutResult;
    }
}
