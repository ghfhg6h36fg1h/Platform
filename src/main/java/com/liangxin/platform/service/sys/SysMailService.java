package com.liangxin.platform.service.sys;

import com.liangxin.platform.common.entity.advise.generate.pt.AnniversaryMailSendRecord;
import com.liangxin.platform.common.entity.advise.generate.pt.BirthdayMailSendRecord;
import com.liangxin.platform.common.entity.advise.generate.pt.ContractExpireRecord;
import com.liangxin.platform.common.entity.advise.generate.pt.ReadyToMemberRecord;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.common.entity.sys.mail.MailSet;
import com.liangxin.platform.common.tools.DateTool;
import com.liangxin.platform.common.tools.JavaMail;
import com.liangxin.platform.mapper.advise.generate.pt.AnniversaryMailSendRecordMapper;
import com.liangxin.platform.mapper.advise.generate.pt.BirthdayMailSendRecordMapper;
import com.liangxin.platform.mapper.advise.generate.pt.ContractExpireRecordMapper;
import com.liangxin.platform.mapper.advise.generate.pt.ReadyToMemberRecordMapper;
import com.liangxin.platform.service.care.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;

@Service
public class SysMailService {

    private final Logger gLog = LogManager.getLogger(SysMailService.class);

    @Autowired
    private BirthdayMailSendRecordMapper gBirthdayMailSendRecordMapper;
    @Autowired
    private AnniversaryMailSendRecordMapper gBAnniversaryMailSendRecordMapper;
    @Autowired
    private ReadyToMemberRecordMapper gReadyToMemberRecordMapper;
    @Autowired
    private ContractExpireRecordMapper gContractExpireRecordMapper;
    @Autowired
    private EmployeeService gEmployeeService;

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


    public OutResult send(MailSet pMailSet) {
        OutResult mOutResult = new OutResult();
        JavaMail mJavaMail = new JavaMail();
        try {
            pMailSet.setSendType(gSendType);
            pMailSet.setServerAddress(gSendServer);
            pMailSet.setSendFromAddress(gSendFromAddress);
            pMailSet.setUserName(gUserName);
            pMailSet.setUserPassWord(gPassWard);
            mJavaMail.send(pMailSet);
            mOutResult.setCode(1);
            mOutResult.setIsSuccess(true);
            mOutResult.setMsg("成功！");
        } catch (Exception ex) {
            mOutResult.setCode(0);
            mOutResult.setIsSuccess(false);
            mOutResult.setMsg(String.valueOf(ex));
            gLog.error("发送邮件出错:", ex);
        }
        return mOutResult;
    }

    public OutResult sendBYTemple(MailSet pMailSet) {
        OutResult mOutResult = new OutResult();
        Integer mPostStatus;
        try {
            pMailSet.setSendType(gSendType);
            pMailSet.setServerAddress(gSendServer);
            pMailSet.setSendFromAddress(gSendFromAddress);
            pMailSet.setUserName(gUserName);
            pMailSet.setUserPassWord(gPassWard);
            //处理及发送邮件
            getTempleMailSet(pMailSet);
            mOutResult.setCode(1);
            mOutResult.setIsSuccess(true);
            mOutResult.setMsg("成功！");
            mPostStatus = 1;
        } catch (Exception ex) {
            mOutResult.setCode(0);
            mOutResult.setIsSuccess(false);
            mOutResult.setMsg(String.valueOf(ex));
            gLog.error("发邮件，处理出错:", ex);
            mPostStatus = 0;
        }
        recordSendStatus(pMailSet, mPostStatus);
        return mOutResult;
    }

    @Value("${care.file.imageRootPath}")
    private String gImageRootPath;

    private void getTempleMailSet(MailSet pMailSet) throws Exception {
        JavaMail mJavaMail = new JavaMail();
        if ("birthday".equals(pMailSet.getSendTemple().trim())) {
            String mFilePathJpg = gImageRootPath + "b1.jpg";
            String mNoneCopy;
            File mFileJpg = new File(mFilePathJpg);
            if (mFileJpg.exists()) {
                pMailSet.setImageBodyList((new ArrayList<String>() {
                    {
                        add(mFilePathJpg);
                    }
                }));
            }
            gEmployeeService.constructBirthDayContent(pMailSet);
            pMailSet.setCopyToAddress((new ArrayList<String>() {
                {
                    add(gSendFromAddress);
                }
            }));
            mJavaMail.send(pMailSet);
            gEmployeeService.getCoopreateToken(pMailSet.getSendToUserWorkId(), pMailSet.getMailText());
        }
        if ("anniversary".equals(pMailSet.getSendTemple().trim())) {
            Calendar mBegin = Calendar.getInstance(); //获取日历实例
            Calendar mEnd = Calendar.getInstance();
            mBegin.setTime(DateTool.getOrdinaryDate(pMailSet.getVocationalDate())); //字符串按照指定格式转化为日期
            mEnd.setTime(new Date());
            Integer mYears = mEnd.get(Calendar.YEAR) - mBegin.get(Calendar.YEAR);
            Integer a = mEnd.get(Calendar.YEAR);
            Integer b = mBegin.get(Calendar.YEAR);
            gEmployeeService.getDifferentMailContentByYears(pMailSet, mYears);
            mJavaMail.send(pMailSet);
            //发送协同
            gEmployeeService.getCoopreateToken(pMailSet.getSendToUserWorkId(), pMailSet.getMailText());
        }
        if ("readyToMember".equals(pMailSet.getSendTemple().trim())) {
            List<String> mLeaderReadyToMemberList = new ArrayList<>();
            mLeaderReadyToMemberList.addAll(pMailSet.getCopyToAddress());
            pMailSet.setCopyToAddress(null);
            gEmployeeService.constructReadyToMemberContent(pMailSet);
            pMailSet.setCopyToAddress((new ArrayList<String>() {
                {
                    add(gSendFromAddress);
                }
            }));
            mJavaMail.send(pMailSet);
            //发送协同
            gEmployeeService.constructReadyToMemberContentCoorperation(pMailSet);
            gEmployeeService.getCoopreateToken(pMailSet.getSendToUserWorkId(), pMailSet.getMailText());


            //发领导
            pMailSet.setSendToAddress(mLeaderReadyToMemberList);
            gEmployeeService.constructReadyToMemberContentLeader(pMailSet);
            mJavaMail.send(pMailSet);
            //发送协同
            gEmployeeService.constructReadyToMemberContentLeaderCoorperation(pMailSet);
            if (null != pMailSet.getUpWorkIdList() && pMailSet.getUpWorkIdList().size() > 0) {
                for (String fUpWorkId : pMailSet.getUpWorkIdList()) {
                    gEmployeeService.getCoopreateToken(fUpWorkId, pMailSet.getMailText());
                }
            }
        }
        if ("contractExpire".equals(pMailSet.getSendTemple().trim())) {
            List<String> mLeaderContractExpireList = new ArrayList<>();
            mLeaderContractExpireList.addAll(pMailSet.getCopyToAddress());
            pMailSet.setCopyToAddress(null);
            gEmployeeService.constructContactExpireContent(pMailSet);
            pMailSet.setCopyToAddress((new ArrayList<String>() {
                {
                    add(gSendFromAddress);
                }
            }));
            mJavaMail.send(pMailSet);
            //发送协同
            gEmployeeService.constructContactExpireContentCoorperation(pMailSet);
            gEmployeeService.getCoopreateToken(pMailSet.getSendToUserWorkId(), pMailSet.getMailText());


            //发领导
            pMailSet.setSendToAddress(mLeaderContractExpireList);
            gEmployeeService.constructContactExpireContentLeader(pMailSet);
            mJavaMail.send(pMailSet);
            //发送协同
            gEmployeeService.constructContactExpireContentLeaderCoorperation(pMailSet);
            if (null != pMailSet.getUpWorkIdList() && pMailSet.getUpWorkIdList().size() > 0) {
                for (String fUpWorkId : pMailSet.getUpWorkIdList()) {
                    gEmployeeService.getCoopreateToken(fUpWorkId, pMailSet.getMailText());
                }
            }
        }
    }

    private void recordSendStatus(MailSet pMailSet, Integer pPostStatus) {
        try {
            if ("birthday".equals(pMailSet.getSendTemple().trim())) {
                BirthdayMailSendRecord mBirthdayMailSendRecord = new BirthdayMailSendRecord();
                mBirthdayMailSendRecord.setId(pMailSet.getReSendRecordId());
                mBirthdayMailSendRecord.setPostTime(new Date());
                mBirthdayMailSendRecord.setPostStatus(new BigDecimal(pPostStatus));
                gBirthdayMailSendRecordMapper.updateByPrimaryKeySelective(mBirthdayMailSendRecord);
            }

            if ("anniversary".equals(pMailSet.getSendTemple().trim())) {
                AnniversaryMailSendRecord mAnniversaryMailSendRecord = new AnniversaryMailSendRecord();
                mAnniversaryMailSendRecord.setId(pMailSet.getReSendRecordId());
                mAnniversaryMailSendRecord.setPostTime(new Date());
                mAnniversaryMailSendRecord.setPostStatus(new BigDecimal(pPostStatus));
                gBAnniversaryMailSendRecordMapper.updateByPrimaryKeySelective(mAnniversaryMailSendRecord);
            }

            if ("readyToMember".equals(pMailSet.getSendTemple().trim())) {
                ReadyToMemberRecord mModifyReadyToMemberRecord = new ReadyToMemberRecord();
                ReadyToMemberRecord mReadyToMemberRecord = gReadyToMemberRecordMapper.selectByPrimaryKey(pMailSet.getReSendRecordId());
                if (null == mReadyToMemberRecord || null == mReadyToMemberRecord.getId()) {
                    mModifyReadyToMemberRecord.setId(pMailSet.getReSendRecordId());
                    if (null != pMailSet.getSendToUserName() && !"".equals(pMailSet.getSendToUserName())) {
                        mModifyReadyToMemberRecord.setName(pMailSet.getSendToUserName());
                    }
                    String mUserEmail = String.join(",", pMailSet.getSendToAddress());
                    if (null != mUserEmail && !"".equals(mUserEmail)) {
                        mModifyReadyToMemberRecord.setEmail(mUserEmail);
                    }
                    String mContent = mUserEmail + (pMailSet.getCopyToAddress() == null ? "" : "," + String.join(",", pMailSet.getCopyToAddress()));
                    if (null != mContent && !"".equals(mContent)) {
                        mModifyReadyToMemberRecord.setContent(mUserEmail);
                    }
                    if (null != pMailSet.getVocationalDate() && !"".equals(pMailSet.getVocationalDate())) {
                        mModifyReadyToMemberRecord.setMemberDate(DateTool.parseStandardDatetime(pMailSet.getVocationalDate() + " 00:00:00"));
                    }
                    if (null != pMailSet.getSendToUserWorkId() && !"".equals(pMailSet.getSendToUserWorkId())) {
                        mModifyReadyToMemberRecord.setWorkId(pMailSet.getSendToUserWorkId());
                    }
                    mModifyReadyToMemberRecord.setPostStatus(new BigDecimal(pPostStatus));
                    mModifyReadyToMemberRecord.setPostTime(new Date());
                    gReadyToMemberRecordMapper.insertSelective(mModifyReadyToMemberRecord);
                } else {
                    mModifyReadyToMemberRecord.setId(pMailSet.getReSendRecordId());
                    mModifyReadyToMemberRecord.setMemberDate(DateTool.parseStandardDatetime(pMailSet.getVocationalDate() + " 00:00:00"));
                    mModifyReadyToMemberRecord.setPostTime(new Date());
                    mModifyReadyToMemberRecord.setPostStatus(new BigDecimal(pPostStatus));
                    gReadyToMemberRecordMapper.updateByPrimaryKeySelective(mModifyReadyToMemberRecord);
                }
            }

            if ("contractExpire".equals(pMailSet.getSendTemple().trim())) {
                ContractExpireRecord mModifyContractExpireRecord = new ContractExpireRecord();
                ContractExpireRecord mContractExpireRecord = gContractExpireRecordMapper.selectByPrimaryKey(pMailSet.getReSendRecordId());
                if (null == mContractExpireRecord || null == mContractExpireRecord.getId()) {
                    mModifyContractExpireRecord.setId(pMailSet.getReSendRecordId());
                    if (null != pMailSet.getSendToUserName() && !"".equals(pMailSet.getSendToUserName())) {
                        mModifyContractExpireRecord.setName(pMailSet.getSendToUserName());
                    }
                    String mUserEmail = String.join(",", pMailSet.getSendToAddress());
                    if (null != mUserEmail && !"".equals(mUserEmail)) {
                        mModifyContractExpireRecord.setEmail(mUserEmail);
                    }
                    String mContent = mUserEmail + (pMailSet.getCopyToAddress() == null ? "" : "," + String.join(",", pMailSet.getCopyToAddress()));
                    if (null != mContent && !"".equals(mContent)) {
                        mModifyContractExpireRecord.setContent(mUserEmail);
                    }
                    if (null != pMailSet.getVocationalDate() && !"".equals(pMailSet.getVocationalDate())) {
                        mModifyContractExpireRecord.setExpireDate(DateTool.parseStandardDatetime(pMailSet.getVocationalDate() + " 00:00:00"));
                    }
                    if (null != pMailSet.getSendToUserWorkId() && !"".equals(pMailSet.getSendToUserWorkId())) {
                        mModifyContractExpireRecord.setWorkId(pMailSet.getSendToUserWorkId());
                    }
                    mModifyContractExpireRecord.setPostStatus(new BigDecimal(pPostStatus));
                    mModifyContractExpireRecord.setPostTime(new Date());
                    gContractExpireRecordMapper.insertSelective(mModifyContractExpireRecord);
                } else {
                    mModifyContractExpireRecord.setId(pMailSet.getReSendRecordId());
                    mModifyContractExpireRecord.setPostTime(new Date());
                    mModifyContractExpireRecord.setExpireDate(DateTool.parseStandardDatetime(pMailSet.getVocationalDate() + " 00:00:00"));
                    mModifyContractExpireRecord.setPostStatus(new BigDecimal(pPostStatus));
                    gContractExpireRecordMapper.updateByPrimaryKeySelective(mModifyContractExpireRecord);
                }
            }
        } catch (Exception ex) {
            gLog.error("操作发送状态出错！", pMailSet, ex);
        }
    }
}
