package com.liangxin.platform.common.entity.advise.outputResult.proposal;

import com.liangxin.platform.common.tools.DateTool;

import java.util.Date;

public class ListOutResult {
    private String id;
    private String content;
    private String status;
    private boolean deleteFlag;
    private String createTime;
    private String updateTime;
    private String owner;
    private String capital;
    private String capitalId;
    private String sectionName;
    private String theme;
    private String ownerName;
    private String presentSituation;
    private String examineOpinion;
    private Long monthInterest;
    private Long rewardAmount;
    private String oaProposalId;
    private String step;
    private int proposalType;
    private String occupation;
    private String flowSteps;
    private String oaLinkHref;
    private String statusCode;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getOaLinkHref() {
        return oaLinkHref;
    }

    public void setOaLinkHref(String oaLinkHref) {
        this.oaLinkHref = oaLinkHref;
    }

    public String getFlowSteps() {
        return flowSteps;
    }

    public void setFlowSteps(String flowSteps) {
        this.flowSteps = flowSteps;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        if("NIL".equals(occupation)){
            this.occupation = "";
        }else {
            this.occupation = occupation;
        }
    }

    public int getProposalType() {
        return proposalType;
    }

    public void setProposalType(int proposalType) {
        this.proposalType = proposalType;
    }

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

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = DateTool.formatChinese(createTime);
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = DateTool.formatChinese(updateTime);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
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
        if("NIL".equals(examineOpinion)){
            this.examineOpinion = "";
        }else {
            this.examineOpinion = examineOpinion;
        }
    }

    public Long getMonthInterest() {
        return monthInterest;
    }

    public void setMonthInterest(Long monthInterest) {
        this.monthInterest = monthInterest;
    }

    public Long getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(Long rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    public String getOaProposalId() {
        return oaProposalId;
    }

    public void setOaProposalId(String oaProposalId) {
        if("NIL".equals(oaProposalId)){
            this.oaProposalId = "";
        }else {
            this.oaProposalId = oaProposalId;
        }
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }
}
