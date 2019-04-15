package com.liangxin.platform.common.entity.advise.inputParam.strategyAccord;

import java.math.BigDecimal;

public class StrategyAccordWebserviceInput {

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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSupervisorsNumber() {
        return supervisorsNumber;
    }

    public void setSupervisorsNumber(String supervisorsNumber) {
        this.supervisorsNumber = supervisorsNumber;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getClientAbbreviation() {
        return clientAbbreviation;
    }

    public void setClientAbbreviation(String clientAbbreviation) {
        this.clientAbbreviation = clientAbbreviation;
    }

    public String getFirstCoorperationTime() {
        return firstCoorperationTime;
    }

    public void setFirstCoorperationTime(String firstCoorperationTime) {
        this.firstCoorperationTime = firstCoorperationTime;
    }

    public String getValidAccordStartTime() {
        return validAccordStartTime;
    }

    public void setValidAccordStartTime(String validAccordStartTime) {
        this.validAccordStartTime = validAccordStartTime;
    }

    public String getValidAccordEndTime() {
        return validAccordEndTime;
    }

    public void setValidAccordEndTime(String validAccordEndTime) {
        this.validAccordEndTime = validAccordEndTime;
    }

    public String getCoorperationRange() {
        return coorperationRange;
    }

    public void setCoorperationRange(String coorperationRange) {
        this.coorperationRange = coorperationRange;
    }

    public String getCoorperationPattern() {
        return coorperationPattern;
    }

    public void setCoorperationPattern(String coorperationPattern) {
        this.coorperationPattern = coorperationPattern;
    }

    public String getQualifiedBrand() {
        return qualifiedBrand;
    }

    public void setQualifiedBrand(String qualifiedBrand) {
        this.qualifiedBrand = qualifiedBrand;
    }

    public String getInformStuffOneNumber() {
        return informStuffOneNumber;
    }

    public void setInformStuffOneNumber(String informStuffOneNumber) {
        this.informStuffOneNumber = informStuffOneNumber;
    }

    public BigDecimal getInformStatus() {
        return informStatus;
    }

    public void setInformStatus(BigDecimal informStatus) {
        this.informStatus = informStatus;
    }

    public String getOaId() {
        return oaId;
    }

    public void setOaId(String oaId) {
        this.oaId = oaId;
    }

    public String getRankings() {
        return rankings;
    }

    public void setRankings(String rankings) {
        this.rankings = rankings;
    }

    public String getInformStuff() {
        return informStuff;
    }

    public void setInformStuff(String informStuff) {
        this.informStuff = informStuff;
    }

    public String getInformStuffTwoNumber() {
        return informStuffTwoNumber;
    }

    public void setInformStuffTwoNumber(String informStuffTwoNumber) {
        this.informStuffTwoNumber = informStuffTwoNumber;
    }

    public String getInformStuffTwoName() {
        return informStuffTwoName;
    }

    public void setInformStuffTwoName(String informStuffTwoName) {
        this.informStuffTwoName = informStuffTwoName;
    }

    public String getSupervisorsName() {
        return supervisorsName;
    }

    public void setSupervisorsName(String supervisorsName) {
        this.supervisorsName = supervisorsName;
    }

    public String getSubmiterName() {
        return submiterName;
    }

    public void setSubmiterName(String submiterName) {
        this.submiterName = submiterName;
    }

    public String getSubmiterNumber() {
        return submiterNumber;
    }

    public void setSubmiterNumber(String submiterNumber) {
        this.submiterNumber = submiterNumber;
    }

}
