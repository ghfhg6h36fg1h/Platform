package com.liangxin.platform.controler.KPI;

import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.KPI.EmployeePerformanceBonusbysidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeePerformanceBonusbysidControler {
    @Autowired
    private EmployeePerformanceBonusbysidService gEmployeePerformanceBonusbysidService;

    @ResponseBody
    @RequestMapping(value = "/${KPIMainPath}/outInterface/GetTeamEmployeebysid")
    public OutResult getEmployeePerformanceBonusbysid(String sid){
        OutResult mRvalue = gEmployeePerformanceBonusbysidService.getEmployeePerformanceBonusbysid(sid);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/EmployeeBonus/GetEmployeeBonusbysid/{sid}",method = RequestMethod.GET)
    public OutResult getEmployeeBonusbysid(@PathVariable String sid){
        OutResult mRvalue = gEmployeePerformanceBonusbysidService.getEmployeeBonusbysid(sid);
        return mRvalue;
    }
}
