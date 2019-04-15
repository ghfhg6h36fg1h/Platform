package com.liangxin.platform.controler.LXYKT;

import com.liangxin.platform.common.entity.LXYKT.AnnualLeaveInfo;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.LXYKT.AnnualLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnnualLeaveControler {
    @Autowired
    private AnnualLeaveService gAnnualLeaveService;

    @ResponseBody
    @RequestMapping(value = "/${LXYKTMainPath}/outInterface/AnnualLeave")
    public OutResult getAnnualLeaveInfo(String empno) {
        OutResult mRvalue = gAnnualLeaveService.getAnnualLeaveInfo(empno);
        return mRvalue;
    }
}
