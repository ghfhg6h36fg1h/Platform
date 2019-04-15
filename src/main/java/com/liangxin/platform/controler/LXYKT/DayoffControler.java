package com.liangxin.platform.controler.LXYKT;

import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.LXYKT.DayoffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DayoffControler {
    @Autowired
    private DayoffService gDayoffService;

    @ResponseBody
    @RequestMapping(value = "/${LXYKTMainPath}/outInterface/Dayoff")
    public OutResult getDayoffInfo(String empno, String startdate, String enddate){
        OutResult mRvalue = gDayoffService.getDayoffInfo(empno, startdate, enddate);
        return  mRvalue;
    }
}
