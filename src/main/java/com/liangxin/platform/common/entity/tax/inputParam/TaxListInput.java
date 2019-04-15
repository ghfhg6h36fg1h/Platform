package com.liangxin.platform.common.entity.tax.inputParam;

import java.math.BigDecimal;

public class TaxListInput {

    private String empno;

    private String name;

    private BigDecimal state;

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
}
