package com.liangxin.platform.controler.LXYKT;

import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.LXYKT.OtUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OtUseControler {
    @Autowired
    private OtUseService gOtUseService;

    @ResponseBody
    @RequestMapping(value = "/${LXYKTMainPath}/outInterface/OtUse")
    public OutResult getOtUseInfo(String empno, String startdate, String enddate){
        OutResult mRvalue = gOtUseService.getOtUseInfo(empno, startdate, enddate);
        return  mRvalue;
    }
}
