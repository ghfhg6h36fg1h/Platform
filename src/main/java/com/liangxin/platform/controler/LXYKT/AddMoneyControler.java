package com.liangxin.platform.controler.LXYKT;

import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.LXYKT.AddMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddMoneyControler {
    @Autowired
    private AddMoneyService gAddMoneyService;

    @ResponseBody
    @RequestMapping(value = "/${LXYKTMainPath}/outInterface/AddMoney")
    public OutResult getAddMoneyInfo(String empno, String startdate, String enddate) {
        OutResult mRvalue = gAddMoneyService.getAddMoneyInfo(empno, startdate, enddate);
        return mRvalue;
    }
}
