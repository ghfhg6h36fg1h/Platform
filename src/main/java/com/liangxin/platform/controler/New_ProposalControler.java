package com.liangxin.platform.controler;

import com.liangxin.platform.common.entity.advise.Proposal;
import com.liangxin.platform.common.entity.advise.generate.pt.New_PROPOSAL;
import com.liangxin.platform.common.entity.advise.inputParam.proposal.ListInput;
import com.liangxin.platform.common.entity.advise.inputParam.proposal.ListOAInput;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.New_ProposalService;
import com.liangxin.platform.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class New_ProposalControler {
    @Autowired
    private New_ProposalService ProposalService;

    @ResponseBody
    @RequestMapping(value = "/${mainPath}/proposal/outInterface/getSumData", method = RequestMethod.GET)
    public OutResult getSumData() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String year = sdf.format(new Date());
        String StartTime = year + "-01-01";
        String EndTime = year + "-12-31";
        OutResult mRvalue = ProposalService.getSumData(StartTime, EndTime);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/${mainPath}/proposal/outInterface/getPersonSumData", method = RequestMethod.GET)
    public OutResult getPersonSumData(String empno) {

        OutResult mRvalue = ProposalService.getPersonSumData(empno);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/${mainPath}/proposal/outInterface/ClaRanking", method = RequestMethod.GET)
    public OutResult ClaRanking(String Ptype, String Ttype) {
        OutResult mRvalue = ProposalService.ClaRanking(Ptype, Ttype);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/${mainPath}/proposal/outInterface/OrgRanking", method = RequestMethod.GET)
    public OutResult OrgRanking(String empno) {
        OutResult mRvalue = ProposalService.OrgRanking(empno);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/proposal/getImplementName", method = RequestMethod.GET)
    public OutResult getImplementName(String empno) {
        OutResult mRvalue = ProposalService.getImplementName(empno);
        return mRvalue;
    }


    @ResponseBody
    @RequestMapping(value = "/${mainPath}/proposal/outInterface/NewGetAll", method = RequestMethod.POST)
    public OutResult NewGetAll(@RequestBody ListInput listInput) {
        OutResult mRvalue = ProposalService.NewGetAll(listInput);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/${mainPath}/proposal/outInterface/NewGetAllGood", method = RequestMethod.POST)
    public OutResult NewGetAllGood(@RequestBody ListInput listInput) {
        OutResult mRvalue = ProposalService.NewGetAllGood(listInput);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/${mainPath}/proposal/outInterface/GetInfo", method = RequestMethod.GET)
    public OutResult GetInfo(String empno) {
        OutResult mRvalue = ProposalService.GetInfo(empno);
        return mRvalue;
    }


    @ResponseBody
    @RequestMapping(value = "/${mainPath}/proposal/outInterface/SubmitForm", method = RequestMethod.POST)
    public OutResult SubmitForm(@RequestParam(value = "file1", required = false) MultipartFile file1,
                                @RequestParam(value = "file2", required = false) MultipartFile file2,
                                @RequestParam(value = "empno", required = false) String empno,
                                @RequestParam(value = "owner", required = false) String owner,
                                @RequestParam(value = "depart", required = false) String depart,
                                @RequestParam(value = "capitalName", required = false) String capitalName,
                                @RequestParam(value = "capitalCode", required = false) String capitalCode,
                                @RequestParam(value = "theme", required = false) String theme,
                                @RequestParam(value = "type", required = false) String type,
                                @RequestParam(value = "PROPOSAL_TYPE", required = false) int PROPOSAL_TYPE,
                                @RequestParam(value = "PRESENT_SITUATION_", required = false) String PRESENT_SITUATION_,
                                @RequestParam(value = "EXAMINE_OPINION_", required = false) String EXAMINE_OPINION_,
                                @RequestParam(value = "status", required = false) String status
    ) {

        OutResult mRvalue;
        String PICTURE1 = "NUL";
        String PICTURE1_TEM = "NUL";
        String PICTURE2 = "NUL";
        String PICTURE2_TEM = "NUL";
        //上传图1获取地址
        if (file1 != null) {
            mRvalue = ProposalService.uploadPic(file1, 1, empno);
            PICTURE1 = (String) mRvalue.getData().get(0);
            PICTURE1_TEM = (String) mRvalue.getData().get(1);
        }
        //上传图2获取地址
        if (file2 != null) {
            mRvalue = ProposalService.uploadPic(file2, 1, empno);
            PICTURE2 = (String) mRvalue.getData().get(0);
            PICTURE2_TEM = (String) mRvalue.getData().get(1);
        }

        New_PROPOSAL new_proposal = new New_PROPOSAL();
        new_proposal.setPicture1(PICTURE1);
        new_proposal.setPicture1Tem(PICTURE1_TEM);
        new_proposal.setPicture2(PICTURE2);
        new_proposal.setPicture2Tem(PICTURE2_TEM);
        new_proposal.setOwner(empno);
        new_proposal.setOwnerName(owner);
        new_proposal.setSectionName(depart);
        new_proposal.setStatus(status);
        new_proposal.setCapitalId(capitalCode);
        new_proposal.setCapitalName(capitalName);
        new_proposal.setTheme(theme);
        new_proposal.setType(type);
        new_proposal.setProposalType(PROPOSAL_TYPE);
        new_proposal.setPresentSituation(PRESENT_SITUATION_);
        new_proposal.setExamineOpinion(EXAMINE_OPINION_);

        mRvalue = ProposalService.AddForm(new_proposal);

        return mRvalue;
    }


    @ResponseBody
    @RequestMapping(value = "/${mainPath}/proposal/outInterface/GetProposalDetail", method = RequestMethod.GET)
    public OutResult GetProposalDetail(String id) {
        OutResult mRvalue = ProposalService.GetProposalDetail(id);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/${mainPath}/proposal/outInterface/UpdateForm", method = RequestMethod.POST)
    public OutResult UpdateForm(@RequestParam(value = "file1", required = false) MultipartFile file1,
                                @RequestParam(value = "file2", required = false) MultipartFile file2,
                                @RequestParam(value = "PrintImgTem0", required = false) String PrintImgTem0,
                                @RequestParam(value = "PrintImgTem1", required = false) String PrintImgTem1,
                                @RequestParam(value = "theme", required = false) String theme,
                                @RequestParam(value = "type", required = false) String type,
                                @RequestParam(value = "PROPOSAL_TYPE", required = false) int PROPOSAL_TYPE,
                                @RequestParam(value = "PRESENT_SITUATION_", required = false) String PRESENT_SITUATION_,
                                @RequestParam(value = "EXAMINE_OPINION_", required = false) String EXAMINE_OPINION_,
                                @RequestParam(value = "status", required = false) String status,
                                @RequestParam(value = "advice", required = false) String advice,
                                @RequestParam(value = "id", required = false) String id,
                                @RequestParam(value = "empno", required = false) String empno,
                                @RequestParam(value = "capitalId", required = false) String capitalId
    ) {
        OutResult mRvalue;
        String PICTURE1 = null;
        String PICTURE1_TEM = null;
        String PICTURE2 = null;
        String PICTURE2_TEM = null;

        if (PrintImgTem0.equals("DELETE")) {
            PICTURE1 = "NUL";
            PICTURE1_TEM = "NUL";
        }
        if (PrintImgTem1.equals("DELETE")) {
            PICTURE2 = "NUL";
            PICTURE2_TEM = "NUL";
        }
        //上传图1获取地址
        if (file1 != null) {
            mRvalue = ProposalService.uploadPic(file1, 1, empno);
            PICTURE1 = (String) mRvalue.getData().get(0);
            PICTURE1_TEM = (String) mRvalue.getData().get(1);
        }
        //上传图2获取地址
        if (file2 != null) {
            mRvalue = ProposalService.uploadPic(file2, 1, empno);
            PICTURE2 = (String) mRvalue.getData().get(0);
            PICTURE2_TEM = (String) mRvalue.getData().get(1);
        }

        New_PROPOSAL new_proposal = new New_PROPOSAL();

        new_proposal.setId(id);
        new_proposal.setOwner(empno);
        new_proposal.setPicture1(PICTURE1);
        new_proposal.setPicture1Tem(PICTURE1_TEM);
        new_proposal.setPicture2(PICTURE2);
        new_proposal.setPicture2Tem(PICTURE2_TEM);
        new_proposal.setStatus(status);
        new_proposal.setTheme(theme);
        new_proposal.setType(type);
        new_proposal.setProposalType(PROPOSAL_TYPE);
        new_proposal.setPresentSituation(PRESENT_SITUATION_);
        new_proposal.setExamineOpinion(EXAMINE_OPINION_);
        new_proposal.setContent(advice);
        new_proposal.setUpdateTime(new Date());
        new_proposal.setCapitalId(capitalId);
        mRvalue = ProposalService.UpdateForm(new_proposal);

        return mRvalue;
    }


    @ResponseBody
    @RequestMapping(value = "/proposal/getWebAll", method = RequestMethod.POST)
    public OutResult getOAAll(@RequestBody ListOAInput pListOAInput) {
        OutResult mRvalue = ProposalService.getWebAll(pListOAInput);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/proposal/NewGetStatisticProposal", method = RequestMethod.POST)
    public OutResult NewGetStatisticProposal(@RequestBody ListOAInput pListOAInput) {
        OutResult mRvalue = ProposalService.NewGetStatisticProposal(pListOAInput);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/proposal/Newexcel", method = RequestMethod.GET)
    public void Newexcel(HttpServletResponse response, String ownerName, String theme, String status,
                         String searchStartDate, String searchEndDate, Integer good) {
        ProposalService.Newexcel(response, ownerName, theme, status, searchStartDate, searchEndDate, good);
    }

    @ResponseBody
    @RequestMapping(value = "/proposal/getWebDetail/{pId}", method = RequestMethod.GET)
    public OutResult getWebDetail(@PathVariable String pId) {
        OutResult mRvalue = ProposalService.getWebDetail(pId);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/proposal/WebUpdate", method = RequestMethod.POST)
    public OutResult WebUpdate(@RequestBody New_PROPOSAL new_proposal) {

        OutResult mRvalue = ProposalService.WebUpdate(new_proposal);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/proposal/getWebRank", method = RequestMethod.GET)
    public OutResult getWebRank(String type, String start, String end) {

        OutResult mRvalue = ProposalService.getWebRank(type, start, end);
        return mRvalue;
    }


    @ResponseBody
    @RequestMapping(value = "/proposal/WebRankExcel", method = RequestMethod.GET)
    public void WebRankExcel(HttpServletResponse response, String type, String start, String end) throws Exception {
        if (type.equals("1"))
            type = "cla";
        else
            type = "per";

        ProposalService.WebRankExcel(response, type, start, end);
    }

}