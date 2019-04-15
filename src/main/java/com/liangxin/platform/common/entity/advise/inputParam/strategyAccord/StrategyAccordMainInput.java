package com.liangxin.platform.common.entity.advise.inputParam.strategyAccord;

import java.math.BigDecimal;
import java.util.Date;

public class StrategyAccordMainInput {
    /**
     * ID
     */
    private String id;

    /**
     * 相关领导
     */
    private String supervisors;

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
     * 负责人
     */
    private String informStuff;

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


    private Integer currentPage = 1;

    private Integer pageSize = 20;

    private String searchStartDate;

    private String searchEndDate;

    /**
     * 是否超期
     */
    private Integer nowDay;

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
     * 相关领导
     *
     * @return SUPERVISORS_ 相关领导
     */
    public String getSupervisors() {
        return supervisors;
    }

    /**
     * 相关领导
     *
     * @param supervisors 相关领导
     */
    public void setSupervisors(String supervisors) {
        this.supervisors = supervisors == null ? null : supervisors.trim();
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
     * 负责人
     *
     * @return INFORM_STUFF_ 负责人
     */
    public String getInformStuff() {
        return informStuff;
    }

    /**
     * 负责人
     *
     * @param informStuff 负责人
     */
    public void setInformStuff(String informStuff) {
        this.informStuff = informStuff == null ? null : informStuff.trim();
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

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearchStartDate() {
        return searchStartDate;
    }

    public void setSearchStartDate(String searchStartDate) {
        this.searchStartDate = searchStartDate;
    }

    public String getSearchEndDate() {
        return searchEndDate;
    }

    public void setSearchEndDate(String searchEndDate) {
        this.searchEndDate = searchEndDate;
    }

    public Integer getNowDay() {
        return nowDay;
    }

    public void setNowDay(Integer nowDay) {
        this.nowDay = nowDay;
    }

    public String getSubmiterNumber() {
        return submiterNumber;
    }

    public void setSubmiterNumber(String submiterNumber) {
        this.submiterNumber = submiterNumber;
    }
}
