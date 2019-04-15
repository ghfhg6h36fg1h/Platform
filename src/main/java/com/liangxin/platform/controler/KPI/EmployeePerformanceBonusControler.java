package com.liangxin.platform.controler.KPI;

import com.liangxin.platform.common.entity.KPI.inputParam.InputPage;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.KPI.EmployeePerformanceBonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeePerformanceBonusControler {
    @Autowired
    private EmployeePerformanceBonusService gEmployeePerformanceBonusService;

    @ResponseBody
    @RequestMapping(value = "/${KPIMainPath}/outInterface/GetTeamEmployee")
    public OutResult getEmployeePerformanceBonus(String employeeNo,String lineName){
        OutResult mRvalue = gEmployeePerformanceBonusService.getEmployeePerformanceBonus(employeeNo,lineName);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/EmployeePerformance/GetEmployeePerformance/{sid}" ,method = RequestMethod.GET)
    public OutResult getEmployeePerformanceImportbysid(@PathVariable String sid){
        OutResult mRvalue = gEmployeePerformanceBonusService.getEmployeePerformanceImportbysid(sid);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/TeamEmployee/GetTeamEmployee" ,method = RequestMethod.POST)
    public OutResult getTeamEmployee(@RequestBody InputPage gInputPage){
        return gEmployeePerformanceBonusService.getEmployeePerformanceImport(gInputPage);
    }

    @ResponseBody
    @RequestMapping(value = "/EmployeeBonus/GetEmployeeBonus" ,method = RequestMethod.POST)
    public OutResult getEmployeeBonusList(@RequestBody InputPage gInputPage){
        return gEmployeePerformanceBonusService.getEmployeeBonusList(gInputPage);
    }
}
