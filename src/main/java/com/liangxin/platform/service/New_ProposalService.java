package com.liangxin.platform.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liangxin.platform.common.entity.advise.generate.pt.New_Integral;
import com.liangxin.platform.common.entity.advise.generate.pt.New_PROPOSAL;
import com.liangxin.platform.common.entity.advise.inputParam.proposal.ListInput;
import com.liangxin.platform.common.entity.advise.inputParam.proposal.ListOAInput;
import com.liangxin.platform.common.entity.advise.outputResult.New_proposal.*;

import com.liangxin.platform.common.entity.advise.outputResult.OutResult;

import com.liangxin.platform.common.entity.advise.outputResult.proposal.ListOutResult;
import com.liangxin.platform.common.entity.advise.outputResult.proposal.ProposalStatisticOut;
import com.liangxin.platform.common.entity.tax.outputParam.IsUpload;
import com.liangxin.platform.common.entity.tax.outputParam.IsUploadThumb;
import com.liangxin.platform.common.oa.webservice.createFlow.AddReview;
import com.liangxin.platform.common.oa.webservice.createFlow.AttachmentForm;
import com.liangxin.platform.common.oa.webservice.createFlow.KmReviewParamterForm;
import com.liangxin.platform.common.oa.webservice.createFlow.SIOACREATEPROCESSOut_HTTPSPort_Client;
import com.liangxin.platform.common.tools.DateTool;
import com.liangxin.platform.common.tools.FileTool;

import com.liangxin.platform.common.tools.HttpTool;
import com.liangxin.platform.common.tools.excel.ExcelData;
import com.liangxin.platform.common.tools.excel.ExcelUtils;
import com.liangxin.platform.mapper.advise.INew_IntegralMapper;
import com.liangxin.platform.mapper.advise.INew_ProposalMapper;

import com.liangxin.platform.mapper.advise.generate.pt.New_IntegralMapper;
import com.liangxin.platform.mapper.advise.generate.pt.New_PROPOSALMapper;

import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.formula.functions.Rank;
import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 提案相关
 *
 * @author TT
 * @date 2019-4-12
 */
@Service
public class New_ProposalService {
    private final Logger gLog = LogManager.getLogger(New_ProposalService.class);

    @Autowired
    private INew_ProposalMapper ProposalMapper;

    @Autowired
    private New_PROPOSALMapper new_proposalMapper;

    @Autowired
    private INew_IntegralMapper inew_integralMapper;

    @Autowired
    private New_IntegralMapper new_integralMapper;


    @Value("${UploadAdvicePath}")
    private String path;
    @Value("${UploadAdviceReadPath}")
    private String Readpath;

    @Value("${FakePath}")
    private String fakePath;

    String StartTime;
    String EndTime;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

    /**
     * APP首页年度总数据
     */
    public OutResult getSumData(String StartTime, String EndTime) {
        OutResult mOutResult = new OutResult();
        int AlluserNum;//总实施数
        int allProposal;//总提案数
        int allbenefit;//总收益

        try {
            List<AllSumOutResult> AllSum = ProposalMapper.getSumData(StartTime, EndTime);
            AlluserNum = ProposalMapper.getUserNum(StartTime, EndTime);
            AllSum.get(0).setAllUse(AlluserNum);
            allProposal = AllSum.get(0).getAllProposal();
            //计算实施率
            double useP = 0;
            if (allProposal != 0)
                useP = (double) AlluserNum / (double) allProposal * 100;
            else
                useP = (double) AlluserNum / 1 * 100;

            BigDecimal bg = new BigDecimal(useP).setScale(1, RoundingMode.UP);
            useP = bg.doubleValue();

            AllSum.get(0).setUserful(useP);

            mOutResult.setCode(0);
            mOutResult.setMsg("成功！");
            mOutResult.setData(AllSum);
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
     * APP首页个人年度数据
     */
    public OutResult getPersonSumData(String empno) {
        int AlluserNum;//总实施数
        OutResult mOutResult = new OutResult();
        sdf = new SimpleDateFormat("yyyy");
        String year = sdf.format(new Date());
        StartTime = year + "-01-01";
        EndTime = year + "-12-31";
        try {
            List<AllSumOutResult> PersonSumData = new ArrayList<>();
            gLog.info("记录测试获取个人信息 工号：" + empno + "" + "StartTime:" + StartTime + "EndTime:" + EndTime);
            PersonSumData.add(ProposalMapper.getPersonData(empno, StartTime, EndTime).get(0));
            AlluserNum = ProposalMapper.getPersonUserNum(empno, StartTime, EndTime);

            //计算实施率
            double useP = 0;

            if (PersonSumData.get(0).getAllProposal() != 0)
                useP = (double) AlluserNum / (double) PersonSumData.get(0).getAllProposal() * 100;
            else
                useP = (double) AlluserNum / 1 * 100;

            BigDecimal bg = new BigDecimal(useP).setScale(1, RoundingMode.UP);
            useP = bg.doubleValue();
            PersonSumData.get(0).setUserful(useP);

            mOutResult.setCode(0);
            mOutResult.setMsg("成功！");
            mOutResult.setData(PersonSumData);
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
     * 个人/班组-年度/月的 提案排行
     */
    public OutResult ClaRanking(String Ptype, String Ttype) {
        OutResult mOutResult = new OutResult();
        if (Ttype.equals("year")) {
            sdf = new SimpleDateFormat("yyyy");
            String year = sdf.format(new Date());
            StartTime = year + "-01-01";
            EndTime = year + "-12-31";
        } else {
            sdf = new SimpleDateFormat("yyyy-MM");
            String YM = sdf.format(new Date());
            StartTime = YM + "-01";
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            EndTime = sdf.format(new Date());
        }

        try {
            List<RankOutResult> RankList;
            if (Ptype.equals("cla"))
                RankList = ProposalMapper.getClaRank(StartTime, EndTime);
            else
                RankList = ProposalMapper.getPerRank(StartTime, EndTime);

            mOutResult.setCode(0);
            mOutResult.setMsg("成功！");
            mOutResult.setData(RankList);
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
     * APP职工+职员 提案查询
     */
    public OutResult NewGetAll(ListInput listInput) {
        OutResult mOutResult = new OutResult();
        try {

            if (listInput.getPresentWorkId() == "")
                listInput.setPresentWorkId(null);
            else
                listInput.setOwner(null);

            PageHelper.startPage(listInput.getCurrentPage(), listInput.getPageSize(), true);
            List<New_ListOutResult> mRvalue = ProposalMapper.NewGetAll(listInput);
            PageInfo<New_ListOutResult> pageInfo = new PageInfo<>(mRvalue);
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

    /**
     * APP优秀提案列表查询
     */
    public OutResult NewGetAllGood(ListInput listInput) {
        OutResult mOutResult = new OutResult();
        try {

            PageHelper.startPage(listInput.getCurrentPage(), listInput.getPageSize(), true);
            List<New_ListOutResult> mRvalue = ProposalMapper.NewGetAllGood(listInput);
            PageInfo<New_ListOutResult> pageInfo = new PageInfo<>(mRvalue);
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

    /**
     * Web 获取提案列表
     */
    public OutResult getWebAll(ListOAInput pListOAInput) {
        OutResult mOutResult = new OutResult();
        try {
            PageHelper.startPage(pListOAInput.getCurrentPage(), pListOAInput.getPageSize(), true);
            List<New_ListOutResult> mRvalue = ProposalMapper.getWebAll(pListOAInput);
            PageInfo<New_ListOutResult> pageInfo = new PageInfo<>(mRvalue);
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

    /**
     * 获取个人部门 上级领导信息
     */
    public OutResult GetInfo(String empno) {
        OutResult mOutResult = new OutResult();
        try {
            List<PersonInfoOutResult> mRvalue = ProposalMapper.GetInfo(empno);

            String depart = ProposalMapper.GetDepart(empno);
            mRvalue.get(0).setDepart(depart);
            mOutResult.setCode(0);
            mOutResult.setData(mRvalue);
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

    /**
     * 上传图片
     */
    public OutResult uploadPic(MultipartFile file, int sid, String empno) {
        OutResult mOutResult = new OutResult();
        List list = new ArrayList();
        try {
            String fileName = file.getOriginalFilename();

            //上传原图
            IsUpload isUpload = FileTool.upload(file, path, fakePath, fileName, sid, empno);
            list.add(isUpload.getPicFakePath());
            //上传缩略图
            IsUploadThumb isUploadThumb = FileTool.thumbnailImage(isUpload.getPicRealPath(), fakePath, 100, 150, "tem", false);
            list.add(isUploadThumb.getThumbnailPath());
            mOutResult.setData(list);
            gLog.info("上传成功:" + isUploadThumb.getThumbnailPath() + "  " + isUpload.getPicRealPath());
        } catch (Exception e) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg("失败：" + e.toString());
            gLog.error("上传失败 ：" + e.getMessage());
        }
        return mOutResult;
    }

    /**
     * 新建提案
     */
    public OutResult AddForm(New_PROPOSAL new_proposal) {
        OutResult mOutResult = new OutResult();
        String mMessage = "";
        try {

            if (new_proposal.getStatus().equals("1")) {
                new_proposal.setContent("");
                String mOaProposalId = createOAProcess(new_proposal, new_proposal.getOwner(), "add");//创建流程
                new_proposal.setOaProposalId(mOaProposalId);
                new_proposalMapper.insertSelective(new_proposal);
            } else if (new_proposal.getStatus().equals("2")) {   //职工新建 推送班长
                if (new_proposalMapper.insertSelective(new_proposal) > 0) {
                    String mSend = getCoopreateToken(new_proposal.getCapitalId(), "您好：\n" +
                            "您收到" + new_proposal.getOwnerName() + "、工号" + new_proposal.getOwner() + "提交的" +
                            "主题为“" + new_proposal.getTheme() + "”的合理化建议，" +
                            "请尽快处理，谢谢！");
                    mMessage = "成功";
                    if ("0".equals(mSend)) {
                        mMessage = "流程创建成功，协同接口调用异常！";
                    } else if (!"SEND_SUCCESS".equals(mSend)) {
                        mMessage = "接口提供方未将消息发送至客户端！消息状态：" + mSend;
                    }
                }

            } else
                new_proposalMapper.insertSelective(new_proposal);

            gLog.info(new_proposal.getOwner() + "新建提案成功");
            mOutResult.setCode(0);
            mOutResult.setMsg(mMessage);
            mOutResult.setIsSuccess(true);

        } catch (Exception ex) {
            gLog.error(new_proposal.getOwner() + "新建提案失败");
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;

    }

    /**
     * 提案详情
     */
    public OutResult GetProposalDetail(String id) {
        OutResult mOutResult = new OutResult();
        try {
            New_PROPOSAL new_proposal = new_proposalMapper.selectByPrimaryKey(id);
            String oaStep = GetOAStepById(new_proposal.getOaProposalId());
            new_proposal.setOaStep(oaStep);
            List<New_PROPOSAL> list = new ArrayList<>();
            list.add(new_proposal);
            mOutResult.setCode(0);
            mOutResult.setData(list);
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

    /**
     * 审批/更新提案
     */
    public OutResult UpdateForm(New_PROPOSAL new_proposal) {
        OutResult mOutResult = new OutResult();
        try {


            if (!new_proposal.getStatus().equals("1")) //不经过OA
                new_proposalMapper.updateByPrimaryKeySelective(new_proposal);//存变化值
            else {
                New_PROPOSAL new_proposal1 = new_proposalMapper.selectByPrimaryKey(new_proposal.getId());//找完整值
                new_proposal1.setStatus(new_proposal.getStatus());
                new_proposal1.setContent(new_proposal.getContent());
                new_proposal1.setExamineOpinion(new_proposal.getExamineOpinion());

                String mOaProposalId = createOAProcess(new_proposal1, new_proposal1.getCapitalId(), "update");//创建流程
                new_proposal1.setOaProposalId(mOaProposalId); //存OA流程ID
                new_proposalMapper.updateByPrimaryKeySelective(new_proposal1);  //更新数据
            }
            String mSend = UpdatePush(new_proposal);
            String mMessage = "";
            if ("0".equals(mSend)) {
                mMessage = "流程创建成功，协同接口调用异常！";
            } else if (!"SEND_SUCCESS".equals(mSend)) {
                mMessage = "接口提供方未将消息发送至客户端！消息状态：" + mSend;
            } else mMessage = "成功";

            gLog.info(new_proposal.getOwner() + "提案更新成功：" + mMessage);
            mOutResult.setCode(0);
            mOutResult.setMsg(mMessage);
            mOutResult.setIsSuccess(true);

        } catch (Exception ex) {

            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(new_proposal.getOwner() + "提案更新失败：" + ex.getMessage());
        }
        return mOutResult;
    }


    @Value("${oa.certify.userName}")
    private String gOaCertifyUser;
    @Value("${oa.certify.passWord}")
    private String gOaCertifyPassWord;
    @Value("${oa.oaWebServicePath}")
    private String gWsdlBasePath;

    @Value("${oa.createProposal.node.equalOneNode}")
    private String gEqualOneNode;
    @Value("${oa.createProposal.node.equalTwoNode}")
    private String gEqualTwoNode;
    @Value("${oa.createProposal.node.equalThreeNode}")
    private String gEqualThreeNode;
    @Value("${oa.createProposal.fdTemplateId}")
    private String gFdTemplateId;

    /**
     * 创建OA流程
     */
    private String createOAProcess(New_PROPOSAL pProposal, String pCapitalId, String type) throws Exception {
        String mRValue = "";
        KmReviewParamterForm mKmReviewParamterForm = createForm(pProposal, pCapitalId, type);
        AddReview mAddReview = new AddReview();
        mAddReview.setArg0(mKmReviewParamterForm);

        SIOACREATEPROCESSOut_HTTPSPort_Client mSIOACREATEPROCESSOut_HTTPSPort_Client = new SIOACREATEPROCESSOut_HTTPSPort_Client();
        mRValue = mSIOACREATEPROCESSOut_HTTPSPort_Client.mainProcess(gWsdlBasePath, mAddReview, gOaCertifyUser, gOaCertifyPassWord).getReturn();
        return mRValue;
    }

    /**
     * 创建OA表单
     */
    private KmReviewParamterForm createForm(New_PROPOSAL pProposal, String pCapitalId, String type) throws Exception {
        String mPresentSituation = "";
        if (type.equals("update"))
            mPresentSituation = "实际提案人：" + pProposal.getOwnerName() + "，工号：" + pProposal.getOwner() + "，部门：" + pProposal.getSectionName() + "\n";

        mPresentSituation += pProposal.getPresentSituation();
        KmReviewParamterForm form = new KmReviewParamterForm();
        form.setFdTemplateId(gFdTemplateId);
        form.setDocSubject(pProposal.getTheme());
        form.setDocCreator("{\"LoginName\": \"" + pCapitalId + "\"}");//创建流程的工号为班长的工号

        String formValues = "{\"fd_326c6fc4e795e2\":\"" + mPresentSituation.replace("\n", "\\n") + "\",\"" +
                "fd_improvement\":\"" + pProposal.getExamineOpinion().replace("\n", "\\n") + "\",\"" +
                "fd_title\":\"" + pProposal.getTheme().replace("\n", "\\n") + "\",\"" +
                "fd_type1\":\"" + pProposal.getType() + "\",\"" +
                "fd_type\":\"" + pProposal.getProposalType() + "\"}";
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

        //附件
        List<AttachmentForm> attForms = createAllAtts(pProposal);
        form.getAttachmentForms().addAll(attForms);

        gLog.info(form);
        return form;
    }

    /**
     * 创建附件列表
     */
    private List<AttachmentForm> createAllAtts(New_PROPOSAL pProposal) throws IOException {
        List<AttachmentForm> attForms = new ArrayList<AttachmentForm>();

        String realPath;

        if (!pProposal.getPicture1().equals("NUL")) {
            realPath = Readpath + "/" + pProposal.getPicture1();
            String Suffix = pProposal.getPicture1().substring(pProposal.getPicture1().lastIndexOf("."));
            //realPath = "C:\\Users\\Administrator\\Desktop\\xietong\\tttt.png";
            String fileName = "附件一" + Suffix;
            AttachmentForm attForm01 = createAtt(realPath, fileName);
            attForms.add(attForm01);

        }
        if (!pProposal.getPicture2().equals("NUL")) {
            realPath = Readpath + "/" + pProposal.getPicture2();
            String Suffix = pProposal.getPicture2().substring(pProposal.getPicture2().lastIndexOf("."));
            String fileName = "附件二" + Suffix;
            AttachmentForm attForm02 = createAtt(realPath, fileName);
            attForms.add(attForm02);
        }


        return attForms;
    }

    /**
     * 创建附件对象
     */
    private AttachmentForm createAtt(String realPath, String name) throws IOException {
        AttachmentForm attForm = new AttachmentForm();
        attForm.setFdFileName(name);
        // 设置附件关键字，表单模式下为附件控件的id
        attForm.setFdKey("fd_attachment");

        byte[] data = file2bytes(realPath);
        attForm.setFdAttachment(data);

        return attForm;
    }

    /**
     * 将文件转换为字节编码
     */
    private byte[] file2bytes(String realPath) throws IOException {
        InputStream in = new FileInputStream(realPath);
        byte[] data = new byte[in.available()];

        try {
            in.read(data);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
            }
        }

        return data;
    }

    /**
     * Web提案状态分类汇总
     */
    public OutResult NewGetStatisticProposal(ListOAInput pListOAInput) {
        OutResult mOutResult = new OutResult();
        try {
            List<ProposalStatisticOut> mMapList = ProposalMapper.NewGetStatisticProposal(pListOAInput);

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

    /**
     * 提案导出
     */
    public void Newexcel(HttpServletResponse response, String ownerName, String theme, String status, String searchStartDate, String searchEndDate, Integer good) {
        try {
            Date mSearchStartDate = DateTool.parseTimestampFromFormats(searchStartDate);
            Date mSearchEndDate = DateTool.parseTimestampFromFormats(searchEndDate);
            ListOAInput mListOAInput = new ListOAInput();
            mListOAInput.setOwnerName(ownerName);
            mListOAInput.setTheme(theme);
            mListOAInput.setStatus(status);
            mListOAInput.setSearchStartDate(mSearchStartDate);
            mListOAInput.setSearchEndDate(mSearchEndDate);
            mListOAInput.setGood(good);

            PageHelper.startPage(1, 9999);
            List<New_ListOutResult> mRvalue = ProposalMapper.getWebAll(mListOAInput);
            handleExportExcel(response, mRvalue);
        } catch (Exception ex) {
            gLog.error("合理化建议导出出错：", ex);
        }
    }

    /**
     * 提案导出（赋值）
     */
    private void handleExportExcel(HttpServletResponse response, List<New_ListOutResult> pRvalue) throws Exception {
        ExcelData data = new ExcelData();
        data.setName("合理化建议数据");
        List<String> titles = new ArrayList();
        titles.add("提案人（工号）");
        titles.add("主题");
        titles.add("审批状态");
        titles.add("部门");
        titles.add("OA流程编号");
        titles.add("创建时间");
        titles.add("类别");
        titles.add("提案类型");
        titles.add("问题描述");
        titles.add("决策建议");
        titles.add("提案人积分");
        titles.add("提案收益");
        titles.add("实施人工号");
        titles.add("实施人姓名");
        titles.add("实施人积分");
        titles.add("是否优秀提案");
        data.setTitles(titles);
        List<List<Object>> rows = new ArrayList();
        String time;
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (New_ListOutResult fListOutResult : pRvalue) {
            List<Object> row = new ArrayList();
            row.add(fListOutResult.getOwnerName() + "(" + fListOutResult.getOwner() + ")");
            row.add(fListOutResult.getTheme());
            row.add(fListOutResult.getStatus());
            row.add(fListOutResult.getSectionName());
            row.add(fListOutResult.getOaProposalId());
            time = sdf.format(fListOutResult.getCreateTime());
            row.add(time);
            if (null != fListOutResult.getType())
                switch (Integer.parseInt(fListOutResult.getType())) {
                    case 1:
                        row.add("工装");
                        break;
                    case 2:
                        row.add("设备");
                        break;
                    case 3:
                        row.add("线体平衡");
                        break;
                    case 4:
                        row.add("流程");
                        break;
                    case 5:
                        row.add("标识");
                        break;
                    case 6:
                        row.add("水、电、气资源节省");
                        break;
                    case 7:
                        row.add("人流、物流优化");
                        break;
                    case 8:
                        row.add("现成环境");
                        break;
                    case 9:
                        row.add("操作方法优化");
                        break;
                    case 10:
                        row.add("作业标准不合理");
                        break;
                    case 11:
                        row.add("相似物料防呆");
                        break;
                    case 12:
                        row.add("包装方式");
                        break;
                    case 13:
                        row.add("材料变更");
                        break;
                    case 14:
                        row.add("取消物料");
                        break;
                    case 15:
                        row.add("BOM改善");
                        break;
                    case 16:
                        row.add("福利改善");
                        break;
                    case 17:
                        row.add("公司形象提升");
                        break;
                    case 18:
                        row.add("安全作业");
                        break;
                    case 19:
                        row.add("安全标识");
                        break;
                    default:
                        row.add("工装");
                        break;
                }
            if (null != fListOutResult.getProposalType())
                switch (fListOutResult.getProposalType()) {
                    case 1:
                        row.add("非体系流程类建议");
                        break;
                    case 2:
                        row.add("知识产权类建议");
                        break;
                    case 3:
                        row.add("体系流程类建议");
                        break;
                    default:
                        row.add("非体系流程类建议");
                        break;
                }
            row.add(fListOutResult.getPresentSituation());
            row.add(fListOutResult.getExamineOpinion());
            row.add(fListOutResult.getIntegral());
            row.add(fListOutResult.getBenefit());
            row.add(fListOutResult.getImplementEmpno());
            row.add(fListOutResult.getImplementName());
            row.add(fListOutResult.getImplementIntegral());

            if (fListOutResult.getGood().equals(1))
                row.add("是");
            else
                row.add("否");
            rows.add(row);
        }
        data.setRows(rows);

        SimpleDateFormat fdate = new SimpleDateFormat("yyyy-MM-dd");
        String fileName = "合理化建议数据-" + fdate.format(new Date()) + ".xls";
        ExcelUtils.exportExcel(response, fileName, data);
    }

    /**
     * 获取OA审批节点
     */
    private String GetOAStepById(String id) {
        String oastep = "";
        try {
            List<OAStepOutResult> oaStepOutResult = ProposalMapper.selectOAByID(id);
            if (oaStepOutResult.size() == 0)
                oastep = "暂无相关信息" + "\n" + "流程信息每日凌晨自动同步";
            else
                for (OAStepOutResult oa : oaStepOutResult) {
                    sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String time = sdf.format(oa.getNode_Date());
                    String str = "";
                    if (oa.getActionKey().equals("handler_pass"))
                        str = "通过";
                    else if (oa.getActionKey().equals("drafter_submit"))
                        str = "起草人提交";
                    else if (oa.getActionKey().equals("handler_abandon"))
                        str = "废弃";
                    else if (oa.getActionKey().equals("handler_returnCommunicate"))
                        str = "回复沟通";
                    else if (oa.getActionKey().equals("handler_communicate"))
                        str = "沟通";
                    else if (oa.getActionKey().equals("handler_commission"))
                        str = "转办";
                    else if (oa.getActionKey().equals("handler_refuse"))
                        str = "驳回";
                    else if (oa.getActionKey().equals("handler_cancelCommunicate"))
                        str = "取消沟通";

                    oastep += time + "  " + oa.getNode_Name() + "  " + str + "\n";
                }

        } catch (Exception ex) {
            oastep = "暂无相关信息" + "\n" + "流程信息每日凌晨自动同步";
        }
        return oastep;
    }

    @Value("${oa.oABaseViewHref}")
    private String gOABaseViewHref;

    /**
     * Web提案详情
     */
    public OutResult getWebDetail(String pId) {
        OutResult mOutResult = new OutResult();
        String mMessage = "";
        try {
            PageHelper.startPage(1, 1);
            New_PROPOSAL New_PROPOSAL = new_proposalMapper.selectByPrimaryKey(pId);
            String OaLinkHref = gOABaseViewHref + New_PROPOSAL.getOaProposalId();
            String oaStep = GetOAStepById(New_PROPOSAL.getOaProposalId());
            List list = new ArrayList();
            list.add(New_PROPOSAL);
            list.add(OaLinkHref);
            list.add(oaStep);
            mOutResult.setData(list);
            mOutResult.setCode(0);
            mOutResult.setMsg("success");
            mOutResult.setIsSuccess(true);
        } catch (Exception ex) {
            mOutResult.setCode(2);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }
        return mOutResult;
    }

    /**
     * Web提案更新
     */
    public OutResult WebUpdate(New_PROPOSAL new_proposal) {
        OutResult mOutResult = new OutResult();
        try {
            if (new_proposal.getStatus().equals("5")) { //最终通过增加积分
                New_Integral newInstance = inew_integralMapper.getTopData(new_proposal.getOwner());
                if (newInstance == null) { //提案人无积分记录 则创建积分记录
                    newInstance = new New_Integral();
                    newInstance.setEmpno(new_proposal.getOwner());
                    newInstance.setIntegralsum(new_proposal.getIntegral());
                    newInstance.setUseIntegral(new_proposal.getIntegral());
                    new_integralMapper.insertSelective(newInstance);
                } else {
                    newInstance.setUseIntegral(newInstance.getUseIntegral() + new_proposal.getIntegral());
                    newInstance.setIntegralsum(newInstance.getIntegralsum() + new_proposal.getIntegral());
                    new_integralMapper.updateByPrimaryKeySelective(newInstance);
                }
                newInstance = inew_integralMapper.getTopData(new_proposal.getImplementEmpno());
                if (newInstance == null) { //实施人无积分记录 则创建积分记录
                    newInstance = new New_Integral();
                    newInstance.setEmpno(new_proposal.getImplementEmpno());
                    newInstance.setIntegralsum(new_proposal.getImplementIntegral());
                    newInstance.setUseIntegral(new_proposal.getImplementIntegral());
                    new_integralMapper.insertSelective(newInstance);
                } else {
                    newInstance.setUseIntegral(newInstance.getUseIntegral() + new_proposal.getImplementIntegral());
                    newInstance.setIntegralsum(newInstance.getIntegralsum() + new_proposal.getImplementIntegral());
                    new_integralMapper.updateByPrimaryKeySelective(newInstance);
                }
            }
            if (new_proposalMapper.updateByPrimaryKeySelective(new_proposal) > 0) {
                String mSend = UpdatePush(new_proposal);
                String mMessage = "";
                if ("0".equals(mSend)) {
                    mMessage = "流程创建成功，协同接口调用异常！";
                } else if (!"SEND_SUCCESS".equals(mSend)) {
                    mMessage = "接口提供方未将消息发送至客户端！消息状态：" + mSend;
                } else mMessage = "成功";

                mOutResult.setCode(0);
                mOutResult.setMsg(mMessage);
                mOutResult.setIsSuccess(true);


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
     * Web提案排行
     */
    public OutResult getWebRank(String type, String StartTime, String EndTime) {
        OutResult mOutResult = new OutResult();
        List list = new ArrayList();
        try {
            List<RankOutResult> RankList;
            if (type.equals("cla"))
                RankList = ProposalMapper.getClaRank(StartTime, EndTime);
            else
                RankList = ProposalMapper.getPerRank(StartTime, EndTime);

            list.add(RankList);
            list.add(getSumData(StartTime, EndTime).getData());

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
     * Web 排行导出
     */
    public void WebRankExcel(HttpServletResponse response, String type, String StartTime, String EndTime) throws Exception {
        List<RankOutResult> RankList;
        if (type.equals("cla"))
            RankList = ProposalMapper.getClaRank(StartTime, EndTime);
        else
            RankList = ProposalMapper.getPerRank(StartTime, EndTime);

        handleExportExcelByCla(response, RankList, type);


    }

    /**
     * Web 排行导出（赋值）
     */
    private void handleExportExcelByCla(HttpServletResponse response, List<RankOutResult> pRvalue, String type) throws Exception {
        ExcelData data = new ExcelData();
        List<Object> row = new ArrayList();
        List<List<Object>> rows = new ArrayList();
        data.setName("排行数据");
        List<String> titles = new ArrayList();
        if (type.equals("cla")) {
            titles.add("部门");
            titles.add("提案数");
            titles.add("人均");
            titles.add("实施率");
            for (RankOutResult fListOutResult : pRvalue) {
                row = new ArrayList();
                row.add(fListOutResult.getDepart());
                row.add(fListOutResult.getClaProposal());
                row.add(fListOutResult.getAverage());
                row.add(fListOutResult.getClaUseful());
                rows.add(row);
            }
        } else {
            titles.add("姓名");
            titles.add("提案数");
            titles.add("实施率");
            for (RankOutResult fListOutResult : pRvalue) {
                row = new ArrayList();
                row.add(fListOutResult.getName());
                row.add(fListOutResult.getPerProposal());
                row.add(fListOutResult.getPerUseful());
                rows.add(row);
            }
        }
        data.setTitles(titles);

        data.setRows(rows);

        SimpleDateFormat fdate = new SimpleDateFormat("yyyy-MM-dd");
        String fileName = "排行数据" + fdate.format(new Date()) + ".xls";
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

    /**
     * 推送信息
     */
    private String UpdatePush(New_PROPOSAL new_proposal) {
        String content;
        String ss = "";
        String pWorkId = "";

        switch (new_proposal.getStatus()) {
            case "0": {
                ss = "驳回至专员审批";
                pWorkId = new_proposal.getOwner();
                break;
            }
            case "1": {
                ss = "班长已通过，OA审批";
                pWorkId = new_proposal.getOwner();
                break;
            }
            case "2": {
                ss = "起草人已重新提交";
                pWorkId = new_proposal.getCapitalId();
                break;
            }
            case "3": {
                ss = "最终驳回";
                pWorkId = new_proposal.getOwner();
                break;
            }
            case "4": {
                ss = "驳回至起草";
                pWorkId = new_proposal.getOwner();
                break;
            }
            case "5": {
                ss = "最终通过";
                pWorkId = new_proposal.getOwner();
                break;
            }
        }
        content = "您好：\n" +
                "您提交的主题为“" + new_proposal.getTheme() + "”的提案，状态变更为“" + ss + "”,请查看，谢谢！\n";
        if (new_proposal.getStatus().equals("5")) {
            //先推送实施人
            pWorkId = new_proposal.getImplementEmpno();
            content = "您好：\n" +
                    "您参与实施的主题为“" + new_proposal.getTheme() + "”的提案，最终通过审批，恭喜获得" + new_proposal.getImplementIntegral() + "积分奖励,请注意查看！\n";
            getCoopreateToken(pWorkId, content);
            //推送提案人
            pWorkId = new_proposal.getOwner();
            content = "您好：\n" +
                    "您提交的主题为“" + new_proposal.getTheme() + "”的提案，最终通过审批，恭喜获得" + new_proposal.getIntegral() + "积分奖励,请注意查看！\n";
        }

        if (new_proposal.getStatus().equals("2"))
            content = "您好：\n" +
                    "您驳回的主题为“" + new_proposal.getTheme() + "”的提案，已重新提交,请查看，谢谢！\n";

        String m = getCoopreateToken(pWorkId, content);
        return m;
    }

    /**
     * 获取Token
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
     * Post推送
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
     * 本部门排行
     */
    public OutResult OrgRanking(String empno) {
        OutResult mOutResult = new OutResult();

        try {
            List<RankOutResult> RankList;
            RankList = ProposalMapper.getOrgRank(empno);

            mOutResult.setCode(0);
            mOutResult.setMsg("成功！");
            mOutResult.setData(RankList);
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
     * 获取实施人姓名
     */
    public OutResult getImplementName(String empno) {
        OutResult mOutResult = new OutResult();

        try {
            List<String> RankList = new ArrayList<>();
            RankList.add(ProposalMapper.getImplementName(empno));
            System.out.println(empno);
            mOutResult.setCode(0);
            mOutResult.setMsg("成功！");
            mOutResult.setData(RankList);
            mOutResult.setIsSuccess(true);
        } catch (Exception ex) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(1);
            mOutResult.setMsg(ex.toString());
            gLog.error(ex.getMessage());
        }

        return mOutResult;
    }
}



