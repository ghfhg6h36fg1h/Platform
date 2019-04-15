package com.liangxin.platform.common.entity.LXYKT;

import static com.liangxin.platform.common.tools.StringUtils.secondToTime;
import static com.liangxin.platform.common.tools.StringUtils.subKqDate;

public class OvertimeInfo { //加班信息

    private String otDate=""; //加班日期
    private String ot1StartTime=""; //第一段起时
    private String ot1EndTime=""; //第一段止时
    private String otType1=""; //加班类型1
    private String ot1Time=""; //加班时长1<分钟>
    private String ot2StartTime=""; //第二段起时
    private String ot2EndTime="";  //第二段止时
    private String otType2=""; //加班类型2
    private String ot2Time=""; //加班时长2<分钟>
    //private String otisWorkShop; //是否车间加班
    private String otisConfirmed=""; //是否确认

    public String getOtDate() {
        return otDate;
    }

    public void setOtDate(String otDate) {
        this.otDate = subKqDate(otDate);
    }

    public String getOt1StartTime() {
        return ot1StartTime;
    }

    public void setOt1StartTime(String ot1StartTime) {
        this.ot1StartTime = secondToTime(ot1StartTime);
    }

    public String getOt1EndTime() {
        return ot1EndTime;
    }

    public void setOt1EndTime(String ot1EndTime) {
        this.ot1EndTime = secondToTime(ot1EndTime);
    }

    public String getOtType1() {
        return otType1;
    }

    public void setOtType1(String otType1) {
        this.otType1 = otType1;
    }

    public String getOt1Time() {
        return ot1Time;
    }

    public void setOt1Time(String ot1Time) {
        this.ot1Time = ot1Time;
    }

    public String getOt2StartTime() {
        return ot2StartTime;
    }

    public void setOt2StartTime(String ot2StartTime) {
        this.ot2StartTime = secondToTime(ot2StartTime);
    }

    public String getOt2EndTime() {
        return ot2EndTime;
    }

    public void setOt2EndTime(String ot2EndTime) {
        this.ot2EndTime = secondToTime(ot2EndTime);
    }

    public String getOtType2() {
        return otType2;
    }

    public void setOtType2(String otType2) {
        this.otType2 = otType2;
    }

    public String getOt2Time() {
        return ot2Time;
    }

    public void setOt2Time(String ot2Time) {
        this.ot2Time = ot2Time;
    }

	/*public String getOtisWorkShop() {
		return otisWorkShop;
	}
	public void setOtisWorkShop(String otisWorkShop) {
		this.otisWorkShop = otisWorkShop;
	}*/

    public String getOtisConfirmed() {
        return otisConfirmed;
    }

    public void setOtisConfirmed(String otisConfirmed) {
        this.otisConfirmed = otisConfirmed;
    }
}
