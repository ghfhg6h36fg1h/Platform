package com.liangxin.platform.common.entity.advise.inputParam.proposal;

/**
 * Created by Enzo Cotter on 2019-3-13.
 */
public class ChangeMoneyInput {
    private String empno;
    private Integer money;
    private String ApplyDate;
    private String state;


    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getApplyDate() {
        return ApplyDate;
    }

    public void setApplyDate(String applyDate) {
        ApplyDate = applyDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
