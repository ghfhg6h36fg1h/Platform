package com.liangxin.platform.common.entity.tax.outputParam;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class TaxExportListOutput {
    private int sid;
    private String empno;
    private String name;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,  timezone="GMT+8")
    private Date applytime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,  timezone="GMT+8")
    private Date approvaltime;
    private BigDecimal state;
    private BigDecimal money1;
    private BigDecimal money2;
    private BigDecimal money3;
    private BigDecimal money4;
    private BigDecimal money5;
    private BigDecimal money6;
    private BigDecimal money7;
    private BigDecimal money8;

    public BigDecimal getMoney7() {
        return money7;
    }

    public void setMoney7(BigDecimal money7) {
        this.money7 = money7;
    }

    public BigDecimal getMoney8() {
        return money8;
    }

    public void setMoney8(BigDecimal money8) {
        this.money8 = money8;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public Date getApprovaltime() {
        return approvaltime;
    }

    public void setApprovaltime(Date approvaltime) {
        this.approvaltime = approvaltime;
    }

    public BigDecimal getState() {
        return state;
    }

    public void setState(BigDecimal state) {
        this.state = state;
    }

    public BigDecimal getMoney1() {
        return money1;
    }

    public void setMoney1(BigDecimal money1) {
        this.money1 = money1;
    }

    public BigDecimal getMoney2() {
        return money2;
    }

    public void setMoney2(BigDecimal money2) {
        this.money2 = money2;
    }

    public BigDecimal getMoney3() {
        return money3;
    }

    public void setMoney3(BigDecimal money3) {
        this.money3 = money3;
    }

    public BigDecimal getMoney4() {
        return money4;
    }

    public void setMoney4(BigDecimal money4) {
        this.money4 = money4;
    }

    public BigDecimal getMoney5() {
        return money5;
    }

    public void setMoney5(BigDecimal money5) {
        this.money5 = money5;
    }

    public BigDecimal getMoney6() {
        return money6;
    }

    public void setMoney6(BigDecimal money6) {
        this.money6 = money6;
    }
}
