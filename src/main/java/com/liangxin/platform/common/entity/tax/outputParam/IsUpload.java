package com.liangxin.platform.common.entity.tax.outputParam;

public class IsUpload {
    private boolean isSuccess;
    private String picFakePath;
    private String picRealPath;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getPicFakePath() {
        return picFakePath;
    }

    public void setPicFakePath(String picFakePath) {
        this.picFakePath = picFakePath;
    }

    public String getPicRealPath() {
        return picRealPath;
    }

    public void setPicRealPath(String picRealPath) {
        this.picRealPath = picRealPath;
    }
}
