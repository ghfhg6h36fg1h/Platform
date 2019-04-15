package com.liangxin.platform.service.KPI;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.liangxin.platform.common.entity.KPI.TeamPerformance;
import com.liangxin.platform.common.entity.KPI.inputParam.InputPage;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.mapper.KPI.ITeamPerformanceMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamPerformanceService {
    private final Logger gLog = LogManager.getLogger(TeamPerformanceService.class);
    @Autowired
    private ITeamPerformanceMapper gITeamPerformanceMapper;

    public OutResult getTeamPerformance(){
        OutResult mOutResult = new OutResult();
        try {
            List<TeamPerformance> mteamPerformance = gITeamPerformanceMapper.getTeamPerformance();
            mOutResult.setData(mteamPerformance);
            mOutResult.setCode(0);
            mOutResult.setMsg("成功");
        }catch (Exception e){
            mOutResult.setCode(1);
            mOutResult.setMsg("失败：" + e.toString());
            gLog.error(e.toString());
        }
        return mOutResult;
    }

    public OutResult getTeamPerformanceList(InputPage gInputPage){
        OutResult mOutResult = new OutResult();
        try {
            Page mPage = PageHelper.startPage(gInputPage.getPageIndex(), gInputPage.getPageSize(),true);
            List<TeamPerformance> mteamPerformance = gITeamPerformanceMapper.getTeamPerformanceList(gInputPage);
            mOutResult.setData(mteamPerformance);
            mOutResult.setTotalCount(mPage.getTotal());
            mOutResult.setIsSuccess(true);
            mOutResult.setCode(0);
            mOutResult.setMsg("成功");
        }catch (Exception e){
            mOutResult.setCode(1);
            mOutResult.setMsg("失败：" + e.toString());
            gLog.error(e.toString());
        }
        return mOutResult;
    }
}
