package com.liangxin.platform.common.entity.LXYKT;

import static com.liangxin.platform.common.tools.StringUtils.subKqDate;

public class OtUseInfo {  // 剩余调休信息

    private String otDate=""; //加班日期
    private String otTime=""; //加班时间
    private String otUseTime=""; //已使用时间
    private String otLeftTime=""; //剩余时间

    public String getOtDate() {
        return otDate;
    }
    public void setOtDate(String otDate) {
        this.otDate = subKqDate(otDate);
    }

    public String getOtTime() {
        return otTime;
    }
    public void setOtTime(String otTime) {
        this.otTime = otTime;
    }

    public String getOtUseTime() {
        return otUseTime;
    }
    public void setOtUseTime(String otUseTime) {
        this.otUseTime = otUseTime;
    }
    public String getOtLeftTime() {
        return otLeftTime;
    }
    public void setOtLeftTime(String otLeftTime) {
        this.otLeftTime = otLeftTime;
    }
}
