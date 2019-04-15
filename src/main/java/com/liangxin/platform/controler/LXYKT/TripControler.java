package com.liangxin.platform.controler.LXYKT;

import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.LXYKT.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TripControler {
    @Autowired
    private TripService gTripService;

    @ResponseBody
    @RequestMapping(value = "/${LXYKTMainPath}/outInterface/Trip")
    public OutResult getTripInfo(String empno,String startdate,String enddate){
        OutResult mRvalue = gTripService.getTripInfo(empno, startdate, enddate);
        return mRvalue;
    }
}
