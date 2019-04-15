package com.liangxin.platform.common.entity.advise.generate.pt;

import java.math.BigDecimal;
import java.util.Date;

public class Capital {
    /**
     * null
     */
    private Object id;

    /**
     * null
     */
    private String name;

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
    private String workId;

    /**
     * null
     */
    private String workshopLine;

    /**
     * null
     */
    private BigDecimal isLeave;

    /**
     * null
     * @return ID_ null
     */
    public Object getId() {
        return id;
    }

    /**
     * null
     * @param id null
     */
    public void setId(Object id) {
        this.id = id;
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
     * @return WORKSHOP_LINE_ null
     */
    public String getWorkshopLine() {
        return workshopLine;
    }

    /**
     * null
     * @param workshopLine null
     */
    public void setWorkshopLine(String workshopLine) {
        this.workshopLine = workshopLine == null ? null : workshopLine.trim();
    }

    /**
     * null
     * @return IS_LEAVE_ null
     */
    public BigDecimal getIsLeave() {
        return isLeave;
    }

    /**
     * null
     * @param isLeave null
     */
    public void setIsLeave(BigDecimal isLeave) {
        this.isLeave = isLeave;
    }
}