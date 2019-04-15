package com.liangxin.platform.common.entity.advise.generate.pt;

import java.math.BigDecimal;
import java.util.Date;

public class BirthdayMailSendRecord {
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
    private String workId;

    /**
     * null
     */
    private String email;

    /**
     * null
     */
    private Date birthday;

    /**
     * null
     */
    private Date postTime;

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
    private BigDecimal deleteFlag;

    /**
     * 1：表示发送成功哦i，2：表示忽略发送，0：表示发送失败。
     */
    private BigDecimal postStatus;

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
     * null
     * @return EMAIL_ null
     */
    public String getEmail() {
        return email;
    }

    /**
     * null
     * @param email null
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * null
     * @return BIRTHDAY_ null
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * null
     * @param birthday null
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * null
     * @return POST_TIME_ null
     */
    public Date getPostTime() {
        return postTime;
    }

    /**
     * null
     * @param postTime null
     */
    public void setPostTime(Date postTime) {
        this.postTime = postTime;
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
     * 1：表示发送成功哦i，2：表示忽略发送，0：表示发送失败。
     * @return POST_STATUS_ 1：表示发送成功哦i，2：表示忽略发送，0：表示发送失败。
     */
    public BigDecimal getPostStatus() {
        return postStatus;
    }

    /**
     * 1：表示发送成功哦i，2：表示忽略发送，0：表示发送失败。
     * @param postStatus 1：表示发送成功哦i，2：表示忽略发送，0：表示发送失败。
     */
    public void setPostStatus(BigDecimal postStatus) {
        this.postStatus = postStatus;
    }
}