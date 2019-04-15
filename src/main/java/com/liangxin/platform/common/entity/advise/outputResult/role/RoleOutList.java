package com.liangxin.platform.common.entity.advise.outputResult.role;

import java.math.BigDecimal;
import java.util.Date;

public class RoleOutList {
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
    private String desc;

    /**
     * 是否启用
     */
    private BigDecimal disable;

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
    private String userId;

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
     * @return DESC_ null
     */
    public String getDesc() {
        return desc;
    }

    /**
     * null
     * @param desc null
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * 是否启用
     * @return DISABLE_ 是否启用
     */
    public BigDecimal getDisable() {
        return disable;
    }

    /**
     * 是否启用
     * @param disable 是否启用
     */
    public void setDisable(BigDecimal disable) {
        this.disable = disable;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
