package com.liangxin.platform.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liangxin.platform.common.entity.advise.generate.pt.StrategyAccord;
import com.liangxin.platform.common.entity.advise.generate.pt.WechatInformLog;
import com.liangxin.platform.common.entity.advise.inputParam.strategyAccord.StrategyAccordMainInput;
import com.liangxin.platform.common.entity.advise.inputParam.strategyAccord.StrategyAccordWebserviceInput;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.common.entity.advise.outputResult.user.BaseOutUser;
import com.liangxin.platform.common.tools.DateTool;
import com.liangxin.platform.common.tools.HttpTool;
import com.liangxin.platform.common.tools.excel.ExcelData;
import com.liangxin.platform.common.tools.excel.ExcelUtils;
import com.liangxin.platform.mapper.advise.IStrategyAccordMapper;
import com.liangxin.platform.mapper.advise.generate.pt.StrategyAccordMapper;
import com.liangxin.platform.mapper.advise.generate.pt.WechatInformLogMapper;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class StrategyAccordService {

    private final Logger gLog = LogManager.getLogger(StrategyAccordService.class);
    @Resource
    private StrategyAccordMapper gStrategyAccordMapper;
    @Resource
    private IStrategyAccordMapper gIStrategyAccordMapper;
    @Resource
    private WechatInformLogMapper gWechatInformLogMapper;

    /**
     * the method of instruct the para  pre  updateOrInsertStrategyAccord
     *
     * @param pStrategyAccordWebserviceInput
     * @return
     */
    public OutResult updateOrInsertStrategyAccordPreInstruct(StrategyAccordWebserviceInput pStrategyAccordWebserviceInput) {
        gLog.info("战略协议进行流程同步，OAId：" + pStrategyAccordWebserviceInput.getOaId());
        StrategyAccord mStrategyAccord = new StrategyAccord();
        mStrategyAccord.setId(pStrategyAccordWebserviceInput.getId());
        String mValidAccordEndTime = DateTool.formatChinese(DateTool.parse(pStrategyAccordWebserviceInput.getValidAccordEndTime(), "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US));
        mStrategyAccord.setValidAccordEndTime(mValidAccordEndTime);
        if (!"".equals(pStrategyAccordWebserviceInput.getClientAbbreviation())) {
            mStrategyAccord.setClientAbbreviation(pStrategyAccordWebserviceInput.getClientAbbreviation());
        }
        if (!"".equals(pStrategyAccordWebserviceInput.getCompanyName())) {
            mStrategyAccord.setCompanyName(pStrategyAccordWebserviceInput.getCompanyName());
        }
        if (!"".equals(pStrategyAccordWebserviceInput.getCoorperationPattern())) {
            mStrategyAccord.setCoorperationPattern(pStrategyAccordWebserviceInput.getCoorperationPattern());
        }
        if (!"".equals(pStrategyAccordWebserviceInput.getCoorperationRange())) {
            mStrategyAccord.setCoorperationRange(pStrategyAccordWebserviceInput.getCoorperationRange());
        }
        if (!"".equals(pStrategyAccordWebserviceInput.getFirstCoorperationTime())) {
            mStrategyAccord.setFirstCoorperationTime(pStrategyAccordWebserviceInput.getFirstCoorperationTime());
        }
        if (!"".equals(pStrategyAccordWebserviceInput.getDistrict())) {
            mStrategyAccord.setDistrict(pStrategyAccordWebserviceInput.getDistrict());
        }
        if (!"".equals(pStrategyAccordWebserviceInput.getInformStatus())) {
            mStrategyAccord.setInformStatus(pStrategyAccordWebserviceInput.getInformStatus());
        }
        if (!"".equals(pStrategyAccordWebserviceInput.getInformStuff()) && !pStrategyAccordWebserviceInput.getInformStuff().equals(pStrategyAccordWebserviceInput.getSubmiterName())) {
            mStrategyAccord.setInformStuff(pStrategyAccordWebserviceInput.getInformStuff());
        }
        if (!"".equals(pStrategyAccordWebserviceInput.getInformStuffOneNumber()) && !pStrategyAccordWebserviceInput.getInformStuffOneNumber().equals(pStrategyAccordWebserviceInput.getSubmiterName())) {
            mStrategyAccord.setInformStuffOneNumber(pStrategyAccordWebserviceInput.getInformStuffOneNumber());
        }
        if (!"".equals(pStrategyAccordWebserviceInput.getInformStuffTwoName())) {
            mStrategyAccord.setInformStuffTwoName(pStrategyAccordWebserviceInput.getInformStuffTwoName());
        }
        if (!"".equals(pStrategyAccordWebserviceInput.getInformStuffTwoNumber())) {
            mStrategyAccord.setInformStuffTwoNumber(pStrategyAccordWebserviceInput.getInformStuffTwoNumber());
        }
        if (!"".equals(pStrategyAccordWebserviceInput.getOaId())) {
            mStrategyAccord.setOaId(pStrategyAccordWebserviceInput.getOaId());
        }
        if (!"".equals(pStrategyAccordWebserviceInput.getQualifiedBrand())) {
            mStrategyAccord.setQualifiedBrand(pStrategyAccordWebserviceInput.getQualifiedBrand());
        }
        String mValidAccordStartTime = DateTool.formatChinese(DateTool.parse(pStrategyAccordWebserviceInput.getValidAccordStartTime(), "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US));
        mStrategyAccord.setValidAccordStartTime(mValidAccordStartTime);
        if (!"".equals(pStrategyAccordWebserviceInput.getRankings())) {
            mStrategyAccord.setRankings(pStrategyAccordWebserviceInput.getRankings());
        }
        if (!"".equals(pStrategyAccordWebserviceInput.getSupervisorsName())) {
            mStrategyAccord.setSupervisorsName(pStrategyAccordWebserviceInput.getSupervisorsName());
        }
        if (!"".equals(pStrategyAccordWebserviceInput.getSupervisorsNumber())) {
            mStrategyAccord.setSupervisorsNumber(pStrategyAccordWebserviceInput.getSupervisorsNumber());
        }
        if (!"".equals(pStrategyAccordWebserviceInput.getSubmiterName())) {
            mStrategyAccord.setSubmiterName(pStrategyAccordWebserviceInput.getSubmiterName());
        }
        if (!"".equals(pStrategyAccordWebserviceInput.getSubmiterNumber())) {
            mStrategyAccord.setSubmiterNumber(pStrategyAccordWebserviceInput.getSubmiterNumber());
        }
        return updateOrInsertStrategyAccord(mStrategyAccord);
    }


    /**
     * 更新或增加战略协议数据
     *
     * @param pStrategyAccord
     * @return
     */
    public OutResult updateOrInsertStrategyAccord(StrategyAccord pStrategyAccord) {
        OutResult mOutResult = new OutResult();
        try {
            if (null != gStrategyAccordMapper.selectByPrimaryKey(pStrategyAccord.getId())) {
                pStrategyAccord.setUpdateTime(new Date());
                gStrategyAccordMapper.updateByPrimaryKeySelective(pStrategyAccord);
            } else {
                pStrategyAccord.setCreateTime(new Date());
                gStrategyAccordMapper.insertSelective(pStrategyAccord);
            }
            mOutResult.setData(null);
            mOutResult.setMsg("success");
            mOutResult.setIsSuccess(true);
            mOutResult.setCode(1);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(0);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    /**
     * get all StrategyAccord records by specified conditions . service
     *
     * @param pStrategyAccordMainInput
     * @return
     */
    public OutResult getAllByConditions(StrategyAccordMainInput pStrategyAccordMainInput, ServletRequest servletRequest) {
        OutResult mOutResult = new OutResult();
        try {
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            HttpSession session = req.getSession(true);
            BaseOutUser mBaseOutUser = (BaseOutUser) session.getAttribute("userInfo");
            pStrategyAccordMainInput.setSubmiterNumber(mBaseOutUser.getWorkId());
            PageHelper.startPage(pStrategyAccordMainInput.getCurrentPage(), pStrategyAccordMainInput.getPageSize(), true);
            List<StrategyAccord> mRvalue = gIStrategyAccordMapper.selectByCondition(pStrategyAccordMainInput);
            PageInfo<StrategyAccord> pageInfo = new PageInfo<>(mRvalue);
            mOutResult.setTotalCount(pageInfo.getTotal());
            mOutResult.setCode(1);
            mOutResult.setData(pageInfo.getList());
            mOutResult.setMsg("成功！");
            mOutResult.setIsSuccess(true);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(0);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }


    /**
     * get all StrategyAccord records by specified conditions . service xietong
     *
     * @param pStrategyAccordMainInput
     * @return
     */
    public OutResult selectByConditionXieTong(StrategyAccordMainInput pStrategyAccordMainInput) {
        OutResult mOutResult = new OutResult();
        try {
            List<StrategyAccord> mRvalue = gIStrategyAccordMapper.selectByConditionXieTong(pStrategyAccordMainInput);
            PageInfo<StrategyAccord> pageInfo = new PageInfo<>(mRvalue);
            mOutResult.setTotalCount(pageInfo.getTotal());
            mOutResult.setCode(0);
            mOutResult.setData(pageInfo.getList());
            mOutResult.setMsg("成功！");
            mOutResult.setIsSuccess(true);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    @Value("${strategyAccordAndProjectRecordConf.strategyAccord.cron.weChatUrl}")
    private String gWeChatSendURL;

    /**
     * regularly send the reminder to related person
     */
    @Scheduled(cron = "${strategyAccordAndProjectRecordConf.strategyAccord.cron.str}")
    private void regularSendWechatMessage() {
        try {
            StrategyAccordMainInput mStrategyAccordMainInput = new StrategyAccordMainInput();
            mStrategyAccordMainInput.setValidAccordEndTime(DateTool.formatIso8601Day(new Date()));
            List<StrategyAccord> mListStrategyAccord = gIStrategyAccordMapper.selectByCondition(mStrategyAccordMainInput);
            //the rule of send prompt!
            List<Integer> mConditionDays = new ArrayList<Integer>() {
                {
                    add(0);
                    add(-30);
                    add(-60);
                    add(-90);
                }
            };
            for (StrategyAccord fStrategyAccord : mListStrategyAccord) {
                // boolean fIsContinue = false;
                for (Integer ffDays : mConditionDays) {
                    if (!"NIL".equals(fStrategyAccord.getValidAccordEndTime().trim())) {
                        String fValidAccordEndTime = fStrategyAccord.getValidAccordEndTime().trim().length() <= 10 ? fStrategyAccord.getValidAccordEndTime().trim() + " 00:00:01" : fStrategyAccord.getValidAccordEndTime().trim();
                        if (DateTool.formatIso8601Day(DateTool.plusDate(DateTool.parseStandardDatetime(fValidAccordEndTime), ffDays)).equals(DateTool.formatIso8601Day(new Date()))) {
                            sendWevhatMessage(fStrategyAccord);
                            //fIsContinue = true;
                        }
                    }
                }

//                if (fIsContinue) {
//                    fIsContinue = false;
//                    continue;
//                }
                //the creation notice is not be needed , remove the code. 2019-03-01
//                if (fStrategyAccord.getInformStatus().equals(new BigDecimal(0))) {
//                    sendWevhatMessage(fStrategyAccord);
//                }
            }
        } catch (Exception ex) {
            gLog.error(ex);
        }
    }

    private void sendWevhatMessage(StrategyAccord pStrategyAccord) throws Exception {
        List<String> mReturnIsSuccessList = new ArrayList<>();
        String mContent = pStrategyAccord.getCompanyName() + "\n战略协议即将在" + pStrategyAccord.getValidAccordEndTime() + "结束";
        if (pStrategyAccord.getInformStuffOneNumber().equals("")) {
            mReturnIsSuccessList.add("1");
        } else {
            Object fiSendResult = HttpTool.sendGet(gWeChatSendURL, "content=" + URLEncoder.encode(mContent, "utf-8") + "&touser=" + pStrategyAccord.getInformStuffOneNumber());
            JSONObject fiSendResltJson = JSONObject.fromObject(fiSendResult);
            WechatInformLog fiWechatInformLog = new WechatInformLog();
            fiWechatInformLog.setId(String.valueOf(UUID.randomUUID()).replace("-", "") + "-" + pStrategyAccord.getInformStuffOneNumber());
            fiWechatInformLog.setMessage(String.valueOf(fiSendResult));
            fiWechatInformLog.setRelativeId(pStrategyAccord.getId());
            gWechatInformLogMapper.insertSelective(fiWechatInformLog);
            if ("1".equals(String.valueOf(fiSendResltJson.get("resultCode")))) {
                mReturnIsSuccessList.add("1");
            } else {
                mReturnIsSuccessList.add("0");
            }
        }
        Object fiSendResult0 = HttpTool.sendGet(gWeChatSendURL, "content=" + URLEncoder.encode(mContent, "utf-8") + "&touser=" + pStrategyAccord.getSupervisorsNumber());
        JSONObject fiSendResltJson0 = JSONObject.fromObject(fiSendResult0);
        WechatInformLog fiWechatInformLog0 = new WechatInformLog();
        fiWechatInformLog0.setId(String.valueOf(UUID.randomUUID()).replace("-", "") + "-" + pStrategyAccord.getSupervisorsNumber());
        fiWechatInformLog0.setMessage(String.valueOf(fiSendResult0));
        fiWechatInformLog0.setRelativeId(pStrategyAccord.getId());
        gWechatInformLogMapper.insertSelective(fiWechatInformLog0);
        if ("1".equals(String.valueOf(fiSendResltJson0.get("resultCode")))) {
            mReturnIsSuccessList.add("1");
        } else {
            mReturnIsSuccessList.add("0");
        }
        Object fiSendResult1 = HttpTool.sendGet(gWeChatSendURL, "content=" + URLEncoder.encode(mContent, "utf-8") + "&touser=" + pStrategyAccord.getInformStuffTwoNumber());
        JSONObject fiSendResltJson1 = JSONObject.fromObject(fiSendResult1);
        WechatInformLog fiWechatInformLog1 = new WechatInformLog();
        fiWechatInformLog1.setId(String.valueOf(UUID.randomUUID()).replace("-", "") + "-" + pStrategyAccord.getInformStuffTwoNumber());
        fiWechatInformLog1.setMessage(String.valueOf(fiSendResult1));
        fiWechatInformLog1.setRelativeId(pStrategyAccord.getId());
        gWechatInformLogMapper.insertSelective(fiWechatInformLog1);
        if ("1".equals(String.valueOf(fiSendResltJson1.get("resultCode")))) {
            mReturnIsSuccessList.add("1");
        } else {
            mReturnIsSuccessList.add("0");
        }
        Object fiSendResult2 = HttpTool.sendGet(gWeChatSendURL, "content=" + URLEncoder.encode(mContent, "utf-8") + "&touser=" + pStrategyAccord.getSubmiterNumber());
        JSONObject fiSendResltJson2 = JSONObject.fromObject(fiSendResult2);
        WechatInformLog fiWechatInformLog2 = new WechatInformLog();
        fiWechatInformLog2.setId(String.valueOf(UUID.randomUUID()).replace("-", "") + "-" + pStrategyAccord.getSubmiterNumber());
        fiWechatInformLog2.setMessage(String.valueOf(fiSendResult2));
        fiWechatInformLog2.setRelativeId(pStrategyAccord.getId());
        gWechatInformLogMapper.insertSelective(fiWechatInformLog2);
        if ("1".equals(String.valueOf(fiSendResltJson2.get("resultCode")))) {
            mReturnIsSuccessList.add("1");
        } else {
            mReturnIsSuccessList.add("0");
        }
        boolean mIsSuccess = true;
        for (String fReturnValue : mReturnIsSuccessList) {
            if ("0".equals(fReturnValue)) {
                mIsSuccess = false;
            }
        }
        StrategyAccord fiStrategyAccord = new StrategyAccord();

        fiStrategyAccord.setId(pStrategyAccord.getId());

        if (mIsSuccess) {
            fiStrategyAccord.setInformStatus(BigDecimal.valueOf(1));
        } else {
            fiStrategyAccord.setInformStatus(BigDecimal.valueOf(0));
        }
        //log the send status!
        gStrategyAccordMapper.updateByPrimaryKeySelective(fiStrategyAccord);
    }

    /**
     * export the excel
     *
     * @param response
     * @param informStuff
     * @param companyName
     * @param oaId
     * @param informStatus
     * @param searchStartDate
     * @param searchEndDate
     */
    public void exportExcel(HttpServletResponse response, ServletRequest servletRequest, String informStuff, String companyName, String oaId, BigDecimal informStatus,
                            String searchStartDate, String searchEndDate) {
        try {
            StrategyAccordMainInput mStrategyAccordMainInput = new StrategyAccordMainInput();
            mStrategyAccordMainInput.setInformStuff(informStuff);
            mStrategyAccordMainInput.setCompanyName(companyName);
            mStrategyAccordMainInput.setOaId(oaId);
            mStrategyAccordMainInput.setInformStatus(informStatus);
            mStrategyAccordMainInput.setSearchStartDate(searchStartDate);
            mStrategyAccordMainInput.setSearchEndDate(searchEndDate);
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            HttpSession session = req.getSession(true);
            BaseOutUser mBaseOutUser = (BaseOutUser) session.getAttribute("userInfo");

            mStrategyAccordMainInput.setSubmiterNumber(mBaseOutUser.getWorkId());
            PageHelper.startPage(1, 9999);
            List<StrategyAccord> mRvalue = gIStrategyAccordMapper.selectByCondition(mStrategyAccordMainInput);
            handleExportExcel(response, mRvalue);
        } catch (Exception ex) {
            gLog.error("合理化建议导出出错：", ex);
        }
    }

    private void handleExportExcel(HttpServletResponse response, List<StrategyAccord> pRvalue) throws Exception {
        ExcelData data = new ExcelData();
        data.setName("营销优化");
        List<String> titles = new ArrayList();
        titles.add("战略客户名称");
        titles.add("客户简称");
        titles.add("地区");
        titles.add("排名");
        titles.add("负责人");
        titles.add("最早合作年份");
        titles.add("协议开始时间");
        titles.add("协议结束时间");
        titles.add("合作范围");
        titles.add("合作模式");
        titles.add("相关领导");
        titles.add("入围品牌");
        titles.add("通知状态");
        titles.add("OA编号");
        data.setTitles(titles);
        List<List<Object>> rows = new ArrayList();
        for (StrategyAccord fStrategyAccord : pRvalue) {
            List<Object> row = new ArrayList();
            row.add(fStrategyAccord.getCompanyName());
            row.add(fStrategyAccord.getClientAbbreviation());
            row.add(fStrategyAccord.getDistrict());
            row.add(fStrategyAccord.getRankings());
            row.add(fStrategyAccord.getInformStuff() + "(" + fStrategyAccord.getInformStuffOneNumber() + ")," + fStrategyAccord.getInformStuffTwoName() + "(" + fStrategyAccord.getInformStuffTwoNumber() + ")");
            row.add(fStrategyAccord.getFirstCoorperationTime());
            row.add(fStrategyAccord.getValidAccordStartTime());
            row.add(fStrategyAccord.getValidAccordEndTime());
            row.add(fStrategyAccord.getCoorperationRange());
            row.add(fStrategyAccord.getCoorperationPattern());
            row.add(fStrategyAccord.getSupervisorsName() + "(" + fStrategyAccord.getSupervisorsNumber() + ")");
            row.add(fStrategyAccord.getQualifiedBrand());
            row.add(fStrategyAccord.getInformStatus());
            row.add(fStrategyAccord.getOaId());
            rows.add(row);
        }
        data.setRows(rows);
        //生成本地
            /*File f = new File("c:/test.xlsx");
            FileOutputStream out = new FileOutputStream(f);
            ExportExcelUtils.exportExcel(data, out);
            out.close();*/
        SimpleDateFormat fdate = new SimpleDateFormat("yyyy-MM-dd");
        String fileName = "营销优化-" + fdate.format(new Date()) + ".xls";
        ExcelUtils.exportExcel(response, fileName, data);
    }

}
