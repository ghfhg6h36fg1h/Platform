package com.liangxin.platform.controler.LXYKT;

import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.LXYKT.SwingCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SwingCardControler {
    @Autowired
    private SwingCardService gSingCardService;

    @ResponseBody
    @RequestMapping(value = "/${LXYKTMainPath}/outInterface/SwingCard")
    public OutResult getSwingCardInfo(String empno,String startdate,String enddate){
        OutResult mRvalue = gSingCardService.getSwingCardInfo(empno, startdate, enddate);
        return mRvalue;
    }
}
