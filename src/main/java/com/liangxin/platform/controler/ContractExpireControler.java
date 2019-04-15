package com.liangxin.platform.controler;

import com.liangxin.platform.common.entity.advise.generate.pt.ContractExpireRecord;
import com.liangxin.platform.common.entity.advise.generate.pt.ReadyToMemberRecord;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.ContractExpireService;
import com.liangxin.platform.service.ReadeyToMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContractExpireControler {
    @Autowired
    private ContractExpireService gContractExpireService;
    @ResponseBody
    @RequestMapping(value = "/contractExpire/update",method = RequestMethod.POST)
    public OutResult update(@RequestBody ContractExpireRecord pContractExpireRecord) {
        OutResult mRvalue = gContractExpireService.update(pContractExpireRecord);
        return mRvalue;
    }
    @ResponseBody
    @RequestMapping(value = "/contractExpire/insert",method = RequestMethod.POST)
    public OutResult insert(@RequestBody ContractExpireRecord pContractExpireRecord) {
        OutResult mRvalue = gContractExpireService.insert(pContractExpireRecord);
        return mRvalue;
    }
}
