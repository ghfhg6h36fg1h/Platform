package com.liangxin.platform.service.tax;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.common.entity.tax.inputParam.DeletePicInput;
import com.liangxin.platform.common.entity.tax.inputParam.TaxListInput;
import com.liangxin.platform.common.entity.tax.inputParam.TaxSearchListInput;
import com.liangxin.platform.common.entity.tax.outputParam.IsUpload;
import com.liangxin.platform.common.entity.tax.outputParam.IsUploadThumb;
import com.liangxin.platform.common.entity.tax.outputParam.TaxExportListOutput;
import com.liangxin.platform.common.entity.tax.outputParam.TaxListOutput;
import com.liangxin.platform.common.entity.tax.pt.Tax;
import com.liangxin.platform.common.tools.FileTool;
import com.liangxin.platform.common.tools.HttpTool;
import com.liangxin.platform.common.tools.excel.ExcelData;
import com.liangxin.platform.common.tools.excel.ExcelUtils;
import com.liangxin.platform.mapper.tax.ITaxMapper;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.liangxin.platform.common.tools.DateTool.mFormatIso8601Day;

@Service
public class TaxService {
    private final Logger gLog = LogManager.getLogger(TaxService.class);

    @Autowired
    private ITaxMapper gITaxMapper;

    @Value("${UploadPath}")
    private String path;

    @Value("${FakePath}")
    private String fakePath;

    @Value("${Tax.appId}")
    private String gappId;

    public OutResult getTaxList(TaxListInput pTaxListInput){
        OutResult mOutResult = new OutResult();
        try {
            List<TaxListOutput> mTaxListOutput = gITaxMapper.getTaxList(pTaxListInput);
            mOutResult.setData(mTaxListOutput);
            mOutResult.setIsSuccess(true);
            mOutResult.setCode(0);
            mOutResult.setMsg("成功");
        }catch (Exception e){
            mOutResult.setCode(1);
            mOutResult.setIsSuccess(false);
            mOutResult.setMsg("失败：" + e.toString());
            gLog.error(e.toString());
        }
        return mOutResult;
    }

    public OutResult getSearchTaxList(TaxSearchListInput pTaxSearchListInput){
        OutResult mOutResult = new OutResult();
        try {
            PageHelper.startPage(pTaxSearchListInput.getCurrentPage(), pTaxSearchListInput.getPageSize(), true);
            List<TaxListOutput> mTaxListOutput = gITaxMapper.getSearchTaxList(pTaxSearchListInput);
            PageInfo<TaxListOutput> pageInfo = new PageInfo<>(mTaxListOutput);
            mOutResult.setTotalCount(pageInfo.getTotal());
            mOutResult.setData(mTaxListOutput);
            mOutResult.setCode(0);
            mOutResult.setData(pageInfo.getList());
            mOutResult.setMsg("成功");
            mOutResult.setIsSuccess(true);
        }catch (Exception e){
            mOutResult.setCode(1);
            mOutResult.setIsSuccess(false);
            mOutResult.setMsg("失败：" + e.toString());
            gLog.error(e.toString());
        }
        return mOutResult;
    }

    public OutResult getTaxDetail(int sid){
        OutResult mOutResult = new OutResult();
        try {
            List<Tax> mTaxList = new ArrayList<>();
            Tax mTax = gITaxMapper.getTaxDetail(sid);
            mTaxList.add(mTax);
            mOutResult.setData(mTaxList);
            mOutResult.setIsSuccess(true);
            mOutResult.setCode(0);
            mOutResult.setMsg("成功");
        }catch (Exception e){
            mOutResult.setCode(1);
            mOutResult.setIsSuccess(false);
            mOutResult.setMsg("失败：" + e.toString());
            gLog.error(e.toString());
        }
        return mOutResult;
    }

    public OutResult taxInsert(Tax pTax){
        OutResult mOutResult = new OutResult();
        try {
            List<Tax> mTaxList = new ArrayList<>();
            Tax mTax = new Tax();
            if (gITaxMapper.selectByState(pTax.getEmpno()) > 0){
                mTax = gITaxMapper.getTaxDetailByState(pTax.getEmpno());
                mOutResult.setIsSuccess(true);
                mOutResult.setCode(0);
                mOutResult.setMsg("成功");
            }else if (gITaxMapper.taxInsert(pTax) > 0){
                mTax = gITaxMapper.getTaxDetailByState(pTax.getEmpno());
                mOutResult.setIsSuccess(true);
                mOutResult.setCode(0);
                mOutResult.setMsg("成功");
            }else {
                mOutResult.setIsSuccess(false);
                mOutResult.setCode(1);
                mOutResult.setMsg("失败");
            }
            mTaxList.add(mTax);
            mOutResult.setData(mTaxList);
        }catch (Exception e){
            mOutResult.setCode(1);
            mOutResult.setIsSuccess(false);
            mOutResult.setMsg("失败：" + e.toString());
            gLog.error(e.toString());
        }
        return mOutResult;
    }

    public OutResult submitTax(Tax pTax){
        OutResult mOutResult = new OutResult();
        try {
            pTax.setUpdatetime(new Date());
            pTax.setApplytime(new Date());
            pTax.setState(new BigDecimal(1));
            if (gITaxMapper.updateTax(pTax) > 0) {
                mOutResult.setIsSuccess(true);
                mOutResult.setCode(0);
                mOutResult.setMsg("提交成功");
            } else {
                mOutResult.setIsSuccess(false);
                mOutResult.setCode(1);
                mOutResult.setMsg("提交失败");
            }
            mOutResult.setData(null);
        } catch (Exception e) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg("失败：" + e.toString());
            gLog.error(e.getMessage());
        }
        return mOutResult;
    }

    public OutResult editTax(Tax pTax){
        OutResult mOutResult = new OutResult();
        try {
            pTax.setUpdatetime(new Date());
            pTax.setState(new BigDecimal(1));
            if (gITaxMapper.updateTax(pTax) > 0) {
                mOutResult.setIsSuccess(true);
                mOutResult.setCode(0);
                mOutResult.setMsg("提交成功");
            } else {
                mOutResult.setIsSuccess(false);
                mOutResult.setCode(1);
                mOutResult.setMsg("提交失败");
            }
            mOutResult.setData(null);
        } catch (Exception e) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg("失败：" + e.toString());
            gLog.error(e.getMessage());
        }
        return mOutResult;
    }

    public OutResult approvalTax(Tax pTax){
        OutResult mOutResult = new OutResult();
        try {
            pTax.setUpdatetime(new Date());
            pTax.setApprovaltime(new Date());
            if (gITaxMapper.updateTax(pTax) > 0) {
                mOutResult.setIsSuccess(true);
                mOutResult.setCode(0);
                mOutResult.setMsg("审批成功");
            } else {
                mOutResult.setIsSuccess(false);
                mOutResult.setCode(1);
                mOutResult.setMsg("审批失败");
            }
            mOutResult.setData(null);
        } catch (Exception e) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg("失败：" + e.toString());
            gLog.error(e.getMessage());
        }
        return mOutResult;
    }

    /*public OutResult submitPic(Tax pTax){
        OutResult mOutResult = new OutResult();
        try {
            pTax.setUpdatetime(new Date());
            if (gITaxMapper.updateTax(pTax) > 0) {
                mOutResult.setIsSuccess(true);
                mOutResult.setCode(0);
                mOutResult.setMsg("上传图片成功");
            } else {
                mOutResult.setIsSuccess(false);
                mOutResult.setCode(1);
                mOutResult.setMsg("上传图片失败");
            }
            mOutResult.setData(null);
        } catch (Exception e) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg("失败：" + e.toString());
            gLog.error(e.getMessage());
        }
        return mOutResult;
    }*/

    public OutResult deletePic(DeletePicInput pDeletePicInput){
        OutResult mOutResult = new OutResult();
        try {
            pDeletePicInput.setUpdatetime(new Date());
            String pic = pDeletePicInput.getPic();
            if (pic.length()>=3){
                pDeletePicInput.setPictemp(pic.substring(0,3) + "temp" + pic.substring(3));
            }
            pDeletePicInput.setEmptyStr("");
            if (gITaxMapper.deletePic(pDeletePicInput) > 0) {
                mOutResult.setIsSuccess(true);
                mOutResult.setCode(0);
                mOutResult.setMsg("删除图片成功");
            } else {
                mOutResult.setIsSuccess(false);
                mOutResult.setCode(1);
                mOutResult.setMsg("删除图片失败");
            }
            mOutResult.setData(null);
        } catch (Exception e) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg("失败：" + e.toString());
            gLog.error(e.getMessage());
        }
        return mOutResult;
    }

    public OutResult uploadPic(MultipartFile file,int sid,String empno,String param){
        OutResult mOutResult = new OutResult();
        try{
            String fileName = file.getOriginalFilename();
            List<Map<String, String>> list = new ArrayList<>();
            Map<String,String> map = new HashMap<>();
            //上传原图
            IsUpload isUpload = FileTool.upload(file, path, fakePath ,fileName,sid,empno);
            //上传缩略图
            IsUploadThumb isUploadThumb = FileTool.thumbnailImage(isUpload.getPicRealPath(), fakePath,100,150,"thumb",false);
            if(isUpload.isSuccess() && isUploadThumb.isSuccess()){
                String tempParam = param.substring(0,3) + "temp" + param.substring(3);
                if (gITaxMapper.uploadPic(sid,param,tempParam,isUpload.getPicFakePath(),isUploadThumb.getThumbnailPath(),new Date()) > 0){
                    mOutResult.setIsSuccess(true);
                    mOutResult.setCode(0);
                    mOutResult.setMsg("上传图片成功");
                    map.put("pic",isUpload.getPicFakePath());
                    map.put("pictemp",isUploadThumb.getThumbnailPath());
                    list.add(map);
                }
                else {
                    mOutResult.setIsSuccess(false);
                    mOutResult.setCode(1);
                    mOutResult.setMsg("上传图片成功,但保存图片路径失败。");
                }
            }else{
                mOutResult.setIsSuccess(false);
                mOutResult.setCode(1);
                mOutResult.setMsg("上传图片失败");
            }
            mOutResult.setData(list);
        }catch (Exception e){
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg("失败：" + e.toString());
            gLog.error(e.getMessage());
        }
        return mOutResult;
    }

    public void pushApprovalTax(Tax pTax){
        String GETTOKENURL = "https://portal.sh-liangxin.com/appsapi/token/apptoken";
        String PARAS="corpid=X6HGI658CAMzfglk&corpsecret=UcbPm4nAejTaBvAgaZNDdIqx4NqKHN9j&appid=" + gappId;
        String POSTURL = "https://portal.sh-liangxin.com/appsapi/message/send?app_access_token=";
        Tax mTax = gITaxMapper.getTaxDetail(pTax.getSid());
        try{
            int createTime = (int)(System.currentTimeMillis());
            String userid = mTax.getEmpno();
            String content= "您好，您于" + mFormatIso8601Day.format(mTax.getApplytime()) + "提交的个人所得税专项附加扣除，已处理为\"" + getState(mTax.getState()) + "\"，请进入“个税专项扣除”应用查看，谢谢！";
            String msgType = "text";
            String type = "num";
            String gettoken = null;
            try {
                //gettoken = HttpTool.getToken(GETTOKENURL);
                gettoken=HttpTool.sendGet(GETTOKENURL,PARAS);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            JSONObject j = JSONObject.fromObject(gettoken);
            String token = j.getString("app_access_token");
            String url = POSTURL + token;
            //System.out.println(url);
            JSONObject jb = new JSONObject();
            jb.put("UserId", userid);
            jb.put("MsgType", msgType);
            jb.put("Content",content);
            jb.put("CreateTime", createTime);
            jb.put("Type", type);
            String mPostParas="UserId="+userid+"&MsgType="+msgType+"&Content="+content+"&CreateTime="+createTime+"&Type="+type;
            //System.out.println(jb.toString());
            String result = null;
            try {
                //result = HttpTool.postString(url,jb.toString());
                result = HttpTool.sendPost(url,mPostParas);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                gLog.error(e.toString());
            }
            gLog.info(result);
        }catch (Exception e){
            gLog.error(e.toString());
        }
    }

     private String getState(BigDecimal pState){
        String state = "";
        switch (pState.intValue()){
            case 1:
                state = "待审";
                break;
            case 2:
                state = "驳回";
                break;
            case 3:
                state = "通过";
                break;
            case 4:
                state = "草稿";
                break;
                default:
                    state = "default";
        }
        return state;
    }

    public void exportExcel(HttpServletResponse response, String name, String empno, BigDecimal state, String searchApplyStartDate, String searchApplyEndDate, String searchApprovalStartDate, String searchApprovalEndDate) {
        try {
            TaxSearchListInput mTaxSearchListInput = new TaxSearchListInput();
            mTaxSearchListInput.setName(name);
            mTaxSearchListInput.setEmpno(empno);
            mTaxSearchListInput.setState(state);
            mTaxSearchListInput.setSearchApplyStartDate(searchApplyStartDate);
            mTaxSearchListInput.setSearchApplyEndDate(searchApplyEndDate);
            mTaxSearchListInput.setSearchApprovalStartDate(searchApprovalStartDate);
            mTaxSearchListInput.setSearchApprovalEndDate(searchApprovalEndDate);
            PageHelper.startPage(1, 9999);
            List<TaxExportListOutput> mRvalue = gITaxMapper.getExportTaxList(mTaxSearchListInput);
            handleExportExcel(response, mRvalue);
        } catch (Exception ex) {
            gLog.error("个税申报数据导出出错：", ex);
        }
    }

    private void handleExportExcel(HttpServletResponse response, List<TaxExportListOutput> pRvalue) throws Exception {
        ExcelData data = new ExcelData();
        data.setName("个税申报");
        List<String> titles = new ArrayList();
        titles.add("工号");
        titles.add("姓名");
        titles.add("提报日期");
        titles.add("审批日期");
        titles.add("状态");
        titles.add("子女教育专项抵扣金额(境内)");
        titles.add("子女教育专项抵扣金额(境外)");
        titles.add("继续教育专项抵扣金额（学历教育）");
        titles.add("继续教育专项抵扣金额（职业资格教育）");
        titles.add("房贷款利息专项抵扣金额");
        titles.add("租房租金专项抵扣金额");
        titles.add("赡养老人专项抵扣金额(独生子女)");
        titles.add("赡养老人专项抵扣金额(非独生子女)");
        data.setTitles(titles);
        List<List<Object>> rows = new ArrayList();
        SimpleDateFormat fDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (TaxExportListOutput fTaxExportListOutput : pRvalue) {
            List<Object> row = new ArrayList();
            row.add(fTaxExportListOutput.getEmpno());
            row.add(fTaxExportListOutput.getName());
            row.add(fTaxExportListOutput.getApplytime()==null? null:fDate.format(fTaxExportListOutput.getApplytime()));
            row.add(fTaxExportListOutput.getApprovaltime()==null? null:fDate.format(fTaxExportListOutput.getApprovaltime()));
            row.add(getState(fTaxExportListOutput.getState()));
            row.add(fTaxExportListOutput.getMoney1());
            row.add(fTaxExportListOutput.getMoney7());
            row.add(fTaxExportListOutput.getMoney2());
            row.add(fTaxExportListOutput.getMoney3());
            row.add(fTaxExportListOutput.getMoney4());
            row.add(fTaxExportListOutput.getMoney5());
            row.add(fTaxExportListOutput.getMoney6());
            row.add(fTaxExportListOutput.getMoney8());
            rows.add(row);
        }
        data.setRows(rows);
        //生成本地
            /*File f = new File("c:/test.xlsx");
            FileOutputStream out = new FileOutputStream(f);
            ExportExcelUtils.exportExcel(data, out);
            out.close();*/
        String fileName = "个税申报-" + mFormatIso8601Day.format(new Date()) + ".xls";
        ExcelUtils.exportExcel(response, fileName, data);
    }

}
