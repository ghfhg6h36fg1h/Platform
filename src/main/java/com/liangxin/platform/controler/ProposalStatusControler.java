package com.liangxin.platform.controler;

import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.ProposalStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProposalStatusControler {
    @Autowired
    private ProposalStatusService gProposalStatusService;
    @ResponseBody
    @RequestMapping(value = "/proposalStatus/getAll",method = RequestMethod.GET)
    public OutResult getAll() {
        OutResult mRvalue = gProposalStatusService.getAll();
        return mRvalue;
    }
}
