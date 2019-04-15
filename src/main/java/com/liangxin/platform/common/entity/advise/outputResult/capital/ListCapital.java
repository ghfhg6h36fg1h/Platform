package com.liangxin.platform.common.entity.advise.outputResult.capital;

import java.util.Date;

public class ListCapital {
    private String id;
    private String name;
    private int deleteFlag;
    private Date createTime;
    private Date updateTime;
    private String workId;
    private String workshopLine;
    private int isLeave;

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public int getIsLeave() {
        return isLeave;
    }

    public void setIsLeave(int isLeave) {
        this.isLeave = isLeave;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getWorkshopLine() {
        return workshopLine;
    }

    public void setWorkshopLine(String workshopLine) {
        this.workshopLine = workshopLine;
    }
}
