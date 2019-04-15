package com.liangxin.platform.common.entity.tax.pt;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Tax {
    /**
     * null
     */
    private int sid;

    /**
     * null
     */
    private String empno;

    /**
     * null
     */
    private String name;

    /**
     * null
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,  timezone="GMT+8")
    private Date createtime;

    /**
     * null
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,  timezone="GMT+8")
    private Date updatetime;

    /**
     * null
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,  timezone="GMT+8")
    private Date applytime;

    /**
     * null
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,  timezone="GMT+8")
    private Date approvaltime;

    /**
     * null
     */
    private String opinion;

    /**
     * null
     */
    private BigDecimal deleteflag;

    /**
     * null
     */
    private BigDecimal state;

    /**
     * null
     */
    private BigDecimal money1;

    /**
     * null
     */
    private String pic11;

    /**
     * null
     */
    private String pictemp11;

    /**
     * null
     */
    private String pic12;

    /**
     * null
     */
    private String pictemp12;

    /**
     * null
     */
    private String pic13;

    /**
     * null
     */
    private String pictemp13;

    /**
     * null
     */
    private String money2;

    /**
     * null
     */
    private String pic21;

    /**
     * null
     */
    private String pictemp21;

    /**
     * null
     */
    private String pic22;

    /**
     * null
     */
    private String pictemp22;

    /**
     * null
     */
    private String pic23;

    /**
     * null
     */
    private String pictemp23;

    /**
     * null
     */
    private BigDecimal money3;

    /**
     * null
     */
    private String pic31;

    /**
     * null
     */
    private String pictemp31;

    /**
     * null
     */
    private String pic32;

    /**
     * null
     */
    private String pictemp32;

    /**
     * null
     */
    private String pic33;

    /**
     * null
     */
    private String pictemp33;

    /**
     * null
     */
    private BigDecimal money4;

    /**
     * null
     */
    private String pic41;

    /**
     * null
     */
    private String pictemp41;

    /**
     * null
     */
    private String pic42;

    /**
     * null
     */
    private String pictemp42;

    /**
     * null
     */
    private String pic43;

    /**
     * null
     */
    private String pictemp43;

    /**
     * null
     */
    private BigDecimal money5;

    /**
     * null
     */
    private String pic51;

    /**
     * null
     */
    private String pictemp51;

    /**
     * null
     */
    private String pic52;

    /**
     * null
     */
    private String pictemp52;

    /**
     * null
     */
    private String pic53;

    /**
     * null
     */
    private String pictemp53;

    /**
     * null
     */
    private BigDecimal money6;

    /**
     * null
     */
    private String pic61;

    /**
     * null
     */
    private String pictemp61;

    /**
     * null
     */
    private String pic62;

    /**
     * null
     */
    private String pictemp62;

    /**
     * null
     */
    private String pic63;

    /**
     * null
     */
    private String pictemp63;

    /**
     * null
     */
    private BigDecimal money7;

    /**
     * null
     */
    private String pic71;

    /**
     * null
     */
    private String pictemp71;

    /**
     * null
     */
    private String pic72;

    /**
     * null
     */
    private String pictemp72;

    /**
     * null
     */
    private String pic73;

    /**
     * null
     */
    private String pictemp73;
    /**
     * null
     */
    private BigDecimal money8;

    /**
     * null
     */
    private String pic81;

    /**
     * null
     */
    private String pictemp81;

    /**
     * null
     */
    private String pic82;

    /**
     * null
     */
    private String pictemp82;

    /**
     * null
     */
    private String pic83;

    /**
     * null
     */
    private String pictemp83;

    public BigDecimal getMoney7() {
        return money7;
    }

    public void setMoney7(BigDecimal money7) {
        this.money7 = money7;
    }

    public String getPic71() {
        return pic71;
    }

    public void setPic71(String pic71) {
        this.pic71 = pic71 == null ? null : pic71.trim();
    }

    public String getPictemp71() {
        return pictemp71;
    }

    public void setPictemp71(String pictemp71) {
        this.pictemp71 = pictemp71 == null ? null : pictemp71.trim();
    }

    public String getPic72() {
        return pic72;
    }

    public void setPic72(String pic72) {
        this.pic72 = pic72 == null ? null : pic72.trim();
    }

    public String getPictemp72() {
        return pictemp72;
    }

    public void setPictemp72(String pictemp72) {
        this.pictemp72 = pictemp72 == null ? null : pictemp72.trim();
    }

    public String getPic73() {
        return pic73;
    }

    public void setPic73(String pic73) {
        this.pic73 = pic73 == null ? null : pic73.trim();
    }

    public String getPictemp73() {
        return pictemp73;
    }

    public void setPictemp73(String pictemp73) {
        this.pictemp73 = pictemp73 == null ? null : pictemp73.trim();
    }

    public BigDecimal getMoney8() {
        return money8;
    }

    public void setMoney8(BigDecimal money8) {
        this.money8 = money8;
    }

    public String getPic81() {
        return pic81;
    }

    public void setPic81(String pic81) {
        this.pic81 = pic81 == null ? null : pic81.trim();
    }

    public String getPictemp81() {
        return pictemp81;
    }

    public void setPictemp81(String pictemp81) {
        this.pictemp81 = pictemp81 == null ? null : pictemp81.trim();
    }

    public String getPic82() {
        return pic82;
    }

    public void setPic82(String pic82) {
        this.pic82 = pic82  == null ? null : pic82.trim();
    }

    public String getPictemp82() {
        return pictemp82;
    }

    public void setPictemp82(String pictemp82) {
        this.pictemp82 = pictemp82 == null ? null : pictemp82.trim();
    }

    public String getPic83() {
        return pic83;
    }

    public void setPic83(String pic83) {
        this.pic83 = pic83 == null ? null : pic83.trim();
    }

    public String getPictemp83() {
        return pictemp83;
    }

    public void setPictemp83(String pictemp83) {
        this.pictemp83 = pictemp83 == null ? null : pictemp83.trim();
    }

    /**
     * null
     * @return SID null
     */
    public int getSid() {
        return sid;
    }

    /**
     * null
     * @param sid null
     */
    public void setSid(int sid) {
        this.sid = sid;
    }

    /**
     * null
     * @return EMPNO null
     */
    public String getEmpno() {
        return empno;
    }

    /**
     * null
     * @param empno null
     */
    public void setEmpno(String empno) {
        this.empno = empno == null ? null : empno.trim();
    }

    /**
     * null
     * @return NAME null
     */
    public String getName() {
        return name;
    }

    /**
     * null
     * @param name null
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * null
     * @return CREATETIME null
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * null
     * @param createtime null
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * null
     * @return UPDATETIME null
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * null
     * @param updatetime null
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * null
     * @return APPLYTIME null
     */
    public Date getApplytime() {
        return applytime;
    }

    /**
     * null
     * @param applytime null
     */
    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    /**
     * null
     * @return APPROVALTIME null
     */
    public Date getApprovaltime() {
        return approvaltime;
    }

    /**
     * null
     * @param approvaltime null
     */
    public void setApprovaltime(Date approvaltime) {
        this.approvaltime = approvaltime;
    }

    /**
     * null
     * @return OPINION null
     */
    public String getOpinion() {
        return opinion;
    }

    /**
     * null
     * @param opinion null
     */
    public void setOpinion(String opinion) {
        this.opinion = opinion == null ? null : opinion.trim();
    }

    /**
     * null
     * @return DELETEFLAG null
     */
    public BigDecimal getDeleteflag() {
        return deleteflag;
    }

    /**
     * null
     * @param deleteflag null
     */
    public void setDeleteflag(BigDecimal deleteflag) {
        this.deleteflag = deleteflag;
    }

    /**
     * null
     * @return STATE null
     */
    public BigDecimal getState() {
        return state;
    }

    /**
     * null
     * @param state null
     */
    public void setState(BigDecimal state) {
        this.state = state;
    }

    /**
     * null
     * @return MONEY1 null
     */
    public BigDecimal getMoney1() {
        return money1;
    }

    /**
     * null
     * @param money1 null
     */
    public void setMoney1(BigDecimal money1) {
        this.money1 = money1;
    }

    /**
     * null
     * @return PIC1_1 null
     */
    public String getPic11() {
        return pic11;
    }

    /**
     * null
     * @param pic11 null
     */
    public void setPic11(String pic11) {
        this.pic11 = pic11 == null ? null : pic11.trim();
    }

    /**
     * null
     * @return PICTEMP1_1 null
     */
    public String getPictemp11() {
        return pictemp11;
    }

    /**
     * null
     * @param pictemp11 null
     */
    public void setPictemp11(String pictemp11) {
        this.pictemp11 = pictemp11 == null ? null : pictemp11.trim();
    }

    /**
     * null
     * @return PIC1_2 null
     */
    public String getPic12() {
        return pic12;
    }

    /**
     * null
     * @param pic12 null
     */
    public void setPic12(String pic12) {
        this.pic12 = pic12 == null ? null : pic12.trim();
    }

    /**
     * null
     * @return PICTEMP1_2 null
     */
    public String getPictemp12() {
        return pictemp12;
    }

    /**
     * null
     * @param pictemp12 null
     */
    public void setPictemp12(String pictemp12) {
        this.pictemp12 = pictemp12 == null ? null : pictemp12.trim();
    }

    /**
     * null
     * @return PIC1_3 null
     */
    public String getPic13() {
        return pic13;
    }

    /**
     * null
     * @param pic13 null
     */
    public void setPic13(String pic13) {
        this.pic13 = pic13 == null ? null : pic13.trim();
    }

    /**
     * null
     * @return PICTEMP1_3 null
     */
    public String getPictemp13() {
        return pictemp13;
    }

    /**
     * null
     * @param pictemp13 null
     */
    public void setPictemp13(String pictemp13) {
        this.pictemp13 = pictemp13 == null ? null : pictemp13.trim();
    }

    /**
     * null
     * @return MONEY2 null
     */
    public String getMoney2() {
        return money2;
    }

    /**
     * null
     * @param money2 null
     */
    public void setMoney2(String money2) {
        this.money2 = money2 == null ? null : money2.trim();
    }

    /**
     * null
     * @return PIC2_1 null
     */
    public String getPic21() {
        return pic21;
    }

    /**
     * null
     * @param pic21 null
     */
    public void setPic21(String pic21) {
        this.pic21 = pic21 == null ? null : pic21.trim();
    }

    /**
     * null
     * @return PICTEMP2_1 null
     */
    public String getPictemp21() {
        return pictemp21;
    }

    /**
     * null
     * @param pictemp21 null
     */
    public void setPictemp21(String pictemp21) {
        this.pictemp21 = pictemp21 == null ? null : pictemp21.trim();
    }

    /**
     * null
     * @return PIC2_2 null
     */
    public String getPic22() {
        return pic22;
    }

    /**
     * null
     * @param pic22 null
     */
    public void setPic22(String pic22) {
        this.pic22 = pic22 == null ? null : pic22.trim();
    }

    /**
     * null
     * @return PICTEMP2_2 null
     */
    public String getPictemp22() {
        return pictemp22;
    }

    /**
     * null
     * @param pictemp22 null
     */
    public void setPictemp22(String pictemp22) {
        this.pictemp22 = pictemp22 == null ? null : pictemp22.trim();
    }

    /**
     * null
     * @return PIC2_3 null
     */
    public String getPic23() {
        return pic23;
    }

    /**
     * null
     * @param pic23 null
     */
    public void setPic23(String pic23) {
        this.pic23 = pic23 == null ? null : pic23.trim();
    }

    /**
     * null
     * @return PICTEMP2_3 null
     */
    public String getPictemp23() {
        return pictemp23;
    }

    /**
     * null
     * @param pictemp23 null
     */
    public void setPictemp23(String pictemp23) {
        this.pictemp23 = pictemp23 == null ? null : pictemp23.trim();
    }

    /**
     * null
     * @return MONEY3 null
     */
    public BigDecimal getMoney3() {
        return money3;
    }

    /**
     * null
     * @param money3 null
     */
    public void setMoney3(BigDecimal money3) {
        this.money3 = money3;
    }

    /**
     * null
     * @return PIC3_1 null
     */
    public String getPic31() {
        return pic31;
    }

    /**
     * null
     * @param pic31 null
     */
    public void setPic31(String pic31) {
        this.pic31 = pic31 == null ? null : pic31.trim();
    }

    /**
     * null
     * @return PICTEMP3_1 null
     */
    public String getPictemp31() {
        return pictemp31;
    }

    /**
     * null
     * @param pictemp31 null
     */
    public void setPictemp31(String pictemp31) {
        this.pictemp31 = pictemp31 == null ? null : pictemp31.trim();
    }

    /**
     * null
     * @return PIC3_2 null
     */
    public String getPic32() {
        return pic32;
    }

    /**
     * null
     * @param pic32 null
     */
    public void setPic32(String pic32) {
        this.pic32 = pic32 == null ? null : pic32.trim();
    }

    /**
     * null
     * @return PICTEMP3_2 null
     */
    public String getPictemp32() {
        return pictemp32;
    }

    /**
     * null
     * @param pictemp32 null
     */
    public void setPictemp32(String pictemp32) {
        this.pictemp32 = pictemp32 == null ? null : pictemp32.trim();
    }

    /**
     * null
     * @return PIC3_3 null
     */
    public String getPic33() {
        return pic33;
    }

    /**
     * null
     * @param pic33 null
     */
    public void setPic33(String pic33) {
        this.pic33 = pic33 == null ? null : pic33.trim();
    }

    /**
     * null
     * @return PICTEMP3_3 null
     */
    public String getPictemp33() {
        return pictemp33;
    }

    /**
     * null
     * @param pictemp33 null
     */
    public void setPictemp33(String pictemp33) {
        this.pictemp33 = pictemp33 == null ? null : pictemp33.trim();
    }

    /**
     * null
     * @return MONEY4 null
     */
    public BigDecimal getMoney4() {
        return money4;
    }

    /**
     * null
     * @param money4 null
     */
    public void setMoney4(BigDecimal money4) {
        this.money4 = money4;
    }

    /**
     * null
     * @return PIC4_1 null
     */
    public String getPic41() {
        return pic41;
    }

    /**
     * null
     * @param pic41 null
     */
    public void setPic41(String pic41) {
        this.pic41 = pic41 == null ? null : pic41.trim();
    }

    /**
     * null
     * @return PICTEMP4_1 null
     */
    public String getPictemp41() {
        return pictemp41;
    }

    /**
     * null
     * @param pictemp41 null
     */
    public void setPictemp41(String pictemp41) {
        this.pictemp41 = pictemp41 == null ? null : pictemp41.trim();
    }

    /**
     * null
     * @return PIC4_2 null
     */
    public String getPic42() {
        return pic42;
    }

    /**
     * null
     * @param pic42 null
     */
    public void setPic42(String pic42) {
        this.pic42 = pic42 == null ? null : pic42.trim();
    }

    /**
     * null
     * @return PICTEMP4_2 null
     */
    public String getPictemp42() {
        return pictemp42;
    }

    /**
     * null
     * @param pictemp42 null
     */
    public void setPictemp42(String pictemp42) {
        this.pictemp42 = pictemp42 == null ? null : pictemp42.trim();
    }

    /**
     * null
     * @return PIC4_3 null
     */
    public String getPic43() {
        return pic43;
    }

    /**
     * null
     * @param pic43 null
     */
    public void setPic43(String pic43) {
        this.pic43 = pic43 == null ? null : pic43.trim();
    }

    /**
     * null
     * @return PICTEMP4_3 null
     */
    public String getPictemp43() {
        return pictemp43;
    }

    /**
     * null
     * @param pictemp43 null
     */
    public void setPictemp43(String pictemp43) {
        this.pictemp43 = pictemp43 == null ? null : pictemp43.trim();
    }

    /**
     * null
     * @return MONEY5 null
     */
    public BigDecimal getMoney5() {
        return money5;
    }

    /**
     * null
     * @param money5 null
     */
    public void setMoney5(BigDecimal money5) {
        this.money5 = money5;
    }

    /**
     * null
     * @return PIC5_1 null
     */
    public String getPic51() {
        return pic51;
    }

    /**
     * null
     * @param pic51 null
     */
    public void setPic51(String pic51) {
        this.pic51 = pic51 == null ? null : pic51.trim();
    }

    /**
     * null
     * @return PICTEMP5_1 null
     */
    public String getPictemp51() {
        return pictemp51;
    }

    /**
     * null
     * @param pictemp51 null
     */
    public void setPictemp51(String pictemp51) {
        this.pictemp51 = pictemp51 == null ? null : pictemp51.trim();
    }

    /**
     * null
     * @return PIC5_2 null
     */
    public String getPic52() {
        return pic52;
    }

    /**
     * null
     * @param pic52 null
     */
    public void setPic52(String pic52) {
        this.pic52 = pic52 == null ? null : pic52.trim();
    }

    /**
     * null
     * @return PICTEMP5_2 null
     */
    public String getPictemp52() {
        return pictemp52;
    }

    /**
     * null
     * @param pictemp52 null
     */
    public void setPictemp52(String pictemp52) {
        this.pictemp52 = pictemp52 == null ? null : pictemp52.trim();
    }

    /**
     * null
     * @return PIC5_3 null
     */
    public String getPic53() {
        return pic53;
    }

    /**
     * null
     * @param pic53 null
     */
    public void setPic53(String pic53) {
        this.pic53 = pic53 == null ? null : pic53.trim();
    }

    /**
     * null
     * @return PICTEMP5_3 null
     */
    public String getPictemp53() {
        return pictemp53;
    }

    /**
     * null
     * @param pictemp53 null
     */
    public void setPictemp53(String pictemp53) {
        this.pictemp53 = pictemp53 == null ? null : pictemp53.trim();
    }

    /**
     * null
     * @return MONEY6 null
     */
    public BigDecimal getMoney6() {
        return money6;
    }

    /**
     * null
     * @param money6 null
     */
    public void setMoney6(BigDecimal money6) {
        this.money6 = money6;
    }

    /**
     * null
     * @return PIC6_1 null
     */
    public String getPic61() {
        return pic61;
    }

    /**
     * null
     * @param pic61 null
     */
    public void setPic61(String pic61) {
        this.pic61 = pic61 == null ? null : pic61.trim();
    }

    /**
     * null
     * @return PICTEMP6_1 null
     */
    public String getPictemp61() {
        return pictemp61;
    }

    /**
     * null
     * @param pictemp61 null
     */
    public void setPictemp61(String pictemp61) {
        this.pictemp61 = pictemp61 == null ? null : pictemp61.trim();
    }

    /**
     * null
     * @return PIC6_2 null
     */
    public String getPic62() {
        return pic62;
    }

    /**
     * null
     * @param pic62 null
     */
    public void setPic62(String pic62) {
        this.pic62 = pic62 == null ? null : pic62.trim();
    }

    /**
     * null
     * @return PICTEMP6_2 null
     */
    public String getPictemp62() {
        return pictemp62;
    }

    /**
     * null
     * @param pictemp62 null
     */
    public void setPictemp62(String pictemp62) {
        this.pictemp62 = pictemp62 == null ? null : pictemp62.trim();
    }

    /**
     * null
     * @return PIC6_3 null
     */
    public String getPic63() {
        return pic63;
    }

    /**
     * null
     * @param pic63 null
     */
    public void setPic63(String pic63) {
        this.pic63 = pic63 == null ? null : pic63.trim();
    }

    /**
     * null
     * @return PICTEMP6_3 null
     */
    public String getPictemp63() {
        return pictemp63;
    }

    /**
     * null
     * @param pictemp63 null
     */
    public void setPictemp63(String pictemp63) {
        this.pictemp63 = pictemp63 == null ? null : pictemp63.trim();
    }
}