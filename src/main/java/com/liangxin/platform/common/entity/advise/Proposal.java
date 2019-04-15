package com.liangxin.platform.common.entity.advise;

import java.util.Date;
import java.util.UUID;

public class Proposal {
    private String id = String.valueOf(UUID.randomUUID()).replace("-","");
    private String content;
    private String status;
    private int deleteFlag;
    private Date createTime;
    private Date updateTime;
    private String owner;
    private String capitalId;
    private String sectionName;
    private String theme;
    private String ownerName;
    private String presentSituation;
    private String examineOpinion;
    private Long monthInterest;
    private Long rewardAmount;
    private String oaProposalId;
    private Integer proposalType;
    private String occupation;
    private String oaStep;

    public Integer getProposalType() {
        return proposalType;
    }

    public void setProposalType(Integer proposalType) {
        this.proposalType = proposalType;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
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

    public int isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
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
        this.oaProposalId = oaProposalId;
    }

    public String getOaStep() {
        return oaStep;
    }

    public void setOaStep(String oaStep) {
        this.oaStep = oaStep;
    }
}
