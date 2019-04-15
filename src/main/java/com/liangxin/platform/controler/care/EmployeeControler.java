package com.liangxin.platform.controler.care;

import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.common.entity.care.inputParas.ExpireAndMemberInput;
import com.liangxin.platform.service.care.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeControler {
    @Autowired
    private EmployeeService gEmployeeService;

    @ResponseBody
    @RequestMapping(value = "/employee/outInterface/getAll", method = RequestMethod.GET)
    public OutResult getBirthdayAll() {
        return gEmployeeService.getBirthdayAll();
    }

    @ResponseBody
    @RequestMapping(value = "/employee/readyToMember/getAll", method = RequestMethod.POST)
    public OutResult readyToMember(@RequestBody ExpireAndMemberInput pExpireAndMemberInput) {
        return gEmployeeService.readyToMember(pExpireAndMemberInput);
    }

    @ResponseBody
    @RequestMapping(value = "/employee/contractExpire/getAll", method = RequestMethod.POST)
    public OutResult contractExpire(@RequestBody ExpireAndMemberInput pExpireAndMemberInput) {
        return gEmployeeService.contractExpire(pExpireAndMemberInput);
    }
}
