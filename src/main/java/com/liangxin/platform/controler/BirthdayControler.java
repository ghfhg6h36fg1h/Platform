package com.liangxin.platform.controler;

import com.liangxin.platform.common.entity.advise.generate.pt.Birthday;
import com.liangxin.platform.common.entity.advise.inputParam.birthday.BirthdayInput;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.BirthdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BirthdayControler {
    @Autowired
    private BirthdayService gBirthdayService;

    @ResponseBody
    @RequestMapping(value = "/Birthday/GetBirthdayAll" ,method = RequestMethod.POST)
    public OutResult getBirthdayAll(@RequestBody BirthdayInput pBirthdayInput){
        return gBirthdayService.getBirthdayAll(pBirthdayInput);
    }

    @ResponseBody
    @RequestMapping(value = "/Birthday/ignoreById", method = RequestMethod.POST)
    public OutResult ignoreById(@RequestBody Birthday pBirthday) {
        return gBirthdayService.ignoreById(pBirthday);
    }
}
