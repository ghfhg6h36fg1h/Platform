package com.liangxin.platform.common.entity.advise.inputParam.user;

import java.math.BigDecimal;
import java.util.Date;

public class BaseInput {
    /**
     * null
     */
    private String id;

    /**
     * null
     */
    private String name;

    /**
     * null
     */
    private String phone;

    /**
     * null
     */
    private String mail;

    /**
     * 验证信息，密码存储字段！
     */
    private String confirmation;

    /**
     * null
     */
    private String idCard;

    /**
     * null
     */
    private String workId;

    /**
     * 第一次踏入社会工作的时间！
     */
    private Date workDate;

    /**
     * 入职时间！
     */
    private Date entryDate;

    /**
     * 0为女，1为男，2未添
     */
    private BigDecimal gender;

    /**
     * 是否有效字段
     */
    private BigDecimal isValid;

    /**
     * null
     */
    private BigDecimal deleteFlag;

    /**
     * null
     */
    private Date createTime;

    /**
     * null
     */
    private Date updateTime;

    /**
     * null
     */
    private String address;

    /**
     * null
     */
    private String userName;
    private Integer currentPage;
    private Integer pageSize;

    /**
     * null
     * @return ID_ null
     */
    public String getId() {
        return id;
    }

    /**
     * null
     * @param id null
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * null
     * @return NAME_ null
     */
    public String getName() {
        return name;
    }

    /**
     * null
     * @param name null
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * null
     * @return PHONE_ null
     */
    public String getPhone() {
        return phone;
    }

    /**
     * null
     * @param phone null
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * null
     * @return MAIL_ null
     */
    public String getMail() {
        return mail;
    }

    /**
     * null
     * @param mail null
     */
    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    /**
     * 验证信息，密码存储字段！
     * @return CONFIRMATION_ 验证信息，密码存储字段！
     */
    public String getConfirmation() {
        return confirmation;
    }

    /**
     * 验证信息，密码存储字段！
     * @param confirmation 验证信息，密码存储字段！
     */
    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation == null ? null : confirmation.trim();
    }

    /**
     * null
     * @return ID_CARD_ null
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * null
     * @param idCard null
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * null
     * @return WORK_ID_ null
     */
    public String getWorkId() {
        return workId;
    }

    /**
     * null
     * @param workId null
     */
    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    /**
     * 第一次踏入社会工作的时间！
     * @return WORK_DATE_ 第一次踏入社会工作的时间！
     */
    public Date getWorkDate() {
        return workDate;
    }

    /**
     * 第一次踏入社会工作的时间！
     * @param workDate 第一次踏入社会工作的时间！
     */
    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    /**
     * 入职时间！
     * @return ENTRY_DATE_ 入职时间！
     */
    public Date getEntryDate() {
        return entryDate;
    }

    /**
     * 入职时间！
     * @param entryDate 入职时间！
     */
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    /**
     * 0为女，1为男，2未添
     * @return GENDER_ 0为女，1为男，2未添
     */
    public BigDecimal getGender() {
        return gender;
    }

    /**
     * 0为女，1为男，2未添
     * @param gender 0为女，1为男，2未添
     */
    public void setGender(BigDecimal gender) {
        this.gender = gender;
    }

    /**
     * 是否有效字段
     * @return IS_VALID_ 是否有效字段
     */
    public BigDecimal getIsValid() {
        return isValid;
    }

    /**
     * 是否有效字段
     * @param isValid 是否有效字段
     */
    public void setIsValid(BigDecimal isValid) {
        this.isValid = isValid;
    }

    /**
     * null
     * @return DELETE_FLAG_ null
     */
    public BigDecimal getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * null
     * @param deleteFlag null
     */
    public void setDeleteFlag(BigDecimal deleteFlag) {
        this.deleteFlag = deleteFlag;
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
     * null
     * @return ADDRESS_ null
     */
    public String getAddress() {
        return address;
    }

    /**
     * null
     * @param address null
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * null
     * @return USER_NAME_ null
     */
    public String getUserName() {
        return userName;
    }

    /**
     * null
     * @param userName null
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
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
}
