package com.liangxin.platform.controler.KPI;

import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.KPI.TeamOverfulfillBonusbysidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeamOverfulfillBonusbysidControler {
    @Autowired
    private TeamOverfulfillBonusbysidService gTeamOverfulfillBonusbysidService;

    @ResponseBody
    @RequestMapping(value = "/${KPIMainPath}/outInterface/GetTeamBonusbysid")
    public OutResult getTeamOverfulfillBonusbysid(String sid){
        OutResult mRvalue = gTeamOverfulfillBonusbysidService.getTeamOverfulfillBonusbysid(sid);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/GetTeamBonus/GetTeamBonusbysid/{sid}",method = RequestMethod.GET)
    public OutResult getTeamOverfulfillBonusList(@PathVariable String sid){
        OutResult mRvalue = gTeamOverfulfillBonusbysidService.getTeamOverfulfillBonusbysid(sid);
        return mRvalue;
    }
}
