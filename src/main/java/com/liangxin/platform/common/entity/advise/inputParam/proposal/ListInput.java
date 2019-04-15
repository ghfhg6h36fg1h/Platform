package com.liangxin.platform.common.entity.advise.inputParam.proposal;

public class ListInput {
    private String presentWorkId;
    private String searchContent;
    private String owner;
//    private String ownerName;
    private String status;
    private int currentPage=1;
    private int pageSize=10;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
//    public String getTheme() {
//        return theme;
//    }
//
//    public void setTheme(String theme) {
//        this.theme = theme;
//    }

    public String getPresentWorkId() {
        return presentWorkId;
    }

    public void setPresentWorkId(String presentWorkId) {
        this.presentWorkId = presentWorkId;
    }

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String owner) {
        this.searchContent = owner;
    }

//    public String getOwnerName() {
//        return ownerName;
//    }
//
//    public void setOwnerName(String ownerName) {
//        this.ownerName = ownerName;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if(pageSize!=0) {
            this.pageSize = pageSize;
        }else{
            this.pageSize =10000;
        }
    }
}
