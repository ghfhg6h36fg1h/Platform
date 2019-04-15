package com.liangxin.platform.common.entity.tax.inputParam;

import java.util.Date;

public class DeletePicInput {
    private int sid;
    private String pic;
    private Date updatetime;
    private String pictemp;
    private String emptyStr;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getPictemp() {
        return pictemp;
    }

    public void setPictemp(String pictemp) {
        this.pictemp = pictemp;
    }

    public String getEmptyStr() {
        return emptyStr;
    }

    public void setEmptyStr(String emptyStr) {
        this.emptyStr = emptyStr;
    }
}
