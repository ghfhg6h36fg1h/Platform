package com.liangxin.platform.common.entity.LXYKT;

import static com.liangxin.platform.common.tools.StringUtils.secondToTime;
import static com.liangxin.platform.common.tools.StringUtils.subKqDate;

public class AttendanceResultsInfo { // 考勤结果数据

    private String kqDate=""; //考勤日期
    private String runno=""; //班次编号
    private String kqIntime=""; //上班时间
    private String kqOuttime=""; //下班时间
    private String kqType=""; // 出勤状况
    private String kqLaterTime="";//迟到时间
    private String kqLeaveTime=""; //早退时间
    private String jbResult=""; //加班条情况
    private String jbTime=""; //加班时间

    public String getKqDate() {
        return kqDate;
    }
    public void setKqDate(String kqDate) {
        this.kqDate = subKqDate(kqDate);
    }

    public String getRunno() {
        return runno;
    }
    public void setRunno(String runno) {
        this.runno = runno;
    }

    public String getKqIntime() {
        return kqIntime;
    }
    public void setKqIntime(String kqIntime) {
        this.kqIntime = secondToTime(kqIntime);
    }
    public String getKqOuttime() {
        return kqOuttime;
    }
    public void setKqOuttime(String kqOuttime) {
        this.kqOuttime = secondToTime(kqOuttime);
    }

    public String getKqType(){
        return kqType;
    }

    public void setKqType(String kqType){
        this.kqType = kqType;
    }

    public String getKqLaterTime(){
        return kqLaterTime;
    }

    public void setKqLaterTime(String kqLaterTime){
        this.kqLaterTime = secondToTime(kqLaterTime);
    }

    public String getKqLeaveTime(){
        return kqLeaveTime;
    }

    public void setKqLeaveTime(String kqLeaveTime){
        this.kqLeaveTime = secondToTime(kqLeaveTime);
    }

    public String getJbResult(){
        return jbResult;
    }

    public void setJbResult(String jbResult){
        this.jbResult = jbResult;
    }

    public String getJbTime(){
        return jbTime;
    }

    public void setJbTime(String jbTime){
        this.jbTime = jbTime;
    }

}
