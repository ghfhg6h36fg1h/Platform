package com.liangxin.platform.common.entity.advise.generate.pt;

import java.math.BigDecimal;
import java.util.Date;

public class StrategyAccord {
    /**
     * ID
     */
    private String id;

    /**
     * 相关领导NUMBER
     */
    private String supervisorsNumber;

    /**
     * 所属区域
     */
    private String district;

    /**
     * 公司全称
     */
    private String companyName;

    /**
     * 客户简称
     */
    private String clientAbbreviation;

    /**
     * 最早合作时间
     */
    private String firstCoorperationTime;

    /**
     * 有效协议开始时间
     */
    private String validAccordStartTime;

    /**
     * 有效协议结束时间
     */
    private String validAccordEndTime;

    /**
     * 合作范围
     */
    private String coorperationRange;

    /**
     * 合作模式
     */
    private String coorperationPattern;

    /**
     * 入围品牌
     */
    private String qualifiedBrand;

    /**
     * 负责人1_NUMBER
     */
    private String informStuffOneNumber;

    /**
     * 是否已推送成功,0 为失败，1为成功
     */
    private BigDecimal informStatus;

    /**
     * OA流程编号
     */
    private String oaId;

    /**
     * null
     */
    private Date createTime;

    /**
     * null
     */
    private Date updateTime;

    /**
     * 0为有效数据，1为已删除数据
     */
    private BigDecimal deleteFlag;

    /**
     * null
     */
    private String rankings;

    /**
     * INFORM STUFF ONE NAME.
     */
    private String informStuff;

    /**
     * INFORM_STUFF_TWO_NUMBER_
     */
    private String informStuffTwoNumber;

    /**
     * INFORM_STUFF_TWO_NAME_
     */
    private String informStuffTwoName;

    /**
     * SUPERVISORS_NAME_
     */
    private String supervisorsName;

    /**
     * SUBMITER  NAME
     */
    private String submiterName;

    /**
     * SUBMITER NUMBER
     */
    private String submiterNumber;

    /**
     * ID
     *
     * @return ID_ ID
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     *
     * @param id ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 相关领导NUMBER
     *
     * @return SUPERVISORS_NUMBER_ 相关领导NUMBER
     */
    public String getSupervisorsNumber() {
        return supervisorsNumber;
    }

    /**
     * 相关领导NUMBER
     *
     * @param supervisorsNumber 相关领导NUMBER
     */
    public void setSupervisorsNumber(String supervisorsNumber) {
        this.supervisorsNumber = supervisorsNumber == null ? null : supervisorsNumber.trim();
    }

    /**
     * 所属区域
     *
     * @return DISTRICT_ 所属区域
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 所属区域
     *
     * @param district 所属区域
     */
    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    /**
     * 公司全称
     *
     * @return COMPANY_NAME_ 公司全称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 公司全称
     *
     * @param companyName 公司全称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 客户简称
     *
     * @return CLIENT_ABBREVIATION_ 客户简称
     */
    public String getClientAbbreviation() {
        return clientAbbreviation;
    }

    /**
     * 客户简称
     *
     * @param clientAbbreviation 客户简称
     */
    public void setClientAbbreviation(String clientAbbreviation) {
        this.clientAbbreviation = clientAbbreviation == null ? null : clientAbbreviation.trim();
    }

    /**
     * 最早合作时间
     *
     * @return FIRST_COORPERATION_TIME_ 最早合作时间
     */
    public String getFirstCoorperationTime() {
        return firstCoorperationTime;
    }

    /**
     * 最早合作时间
     *
     * @param firstCoorperationTime 最早合作时间
     */
    public void setFirstCoorperationTime(String firstCoorperationTime) {
        this.firstCoorperationTime = firstCoorperationTime == null ? null : firstCoorperationTime.trim();
    }

    /**
     * 有效协议开始时间
     *
     * @return VALID_ACCORD_START_TIME_ 有效协议开始时间
     */
    public String getValidAccordStartTime() {
        return validAccordStartTime;
    }

    /**
     * 有效协议开始时间
     *
     * @param validAccordStartTime 有效协议开始时间
     */
    public void setValidAccordStartTime(String validAccordStartTime) {
        this.validAccordStartTime = validAccordStartTime == null ? null : validAccordStartTime.trim();
    }

    /**
     * 有效协议结束时间
     *
     * @return VALID_ACCORD_END_TIME_ 有效协议结束时间
     */
    public String getValidAccordEndTime() {
        return validAccordEndTime;
    }

    /**
     * 有效协议结束时间
     *
     * @param validAccordEndTime 有效协议结束时间
     */
    public void setValidAccordEndTime(String validAccordEndTime) {
        this.validAccordEndTime = validAccordEndTime == null ? null : validAccordEndTime.trim();
    }

    /**
     * 合作范围
     *
     * @return COORPERATION_RANGE_ 合作范围
     */
    public String getCoorperationRange() {
        return coorperationRange;
    }

    /**
     * 合作范围
     *
     * @param coorperationRange 合作范围
     */
    public void setCoorperationRange(String coorperationRange) {
        this.coorperationRange = coorperationRange == null ? null : coorperationRange.trim();
    }

    /**
     * 合作模式
     *
     * @return COORPERATION_PATTERN_ 合作模式
     */
    public String getCoorperationPattern() {
        return coorperationPattern;
    }

    /**
     * 合作模式
     *
     * @param coorperationPattern 合作模式
     */
    public void setCoorperationPattern(String coorperationPattern) {
        this.coorperationPattern = coorperationPattern == null ? null : coorperationPattern.trim();
    }

    /**
     * 入围品牌
     *
     * @return QUALIFIED_BRAND_ 入围品牌
     */
    public String getQualifiedBrand() {
        return qualifiedBrand;
    }

    /**
     * 入围品牌
     *
     * @param qualifiedBrand 入围品牌
     */
    public void setQualifiedBrand(String qualifiedBrand) {
        this.qualifiedBrand = qualifiedBrand == null ? null : qualifiedBrand.trim();
    }

    /**
     * 负责人1_NUMBER
     *
     * @return INFORM_STUFF_ONE_NUMBER_ 负责人1_NUMBER
     */
    public String getInformStuffOneNumber() {
        return informStuffOneNumber;
    }

    /**
     * 负责人1_NUMBER
     *
     * @param informStuffOneNumber 负责人1_NUMBER
     */
    public void setInformStuffOneNumber(String informStuffOneNumber) {
        if (!"NIL".equals(informStuffOneNumber)) {
            this.informStuffOneNumber = informStuffOneNumber == null ? null : informStuffOneNumber.trim();
        } else {
            this.informStuffOneNumber = "";
        }
    }

    /**
     * 是否已推送成功,0 为失败，1为成功
     *
     * @return INFORM_STATUS_ 是否已推送成功,0 为失败，1为成功
     */
    public BigDecimal getInformStatus() {
        return informStatus;
    }

    /**
     * 是否已推送成功,0 为失败，1为成功
     *
     * @param informStatus 是否已推送成功,0 为失败，1为成功
     */
    public void setInformStatus(BigDecimal informStatus) {
        this.informStatus = informStatus;
    }

    /**
     * OA流程编号
     *
     * @return OA_ID_ OA流程编号
     */
    public String getOaId() {
        return oaId;
    }

    /**
     * OA流程编号
     *
     * @param oaId OA流程编号
     */
    public void setOaId(String oaId) {
        this.oaId = oaId == null ? null : oaId.trim();
    }

    /**
     * null
     *
     * @return CREATE_TIME_ null
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * null
     *
     * @param createTime null
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * null
     *
     * @return UPDATE_TIME_ null
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * null
     *
     * @param updateTime null
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 0为有效数据，1为已删除数据
     *
     * @return DELETE_FLAG_ 0为有效数据，1为已删除数据
     */
    public BigDecimal getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 0为有效数据，1为已删除数据
     *
     * @param deleteFlag 0为有效数据，1为已删除数据
     */
    public void setDeleteFlag(BigDecimal deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * null
     *
     * @return RANKINGS null
     */
    public String getRankings() {
        return rankings;
    }

    /**
     * null
     *
     * @param rankings null
     */
    public void setRankings(String rankings) {
        this.rankings = rankings == null ? null : rankings.trim();
    }

    /**
     * INFORM STUFF ONE NAME.
     *
     * @return INFORM_STUFF_ INFORM STUFF ONE NAME.
     */
    public String getInformStuff() {
        return informStuff;
    }

    /**
     * INFORM STUFF ONE NAME.
     *
     * @param informStuff INFORM STUFF ONE NAME.
     */
    public void setInformStuff(String informStuff) {
        if (!"NIL".equals(informStuff)) {
            this.informStuff = informStuff == null ? null : informStuff.trim();
        } else {
            this.informStuff = "";
        }
    }

    /**
     * INFORM_STUFF_TWO_NUMBER_
     *
     * @return INFORM_STUFF_TWO_NUMBER_ INFORM_STUFF_TWO_NUMBER_
     */
    public String getInformStuffTwoNumber() {
        return informStuffTwoNumber;
    }

    /**
     * INFORM_STUFF_TWO_NUMBER_
     *
     * @param informStuffTwoNumber INFORM_STUFF_TWO_NUMBER_
     */
    public void setInformStuffTwoNumber(String informStuffTwoNumber) {
        this.informStuffTwoNumber = informStuffTwoNumber == null ? null : informStuffTwoNumber.trim();
    }

    /**
     * INFORM_STUFF_TWO_NAME_
     *
     * @return INFORM_STUFF_TWO_NAME_ INFORM_STUFF_TWO_NAME_
     */
    public String getInformStuffTwoName() {
        return informStuffTwoName;
    }

    /**
     * INFORM_STUFF_TWO_NAME_
     *
     * @param informStuffTwoName INFORM_STUFF_TWO_NAME_
     */
    public void setInformStuffTwoName(String informStuffTwoName) {
        this.informStuffTwoName = informStuffTwoName == null ? null : informStuffTwoName.trim();
    }

    /**
     * SUPERVISORS_NAME_
     *
     * @return SUPERVISORS_NAME_ SUPERVISORS_NAME_
     */
    public String getSupervisorsName() {
        return supervisorsName;
    }

    /**
     * SUPERVISORS_NAME_
     *
     * @param supervisorsName SUPERVISORS_NAME_
     */
    public void setSupervisorsName(String supervisorsName) {
        this.supervisorsName = supervisorsName == null ? null : supervisorsName.trim();
    }

    /**
     * SUBMITER  NAME
     *
     * @return SUBMITER_NAME_ SUBMITER  NAME
     */
    public String getSubmiterName() {
        return submiterName;
    }

    /**
     * SUBMITER  NAME
     *
     * @param submiterName SUBMITER  NAME
     */
    public void setSubmiterName(String submiterName) {
        this.submiterName = submiterName == null ? null : submiterName.trim();
    }

    /**
     * SUBMITER NUMBER
     *
     * @return SUBMITER_NUMBER_ SUBMITER NUMBER
     */
    public String getSubmiterNumber() {
        return submiterNumber;
    }

    /**
     * SUBMITER NUMBER
     *
     * @param submiterNumber SUBMITER NUMBER
     */
    public void setSubmiterNumber(String submiterNumber) {
        this.submiterNumber = submiterNumber == null ? null : submiterNumber.trim();
    }
}