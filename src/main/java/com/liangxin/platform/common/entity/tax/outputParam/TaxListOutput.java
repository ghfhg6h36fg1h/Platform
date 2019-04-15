package com.liangxin.platform.common.entity.tax.outputParam;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class TaxListOutput {
    private int sid;
    private String empno;
    private String name;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,  timezone="GMT+8")
    private Date applytime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,  timezone="GMT+8")
    private Date approvaltime;
    private BigDecimal state;

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

    public BigDecimal getState() {
        return state;
    }

    public void setState(BigDecimal state) {
        this.state = state;
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
}
