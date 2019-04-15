package com.liangxin.platform.common.entity.advise.inputParam.capital;

public class InputForOAList {
    String id;
    String name;
    String workId;
    String workShopLine;
    Integer isLeave;
    int pageIndex=1;
    int pageSize=10;

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

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getWorkShopLine() {
        return workShopLine;
    }

    public void setWorkShopLine(String workShopLine) {
        this.workShopLine = workShopLine;
    }

    public Integer getIsLeave() {
        return isLeave;
    }

    public void setIsLeave(Integer isLeave) {
        this.isLeave = isLeave;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
