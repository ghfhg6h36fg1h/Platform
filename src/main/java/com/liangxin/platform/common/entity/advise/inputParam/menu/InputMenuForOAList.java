package com.liangxin.platform.common.entity.advise.inputParam.menu;

import java.math.BigDecimal;
import java.util.Date;

public class InputMenuForOAList {
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
     * null
     */
    private BigDecimal disable;

    /**
     * null
     */
    private String parentId;

    /**
     * null
     */
    private BigDecimal type;

    /**
     * 菜单等级，从0开始
     */
    private BigDecimal level;

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
    private String actionUrl;

    private Integer currentPage = 1;
    private Integer pageSize = 10;

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

    /**
     * null
     *
     * @return ID_ null
     */
    public String getId() {
        return id;
    }

    /**
     * null
     *
     * @param id null
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * null
     *
     * @return NAME_ null
     */
    public String getName() {
        return name;
    }

    /**
     * null
     *
     * @param name null
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * null
     *
     * @return DESC_ null
     */
    public String getDesc() {
        return desc;
    }

    /**
     * null
     *
     * @param desc null
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * null
     *
     * @return DISABLE_ null
     */
    public BigDecimal getDisable() {
        return disable;
    }

    /**
     * null
     *
     * @param disable null
     */
    public void setDisable(BigDecimal disable) {
        this.disable = disable;
    }

    /**
     * null
     *
     * @return PARENT_ID_ null
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * null
     *
     * @param parentId null
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * null
     *
     * @return TYPE_ null
     */
    public BigDecimal getType() {
        return type;
    }

    /**
     * null
     *
     * @param type null
     */
    public void setType(BigDecimal type) {
        this.type = type;
    }

    /**
     * 菜单等级，从0开始
     *
     * @return LEVEL_ 菜单等级，从0开始
     */
    public BigDecimal getLevel() {
        return level;
    }

    /**
     * 菜单等级，从0开始
     *
     * @param level 菜单等级，从0开始
     */
    public void setLevel(BigDecimal level) {
        this.level = level;
    }

    /**
     * null
     *
     * @return DELETE_FLAG_ null
     */
    public BigDecimal getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * null
     *
     * @param deleteFlag null
     */
    public void setDeleteFlag(BigDecimal deleteFlag) {
        this.deleteFlag = deleteFlag;
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
     * null
     *
     * @return ACTION_URL_ null
     */
    public String getActionUrl() {
        return actionUrl;
    }

    /**
     * null
     *
     * @param actionUrl null
     */
    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl == null ? null : actionUrl.trim();
    }
}
