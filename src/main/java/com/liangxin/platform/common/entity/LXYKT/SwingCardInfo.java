package com.liangxin.platform.common.entity.LXYKT;

import static com.liangxin.platform.common.tools.StringUtils.secondToTime;
import static com.liangxin.platform.common.tools.StringUtils.subKqDate;

public class SwingCardInfo { //刷卡数据信息

    private String kqDate="";//打卡日期
    private String kqTime="";//打卡时间
    private String remark="";//打卡地点
    private String dataTypeID="";//数据类型（1=系统自动采集  2=补打卡）

    public String getKqDate() {
        return kqDate;
    }
    public void setKqDate(String kqDate) {
        this.kqDate = subKqDate(kqDate);
    }

    public String getKqTime() {
        return kqTime;
    }
    public void setKqTime(String kqTime) {
        this.kqTime = secondToTime(kqTime);
    }

    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getDataTypeID() {
        return dataTypeID;
    }
    public void setDataTypeID(String dataTypeID) {
        switch (dataTypeID) {
            case "1" :
                this.dataTypeID = "系统采集";
                break;
            case "2" :
                this.dataTypeID = "手工补卡";
                break;
                default:
                    this.dataTypeID = "未知";
        }
    }
}
