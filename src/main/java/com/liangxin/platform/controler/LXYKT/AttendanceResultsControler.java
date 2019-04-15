package com.liangxin.platform.controler.LXYKT;

import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.LXYKT.AttendanceResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AttendanceResultsControler {
    @Autowired
    private AttendanceResultsService gAttendanceResultsService;

    @ResponseBody
    @RequestMapping(value = "/${LXYKTMainPath}/outInterface/AttendanceResults")
    public OutResult getAttendanceResultsInfo(String empno, String startdate, String enddate) {
        OutResult mRvalue = gAttendanceResultsService.getAttendanceResultInfo(empno, startdate, enddate);
        return mRvalue;
    }
}
