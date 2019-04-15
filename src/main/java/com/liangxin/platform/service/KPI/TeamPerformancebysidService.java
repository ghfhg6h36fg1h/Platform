package com.liangxin.platform.service.KPI;

import com.liangxin.platform.common.entity.KPI.TeamPerformance;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.mapper.KPI.ITeamPerformancebysidMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamPerformancebysidService {
    private final Logger gLog = LogManager.getLogger(TeamPerformancebysidService.class);
    @Autowired
    private ITeamPerformancebysidMapper gITeamPerformancebysidMapper;

    public OutResult getTeamPerformancebysid(String sid){
        OutResult mOutResult = new OutResult();
        try {
            List<TeamPerformance> mteamPerformance = gITeamPerformancebysidMapper.getTeamPerformancebysid(sid);
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
}
