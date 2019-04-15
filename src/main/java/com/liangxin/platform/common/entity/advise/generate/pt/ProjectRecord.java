package com.liangxin.platform.common.entity.advise.generate.pt;

import java.math.BigDecimal;
import java.util.Date;

public class ProjectRecord {
    /**
     * ID
     */
    private String id;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 所有人
     */
    private String everyone;

    /**
     * 成套厂
     */
    private String buildFactory;

    /**
     * 报备内容
     */
    private String recordMessage;

    /**
     * 报备人员（工号、姓名）
     */
    private String recorderInfo;

    /**
     * 报备日期
     */
    private String recordDate;

    /**
     * 是否已推送成功0 FAIL,1 SUCCESS
     */
    private BigDecimal informStatus;

    /**
     * OA流程编号
     */
    private String oaNumber;

    /**
     * null
     */
    private Date createTime;

    /**
     * null
     */
    private Date updateTime;

    /**
     * 0 UNDELETED , 1 DELETED
     */
    private BigDecimal deleteFlag;

    /**
     * ID
     * @return ID_ ID
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     * @param id ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 项目名称
     * @return NAME_ 项目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 项目名称
     * @param name 项目名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所有人
     * @return EVERYONE_ 所有人
     */
    public String getEveryone() {
        return everyone;
    }

    /**
     * 所有人
     * @param everyone 所有人
     */
    public void setEveryone(String everyone) {
        this.everyone = everyone == null ? null : everyone.trim();
    }

    /**
     * 成套厂
     * @return BUILD_FACTORY_ 成套厂
     */
    public String getBuildFactory() {
        return buildFactory;
    }

    /**
     * 成套厂
     * @param buildFactory 成套厂
     */
    public void setBuildFactory(String buildFactory) {
        this.buildFactory = buildFactory == null ? null : buildFactory.trim();
    }

    /**
     * 报备内容
     * @return RECORD_MESSAGE_ 报备内容
     */
    public String getRecordMessage() {
        return recordMessage;
    }

    /**
     * 报备内容
     * @param recordMessage 报备内容
     */
    public void setRecordMessage(String recordMessage) {
        this.recordMessage = recordMessage == null ? null : recordMessage.trim();
    }

    /**
     * 报备人员（工号、姓名）
     * @return RECORDER_INFO_ 报备人员（工号、姓名）
     */
    public String getRecorderInfo() {
        return recorderInfo;
    }

    /**
     * 报备人员（工号、姓名）
     * @param recorderInfo 报备人员（工号、姓名）
     */
    public void setRecorderInfo(String recorderInfo) {
        this.recorderInfo = recorderInfo == null ? null : recorderInfo.trim();
    }

    /**
     * 报备日期
     * @return RECORD_DATE_ 报备日期
     */
    public String getRecordDate() {
        return recordDate;
    }

    /**
     * 报备日期
     * @param recordDate 报备日期
     */
    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate == null ? null : recordDate.trim();
    }

    /**
     * 是否已推送成功0 FAIL,1 SUCCESS
     * @return INFORM_STATUS_ 是否已推送成功0 FAIL,1 SUCCESS
     */
    public BigDecimal getInformStatus() {
        return informStatus;
    }

    /**
     * 是否已推送成功0 FAIL,1 SUCCESS
     * @param informStatus 是否已推送成功0 FAIL,1 SUCCESS
     */
    public void setInformStatus(BigDecimal informStatus) {
        this.informStatus = informStatus;
    }

    /**
     * OA流程编号
     * @return OA_NUMBER_ OA流程编号
     */
    public String getOaNumber() {
        return oaNumber;
    }

    /**
     * OA流程编号
     * @param oaNumber OA流程编号
     */
    public void setOaNumber(String oaNumber) {
        this.oaNumber = oaNumber == null ? null : oaNumber.trim();
    }

    /**
     * null
     * @return CREATE_TIME_ null
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * null
     * @param createTime null
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * null
     * @return UPDATE_TIME_ null
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * null
     * @param updateTime null
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 0 UNDELETED , 1 DELETED
     * @return DELETE_FLAG_ 0 UNDELETED , 1 DELETED
     */
    public BigDecimal getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 0 UNDELETED , 1 DELETED
     * @param deleteFlag 0 UNDELETED , 1 DELETED
     */
    public void setDeleteFlag(BigDecimal deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}