package com.liangxin.platform.common.entity.KPI;

public class EmployeeBonus {

    private int sid; //sid
    private String workShop; //车间
    private String employeeNo; //工号
    private String name; //姓名
    private String lineName; //线别
    private String teamOverfulfillBonus; //班组超产奖金
    private String wastage; //班组流失人数
    private String deductBonus; //班组扣除奖金
    private String teamPerformanceBonus; //班组绩效奖金
    private String bonusFactor; //奖金系数
    private String perBonus; //个人奖金
    private String rank; //当月职级
    private String prdDate; //日期

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getWorkShop() {
        return workShop;
    }

    public void setWorkShop(String workShop) {
        this.workShop = workShop;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getTeamOverfulfillBonus() {
        return teamOverfulfillBonus;
    }

    public void setTeamOverfulfillBonus(String teamOverfulfillBonus) {
        this.teamOverfulfillBonus = teamOverfulfillBonus;
    }

    public String getWastage() {
        return wastage;
    }

    public void setWastage(String wastage) {
        this.wastage = wastage;
    }

    public String getDeductBonus() {
        return deductBonus;
    }

    public void setDeductBonus(String deductBonus) {
        this.deductBonus = deductBonus;
    }

    public String getTeamPerformanceBonus() {
        return teamPerformanceBonus;
    }

    public void setTeamPerformanceBonus(String teamPerformanceBonus) {
        this.teamPerformanceBonus = teamPerformanceBonus;
    }

    public String getBonusFactor() {
        return bonusFactor;
    }

    public void setBonusFactor(String bonusFactor) {
        this.bonusFactor = bonusFactor;
    }

    public String getPerBonus() {
        return perBonus;
    }

    public void setPerBonus(String perBonus) {
        this.perBonus = perBonus;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPrdDate() {
        return prdDate;
    }

    public void setPrdDate(String prdDate) {
        this.prdDate = prdDate;
    }

}
