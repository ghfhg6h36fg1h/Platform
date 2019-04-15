package com.liangxin.platform.common.entity.LXYKT;

import static com.liangxin.platform.common.tools.StringUtils.secondToTime;
import static com.liangxin.platform.common.tools.StringUtils.subKqDate;

public class DayoffInfo {  //请假信息

    private String dayoffDate=""; //请假日期
    private String amDayoffType=""; // 第一次请假类型
    private String amDayoffStartTime=""; // 第一次请假开始时间
    private String amDayoffEndTime=""; // 第一次请假结束时间
    private String amDayoffMinutes=""; // 第一次请假时长
    private String pmDayoffType=""; // 第二次请假类型
    private String pmDayoffStartTime=""; //第二次请假开始时间
    private String pmDayoffEndTime=""; //第二次请假结束时间
    private String pmDayoffMinutes=""; //第二次请假时长
    private String dayoffisConfirmed=""; // 是否确认

    public String getDayoffDate() {
        return dayoffDate;
    }
    public void setDayoffDate(String dayoffDate) {
        this.dayoffDate = subKqDate(dayoffDate);
    }

    public String getAmDayoffType() {
        return amDayoffType;
    }
    public void setAmDayoffType(String amDayoffType) {
        this.amDayoffType = amDayoffType;
    }

    public String getAmDayoffStartTime() {
        return amDayoffStartTime;
    }
    public void setAmDayoffStartTime(String amDayoffStartTime) {
        this.amDayoffStartTime = secondToTime(amDayoffStartTime);
    }
    public String getAmDayoffEndTime() {
        return amDayoffEndTime;
    }
    public void setAmDayoffEndTime(String amDayoffEndTime) {
        this.amDayoffEndTime = secondToTime(amDayoffEndTime);
    }

    public String getAmDayoffMinutes() {
        return amDayoffMinutes;
    }
    public void setAmDayoffMinutes(String amDayoffMinutes) {
        this.amDayoffMinutes = amDayoffMinutes;
    }

    public String getPmDayoffType() {
        return pmDayoffType;
    }
    public void setPmDayoffType(String pmDayoffType) {
        this.pmDayoffType = pmDayoffType;
    }

    public String getPmDayoffStartTime() {
        return pmDayoffStartTime;
    }
    public void setPmDayoffStartTime(String pmDayoffStartTime) {
        this.pmDayoffStartTime = secondToTime(pmDayoffStartTime);
    }
    public String getPmDayoffEndTime() {
        return pmDayoffEndTime;
    }
    public void setPmDayoffEndTime(String pmDayoffEndTime) {
        this.pmDayoffEndTime = secondToTime(pmDayoffEndTime);
    }

    public String getPmDayoffMinutes() {
        return pmDayoffMinutes;
    }
    public void setPmDayoffMinutes(String pmDayoffMinutes) {
        this.pmDayoffMinutes = pmDayoffMinutes;
    }

    public String getDayoffisConfirmed() {
        return dayoffisConfirmed;
    }
    public void setDayoffisConfirmed(String dayoffisConfirmed) {
        this.dayoffisConfirmed = dayoffisConfirmed;
    }
}
