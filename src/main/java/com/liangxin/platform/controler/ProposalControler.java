package com.liangxin.platform.controler;

import com.liangxin.platform.common.entity.advise.Proposal;
import com.liangxin.platform.common.entity.advise.inputParam.proposal.ListInput;
import com.liangxin.platform.common.entity.advise.inputParam.proposal.ListOAInput;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



import java.util.Date;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;


@Controller
public class ProposalControler {
    @Autowired
    private ProposalService gProposalService;

    @ResponseBody
    @RequestMapping(value = "/${mainPath}/proposal/outInterface/getAll", method = RequestMethod.POST)
    public OutResult getAll(@RequestBody ListInput pListInput) {
        OutResult mRvalue = gProposalService.getAll(pListInput);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/${mainPath}/proposal/outInterface/addProposal", method = RequestMethod.POST)
    public OutResult addProposal(@RequestBody Proposal pAddProposal) {
        OutResult mRvalue = gProposalService.addProposal(pAddProposal);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/${mainPath}/proposal/outInterface/getById", method = RequestMethod.GET)
    public OutResult getById(String id, String presentWorkId) {
        OutResult mRvalue = gProposalService.getById(id, presentWorkId);
        return mRvalue;
    }
    @ResponseBody
    @RequestMapping(value = "/${mainPath}/proposal/outInterface/getNaderOAStepByOaProposalId", method = RequestMethod.GET)
    public OutResult getoutInterfaceNaderOAStepByOaProposalId(String pProposalId,String pOaProposalId) {
        OutResult mRvalue = gProposalService.getNaderOAStepByOaProposalId(pProposalId,pOaProposalId);
        return mRvalue;
    }
    @ResponseBody
    @RequestMapping(value = "/${mainPath}/proposal/outInterface/update", method = RequestMethod.POST)
    public OutResult update(@RequestBody Proposal pAddProposal) {
        OutResult mRvalue = gProposalService.update(pAddProposal);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/${mainPath}/proposal/outInterface/updateByOwner", method = RequestMethod.POST)
    public OutResult updateByOwner(@RequestBody Proposal pAddProposal) {
        OutResult mRvalue = gProposalService.updateByOwner(pAddProposal);
        return mRvalue;
    }
    @ResponseBody
    @RequestMapping(value = "/proposal/getOAAll", method = RequestMethod.POST)
    public OutResult getOAAll(@RequestBody ListOAInput pListOAInput) {
        OutResult mRvalue = gProposalService.getOAAll(pListOAInput);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/proposal/oaUpdate", method = RequestMethod.POST)
    public OutResult oaUpdate(@RequestBody Proposal pAddProposal) {
        OutResult mRvalue = gProposalService.oaUpdate(pAddProposal);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/proposal/getOAById/{pId}", method = RequestMethod.GET)
    public OutResult getOAById(@PathVariable String pId) {
        OutResult mRvalue = gProposalService.getOAById(pId);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/proposal/getNaderOAStepByOaProposalId", method = RequestMethod.GET)
    public OutResult getNaderOAStepByOaProposalId(String pProposalId,String pOaProposalId) {
        OutResult mRvalue = gProposalService.getNaderOAStepByOaProposalId(pProposalId,pOaProposalId);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/proposal/getStatisticProposal", method = RequestMethod.POST)
    public OutResult getStatisticProposal(@RequestBody ListOAInput pListOAInput) {
        OutResult mRvalue = gProposalService.getStatisticProposal(pListOAInput);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/proposal/excel", method = RequestMethod.GET)
    public void exportExcel(HttpServletResponse response,String ownerName,String capitalName,String theme,String status,
                            String searchStartDate,String searchEndDate){
        gProposalService.exportExcel(response,ownerName,capitalName,theme,status,searchStartDate,searchEndDate);
    }
}