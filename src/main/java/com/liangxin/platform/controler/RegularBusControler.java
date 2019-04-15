package com.liangxin.platform.controler;

import com.liangxin.platform.common.entity.advise.generate.pt.RegularBus;
import com.liangxin.platform.common.entity.advise.inputParam.regularBus.RegularBusInputForGetAllList;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.RegularBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegularBusControler {
    @Autowired
    private RegularBusService gPRegularBusService;
    @ResponseBody
    @RequestMapping(value = "/regularBus/getAll",method = RequestMethod.POST)
    public OutResult getAll(@RequestBody RegularBusInputForGetAllList pRegularBusInputForGetAllList) {
        OutResult mRvalue = gPRegularBusService.getAll(pRegularBusInputForGetAllList);
        return mRvalue;
    }
    @ResponseBody
    @RequestMapping(value = "/regularBus/getMaxUpdateTime",method = RequestMethod.GET)
    public OutResult getMaxUpdateTime() {
        OutResult mRvalue = gPRegularBusService.getMaxUpdateTime();
        return mRvalue;
    }
    @ResponseBody
    @RequestMapping(value = "/regularBus/update",method = RequestMethod.POST)
    public OutResult update(@RequestBody RegularBus pRegularBus) {
        OutResult mRvalue = gPRegularBusService.update(pRegularBus);
        return mRvalue;
    }
}
