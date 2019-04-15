package com.liangxin.platform.common.entity.advise.outputResult.New_proposal;

/**
 * Created by Enzo Cotter on 2019-3-13.
 */
public class IntegralListOutResult {
    private int id;
    private String applyDate;
    private int money;
    private String state;
    private String empno;
    private String Commission_Date;
    private String Wait_Date;
    private String Get_Date;
    private String depart;
    private Integer integralsum;
    private String name;
    private Integer useIntegral;



    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public String getCommission_Date() {
        return Commission_Date;
    }

    public void setCommission_Date(String commission_Date) {
        Commission_Date = commission_Date;
    }

    public String getWait_Date() {
        return Wait_Date;
    }

    public void setWait_Date(String wait_Date) {
        Wait_Date = wait_Date;
    }

    public String getGet_Date() {
        return Get_Date;
    }

    public void setGet_Date(String get_Date) {
        Get_Date = get_Date;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public Integer getIntegralsum() {
        return integralsum;
    }

    public void setIntegralsum(Integer integralsum) {
        this.integralsum = integralsum;
    }

    public Integer getUseIntegral() {
        return useIntegral;
    }

    public void setUseIntegral(Integer useIntegral) {
        this.useIntegral = useIntegral;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
