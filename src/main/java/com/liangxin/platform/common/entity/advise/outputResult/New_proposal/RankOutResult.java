package com.liangxin.platform.common.entity.advise.outputResult.New_proposal;

/**
 * Created by Enzo Cotter on 2019-3-13.
 */
public class RankOutResult {
    private String depart;
    private int ClaProposal;
    private double average;
    private double ClaUseful;

    private String name;
    private String empno;
    private int PerProposal;
    private int PerUseful;

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public int getClaProposal() {
        return ClaProposal;
    }

    public void setClaProposal(int claProposal) {
        ClaProposal = claProposal;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPerProposal() {
        return PerProposal;
    }

    public void setPerProposal(int perProposal) {
        PerProposal = perProposal;
    }


    public void setClaUseful(double claUseful) {
        ClaUseful = claUseful;
    }

    public int getPerUseful() {
        return PerUseful;
    }

    public void setPerUseful(int perUseful) {
        PerUseful = perUseful;
    }

    public double getClaUseful() {
        return ClaUseful;
    }

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }
}
