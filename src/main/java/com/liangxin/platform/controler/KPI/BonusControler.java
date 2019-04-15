package com.liangxin.platform.controler.KPI;

import com.liangxin.platform.service.KPI.BonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
public class BonusControler {
    @Autowired
    private BonusService gBonusService;

    @ResponseBody
    @RequestMapping(value = "bonus/upload" ,method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file",required = false)MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        String result = gBonusService.readExcelFile(file);
        return result;
    }

@ResponseBody
@RequestMapping(value = "bonus/push" ,method = RequestMethod.POST)
public void push( HttpServletRequest request, HttpServletResponse response){

        gBonusService.pushEmployeePerformanceBonus();

}
}