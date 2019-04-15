package com.liangxin.platform.controler;

import com.liangxin.platform.common.entity.advise.generate.pt.ReadyToMemberRecord;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.ReadeyToMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReadyToMemberRecordControler {
    @Autowired
    private ReadeyToMemberService gReadeyToMemberService;
    @ResponseBody
    @RequestMapping(value = "/readyToMemberRecord/update",method = RequestMethod.POST)
    public OutResult update(@RequestBody ReadyToMemberRecord pReadyToMemberRecord) {
        OutResult mRvalue = gReadeyToMemberService.update(pReadyToMemberRecord);
        return mRvalue;
    }
    @ResponseBody
    @RequestMapping(value = "/readyToMemberRecord/insert",method = RequestMethod.POST)
    public OutResult insert(@RequestBody ReadyToMemberRecord pReadyToMemberRecord) {
        OutResult mRvalue = gReadeyToMemberService.insert(pReadyToMemberRecord);
        return mRvalue;
    }
}
