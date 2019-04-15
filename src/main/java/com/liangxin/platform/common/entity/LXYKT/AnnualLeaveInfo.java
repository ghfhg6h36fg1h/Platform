package com.liangxin.platform.common.entity.LXYKT;

public class AnnualLeaveInfo {    //年休假信息

    private String workAge=""; //工龄
    private String totalVocation=""; //总年休假
    private String usedVocation=""; //已使用年休假
    private String leftVocation=""; // 剩余年休假
    private String freeVocation=""; //自由年休假
    private String convertLeftVocation=""; //可折算剩余年休

    public String getConvertLeftVocation() {
        return convertLeftVocation;
    }

    public void setConvertLeftVocation(String convertLeftVocation) {
        this.convertLeftVocation = convertLeftVocation;
    }

    public String getWorkAge() {
        return workAge;
    }
    public void setWorkAge(String workAge) {
        this.workAge = workAge;
    }

    public String getTotalVocation() {
        return totalVocation;
    }
    public void setTotalVocation(String totalVocation) {
        this.totalVocation = totalVocation;
    }

    public String getUsedVocation() {
        return usedVocation;
    }
    public void setUsedVocation(String usedVocation) {
        this.usedVocation = usedVocation;
    }
    public String getLeftVocation() {
        return leftVocation;
    }
    public void setLeftVocation(String leftVocation) {
        this.leftVocation = leftVocation;
    }

    public String getFreeVocation() {
        return freeVocation;
    }
    public void setFreeVocation(String freeVocation) {
        this.freeVocation = freeVocation;
    }
}
