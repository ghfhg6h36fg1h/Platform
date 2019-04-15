package com.liangxin.platform.controler.LXYKT;

import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.LXYKT.OverTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OverTimeControler {
    @Autowired
    private OverTimeService gOverTimeService;

    @ResponseBody
    @RequestMapping(value = "/${LXYKTMainPath}/outInterface/Overtime")
    public OutResult getOverTimeInfo(String empno,String startdate,String enddate){
        OutResult mRvalue = gOverTimeService.getOverTimeInfo(empno, startdate, enddate);
        return  mRvalue;
    }
}
