package com.liangxin.platform.controler;

import com.liangxin.platform.common.entity.advise.generate.pt.Capital;
import com.liangxin.platform.common.entity.advise.inputParam.capital.InputForOAList;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.CapitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CapitalControler {
    @Autowired
    private CapitalService gCapitalService;

    @ResponseBody
    @RequestMapping(value = "/${mainPath}/capital/outInterface/isCapital", method = RequestMethod.GET)
    public OutResult isCapital(String workId) {
        return gCapitalService.isCapital(workId);
    }

    @ResponseBody
    @RequestMapping(value = "/${mainPath}/capital/outInterface/getCapitalList", method = RequestMethod.GET)
    public OutResult getCapitalList() {
        return gCapitalService.getCapitalList();
    }

    @ResponseBody
    @RequestMapping(value = "/capital/getCapitalList", method = RequestMethod.POST)
    public OutResult getCapitalListForOA(@RequestBody InputForOAList pInputForOAList) {
        return gCapitalService.getCapitalListForOA(pInputForOAList);
    }

    @ResponseBody
    @RequestMapping(value = "/capital/add", method = RequestMethod.POST)
    public OutResult add(@RequestBody Capital pCapital) {
        return gCapitalService.add(pCapital);
    }

    @ResponseBody
    @RequestMapping(value = "/capital/update", method = RequestMethod.POST)
    public OutResult update(@RequestBody Capital pCapital) {
        return gCapitalService.update(pCapital);
    }

    @ResponseBody
    @RequestMapping(value = "/capital/{pId}", method = RequestMethod.GET)
    public OutResult getById(@PathVariable String pId) {
        return gCapitalService.getById(pId);
    }
}
