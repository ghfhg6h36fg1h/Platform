package com.liangxin.platform.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liangxin.platform.common.entity.advise.Proposal;

import com.liangxin.platform.common.entity.advise.inputParam.proposal.ListInput;
import com.liangxin.platform.common.entity.advise.inputParam.proposal.ListOAInput;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.common.entity.advise.outputResult.proposal.ListOutResult;
import com.liangxin.platform.common.entity.advise.outputResult.proposal.NaderOAStep;
import com.liangxin.platform.common.entity.advise.outputResult.proposal.ProposalStatisticOut;
import com.liangxin.platform.common.oa.webservice.createFlow.AddReview;
import com.liangxin.platform.common.oa.webservice.createFlow.KmReviewParamterForm;
import com.liangxin.platform.common.oa.webservice.createFlow.SIOACREATEPROCESSOut_HTTPSPort_Client;
import com.liangxin.platform.common.oa.webservice.getFlowDetailByFlowNumber.SIOAGETPROCESSDETAILACCORDINGTOPROCESSNOOut_HTTPSPort_Client;
import com.liangxin.platform.common.oa.webservice.getFlowNumberByFlowId.SIOAGETPROCESSNOACCORDINGTOPROCESSIDOut_HTTPSPort_Client;
import com.liangxin.platform.common.tools.DateTool;
import com.liangxin.platform.common.tools.HttpTool;
import com.liangxin.platform.common.tools.excel.ExcelData;
import com.liangxin.platform.common.tools.excel.ExcelUtils;
import com.liangxin.platform.mapper.advise.IProposalMapper;
import net.sf.json.JSONArray;
import org.apache.ibatis.jdbc.Null;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;

@Service
public class ProposalService {
    private final Logger gLog = LogManager.getLogger(ProposalService.class);
    @Autowired
    private IProposalMapper gProposalMapper;
    @Autowired
    private CapitalService gCapitalService;
    @Autowired
    private ProposalStatusService gProposalStatusService;

    public OutResult getAll(ListInput pListInput) {
        OutResult mOutResult = new OutResult();
        try {
            OutResult mIsCapitalOutResult = gCapitalService.isCapital(pListInput.getPresentWorkId());
            if (mIsCapitalOutResult.getCode() == 0) {
                if (mIsCapitalOutResult.getIsSuccess()) {
                    pListInput.setOwner(null);
                } else {
                    pListInput.setOwner(pListInput.getPresentWorkId());
                    pListInput.setPresentWorkId(null);
                }
                PageHelper.startPage(pListInput.getCurrentPage(), pListInput.getPageSize(), true);
                List<ListOutResult> mRvalue = gProposalMapper.getAll(pListInput);
                PageInfo<ListOutResult> pageInfo = new PageInfo<>(mRvalue);
                mOutResult.setTotalCount(pageInfo.getTotal());
                mOutResult.setCode(0);
                mOutResult.setData(pageInfo.getList());
                mOutResult.setMsg("成功！");
                mOutResult.setIsSuccess(true);
            } else {
                gLog.error("获取提案列表接口，判断是否为班长出错！");
                mOutResult.setIsSuccess(false);
                mOutResult.setCode(1);
                mOutResult.setMsg("判断是否为班长,失败！");
                return mOutResult;
            }
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    /**
     * 增加提案方法
     *
     * @param pProposal
     * @return
     */
    public OutResult addProposal(Proposal pProposal) {
        OutResult mOutResult = new OutResult();
        try {
            String mMessage = "";
            if (gProposalMapper.addProposal(pProposal) > 0) {
                String mSend = getCoopreateToken(pProposal.getCapitalId(), "您好：\n" +
                        "您收到" + pProposal.getOwnerName() + "、工号" + pProposal.getOwner() + "提交的合理化建议提案，\n" +
                        "主题为“" + pProposal.getTheme() + "”，\n" +
                        "请尽快处理，谢谢！");
                mMessage = "成功";
                if ("0".equals(mSend)) {
                    mMessage = "流程创建成功，协同接口调用异常！";
                } else if (!"SEND_SUCCESS".equals(mSend)) {
                    mMessage = "接口提供方未将消息发送至客户端！消息状态：" + mSend;
                }
                mOutResult.setIsSuccess(true);
            } else {
                mMessage = "流程创建成功！数据库更新失败！";
            }
            mOutResult.setMsg(mMessage);
            mOutResult.setCode(0);
        } catch (Exception ex) {
            mOutResult.setCode(1);
            mOutResult.setIsSuccess(false);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    @Value("${message.getToken.url}")
    private String gGetMessageTokenUrl;
    @Value("${message.getToken.appId}")
    private String gGetMessageTokenAppId;
    @Value("${message.getToken.corpId}")
    private String gGetMessageTokenCorpId;
    @Value("${message.getToken.corpSecret}")
    private String gGetMessageTokenCorpSecret;

    /**
     * 调用get接口
     *
     * @return
     */
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

    /**
     * 调用post接口
     *
     * @return
     */
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

    /**
     * 根据ID获取提案详情！
     *
     * @param pId
     * @return
     */
    public OutResult getById(String pId, String pPresentWorkId) {
        OutResult mOutResult = new OutResult();
        try {
            PageHelper.startPage(1, 1);
            List<ListOutResult> mRvalue = gProposalMapper.getById(pId);
            if (mRvalue.size() > 0) {
                if (isHaveRight(pId, pPresentWorkId) == 1 || pPresentWorkId.equals(mRvalue.get(0).getOwner())) {

                    mOutResult.setCode(0);
                    mOutResult.setMsg("success");
                    mOutResult.setIsSuccess(true);
                    mOutResult.setData(mRvalue);

                } else {
                    mOutResult.setIsSuccess(false);
                    mOutResult.setCode(1);
                    mOutResult.setMsg("Permission denied!");
                }
            }
        } catch (Exception ex) {
            mOutResult.setCode(2);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    private String GetMaxStep(JSONArray pJSONArray) throws ParseException {
        String mRvalue = "";
//        String aa = "[{\t\"IdTime\": \"2017-05-09 15:31:31.569\",\t\"TargetName\": \"审批节点\",\t\"Handle\": \"通过\",\t\"Status\": \"30\",\t\"Audit\": \"同意（来自：移动WEB版）\",\t\"ID\": \"N9\",\t\"IdName\": \"审批节点\",\t\"OaName\": \"测试不连续的相同处理人2\",\t\"TargetId\": \"N4\",\t\"Handler\": \"柯晨\"}, {\t\"IdTime\": \"2017-05-09 15:32:11.334\",\t\"TargetName\": \"审批节点\",\t\"Handle\": \"通过\",\t\"Status\": \"30\",\t\"Audit\": \"同意\",\t\"ID\": \"N4\",\t\"IdName\": \"审批节点\",\t\"OaName\": \"测试不连续的相同处理人2\",\t\"TargetId\": \"N10\",\t\"Handler\": \"顾湘海\"}, {\t\"IdTime\": \"2017-05-09 15:31:11.289\",\t\"TargetName\": \"审批节点\",\t\"Handle\": \"sys-lbpmservice-operation-drafter:lbpmOperations.fdOperType.draft.submit\",\t\"Status\": \"30\",\t\"Audit\": null,\t\"ID\": \"N2\",\t\"IdName\": \"起草节点\",\t\"OaName\": \"测试不连续的相同处理人2\",\t\"TargetId\": \"N9\",\t\"Handler\": \"顾湘海\"}, {\t\"IdTime\": \"2017-05-09 15:32:53.641\",\t\"TargetName\": \"结束节点\",\t\"Handle\": \"通过\",\t\"Status\": \"30\",\t\"Audit\": \"同意\",\t\"ID\": \"N10\",\t\"IdName\": \"审批节点\",\t\"OaName\": \"测试不连续的相同处理人2\",\t\"TargetId\": \"N3\",\t\"Handler\": \"柯晨\"}]";
//        JSONArray pJSONArray = JSONArray.fromObject(aa);
        List<Object> mDeleteList = new ArrayList<>();
        for (int i = 0; i < pJSONArray.size(); i++) {
            if ("null" == String.valueOf(JSONObject.fromObject(pJSONArray.get(i)).get("IdTime"))) {
                mDeleteList.add(pJSONArray.get(i));
            }
        }
        for (Object obj : mDeleteList) {
            pJSONArray.remove(obj);
            gLog.info("删除IdTime的流程节点", obj);
        }
        for (int i = 0; i < pJSONArray.size(); i++) {
            for (int j = i + 1; j < pJSONArray.size(); j++) {
                Date mDateI = DateTool.parse(String.valueOf(JSONObject.fromObject(pJSONArray.get(i)).get("IdTime")), DateTool.defaultTimestampFormat());
                Date mDateJ = DateTool.parse(String.valueOf(JSONObject.fromObject(pJSONArray.get(j)).get("IdTime")), DateTool.defaultTimestampFormat());
                if (mDateI.getTime() > mDateJ.getTime()) {
                    Object mTmpJSONObject;
                    mTmpJSONObject = pJSONArray.get(i);
                    pJSONArray.set(i, pJSONArray.get(j));
                    pJSONArray.set(j, mTmpJSONObject);
                }
            }
        }
        if (pJSONArray.size() > 0) {
            mRvalue = String.valueOf(JSONObject.fromObject(pJSONArray.get((pJSONArray.size() - 1))).get("Handle"));
        } else {
            mRvalue = "No illegal data or no flow step!";
        }
        return mRvalue;
    }

    @Value("${oa.certify.userName}")
    private String gOaCertifyUser;
    @Value("${oa.certify.passWord}")
    private String gOaCertifyPassWord;
    @Value("${oa.oaWebServicePath}")
    private String gWsdlBasePath;

    private JSONArray getProposalStep(String pFlowId) {
        JSONArray mRValue = null;
        try {
            SIOAGETPROCESSNOACCORDINGTOPROCESSIDOut_HTTPSPort_Client MSIOAGETPROCESSNOACCORDINGTOPROCESSIDOut_HTTPSPort_Client =
                    new SIOAGETPROCESSNOACCORDINGTOPROCESSIDOut_HTTPSPort_Client();
            String mFlowNumber = MSIOAGETPROCESSNOACCORDINGTOPROCESSIDOut_HTTPSPort_Client.mainProcess(gWsdlBasePath, pFlowId, gOaCertifyUser, gOaCertifyPassWord);
            JSONObject mJSONObject = JSONObject.fromObject(mFlowNumber);
            if (null == mJSONObject.get("OaNumber")) {
                gLog.info("调用获取流程编号接口错误", String.valueOf(mJSONObject.get("message")));
            } else {
                String mNumber = String.valueOf(mJSONObject.get("OaNumber"));
                try {
                    SIOAGETPROCESSDETAILACCORDINGTOPROCESSNOOut_HTTPSPort_Client mSIOAGETPROCESSDETAILACCORDINGTOPROCESSNOOut_HTTPSPort_Client
                            = new SIOAGETPROCESSDETAILACCORDINGTOPROCESSNOOut_HTTPSPort_Client();
                    String mFlowDetail = mSIOAGETPROCESSDETAILACCORDINGTOPROCESSNOOut_HTTPSPort_Client.mainProcess(gWsdlBasePath, mNumber, gOaCertifyUser, gOaCertifyPassWord);
                    JSONArray mStepJSONArray = JSONArray.fromObject(mFlowDetail);
                    if (null != mStepJSONArray && mStepJSONArray.size() > 0) {
                        JSONObject mFirstJObject = JSONObject.fromObject(mStepJSONArray.get(0));
                        if (null != mFirstJObject.get("message")) {
                            gLog.info("调用获取流程信息接口错误", String.valueOf(mJSONObject.get("message")));
                        } else {
                            mRValue = mStepJSONArray;
                        }
                    }
                } catch (Exception ex) {
                    gLog.error("调用获取流程信息接口失败！", ex);
                }
            }
        } catch (Exception ex) {
            gLog.error("调用获取流程编号接口错误", ex);
        }
        return mRValue;
    }

//    private JSONArray getProposalStep(String pFlowId) {
//        JSONArray mRValue = null;
//        try {
//            Object[] mResults = gAxis2Tool.mainProcess(gGetFlowNumberUrl, gGetFlowNumberNameSpace, gGetFlowNumberMethodName, new Object[]{pFlowId});
//            JSONObject mJSONObject = JSONObject.fromObject(mResults[0].getClass().getDeclaredField("data").get(mResults[0]));
//            if (null == mJSONObject.get("OaNumber")) {
//                gLog.info("调用获取流程编号接口错误", String.valueOf(mJSONObject.get("message")));
//            } else {
//                String mNumber = String.valueOf(mJSONObject.get("OaNumber"));
//                try {
//                    Object[] mStepResults = gAxis2Tool.mainProcess(gGetFlowSteplUrl, gGetFlowStepNameSpace, gGetFlowStepMethodName, new Object[]{mNumber});
//                    JSONArray mStepJSONArray = JSONArray.fromObject(mStepResults[0].getClass().getDeclaredField("data").get(mStepResults[0]));
//                    if (null != mStepJSONArray && mStepJSONArray.size() > 0) {
//                        JSONObject mFirstJObject = JSONObject.fromObject(mStepJSONArray.get(0));
//                        if (null != mFirstJObject.get("message")) {
//                            gLog.info("调用获取流程信息接口错误", String.valueOf(mJSONObject.get("message")));
//                        } else {
//                            mRValue = mStepJSONArray;
//                        }
//                    }
//                } catch (Exception ex) {
//                    gLog.error("调用获取流程信息接口失败！", ex);
//                }
//            }
//        } catch (Exception ex) {
//            gLog.error("调用获取流程编号接口错误", ex);
//        }
//        return mRValue;
//    }

    public int isHaveRight(String pId, String pPresentWorkId) {
        int mRvalue = 0;
        if (pPresentWorkId.equals(gProposalMapper.getCapitalIdById(pId))) {
            mRvalue = 1;
        }
        return mRvalue;
    }

    /**
     * 更改记录！
     *
     * @param pProposal
     * @return
     */
    public OutResult update(Proposal pProposal) {
        OutResult mOutResult = new OutResult();
        try {
            if (isHaveRight(pProposal.getId(), pProposal.getCapitalId()) == 1) {
                List<ListOutResult> mListOutResult = gProposalMapper.getById(pProposal.getId());
                if (mListOutResult.size() > 0) {
                    String mStatsName = gProposalStatusService.getNameById(pProposal.getStatus());
                    if (null != pProposal.getStatus() && "1".equals(pProposal.getStatus())) {
                        String mOaProposalId;
                        try {
                            mOaProposalId = createOAProcess(mListOutResult.get(0), pProposal.getCapitalId());//创建流程
                        } catch (Exception ex) {
                            gLog.error("调用创建流程ID 的接口出错！", ex);
                            mOutResult.setCode(1);
                            mOutResult.setMsg("调用创建流程ID 的接口出错！");
                            return mOutResult;
                        }
                        pProposal.setOaProposalId(mOaProposalId);
                    }
                    if (gProposalMapper.update(pProposal) > 0) {
                        getCoopreateToken(mListOutResult.get(0).getOwner(), "您好：\n" +
                                "您提交的主题为“" + mListOutResult.get(0).getTheme() + "”的合理化建议提案，\n" +
                                "已被处理为“" + mStatsName + "”，\n" +
                                "请查看，谢谢！");
                        mOutResult.setIsSuccess(true);
                        mOutResult.setData(null);
                        mOutResult.setMsg("成功！");
                    } else {
                        mOutResult.setIsSuccess(false);
                        gLog.info("数据库中未更新数据", pProposal);
                        mOutResult.setMsg("数据库中未更新数据！");
                    }
                } else {
                    mOutResult.setIsSuccess(false);
                    mOutResult.setMsg("数据库中无此数据！");
                }
            } else {
                mOutResult.setIsSuccess(false);
                mOutResult.setMsg("无权限更改！");
            }
            mOutResult.setCode(0);
        } catch (Exception ex) {
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    public OutResult updateByOwner(Proposal pProposal) {
        OutResult mOutResult = new OutResult();
        try {
            if (gProposalMapper.updateByOwner(pProposal) > 0) {
                getCoopreateToken(pProposal.getCapitalId(), "您好：\n" +
                        "您收到" + pProposal.getOwnerName() + "、工号" + pProposal.getOwner() + "提交的合理化建议提案，\n" +
                        "主题为“" + pProposal.getTheme() + "”，\n" +
                        "请尽快处理，谢谢！");
                mOutResult.setIsSuccess(true);
                mOutResult.setData(null);
                mOutResult.setMsg("成功！");
            } else {
                mOutResult.setIsSuccess(false);
                mOutResult.setMsg("数据库中无此数据！");
            }
            mOutResult.setCode(0);
        } catch (Exception ex) {
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    public OutResult oaUpdate(Proposal pProposal) {
        OutResult mOutResult = new OutResult();
        try {
            List<ListOutResult> mListOutResult = gProposalMapper.getById(pProposal.getId());
            if (mListOutResult.size() > 0) {
                if (gProposalMapper.update(pProposal) > 0) {
                    if (null != pProposal.getStatus() && pProposal.getStatus() != mListOutResult.get(0).getStatus()) {
                        String mStatsName = gProposalStatusService.getNameById(pProposal.getStatus());
                        String mContent = "您好：\n" +
                                "您提交的主题为“" + mListOutResult.get(0).getTheme() + "”的合理化建议提案，\n" +
                                "已被处理为“" + mStatsName + "”，\n" +
                                "请查看，谢谢！";
                        getCoopreateToken(mListOutResult.get(0).getOwner(), mContent);
                        //getCoopreateToken("24307", mContent);
                    }
                    mOutResult.setIsSuccess(true);
                    mOutResult.setData(null);
                    mOutResult.setMsg("成功！");
                } else {
                    mOutResult.setIsSuccess(false);
                    gLog.info("数据库中未更新数据", pProposal);
                    mOutResult.setMsg("数据库中未更新数据！");
                }
            } else {
                mOutResult.setIsSuccess(false);
                mOutResult.setMsg("数据库中无此数据！");
            }
            mOutResult.setCode(1);
        } catch (Exception ex) {
            mOutResult.setCode(0);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    /**
     * 调用webservice
     *
     * @return
     */
    private String createOAProcess(ListOutResult pProposal, String pCapitalId) throws Exception {
        String mRValue = "";
        KmReviewParamterForm mKmReviewParamterForm = createForm(pProposal, pCapitalId);
        AddReview mAddReview = new AddReview();
        mAddReview.setArg0(mKmReviewParamterForm);

        SIOACREATEPROCESSOut_HTTPSPort_Client mSIOACREATEPROCESSOut_HTTPSPort_Client = new SIOACREATEPROCESSOut_HTTPSPort_Client();
        mRValue = mSIOACREATEPROCESSOut_HTTPSPort_Client.mainProcess(gWsdlBasePath, mAddReview, gOaCertifyUser, gOaCertifyPassWord).getReturn();
        return mRValue;
    }

    @Value("${oa.createProposal.node.equalOneNode}")
    private String gEqualOneNode;
    @Value("${oa.createProposal.node.equalTwoNode}")
    private String gEqualTwoNode;
    @Value("${oa.createProposal.node.equalThreeNode}")
    private String gEqualThreeNode;
    @Value("${oa.createProposal.fdTemplateId}")
    private String gFdTemplateId;


    KmReviewParamterForm createForm(ListOutResult pProposal, String pCapitalId) throws Exception {
        String mPresentSituation = "实际提案人：" + pProposal.getOwnerName() + "，工号：" + pProposal.getOwner() + "，部门：" + pProposal.getSectionName() + "，职位：" + pProposal.getOccupation() + "\n";
        mPresentSituation += pProposal.getPresentSituation();
        KmReviewParamterForm form = new KmReviewParamterForm();
        form.setFdTemplateId(gFdTemplateId);
        //form.setFdTemplateId("162ada9159286c15132167e4d29a89fb");
        form.setDocSubject(pProposal.getTheme());
        //form.setDocCreator("{\"LoginName\": \"18902\"}");
        form.setDocCreator("{\"LoginName\": \"" + pCapitalId + "\"}");//创建流程的工号为班长的工号
        String formValues = "{\"fd_326c6fc4e795e2\":\"" +
                mPresentSituation.replace("\n", "\\n") + "\",\"fd_improvement\":\"" +
                pProposal.getContent().replace("\n", "\\n") + "\",\"fd_title\":\"" +
                pProposal.getTheme().replace("\n", "\\n") + "\",\"fd_post\":\"职工\",\"fd_expected_earnings\":\"" +
                pProposal.getMonthInterest() + "\",\"fd_post\":\"职工\",\"fd_type\":\"" + pProposal.getProposalType() + "\"}";
        form.setFormValues(formValues);
        String mCheckCode = "";
        if (pProposal.getProposalType() == 1) {
            mCheckCode = gEqualOneNode;
        } else if (pProposal.getProposalType() == 2) {
            mCheckCode = gEqualTwoNode;
        } else if (pProposal.getProposalType() == 3) {
            mCheckCode = gEqualThreeNode;
        } else {
            mCheckCode = gEqualOneNode;
            gLog.error("前端传入了非法的流程建议type::==>>" + pProposal.getProposalType() + ",审批节点默认为类型为1");
        }
        String flowParam = "{auditNode:\"请审核\", futureNodeId:\"" + mCheckCode + "\"}";
        form.setFlowParam(flowParam);
        form.setDocStatus("20");
        gLog.info(form);
        return form;
    }


    public OutResult getOAAll(ListOAInput pListOAInput) {
        OutResult mOutResult = new OutResult();
        try {
            PageHelper.startPage(pListOAInput.getCurrentPage(), pListOAInput.getPageSize(), true);
            List<ListOutResult> mRvalue = gProposalMapper.getOAAll(pListOAInput);
            PageInfo<ListOutResult> pageInfo = new PageInfo<>(mRvalue);
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

    @Value("${oa.oABaseViewHref}")
    private String gOABaseViewHref;

    public OutResult getOAById(String pId) {
        OutResult mOutResult = new OutResult();
        String mMessage = "";
        try {
            PageHelper.startPage(1, 1);
            List<ListOutResult> mRvalue = gProposalMapper.getById(pId);
            if (mRvalue.size() > 0) {
                if (mRvalue.get(0).getOaProposalId() != null || mRvalue.get(0).getOaProposalId() != "NIL") {
                    String mOAProposalId = mRvalue.get(0).getOaProposalId();
                    mRvalue.get(0).setOaLinkHref(gOABaseViewHref + mOAProposalId);
                }
            }
            mOutResult.setCode(0);
            mOutResult.setMsg("success");
            mOutResult.setIsSuccess(true);
            mOutResult.setData(mRvalue);
        } catch (Exception ex) {
            mOutResult.setCode(2);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    /**
     * getById公共部分
     *
     * @param pRvalue
     * @param pMessage
     * @param pId
     * @param pOutResult
     * @throws ParseException
     */
    private void getByIdPublic(List<ListOutResult> pRvalue, String pMessage, String pId, OutResult pOutResult) throws ParseException {
        if (!"".equals(pRvalue.get(0).getOaProposalId())) {
            JSONArray mStep = getProposalStep(pRvalue.get(0).getOaProposalId());
            if (mStep == null) {
                pRvalue.get(0).setStep("");
                pMessage += "fail when invoke the interface of flow step！";
            } else {
                String mLatestStep = GetMaxStep(mStep);
                pRvalue.get(0).setFlowSteps(String.valueOf(mStep));
                Proposal mUpdateStepProposal = new Proposal();
                mUpdateStepProposal.setId(pId);
                mUpdateStepProposal.setOaStep(mLatestStep);
                pRvalue.get(0).setStep(mLatestStep);
                gProposalMapper.update(mUpdateStepProposal);
                if (gProposalMapper.update(mUpdateStepProposal) < 1) {
                    pMessage += " but update finalStep is fail！";
                }
            }
        }
        pOutResult.setIsSuccess(true);
        pOutResult.setCode(0);
        pOutResult.setData(pRvalue);
        pOutResult.setMsg("getById success!" + pMessage);
    }


    public OutResult getNaderOAStepByOaProposalId(String pProposalId, String pOaProposalId) {
        OutResult mOutResult = new OutResult();
        String mMessage = "";
        NaderOAStep mNaderOAStep = new NaderOAStep();
        List<NaderOAStep> mNaderOAStepList = new ArrayList<>();
        try {
            JSONArray mStep = getProposalStep(pOaProposalId);
            if (mStep == null) {
                mNaderOAStep.setStep("");
                mMessage += "fail when invoke the interface of flow step！";
            } else {
                mNaderOAStep.setFlowSteps(String.valueOf(mStep));
                String mLatestStep = GetMaxStep(mStep);
                mNaderOAStep.setStep(mLatestStep);
                mNaderOAStepList.add(mNaderOAStep);
                Proposal mUpdateStepProposal = new Proposal();
                mUpdateStepProposal.setId(pProposalId);
                mUpdateStepProposal.setOaStep(mLatestStep);
                gProposalMapper.update(mUpdateStepProposal);
                if (gProposalMapper.update(mUpdateStepProposal) < 1) {
                    mMessage += " but update finalStep is fail！";
                }
            }
            mOutResult.setIsSuccess(true);
            mOutResult.setCode(0);
            mOutResult.setData(mNaderOAStepList);
            mOutResult.setMsg("getNaderOAStepByOaProposalId success!" + mMessage);
        } catch (Exception ex) {
            mOutResult.setCode(2);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    public OutResult getStatisticProposal(ListOAInput pListOAInput) {
        OutResult mOutResult = new OutResult();
        try {
            List<ProposalStatisticOut> mMapList = gProposalMapper.getStatisticProposal(pListOAInput);

         //   ProposalStatisticOut mProposalStatisticOut = gProposalMapper.getStatisticProposal(pListOAInput);
          //  mMapList.add(mProposalStatisticOut);
            mOutResult.setCode(0);
            mOutResult.setData(mMapList);
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

    public void exportExcel(HttpServletResponse response, String ownerName, String capitalName, String theme, String status,
                            String searchStartDate, String searchEndDate) {
        try {
            Date mSearchStartDate=DateTool.parseTimestampFromFormats(searchStartDate);
            Date mSearchEndDate=DateTool.parseTimestampFromFormats(searchEndDate);
            ListOAInput mListOAInput = new ListOAInput();
            mListOAInput.setOwnerName(ownerName);
            mListOAInput.setCapitalName(capitalName);
            mListOAInput.setTheme(theme);
            mListOAInput.setStatus(status);
            mListOAInput.setSearchStartDate(mSearchStartDate);
            mListOAInput.setSearchEndDate(mSearchEndDate);
            PageHelper.startPage(1, 9999);
            List<ListOutResult> mRvalue = gProposalMapper.getOAAll(mListOAInput);
            handleExportExcel(response, mRvalue);
        } catch (Exception ex) {
            gLog.error("合理化建议导出出错：", ex);
        }
    }

    private void handleExportExcel(HttpServletResponse response, List<ListOutResult> pRvalue) throws Exception {
        ExcelData data = new ExcelData();
        data.setName("合理化建议数据");
        List<String> titles = new ArrayList();
        titles.add("主题");
        titles.add("提案人（工号）");
        titles.add("班长（工号）");
        titles.add("审批状态");
        titles.add("部门");
        titles.add("职位");
        titles.add("OA流程编号");
        data.setTitles(titles);
        List<List<Object>> rows = new ArrayList();
        for (ListOutResult fListOutResult : pRvalue) {
            List<Object> row = new ArrayList();
            row.add(fListOutResult.getTheme());
            row.add(fListOutResult.getOwnerName() + "(" + fListOutResult.getOwner() + ")");
            row.add(fListOutResult.getCapital() + "(" + fListOutResult.getCapitalId() + ")");
            row.add(fListOutResult.getStatus());
            row.add(fListOutResult.getSectionName());
            row.add(fListOutResult.getOccupation());
            row.add(fListOutResult.getOaProposalId());
            rows.add(row);
        }
        data.setRows(rows);
        //生成本地
            /*File f = new File("c:/test.xlsx");
            FileOutputStream out = new FileOutputStream(f);
            ExportExcelUtils.exportExcel(data, out);
            out.close();*/
        SimpleDateFormat fdate = new SimpleDateFormat("yyyy-MM-dd");
        String fileName = "合理化建议数据-" + fdate.format(new Date()) + ".xls";
        ExcelUtils.exportExcel(response, fileName, data);
    }
}