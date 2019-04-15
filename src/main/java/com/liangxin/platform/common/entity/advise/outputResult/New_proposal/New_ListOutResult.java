package com.liangxin.platform.common.entity.advise.outputResult.New_proposal;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class New_ListOutResult {
    private String id;

    private String content;

    private String status;

    private Integer deleteFlag;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private String owner;

    private String capitalId;

    private String sectionName;

    private String theme;

    private String ownerName;

    private String presentSituation;

    private String examineOpinion;

    private BigDecimal monthInterest;

    private BigDecimal rewardAmount;

    private String oaProposalId;

    private String occuption;

    private Integer proposalType;

    private String oaStep;

    private BigDecimal benefit;

    private Integer integral;

    private String picture1;

    private String picture1Tem;

    private String picture2;

    private String picture2Tem;

    private String oaProposalNum;

    private String type;

    private Integer good;

    private String capitalName;

    private String implementName;

    private String implementEmpno;

    private Integer implementIntegral;

    private String oaLinkHref;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCapitalId() {
        return capitalId;
    }

    public void setCapitalId(String capitalId) {
        this.capitalId = capitalId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPresentSituation() {
        return presentSituation;
    }

    public void setPresentSituation(String presentSituation) {
        this.presentSituation = presentSituation;
    }

    public String getExamineOpinion() {
        return examineOpinion;
    }

    public void setExamineOpinion(String examineOpinion) {
        this.examineOpinion = examineOpinion;
    }

    public BigDecimal getMonthInterest() {
        return monthInterest;
    }

    public void setMonthInterest(BigDecimal monthInterest) {
        this.monthInterest = monthInterest;
    }

    public BigDecimal getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(BigDecimal rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    public String getOaProposalId() {
        return oaProposalId;
    }

    public void setOaProposalId(String oaProposalId) {
        this.oaProposalId = oaProposalId;
    }

    public String getOccuption() {
        return occuption;
    }

    public void setOccuption(String occuption) {
        this.occuption = occuption;
    }

    public Integer getProposalType() {
        return proposalType;
    }

    public void setProposalType(Integer proposalType) {
        this.proposalType = proposalType;
    }

    public String getOaStep() {
        return oaStep;
    }

    public void setOaStep(String oaStep) {
        this.oaStep = oaStep;
    }

    public BigDecimal getBenefit() {
        return benefit;
    }

    public void setBenefit(BigDecimal benefit) {
        this.benefit = benefit;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getPicture1() {
        return picture1;
    }

    public void setPicture1(String picture1) {
        this.picture1 = picture1;
    }

    public String getPicture1Tem() {
        return picture1Tem;
    }

    public void setPicture1Tem(String picture1Tem) {
        this.picture1Tem = picture1Tem;
    }

    public String getPicture2() {
        return picture2;
    }

    public void setPicture2(String picture2) {
        this.picture2 = picture2;
    }

    public String getPicture2Tem() {
        return picture2Tem;
    }

    public void setPicture2Tem(String picture2Tem) {
        this.picture2Tem = picture2Tem;
    }

    public String getOaProposalNum() {
        return oaProposalNum;
    }

    public void setOaProposalNum(String oaProposalNum) {
        this.oaProposalNum = oaProposalNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getGood() {
        return good;
    }

    public void setGood(Integer good) {
        this.good = good;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public String getImplementName() {
        return implementName;
    }

    public void setImplementName(String implementName) {
        this.implementName = implementName;
    }

    public String getImplementEmpno() {
        return implementEmpno;
    }

    public void setImplementEmpno(String implementEmpno) {
        this.implementEmpno = implementEmpno;
    }

    public Integer getImplementIntegral() {
        return implementIntegral;
    }

    public void setImplementIntegral(Integer implementIntegral) {
        this.implementIntegral = implementIntegral;
    }

    public String getOaLinkHref() {
        return oaLinkHref;
    }

    public void setOaLinkHref(String oaLinkHref) {
        this.oaLinkHref = oaLinkHref;
    }
}