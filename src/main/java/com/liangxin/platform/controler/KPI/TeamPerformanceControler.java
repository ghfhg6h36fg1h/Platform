package com.liangxin.platform.controler.KPI;

import com.liangxin.platform.common.entity.KPI.inputParam.InputPage;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.KPI.TeamPerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeamPerformanceControler {
    @Autowired
    private TeamPerformanceService gTeamPerformanceService;

    @ResponseBody
    @RequestMapping(value = "/${KPIMainPath}/outInterface/GetTeamPerformance")
    public OutResult getTeamPerformance(){
        OutResult mRvalue = gTeamPerformanceService.getTeamPerformance();
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/TeamPerformance/GetTeamPerformance" ,method = RequestMethod.POST)
    public OutResult getEmployeeBonusList(@RequestBody InputPage gInputPage){
        return gTeamPerformanceService.getTeamPerformanceList(gInputPage);
    }
}
