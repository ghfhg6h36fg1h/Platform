package com.liangxin.platform.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liangxin.platform.common.entity.advise.generate.pt.New_Integral;
import com.liangxin.platform.common.entity.advise.generate.pt.New_IntegralDetail;
import com.liangxin.platform.common.entity.advise.inputParam.proposal.ChangeMoneyInput;
import com.liangxin.platform.common.entity.advise.inputParam.proposal.ListOAInput;
import com.liangxin.platform.common.entity.advise.outputResult.New_proposal.IntegralListOutResult;
import com.liangxin.platform.common.entity.advise.outputResult.New_proposal.New_ListOutResult;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.common.tools.HttpTool;
import com.liangxin.platform.common.tools.excel.ExcelData;
import com.liangxin.platform.common.tools.excel.ExcelUtils;
import com.liangxin.platform.mapper.advise.INew_IntegralMapper;
import com.liangxin.platform.mapper.advise.generate.pt.New_IntegralDetailMapper;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Enzo Cotter on 2019-3-13.
 */
@Service
public class New_IntegralService {

    @Autowired
    private INew_IntegralMapper mIntegralMapper;
    @Autowired
    private New_IntegralDetailMapper integralDetailMapper;
    private final Logger gLog = LogManager.getLogger(New_IntegralService.class);

    /**
     * 积分首页 Top数据和List数据
     */
    public OutResult IntegralHome(String empno) {
        OutResult mOutResult = new OutResult();
        try {
            List list = new ArrayList();
            New_Integral topData = mIntegralMapper.getTopData(empno);
            list.add(topData);
            List<IntegralListOutResult> IntegralList = mIntegralMapper.getListData(empno);
            list.add(IntegralList);

            mOutResult.setCode(0);
            mOutResult.setMsg("成功！");
            mOutResult.setData(list);
            mOutResult.setIsSuccess(true);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    /**
     * 获取Top数据
     */
    public OutResult IntegralTop(String empno) {
        OutResult mOutResult = new OutResult();
        try {
            List list = new ArrayList();
            New_Integral topData = mIntegralMapper.getTopData(empno);
            list.add(topData);
            mOutResult.setCode(0);
            mOutResult.setMsg("成功！");
            mOutResult.setData(list);
            mOutResult.setIsSuccess(true);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    /**
     * 积分换钱
     */
    public OutResult ChangeMoney(ChangeMoneyInput changeMoneyInput) {
        OutResult mOutResult = new OutResult();
        try {
            New_IntegralDetail new_integralDetail = new New_IntegralDetail();
            new_integralDetail.setEmpno(changeMoneyInput.getEmpno());
            new_integralDetail.setMoney(changeMoneyInput.getMoney());
            new_integralDetail.setStatus("0");
            //第二重校验
            New_Integral topData = mIntegralMapper.getTopData(changeMoneyInput.getEmpno());
            if (topData.getUseIntegral() < changeMoneyInput.getMoney()) {
                mOutResult.setCode(1);
                mOutResult.setMsg("兑换失败！");
                mOutResult.setIsSuccess(false);
            } else {
                integralDetailMapper.insertSelective(new_integralDetail);
                mIntegralMapper.ChangeIntegral(changeMoneyInput);
                gLog.info(changeMoneyInput.getEmpno()+"成功换取"+changeMoneyInput.getMoney()+"元");
                mOutResult.setCode(0);
                mOutResult.setMsg("成功！");
                mOutResult.setIsSuccess(true);
            }

        } catch (Exception ex) {
            gLog.error(changeMoneyInput.getEmpno()+"换取失败"+changeMoneyInput.getMoney()+"元");

            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    /**
     * 积分兑换详情
     */
    public OutResult IntegralDetail(int id) {
        OutResult mOutResult = new OutResult();
        try {
            New_IntegralDetail new_integralDetail = integralDetailMapper.selectByPrimaryKey(id);
            List<New_IntegralDetail> list = new ArrayList<>();
            list.add(new_integralDetail);
            mOutResult.setCode(0);
            mOutResult.setMsg("成功！");
            mOutResult.setData(list);
            mOutResult.setIsSuccess(true);

        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    /** 确认领取金额 */
    public OutResult GetMoney(New_IntegralDetail new_integralDetail) {
        OutResult mOutResult = new OutResult();
        try {
            integralDetailMapper.updateByPrimaryKeySelective(new_integralDetail);

            mOutResult.setCode(0);
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

/** Web 积分详情列表 姓名维度*/
    public OutResult getWebIntegralList(ListOAInput listOAInput) {
        OutResult mOutResult = new OutResult();
        try {
            PageHelper.startPage(listOAInput.getCurrentPage(), listOAInput.getPageSize(), true);
            List<IntegralListOutResult> new_integralDetails = mIntegralMapper.getWebIntegralList(listOAInput);
            PageInfo<IntegralListOutResult> pageInfo = new PageInfo<>(new_integralDetails);
            mOutResult.setTotalCount(pageInfo.getTotal());
            mOutResult.setCode(0);
            mOutResult.setMsg("成功！");
            mOutResult.setData(new_integralDetails);
            mOutResult.setIsSuccess(true);

        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }
/** Web 兑换管理-改变状态*/
    public OutResult WebChangeState(String state) {
        OutResult mOutResult = new OutResult();
        try {
            if (state.equals("1")) {
                List<IntegralListOutResult> new_integralDetails = mIntegralMapper.getWebIntegralListByState("1");
                if (new_integralDetails.size() != 0) {
                    mOutResult.setIsSuccess(false);
                    mOutResult.setCode(1);
                    mOutResult.setMsg("系统查询到有未完成的'已汇总OA申请'");
                } else {
                    //先拿到当前状态list 遍历推送
                    List<IntegralListOutResult> pushList = mIntegralMapper.getWebIntegralListByState("0");

                    if (mIntegralMapper.updateWebIntegralListByState("1") > 0) {
                        mOutResult.setIsSuccess(true);
                        mOutResult.setCode(0);
                        mOutResult.setMsg("更新已汇总状态成功");
                        gLog.info("0-1 批量更新成功");
                        IntegralPush(pushList, "0");  //更新成功再推送
                    } else {
                        mOutResult.setIsSuccess(true);
                        mOutResult.setCode(0);
                        mOutResult.setMsg("无数据更新");
                    }
                }
            }
            if (state.equals("2")) {
                //先拿到当前状态list 遍历推送
                List<IntegralListOutResult> pushList = mIntegralMapper.getWebIntegralListByState("1");

                if (mIntegralMapper.updateWebIntegralListByState("2") > 0) {
                    mOutResult.setIsSuccess(true);
                    mOutResult.setCode(0);
                    mOutResult.setMsg("更新已发放状态成功");
                    gLog.info("1-2 批量更新成功");
                    IntegralPush(pushList, "1");

                } else {
                    mOutResult.setIsSuccess(true);
                    mOutResult.setCode(0);
                    mOutResult.setMsg("无数据更新");
                }
            }

        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error("批量更新状态失败"+ex.getMessage());
        }
        return mOutResult;
    }
/** Web 根据姓名/工号 搜索积分详情*/
    public OutResult getWebIntegralListByName(ListOAInput listOAInput) {
        OutResult mOutResult = new OutResult();
        try {
            PageHelper.startPage(listOAInput.getCurrentPage(), listOAInput.getPageSize(), true);
            List<IntegralListOutResult> new_integralDetails = mIntegralMapper.getWebIntegralListByName(listOAInput);
            PageInfo<IntegralListOutResult> pageInfo = new PageInfo<>(new_integralDetails);
            mOutResult.setTotalCount(pageInfo.getTotal());
            mOutResult.setCode(0);
            mOutResult.setMsg("成功！");
            mOutResult.setData(new_integralDetails);
            mOutResult.setIsSuccess(true);

        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }
    /** Web 根据姓名/工号 搜索积分兑换历史*/
    public OutResult getWebIntegralListByEmpno(ListOAInput listOAInput) {
        OutResult mOutResult = new OutResult();
        try {
            PageHelper.startPage(listOAInput.getCurrentPage(), listOAInput.getPageSize(), true);
            List<IntegralListOutResult> new_integralDetails = mIntegralMapper.getWebIntegralListByEmpno(listOAInput);
            PageInfo<IntegralListOutResult> pageInfo = new PageInfo<>(new_integralDetails);
            mOutResult.setTotalCount(pageInfo.getTotal());
            mOutResult.setCode(0);
            mOutResult.setMsg("成功！");
            mOutResult.setData(new_integralDetails);
            mOutResult.setIsSuccess(true);

        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }
/** 积分导出*/
    public void Integralexcel(HttpServletResponse response) {
        try {
            ListOAInput listOAInput = new ListOAInput();
            listOAInput.setKeyword("");
            PageHelper.startPage(1, 9999);
            List<IntegralListOutResult> new_integralDetails = mIntegralMapper.getWebIntegralListByName(listOAInput);
            handleExportExcel(response, new_integralDetails);

        } catch (Exception ex) {
            gLog.error("合理化建议导出出错：", ex);
        }
    }
/** 积分导出赋值*/
    private void handleExportExcel(HttpServletResponse response, List<IntegralListOutResult> pRvalue) throws Exception {
        ExcelData data = new ExcelData();
        data.setName("积分数据");
        List<String> titles = new ArrayList();
        titles.add("姓名（工号）");
        titles.add("部门");
        titles.add("总奖励积分");
        titles.add("积分结余");
        data.setTitles(titles);
        List<List<Object>> rows = new ArrayList();
        for (IntegralListOutResult fListOutResult : pRvalue) {
            List<Object> row = new ArrayList();
            row.add(fListOutResult.getName());
            row.add(fListOutResult.getDepart());
            row.add(fListOutResult.getIntegralsum());
            row.add(fListOutResult.getUseIntegral());
            rows.add(row);
        }
        data.setRows(rows);

        SimpleDateFormat fdate = new SimpleDateFormat("yyyy-MM-dd");
        String fileName = "积分数据-" + fdate.format(new Date()) + ".xls";
        ExcelUtils.exportExcel(response, fileName, data);
    }
/** 根据状态筛选出积分兑换列表*/
    public void IntegralexcelByStatus(HttpServletResponse response, String status) {
        try {
            ListOAInput listOAInput = new ListOAInput();
            listOAInput.setStatus(status);
            PageHelper.startPage(1, 9999);
            List<IntegralListOutResult> new_integralDetails = mIntegralMapper.getWebIntegralList(listOAInput);
            handleExportExcelByStatus(response, new_integralDetails);

        } catch (Exception ex) {
            gLog.error( ex);
        }
    }
/** 根据状态导出积分兑换列表*/
    private void handleExportExcelByStatus(HttpServletResponse response, List<IntegralListOutResult> pRvalue) throws Exception {
        ExcelData data = new ExcelData();
        data.setName("积分数据");
        List<String> titles = new ArrayList();
        titles.add("姓名（工号）");
        titles.add("部门");
        titles.add("申请日期");
        titles.add("金额");
        data.setTitles(titles);
        List<List<Object>> rows = new ArrayList();
        for (IntegralListOutResult fListOutResult : pRvalue) {
            List<Object> row = new ArrayList();
            row.add(fListOutResult.getName());
            row.add(fListOutResult.getDepart());
            row.add(fListOutResult.getApplyDate());
            row.add(fListOutResult.getMoney());
            rows.add(row);
        }
        data.setRows(rows);

        SimpleDateFormat fdate = new SimpleDateFormat("yyyy-MM-dd");
        String fileName = "积分状态数据-状态" + pRvalue.get(0).getState() + "- " + fdate.format(new Date()) + ".xls";
        ExcelUtils.exportExcel(response, fileName, data);
    }


    //推送相关------------------------------------------------------
    @Value("${message.getToken.url}")
    private String gGetMessageTokenUrl;
    @Value("${message.getToken.appId}")
    private String gGetMessageTokenAppId;
    @Value("${message.getToken.corpId}")
    private String gGetMessageTokenCorpId;
    @Value("${message.getToken.corpSecret}")
    private String gGetMessageTokenCorpSecret;

/** 积分推送*/
    private void IntegralPush(List<IntegralListOutResult> pushList, String type) {
        String content;
        String pWorkId = "";

        if (type.equals("0"))
            for (IntegralListOutResult integral : pushList) {
                pWorkId = integral.getEmpno();
                content = "您好：\n" +
                        "您于" + integral.getApplyDate().substring(0, 20) + "提交的" + integral.getMoney() + "元的积分兑现申请，专员已汇总，等待财务审批，请查看！\n";
                getCoopreateToken(pWorkId, content);
            }
        else
            for (IntegralListOutResult integral : pushList) {
                pWorkId = integral.getEmpno();
                content = "您好：\n" +
                        "您于" + integral.getApplyDate().substring(0, 20) + "提交的" + integral.getMoney() + "元的积分兑现申请已通过，请至合理化专员处领取奖金！\n";
                getCoopreateToken(pWorkId, content);
            }

    }



    private String getCoopreateToken(String pWorkId, String pContent) {
        String mRValue = "";
        String mPara = "corpid=" + gGetMessageTokenCorpId + "&corpsecret=" + gGetMessageTokenCorpSecret + "&appid=" + gGetMessageTokenAppId;
        mRValue = HttpTool.sendGet(gGetMessageTokenUrl, mPara);
        if (mRValue.contains("异常信息")) {
            gLog.error("url:" + gGetMessageTokenUrl + ",para:" + mPara + ",result:" + mRValue);
            return "0";
        }
        JSONObject jsonObject = JSONObject.fromObject(mRValue);
        if (null != jsonObject.get("app_access_token")) {
            mRValue = postMessage(String.valueOf(jsonObject.get("app_access_token")).trim(), pWorkId, pContent);
        } else {
            gLog.error("url:" + gGetMessageTokenUrl + ",para:" + mPara + ",result:" + String.valueOf(jsonObject.get("errmemo")));
            mRValue = "0";
        }
        return mRValue;
    }

    @Value("${message.sendMessageToWorkId.url}")
    private String gSendMessageUrl;


    private String postMessage(String pAccessToken, String pWorkId, String pContent) {
        String mRValue = "";
        String mPara = "app_access_token=" + pAccessToken + "&UserId=" + pWorkId + "&MsgType=text&Type=num&Content=" + pContent + "&CreateTime=" + System.currentTimeMillis();
        mRValue = HttpTool.sendPost(gSendMessageUrl, mPara);
        if (mRValue.contains("异常信息")) {
            gLog.error("url:" + gSendMessageUrl + ",para:" + mPara + ",result:" + mRValue);
            return "0";
        }
        JSONObject jsonObject = JSONObject.fromObject(mRValue);
        if (null != jsonObject.get("msg_status")) {
            mRValue = String.valueOf(jsonObject.get("msg_status"));
        } else {
            gLog.error("url:" + gSendMessageUrl + ",para:" + mPara + ",result:" + String.valueOf(jsonObject.get("errmemo")));
            mRValue = "0";
        }
        return mRValue;
    }


}

