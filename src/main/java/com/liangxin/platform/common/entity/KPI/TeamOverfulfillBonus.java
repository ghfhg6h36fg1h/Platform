package com.liangxin.platform.common.entity.KPI;

public class TeamOverfulfillBonus { //班组超产奖金表
    private int sid; //sid
    private String lineType; //工作中心
    private String lineName; //工作中心名称
    private String teamLeader; //班长
    private String prdType; //生产产品大类
    private String dayProductionNumber; //当天生产极数
    private String timeOfDay; //当天投入时间
    private String capacityPerHour; //单位小时人均产能实际
    private String dayOverfulfillBonus; //日超产奖金
    private String monthlyCumulativeOutput; //月累计产量
    private String monthlyCumulativeTime; //月累计时间
    private String cumHourlyCapacity; //累计小时人均产能实际
    private String cumOverfulfillBonus; //累计超产奖金
    private String capacityPerHourStandard; //单位小时人均产能基准
    private String capacityPerHourGoal; //单位小时人均产能目标
    private String challengeValue; //挑战值
    private String monthEfficiency; //当月效率提升
    private String prdDate; //日期

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getLineType() {
        return lineType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(String teamLeader) {
        this.teamLeader = teamLeader;
    }

    public String getPrdType() {
        return prdType;
    }

    public void setPrdType(String prdType) {
        this.prdType = prdType;
    }

    public String getDayProductionNumber() {
        return dayProductionNumber;
    }

    public void setDayProductionNumber(String dayProductionNumber) {
        this.dayProductionNumber = dayProductionNumber;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public String getCapacityPerHour() {
        return capacityPerHour;
    }

    public void setCapacityPerHour(String capacityPerHour) {
        this.capacityPerHour = capacityPerHour;
    }

    public String getDayOverfulfillBonus() {
        return dayOverfulfillBonus;
    }

    public void setDayOverfulfillBonus(String dayOverfulfillBonus) {
        this.dayOverfulfillBonus = dayOverfulfillBonus;
    }

    public String getMonthlyCumulativeOutput() {
        return monthlyCumulativeOutput;
    }

    public void setMonthlyCumulativeOutput(String monthlyCumulativeOutput) {
        this.monthlyCumulativeOutput = monthlyCumulativeOutput;
    }

    public String getMonthlyCumulativeTime() {
        return monthlyCumulativeTime;
    }

    public void setMonthlyCumulativeTime(String monthlyCumulativeTime) {
        this.monthlyCumulativeTime = monthlyCumulativeTime;
    }

    public String getCumHourlyCapacity() {
        return cumHourlyCapacity;
    }

    public void setCumHourlyCapacity(String cumHourlyCapacity) {
        this.cumHourlyCapacity = cumHourlyCapacity;
    }

    public String getCumOverfulfillBonus() {
        return cumOverfulfillBonus;
    }

    public void setCumOverfulfillBonus(String cumOverfulfillBonus) {
        this.cumOverfulfillBonus = cumOverfulfillBonus;
    }

    public String getCapacityPerHourStandard() {
        return capacityPerHourStandard;
    }

    public void setCapacityPerHourStandard(String capacityPerHourStandard) {
        this.capacityPerHourStandard = capacityPerHourStandard;
    }

    public String getCapacityPerHourGoal() {
        return capacityPerHourGoal;
    }

    public void setCapacityPerHourGoal(String capacityPerHourGoal) {
        this.capacityPerHourGoal = capacityPerHourGoal;
    }

    public String getChallengeValue() {
        return challengeValue;
    }

    public void setChallengeValue(String challengeValue) {
        this.challengeValue = challengeValue;
    }

    public String getMonthEfficiency() {
        return monthEfficiency;
    }

    public void setMonthEfficiency(String monthEfficiency) {
        this.monthEfficiency = monthEfficiency;
    }

    public String getPrdDate() {
        return prdDate;
    }

    public void setPrdDate(String prdDate) {
        this.prdDate = prdDate;
    }
}

