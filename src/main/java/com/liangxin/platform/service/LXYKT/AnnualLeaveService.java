package com.liangxin.platform.service.LXYKT;

import com.liangxin.platform.common.entity.LXYKT.AnnualLeaveInfo;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.common.tools.StringUtils;
import com.liangxin.platform.mapper.LXYKT.IAnnualLeaveMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnnualLeaveService {
    private final Logger gLog = LogManager.getLogger(AttendanceResultsService.class);
    @Autowired
    private IAnnualLeaveMapper gIAnnualLeaveMapper;

    public OutResult getAnnualLeaveInfo(String empno){
        OutResult mOutResult = new OutResult();
        try{
            if (StringUtils.isNotEmpty(empno)){
                AnnualLeaveInfo  mAnnualLeaveInfo = gIAnnualLeaveMapper.getAnnualLeaveInfo(empno);
                List<AnnualLeaveInfo> mAnnualLeaveInfoList = new ArrayList<>();
                mAnnualLeaveInfoList.add(mAnnualLeaveInfo);
                mOutResult.setData(mAnnualLeaveInfoList);
                mOutResult.setCode(0);
                mOutResult.setMsg("成功");
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

    /*private List<AnnualLeaveInfo> getAnnualLeaveInfoList(String empno){
        try{
            List<AnnualLeaveInfo> mAnnualLeaveInfoList = new ArrayList<AnnualLeaveInfo>();
            AnnualLeaveInfo mAnnualLeaveInfo = new AnnualLeaveInfo();
            List<String> dayofflist = new ArrayList<String>();
            String workage = null;
            String nxjid = null;
            String Days = null;
            String ZyDdays = null;
            Double totalvocation = 0.0;
            Double usedvocation = 0.0;
            Double leftvocation = 0.0;
            workage = gIAnnualLeaveMapper.getWorkAgeInfo(empno);
            mAnnualLeaveInfo.setWorkAge(workage);
            if (Integer.parseInt(workage) >= 20){
                nxjid = "6";
            }
            else if (Integer.parseInt(workage) >= 10) {
                nxjid = "5";
            }
            else if (Integer.parseInt(workage) >= 6) {
                nxjid = "4";
            }
            else if (Integer.parseInt(workage) >= 3) {
                nxjid = "3";
            }
            else if (Integer.parseInt(workage) >= 1) {
                nxjid = "2";
            }
            else {
                nxjid = "1";
            }
            Days = gIAnnualLeaveMapper.getDayInfo(nxjid);
            mAnnualLeaveInfo.setTotalVocation(Days);
            ZyDdays = gIAnnualLeaveMapper.getFreeDayInfo(nxjid);
            mAnnualLeaveInfo.setFreeVocation(ZyDdays);
            totalvocation = Double.parseDouble(Days);
            dayofflist = gIAnnualLeaveMapper.getDayoffInfo(empno);
            for(String dayoff : dayofflist){
                usedvocation  +=  Double.parseDouble(dayoff);
            }
            mAnnualLeaveInfo.setUsedVocation(usedvocation.toString());
            leftvocation = totalvocation - usedvocation;
            mAnnualLeaveInfo.setLeftVocation(leftvocation.toString());
            mAnnualLeaveInfoList.add(mAnnualLeaveInfo);
            return  mAnnualLeaveInfoList;
        }catch (Exception e){
            gLog.error(e.toString());
        }
        return new ArrayList<AnnualLeaveInfo>();
    }*/

}
