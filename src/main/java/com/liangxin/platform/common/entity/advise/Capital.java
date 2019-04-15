package com.liangxin.platform.common.entity.advise;

import java.util.Date;
import java.util.UUID;

public class Capital {
    private String id = String.valueOf(UUID.randomUUID()).replace("-","");
    private String name;
    private boolean deleteFlag;
    private Date createTime;
    private Date updateTime;
    private String workId;
    private String workshopLine;

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

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
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
