package com.liangxin.platform.controler.LXYKT;

import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.LXYKT.ConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConsumeControler {
    @Autowired
    private ConsumeService gConsumeService;

    @ResponseBody
    @RequestMapping(value = "/${LXYKTMainPath}/outInterface/Consume")
    public OutResult getConsumeInfo(String empno, String startdate, String enddate){
        OutResult mRvalue = gConsumeService.getConsumeInfo(empno, startdate, enddate);
        return  mRvalue;
    }
}
