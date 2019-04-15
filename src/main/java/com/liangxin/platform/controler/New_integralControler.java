package com.liangxin.platform.controler;

import com.liangxin.platform.common.entity.advise.generate.pt.New_IntegralDetail;
import com.liangxin.platform.common.entity.advise.inputParam.proposal.ChangeMoneyInput;
import com.liangxin.platform.common.entity.advise.inputParam.proposal.ListInput;
import com.liangxin.platform.common.entity.advise.inputParam.proposal.ListOAInput;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.New_IntegralService;
import com.liangxin.platform.service.New_ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@Controller
public class New_integralControler {
    @Autowired
    private New_IntegralService IntegralService;


    @ResponseBody
    @RequestMapping(value = "/${mainPath}/proposal/outInterface/IntegralHome", method = RequestMethod.GET)
    public OutResult IntegralHome(String empno) {
        OutResult mRvalue = IntegralService.IntegralHome(empno);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/${mainPath}/proposal/outInterface/IntegralTop", method = RequestMethod.GET)
    public OutResult IntegralTop(String empno) {
        OutResult mRvalue = IntegralService.IntegralTop(empno);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/${mainPath}/proposal/outInterface/ChangeMoney", method = RequestMethod.POST)
    public OutResult ChangeMoney(@RequestBody ChangeMoneyInput changeMoneyInput) {
        OutResult mRvalue = IntegralService.ChangeMoney(changeMoneyInput);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/${mainPath}/proposal/outInterface/IntegralDetail", method = RequestMethod.GET)
    public OutResult IntegralDetail(int id) {
        OutResult mRvalue = IntegralService.IntegralDetail(id);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/${mainPath}/proposal/outInterface/GetMoney", method = RequestMethod.POST)
    public OutResult GetMoney(@RequestBody New_IntegralDetail new_integralDetail) {
        OutResult mRvalue = IntegralService.GetMoney(new_integralDetail);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/proposal/getWebIntegralListByName", method = RequestMethod.POST)
    public OutResult getWebIntegralListByName(@RequestBody ListOAInput pListOAInput) {

        OutResult mRvalue = IntegralService.getWebIntegralListByName(pListOAInput);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/proposal/getWebIntegralList", method = RequestMethod.POST)
    public OutResult getWebIntegralList(@RequestBody ListOAInput pListOAInput) {
        if (pListOAInput.getStatus()=="")
            pListOAInput.setStatus(null);
        OutResult mRvalue = IntegralService.getWebIntegralList(pListOAInput);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/proposal/getWebIntegralListByEmpno", method = RequestMethod.POST)
    public OutResult getWebIntegralListByEmpno(@RequestBody ListOAInput pListOAInput) {

        OutResult mRvalue = IntegralService.getWebIntegralListByEmpno(pListOAInput);
        return mRvalue;
    }


    @ResponseBody
    @RequestMapping(value = "/proposal/WebChangeState", method = RequestMethod.GET)
    public OutResult WebChangeState(String state) {
        OutResult mRvalue = IntegralService.WebChangeState(state);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/proposal/Integralexcel", method = RequestMethod.GET)
    public void Integralexcel(HttpServletResponse response){
        IntegralService.Integralexcel(response);
    }
    @ResponseBody
    @RequestMapping(value = "/proposal/IntegralexcelByStatus", method = RequestMethod.GET)
    public void IntegralexcelByStatus(HttpServletResponse response,String status){

       IntegralService.IntegralexcelByStatus(response,status);
    }

}