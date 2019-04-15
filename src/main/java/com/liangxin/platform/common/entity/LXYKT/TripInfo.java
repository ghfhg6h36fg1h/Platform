package com.liangxin.platform.common.entity.LXYKT;

import static com.liangxin.platform.common.tools.StringUtils.secondToTime;
import static com.liangxin.platform.common.tools.StringUtils.subKqDate;

public class TripInfo {//出差信息

    private String tripDate=""; //出差日期
    private String amTripStartTime=""; // 第一段起时
    private String amTripEndTime=""; // 第一段止时
    private String amTripType=""; //出差类型1
    private String amTripMinutes=""; //出差时间1
    private String pmTripStartTime=""; // 第二段起时
    private String pmTripEndTime=""; //第二段止时
    private String pmTripType=""; //出差类型2
    private String pmTripMinutes=""; //出差时间2
    private String tripisConfirmed=""; // 是否确认

    public String getTripDate() {
        return tripDate;
    }
    public void setTripDate(String tripDate) {
        this.tripDate = subKqDate(tripDate);
    }

    public String getAmTripStartTime() {
        return amTripStartTime;
    }
    public void setAmTripStartTime(String amTripStartTime) {
        this.amTripStartTime = secondToTime(amTripStartTime);
    }

    public String getAmTripEndTime() {
        return amTripEndTime;
    }
    public void setAmTripEndTime(String amTripEndTime) {
        this.amTripEndTime = secondToTime(amTripEndTime);
    }
    public String getAmTripType() {
        return amTripType;
    }
    public void setAmTripType(String amTripType) {
        this.amTripType = amTripType;
    }

    public String getAmTripMinutes() {
        return amTripMinutes;
    }
    public void setAmTripMinutes(String amTripMinutes) {
        this.amTripMinutes = amTripMinutes;
    }

    public String getPmTripStartTime() {
        return pmTripStartTime;
    }
    public void setPmTripStartTime(String pmTripStartTime) {
        this.pmTripStartTime = secondToTime(pmTripStartTime);
    }

    public String getPmTripEndTime() {
        return pmTripEndTime;
    }
    public void setPmTripEndTime(String pmTripEndTime) {
        this.pmTripEndTime = secondToTime(pmTripEndTime);
    }
    public String getPmTripType() {
        return pmTripType;
    }
    public void setPmTripType(String pmTripType) {
        this.pmTripType = pmTripType;
    }

    public String getPmTripMinutes() {
        return pmTripMinutes;
    }
    public void setPmTripMinutes(String pmTripMinutes) {
        this.pmTripMinutes = pmTripMinutes;
    }

    public String getTripisConfirmed() {
        return tripisConfirmed;
    }
    public void setTripisConfirmed(String tripisConfirmed) {
        this.tripisConfirmed = tripisConfirmed;
    }
}
