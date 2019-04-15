package com.liangxin.platform.controler;

import com.liangxin.platform.common.entity.advise.generate.pt.Anniversary;
import com.liangxin.platform.common.entity.advise.inputParam.anniversary.AnniversaryInput;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.AnniversaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnniversaryControler {
    @Autowired
    private AnniversaryService gAnniversaryService;

    @ResponseBody
    @RequestMapping(value = "/Anniversary/GetAnniversaryAll" ,method = RequestMethod.POST)
    public OutResult getAnniversaryAll(@RequestBody AnniversaryInput pAnniversaryInput){
        return gAnniversaryService.getAnniversaryAll(pAnniversaryInput);
    }

    @ResponseBody
    @RequestMapping(value = "/Anniversary/ignoreById", method = RequestMethod.POST)
    public OutResult ignoreById(@RequestBody Anniversary pAnniversary) {
        return gAnniversaryService.ignoreById(pAnniversary);
    }
}
