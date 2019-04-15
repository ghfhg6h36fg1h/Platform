package com.liangxin.platform.common.entity.tax.outputParam;

public class IsUploadThumb {
    private boolean isSuccess;
    private String thumbnailPath;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }
}
