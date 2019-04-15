package com.liangxin.platform.controler.KPI;

import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.KPI.TeamPerformancebysidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeamPerformancebysidControler {
    @Autowired
    private TeamPerformancebysidService gTeamPerformancebysidService;

    @ResponseBody
    @RequestMapping(value = "/${KPIMainPath}/outInterface/GetTeamPerformancebysid")
    public OutResult getTeamPerformancebysid(String sid){
        OutResult mRvalue = gTeamPerformancebysidService.getTeamPerformancebysid(sid);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/TeamPerformance/GetTeamPerformancebysid/{sid}" , method = RequestMethod.GET)
    public OutResult getTeamPerformanceListbysid(@PathVariable String sid){
        OutResult mRvalue = gTeamPerformancebysidService.getTeamPerformancebysid(sid);
        return mRvalue;
    }
}
