package com.liangxin.platform.controler.KPI;

import com.liangxin.platform.common.entity.KPI.inputParam.InputPage;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.KPI.TeamOverfulfillBonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeamOverfulfillBonusControler {
    @Autowired
    private TeamOverfulfillBonusService gTeamOverfulfillBonusService;

    @ResponseBody
    @RequestMapping(value = "/${KPIMainPath}/outInterface/GetTeamBonus")
    public OutResult getTeamOverfulfillBonus(){
        OutResult mRvalue = gTeamOverfulfillBonusService.getTeamOverfulfillBonus();
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/TeamBonus/GetTeamBonus" ,method = RequestMethod.POST)
    public OutResult getTeamBonus(@RequestBody InputPage gInputPage){
        return gTeamOverfulfillBonusService.getTeamBonus(gInputPage);
    }

}
