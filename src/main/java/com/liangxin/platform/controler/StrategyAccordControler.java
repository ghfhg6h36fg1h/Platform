package com.liangxin.platform.controler;

import com.liangxin.platform.common.entity.advise.inputParam.strategyAccord.StrategyAccordMainInput;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.StrategyAccordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

@Controller
public class StrategyAccordControler {

    @Autowired
    private StrategyAccordService gStrategyAccordService;

    /**
     * get all StrategyAccord records by specified conditions.
     * @param pStrategyAccordMainInput
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "strategyAccord/getAll", method = RequestMethod.POST)
    public OutResult getAllByConditions(@RequestBody StrategyAccordMainInput pStrategyAccordMainInput,ServletRequest servletRequest) {
        return gStrategyAccordService.getAllByConditions(pStrategyAccordMainInput,servletRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/strategyAccord/excel", method = RequestMethod.GET)
    public void exportExcel(HttpServletResponse response,ServletRequest servletRequest, String informStuff, String companyName, String oaId, BigDecimal informStatus,
                            String searchStartDate, String searchEndDate){
        gStrategyAccordService.exportExcel(response,servletRequest,informStuff,companyName,oaId,informStatus,searchStartDate,searchEndDate);
    }

    /**
     * get all StrategyAccord records by specified conditions:xietong.
     * @param pStrategyAccordMainInput
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/${YXYHMainPath}/strategyAccord/outInterface/getAll", method = RequestMethod.POST)
    public OutResult getAllByConditionsXieTong(@RequestBody StrategyAccordMainInput pStrategyAccordMainInput) {
        return gStrategyAccordService.selectByConditionXieTong(pStrategyAccordMainInput);
    }

    /**
     * get all StrategyAccord records by specified conditions:xietong.
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/${YXYHMainPath}/strategyAccord/outInterface/getOne", method = RequestMethod.GET)
    public OutResult getAllByConditionsXieTong(String id) {
        StrategyAccordMainInput pStrategyAccordMainInput=new StrategyAccordMainInput();
        pStrategyAccordMainInput.setId(id);
        return gStrategyAccordService.selectByConditionXieTong(pStrategyAccordMainInput);
    }

}
