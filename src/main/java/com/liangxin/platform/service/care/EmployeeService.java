package com.liangxin.platform.service.care;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.liangxin.platform.common.entity.advise.generate.pt.AnniversaryMailSendRecord;
import com.liangxin.platform.common.entity.advise.generate.pt.BirthdayMailSendRecord;
import com.liangxin.platform.common.entity.advise.generate.pt.ContractExpireRecord;
import com.liangxin.platform.common.entity.advise.generate.pt.ReadyToMemberRecord;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.common.entity.care.inputParas.ExpireAndMemberInput;
import com.liangxin.platform.common.entity.care.outputResult.Employee;
import com.liangxin.platform.common.entity.care.outputResult.ExpireAndMember;
import com.liangxin.platform.common.entity.sys.mail.MailSet;
import com.liangxin.platform.common.tools.DateTool;
import com.liangxin.platform.common.tools.HttpTool;
import com.liangxin.platform.common.tools.JavaMail;
import com.liangxin.platform.mapper.advise.generate.pt.AnniversaryMailSendRecordMapper;
import com.liangxin.platform.mapper.advise.generate.pt.BirthdayMailSendRecordMapper;
import com.liangxin.platform.mapper.advise.generate.pt.ContractExpireRecordMapper;
import com.liangxin.platform.mapper.advise.generate.pt.ReadyToMemberRecordMapper;
import com.liangxin.platform.mapper.care.IEmployeeMapper;
import com.liangxin.platform.service.ProposalService;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.util.*;

@Service
public class EmployeeService {
    private final Logger gLog = LogManager.getLogger(EmployeeService.class);
    private JavaMail gJavaMail = new JavaMail();
    @Autowired
    private IEmployeeMapper gIEmployeeMapper;
    @Autowired
    private BirthdayMailSendRecordMapper gBirthdayMailSendRecordMapper;
    @Autowired
    private AnniversaryMailSendRecordMapper gAnniversaryMailSendRecordMapper;
    @Autowired
    private ReadyToMemberRecordMapper gReadyToMemberRecordMapper;
    @Autowired
    private ContractExpireRecordMapper gContractExpireRecordMapper;
    @Autowired
    private ProposalService gProposalService;

    public OutResult getBirthdayAll() {
        OutResult mOutResult = new OutResult();
        try {
            List<Employee> mRvalue = gIEmployeeMapper.getBirthdayAll("07/25");
            mOutResult.setTotalCount(mRvalue.size());
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


    @Value("${sys.mail.sendType}")
    private String gSendType;
    @Value("${sys.mail.sendServer}")
    private String gSendServer;
    @Value("${sys.mail.sendFromAddress}")
    private String gSendFromAddress;
    @Value("${sys.mail.userName}")
    private String gUserName;
    @Value("${sys.mail.passWard}")
    private String gPassWard;

    @Value("${care.file.imageRootPath}")
    private String gImageRootPath;


    @Value("${care.schedule.birthday.isOn}")
    private boolean gScheduleBirthdayIsOn;

    @Scheduled(cron = "${care.schedule.birthday.cron}")
    private void scheduleBirthday() {
        try {
            if (gScheduleBirthdayIsOn) {
                Date mTodayDate = new Date();
                String mDate = DateTool.format(mTodayDate, DateTool.getMMDDFormat());
                List<Employee> mRvalue = gIEmployeeMapper.getBirthdayAll(mDate);
                if (null != mRvalue && mRvalue.size() > 0) {
                    BirthdayMailSendRecord mbirthdayMailSendRecord;
                    MailSet mMailSet;
                    Integer mPostStatus = 0;
                    for (Employee fEmployee : mRvalue) {
                        mbirthdayMailSendRecord = new BirthdayMailSendRecord();
                        String mId = String.valueOf(UUID.randomUUID()).replace("-", "");
                        mbirthdayMailSendRecord.setId(mId);
                        mbirthdayMailSendRecord.setEmail(fEmployee.getEmail());
                        mbirthdayMailSendRecord.setName(fEmployee.getName());
                        mbirthdayMailSendRecord.setBirthday(fEmployee.getBirthday());
                        mbirthdayMailSendRecord.setPostTime(mTodayDate);
                        mbirthdayMailSendRecord.setWorkId(fEmployee.getWorkId());
                        mMailSet = new MailSet();
                        mMailSet.setSendToUserName(fEmployee.getName());
                        constructBirthDayContent(mMailSet);
                        mMailSet.setSendToAddress((new ArrayList<String>() {
                            {
                                add(fEmployee.getEmail());
                            }
                        }));
                        mMailSet.setCopyToAddress((new ArrayList<String>() {
                            {
                                add(gSendFromAddress);
                            }
                        }));
                        String mFilePathJpg = gImageRootPath + "b1.jpg";
                        File mFileJpg = new File(mFilePathJpg);
                        if (mFileJpg.exists()) {
                            mMailSet.setImageBodyList((new ArrayList<String>() {
                                {
                                    add(mFilePathJpg);
                                }
                            }));
                        }
                        mPostStatus = commonSendMail(mMailSet, fEmployee);
                        mbirthdayMailSendRecord.setPostStatus(BigDecimal.valueOf(mPostStatus));
                        gBirthdayMailSendRecordMapper.insertSelective(mbirthdayMailSendRecord);
                    }
                }
            }
        } catch (Exception ex) {
            gLog.error("发送生日提醒邮件方法出错，原因:", ex);
        }
        gLog.info("执行了scheduleBirthday生日邮件提醒函数，时间:" + new Date());
    }


    @Value("${care.schedule.anniversary.isOn}")
    private boolean gScheduleAnniversaryIsOn;

    @Scheduled(cron = "${care.schedule.anniversary.cron}")
    private void scheduleAnniversary() {
        try {
            if (gScheduleAnniversaryIsOn) {
                Date mTodayDate = new Date();
                String mDate = DateTool.format(mTodayDate, DateTool.getMMDDFormat());
                List<Employee> mRvalue = gIEmployeeMapper.getAnniversaryAll(mDate);
                if (null != mRvalue && mRvalue.size() > 0) {
                    AnniversaryMailSendRecord mAnniversaryMailSendRecord;
                    MailSet mMailSet;
                    Integer mPostStatus = 0;
                    for (Employee fEmployee : mRvalue) {
                        mAnniversaryMailSendRecord = new AnniversaryMailSendRecord();
                        String mId = String.valueOf(UUID.randomUUID()).replace("-", "");
                        mAnniversaryMailSendRecord.setId(mId);
                        mAnniversaryMailSendRecord.setName(fEmployee.getName());
                        mAnniversaryMailSendRecord.setEmail(fEmployee.getEmail());
                        mAnniversaryMailSendRecord.setWorkDay(fEmployee.getHireValid());
                        mAnniversaryMailSendRecord.setPostTime(mTodayDate);
                        mAnniversaryMailSendRecord.setWorkId(fEmployee.getWorkId());
                        mMailSet = new MailSet();
                        mMailSet.setSendToAddress((new ArrayList<String>() {
                            {
                                add(fEmployee.getEmail());
                            }
                        }));
                        //根据年份选择不同图片和内容
                        mMailSet.setCopyToAddress((new ArrayList<String>() {
                            {
                                add(gSendFromAddress);
                            }
                        }));
                        Calendar mBegin = Calendar.getInstance(); //获取日历实例
                        Calendar mEnd = Calendar.getInstance();
                        mBegin.setTime(fEmployee.getHireValid()); //字符串按照指定格式转化为日期
                        mEnd.setTime(new Date());
                        Integer mYears = mEnd.get(Calendar.YEAR) - mBegin.get(Calendar.YEAR);
                        if (mYears == 1 || mYears == 3 || mYears == 5 || mYears == 8 || mYears == 10 || mYears == 15 || mYears == 20) {
                            mMailSet.setSendToUserName(fEmployee.getName());
                            getDifferentMailContentByYears(mMailSet, mYears);
                            mPostStatus = commonSendMail(mMailSet, fEmployee);
                            mAnniversaryMailSendRecord.setPostStatus(BigDecimal.valueOf(mPostStatus));
                            gAnniversaryMailSendRecordMapper.insertSelective(mAnniversaryMailSendRecord);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            gLog.error("发送色灰姑娘日提醒邮件方法出错，原因:", ex);
        }
        gLog.info("执行了scheduleAnniversary周年邮件提醒函数，时间:" + new Date());
    }


    public void getDifferentMailContentByYears(MailSet pMailSet, Integer pYears) {
        String mFilePathJpg = gImageRootPath + pYears + ".jpg";
        String mFilePathNpg = gImageRootPath + pYears + ".png";
        File mFileJpg = new File(mFilePathJpg);
        if (mFileJpg.exists()) {
            pMailSet.setImageBodyList((new ArrayList<String>() {
                {
                    add(mFilePathJpg);
                }
            }));
        }
        //the code of mFilePathJpg does not exists
        File mFileNpg = new File(mFilePathNpg);
        if (mFileNpg.exists()) {
            pMailSet.setImageBodyList((new ArrayList<String>() {
                {
                    add(mFilePathNpg);
                }
            }));
        }

        constructAnniversaryContent(pMailSet, pYears);
    }


    private Integer commonSendMail(MailSet pMailSet, Employee pEmployee) {
        Integer mRValue = 0;
        try {
            pMailSet.setSendType(gSendType);
            pMailSet.setServerAddress(gSendServer);
            pMailSet.setSendFromAddress(gSendFromAddress);
            pMailSet.setUserName(gUserName);
            pMailSet.setUserPassWord(gPassWard);
            gJavaMail.send(pMailSet);
            //send  cooperation application
            getCoopreateToken(pEmployee.getWorkId(), pMailSet.getMailText());
            mRValue = 1;
        } catch (Exception ex) {
            gLog.error("姓名:" + pEmployee.getName() + "，工号:" + pEmployee.getWorkId() + "，生日提醒邮件发送失败，原因：", ex);
            mRValue = 0;
        }
        return mRValue;
    }


    @Value("${care.message.getToken.url}")
    private String gGetCareMessageTokenUrl;
    @Value("${care.message.getToken.appId}")
    private String gGetCareMessageTokenAppId;
    @Value("${care.message.getToken.corpId}")
    private String gGetCareMessageTokenCorpId;
    @Value("${care.message.getToken.corpSecret}")
    private String gGetCareMessageTokenCorpSecret;

    /**
     * 调用get接口
     *
     * @return
     */
    public String getCoopreateToken(String pWorkId, String pContent) {
        String mRValue = "";
        String mDeCpor = "";
        String mPara = "corpid=" + gGetCareMessageTokenCorpId + "&corpsecret=" + gGetCareMessageTokenCorpSecret + "&appid=" + gGetCareMessageTokenAppId;
        mRValue = HttpTool.sendGet(gGetCareMessageTokenUrl, mPara);
        if (mRValue.contains("异常信息")) {
            gLog.error("url:" + gGetCareMessageTokenUrl + ",para:" + mPara + ",result:" + mRValue);
            return "0";
        }
        JSONObject jsonObject = JSONObject.fromObject(mRValue);
        if (null != jsonObject.get("app_access_token")) {
            mRValue = postMessage(String.valueOf(jsonObject.get("app_access_token")).trim(), pWorkId, pContent);
        } else {
            gLog.error("url:" + gGetCareMessageTokenUrl + ",para:" + mPara + ",result:" + String.valueOf(jsonObject.get("errmemo")));
            mRValue = "0";
        }
        return mRValue;
    }

    @Value("${care.message.sendMessageToWorkId.url}")
    private String gSendCareMessageUrl;

    /**
     * 调用post接口
     *
     * @return
     */
    private String postMessage(String pAccessToken, String pWorkId, String pContent) {
        String mRValue = "";
        String mDeCpor = "";
        String mPara = "app_access_token=" + pAccessToken + "&UserId=" + pWorkId + "&MsgType=text&Type=num&Content=" + pContent + "&CreateTime=" + System.currentTimeMillis();
        mRValue = HttpTool.sendPost(gSendCareMessageUrl, mPara);
        if (mRValue.contains("异常信息")) {
            gLog.error("url:" + gSendCareMessageUrl + ",para:" + mPara + ",result:" + mRValue);
            return "0";
        }
        JSONObject jsonObject = JSONObject.fromObject(mRValue);
        if (null != jsonObject.get("msg_status")) {
            mRValue = String.valueOf(jsonObject.get("msg_status"));
        } else {
            gLog.error("url:" + gSendCareMessageUrl + ",para:" + mPara + ",result:" + String.valueOf(jsonObject.get("errmemo")));
            mRValue = "0";
        }
        return mRValue;
    }

    public OutResult readyToMember(ExpireAndMemberInput pExpireAndMemberInput) {
        OutResult mOutResult = new OutResult();
        try {
            Page mPage = PageHelper.startPage(pExpireAndMemberInput.getPageIndex(), pExpireAndMemberInput.getPageSize(), true);
            List<ExpireAndMember> mReadyToMember = gIEmployeeMapper.getReadyToMemberList(pExpireAndMemberInput);
            handleManualDataList(mReadyToMember, "readyToMember");
            mOutResult.setData(mReadyToMember);
            mOutResult.setTotalCount(mPage.getTotal());
            mOutResult.setIsSuccess(true);
            mOutResult.setCode(1);
            mOutResult.setMsg("成功");
        } catch (Exception e) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(0);
            mOutResult.setMsg("失败：" + e.toString());
            gLog.error(e.toString());
        }
        return mOutResult;
    }

    public OutResult contractExpire(ExpireAndMemberInput pExpireAndMemberInput) {
        OutResult mOutResult = new OutResult();
        try {
            Page mPage = PageHelper.startPage(pExpireAndMemberInput.getPageIndex(), pExpireAndMemberInput.getPageSize(), true);
            List<ExpireAndMember> mReadyToMember = gIEmployeeMapper.getContractExpireList(pExpireAndMemberInput);
            handleManualDataList(mReadyToMember, "contractExpire");
            mOutResult.setData(mReadyToMember);
            mOutResult.setTotalCount(mPage.getTotal());
            mOutResult.setIsSuccess(true);
            mOutResult.setCode(1);
            mOutResult.setMsg("成功");
        } catch (Exception e) {
            mOutResult.setIsSuccess(false);
            mOutResult.setCode(0);
            mOutResult.setMsg("失败：" + e.toString());
            gLog.error(e.toString());
        }
        return mOutResult;
    }

    private void handleManualDataList(List<ExpireAndMember> pReadyToMember, String pType) {
        if (null != pReadyToMember && pReadyToMember.size() > 0) {
            for (ExpireAndMember fExpireAndMember : pReadyToMember) {
                Map<String, Object> mFirstUpGradeMap = gIEmployeeMapper.getUpGradeNameAndUserId(fExpireAndMember.getUserId());
                if (null != mFirstUpGradeMap && mFirstUpGradeMap.size() > 0) {
                    fExpireAndMember.setUpGradeUserWorkId(getMapValue(mFirstUpGradeMap, "pos_empcode"));
                    fExpireAndMember.setUpGradeUserName(getMapValue(mFirstUpGradeMap, "pos_c_name"));
                    fExpireAndMember.setUpGradeUserEmail(getMapValue(mFirstUpGradeMap, "pos_email"));
                    String mUpGradeUserId = getMapValue(mFirstUpGradeMap, "pos_serialnumber");
                    if (null != mUpGradeUserId && "contractExpire" == pType) {
                        Map<String, Object> mSecondUpGradeMap = gIEmployeeMapper.getUpGradeNameAndUserId(mUpGradeUserId);
                        if (null != mSecondUpGradeMap && mSecondUpGradeMap.size() > 0) {
                            fExpireAndMember.setSecondGradeUserWorkId(getMapValue(mSecondUpGradeMap, "pos_empcode"));
                            fExpireAndMember.setSecondGradeUserName(getMapValue(mSecondUpGradeMap, "pos_c_name"));
                            fExpireAndMember.setSecondGradeUserEmail(getMapValue(mSecondUpGradeMap, "pos_email"));
                            String mUpSecondGradeUserId = getMapValue(mSecondUpGradeMap, "pos_serialnumber");
                            if (null != mUpSecondGradeUserId) {
                                Map<String, Object> mThirdUpGradeMap = gIEmployeeMapper.getUpGradeNameAndUserId(mUpSecondGradeUserId);
                                if (null != mThirdUpGradeMap && mThirdUpGradeMap.size() > 0) {
                                    fExpireAndMember.setThirdGradeUserWorkId(getMapValue(mThirdUpGradeMap, "pos_empcode"));
                                    fExpireAndMember.setThirdGradeUserName(getMapValue(mThirdUpGradeMap, "pos_c_name"));
                                    fExpireAndMember.setThirdGradeUserEmail(getMapValue(mThirdUpGradeMap, "pos_email"));
                                }
                            }
                        }
                    }
                }
                if ("readyToMember" == pType) {
                    ReadyToMemberRecord mReadyToMemberRecord = gReadyToMemberRecordMapper.selectByPrimaryKey(fExpireAndMember.getUserId());
                    if (null != mReadyToMemberRecord) {
                        fExpireAndMember.setPostStatus(Integer.valueOf(String.valueOf(mReadyToMemberRecord.getPostStatus())));
                        fExpireAndMember.setSendDate(mReadyToMemberRecord.getPostTime());
                    } else {
                        fExpireAndMember.setPostStatus(3);
                    }
                }
                if ("contractExpire" == pType) {
                    ContractExpireRecord mContractExpireRecord = gContractExpireRecordMapper.selectByPrimaryKey(fExpireAndMember.getUserId());
                    if (null != mContractExpireRecord) {
                        String mGetExpireDate = DateTool.formatIso8601Day(mContractExpireRecord.getExpireDate());
                        if (!mGetExpireDate.equals(fExpireAndMember.getDate())) {
                            fExpireAndMember.setPostStatus(3);
                        } else {
                            fExpireAndMember.setPostStatus(Integer.valueOf(String.valueOf(mContractExpireRecord.getPostStatus())));
                            fExpireAndMember.setSendDate(mContractExpireRecord.getPostTime());
                        }
                    } else {
                        fExpireAndMember.setPostStatus(3);
                    }
                }
            }
        }
    }


    public void constructBirthDayContent(MailSet pMailSet) {
        pMailSet.setMailSubject("生日快乐");
        pMailSet.setMailText("亲爱的" + pMailSet.getSendToUserName() + "：\n" +
                "公司的发展离不开您和家人的支持、奉献，感谢您的辛勤工作。在这个特别的日子，送上最真挚的祝福，祝您生日快乐 、健康幸福！");
    }

    public void constructAnniversaryContent(MailSet pMailSet, Integer pYears) {
        pMailSet.setMailSubject("入职" + pYears + "年纪念日祝福");
        pMailSet.setMailText("亲爱的" + pMailSet.getSendToUserName() + "：\n " +
                "今天，您来到良信已经" + pYears + "年了！这段旅程，我们一起感受成功，一起承担失败，一起砥砺前行。感谢您的陪伴、付出，祝您事业成功，生活快乐！");
    }

    public void constructContactExpireContent(MailSet pMailSet) {
        pMailSet.setMailSubject("劳动合同续签提醒");
        pMailSet.setMailText("亲爱的" + pMailSet.getSendToUserName() + "：\n" +
                "您的劳动合同即将到期，请您至人力资源员工管理部或区域商务支持处续签劳动合同。若您终止劳动合同，请您回复我并告知原因。");
    }

    public void constructContactExpireContentLeader(MailSet pMailSet) {
        pMailSet.setMailSubject("" + pMailSet.getSendToUserName() + "劳动合同续签提醒");
        pMailSet.setMailText("尊敬的领导\n" +
                "" + pMailSet.getSendToUserName() + "劳动合同即将到期，请您和员工面谈，提醒员工尽快至人力资源员工管理部或区域商务支持处续签劳动合同。");
    }

    public void constructContactExpireContentCoorperation(MailSet pMailSet) {
        pMailSet.setMailSubject("劳动合同续签提醒");
        pMailSet.setMailText(pMailSet.getSendToUserName() + "\n" +
                "您的劳动合同即将到期，请尽快至人力资源部或区域商务支持处续签劳动合同。");
    }

    public void constructContactExpireContentLeaderCoorperation(MailSet pMailSet) {
        pMailSet.setMailSubject("" + pMailSet.getSendToUserName() + "劳动合同续签提醒");
        pMailSet.setMailText("尊敬的领导\n" +
                "" + pMailSet.getSendToUserName() + "劳动合同即将到期，请您和员工面谈，提醒员工尽快至人力资源部或区域商务支持处续签劳动合同。");
    }


    public void constructReadyToMemberContent(MailSet pMailSet) {
        pMailSet.setMailSubject("试用期到期提醒");
        pMailSet.setMailText("亲爱的 " + pMailSet.getSendToUserName() + "：\n" +
                "       到" + pMailSet.getVocationalDate() + "，您的试用期将满。\n" +
                "       现提醒您，请跟直属领导沟通确认，并在试用期满前提出【转正申请流程】，以便您转正后的工资顺利发放。");
    }

    public void constructReadyToMemberContentLeader(MailSet pMailSet) {
        pMailSet.setMailSubject("" + pMailSet.getVocationalDate() + "试用期到期提醒");
        pMailSet.setMailText("尊敬的领导：\n" +
                "      您好！\n" +
                "      到" + pMailSet.getVocationalDate() + "，员工" + pMailSet.getSendToUserName() + "试用期将满。\n" +
                "      现提醒您，若满意其工作表现，认为其充分符合岗位需求，请您鼓励其在试用期满前提出【转正申请流程】，促进他的进步。若认为其并不能胜任岗位或不符合录用条件，请邮件回复人力资源招聘发展部说明情况。\n" +
                "\n" +
                "      感谢您的支持！");
    }

    public void constructReadyToMemberContentCoorperation(MailSet pMailSet) {
        pMailSet.setMailSubject("试用期到期提醒");
        pMailSet.setMailText("亲爱的" + pMailSet.getSendToUserName() + "：\n" +
                "您试用期届满，请尽快与您的直属领导沟通确认后提出《转正申请流程》，祝您工作愉快！");
    }

    public void constructReadyToMemberContentLeaderCoorperation(MailSet pMailSet) {
        pMailSet.setMailSubject("" + pMailSet.getVocationalDate() + "试用期到期提醒");
        pMailSet.setMailText("尊敬的领导：\n" +
                "      您好！\n" +
                "      " + pMailSet.getSendToUserName() + "，试用期将满，请尽快与员工沟通后督促其提出《转正申请流程》，祝您工作愉快！");
    }

    private String getMapValue(Map<String, Object> pUpGradeMap, String pKey) {
        if (null == pUpGradeMap) {
            return null;
        } else {
            if (null == pUpGradeMap.get(pKey)) {
                return null;
            } else {
                return String.valueOf(pUpGradeMap.get(pKey));
            }
        }
    }
}
