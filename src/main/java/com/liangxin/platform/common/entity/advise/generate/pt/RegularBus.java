package com.liangxin.platform.common.entity.advise.generate.pt;

import java.math.BigDecimal;
import java.util.Date;

public class RegularBus {
    /**
     * null
     */
    private Object id;

    /**
     * null
     */
    private Object name;

    /**
     * null
     */
    private Object desc;

    /**
     * null
     */
    private Object carNumber;

    /**
     * 1：宿舍，2：厂区
     */
    private BigDecimal from;

    /**
     * 1：宿舍，2：厂区
     */
    private BigDecimal to;

    /**
     * null
     */
    private Object setOutTime;

    /**
     * null
     */
    private Object arriveTime;

    /**
     * null
     */
    private Date updateTime;

    /**
     * null
     */
    private Date createTime;

    /**
     * null
     */
    private BigDecimal deleteFlag;

    /**
     * 1：工作日，2：周六，3：周日
     */
    private BigDecimal timeType;

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
    public Object getName() {
        return name;
    }

    /**
     * null
     * @param name null
     */
    public void setName(Object name) {
        this.name = name;
    }

    /**
     * null
     * @return DESC_ null
     */
    public Object getDesc() {
        return desc;
    }

    /**
     * null
     * @param desc null
     */
    public void setDesc(Object desc) {
        this.desc = desc;
    }

    /**
     * null
     * @return CAR_NUMBER_ null
     */
    public Object getCarNumber() {
        return carNumber;
    }

    /**
     * null
     * @param carNumber null
     */
    public void setCarNumber(Object carNumber) {
        this.carNumber = carNumber;
    }

    /**
     * 1：宿舍，2：厂区
     * @return FROM_ 1：宿舍，2：厂区
     */
    public BigDecimal getFrom() {
        return from;
    }

    /**
     * 1：宿舍，2：厂区
     * @param from 1：宿舍，2：厂区
     */
    public void setFrom(BigDecimal from) {
        this.from = from;
    }

    /**
     * 1：宿舍，2：厂区
     * @return TO_ 1：宿舍，2：厂区
     */
    public BigDecimal getTo() {
        return to;
    }

    /**
     * 1：宿舍，2：厂区
     * @param to 1：宿舍，2：厂区
     */
    public void setTo(BigDecimal to) {
        this.to = to;
    }

    /**
     * null
     * @return SET_OUT_TIME_ null
     */
    public Object getSetOutTime() {
        return setOutTime;
    }

    /**
     * null
     * @param setOutTime null
     */
    public void setSetOutTime(Object setOutTime) {
        this.setOutTime = setOutTime;
    }

    /**
     * null
     * @return ARRIVE_TIME_ null
     */
    public Object getArriveTime() {
        return arriveTime;
    }

    /**
     * null
     * @param arriveTime null
     */
    public void setArriveTime(Object arriveTime) {
        this.arriveTime = arriveTime;
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
     * 1：工作日，2：周六，3：周日
     * @return TIME_TYPE_ 1：工作日，2：周六，3：周日
     */
    public BigDecimal getTimeType() {
        return timeType;
    }

    /**
     * 1：工作日，2：周六，3：周日
     * @param timeType 1：工作日，2：周六，3：周日
     */
    public void setTimeType(BigDecimal timeType) {
        this.timeType = timeType;
    }
}