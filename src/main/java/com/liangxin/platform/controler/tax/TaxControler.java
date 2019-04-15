package com.liangxin.platform.controler.tax;

import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.common.entity.tax.inputParam.DeletePicInput;
import com.liangxin.platform.common.entity.tax.inputParam.TaxListInput;
import com.liangxin.platform.common.entity.tax.inputParam.TaxSearchListInput;
import com.liangxin.platform.common.entity.tax.pt.Tax;
import com.liangxin.platform.service.tax.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;


@Controller
public class TaxControler {

    private final ResourceLoader resourceLoader;

    @Autowired
    public TaxControler(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Autowired
    private TaxService gTaxService;

    @ResponseBody
    @RequestMapping(value = "/${TAXMainPath}/outInterface/GetTaxList" ,method = RequestMethod.POST)
    public OutResult getTaxList(@RequestBody TaxListInput pTaxListInput){
         OutResult mRvalue = gTaxService.getTaxList(pTaxListInput);
         return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/tax/getSearchTaxList" ,method = RequestMethod.POST)
    public OutResult getSearchTaxList(@RequestBody TaxSearchListInput pTaxSearchListInput){
        OutResult mRvalue = gTaxService.getSearchTaxList(pTaxSearchListInput);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/tax/getTaxDetail/{sid}" ,method = RequestMethod.GET)
    public OutResult getWebTaxDetail(@PathVariable int sid){
        OutResult mRvalue = gTaxService.getTaxDetail(sid);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/tax/approvalTax" ,method = RequestMethod.POST)
    public OutResult approvalTax(@RequestBody Tax pTax){
        OutResult mRvalue = gTaxService.approvalTax(pTax);
        if(mRvalue.getIsSuccess()){
            gTaxService.pushApprovalTax(pTax);
        }
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/${TAXMainPath}/outInterface/GetTaxDetail/{sid}" ,method = RequestMethod.GET)
    public OutResult getTaxDetail(@PathVariable int sid){
        OutResult mRvalue = gTaxService.getTaxDetail(sid);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/${TAXMainPath}/outInterface/InsertTax" ,method = RequestMethod.POST)
    public OutResult taxInsert(@RequestBody Tax pTax){
        OutResult mRvalue = gTaxService.taxInsert(pTax);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/${TAXMainPath}/outInterface/EditTax" ,method = RequestMethod.POST)
    public OutResult editTax(@RequestBody Tax pTax){
        OutResult mRvalue = gTaxService.editTax(pTax);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/${TAXMainPath}/outInterface/SubmitTax" ,method = RequestMethod.POST)
    public OutResult submitTax(@RequestBody Tax pTax){
        OutResult mRvalue = gTaxService.submitTax(pTax);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/${TAXMainPath}/outInterface/DeletePic" ,method = RequestMethod.POST)
    public OutResult deletePic(@RequestBody DeletePicInput pDeletePicInput){
        OutResult mRvalue = gTaxService.deletePic(pDeletePicInput);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/${TAXMainPath}/outInterface/UploadPic" ,method = RequestMethod.POST)
    public OutResult uploadPic(@RequestParam(value = "file" ,required = false) MultipartFile file,@RequestParam(value = "sid",required = false) int sid,@RequestParam(value = "empno" ,required = false) String empno,@RequestParam(value = "param",required = false) String param){
        OutResult mRvalue = gTaxService.uploadPic(file,sid,empno,param);
        return mRvalue;
    }

    @RequestMapping("/tax/outInterface/showPic")
    public ResponseEntity showPic(String fileName){
        try {
            // 由于是读取本机的文件，file是一定要加上的
            return ResponseEntity.ok(resourceLoader.getResource("file:" + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/tax/excel", method = RequestMethod.GET)
    public void exportExcel(HttpServletResponse response, String name, String empno, BigDecimal state, String searchApplyStartDate, String searchApplyEndDate, String searchApprovalStartDate, String searchApprovalEndDate){
        gTaxService.exportExcel(response,name,empno,state,searchApplyStartDate,searchApplyEndDate,searchApprovalStartDate,searchApprovalEndDate);
    }

}
