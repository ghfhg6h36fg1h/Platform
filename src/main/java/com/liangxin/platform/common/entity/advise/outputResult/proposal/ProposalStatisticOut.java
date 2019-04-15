package com.liangxin.platform.common.entity.advise.outputResult.proposal;

public class ProposalStatisticOut {
    private Integer pendingCount;
    private Integer passedCount;
    private Integer rejectCount;
    private Integer eventuallyReject;
    private Integer reNew;
    private Integer eventuallyPass;

    public Integer getPendingCount() {
        return pendingCount;
    }

    public void setPendingCount(Integer pendingCount) {
        this.pendingCount = pendingCount;
    }

    public Integer getPassedCount() {
        return passedCount;
    }

    public void setPassedCount(Integer passedCount) {
        this.passedCount = passedCount;
    }

    public Integer getRejectCount() {
        return rejectCount;
    }

    public void setRejectCount(Integer rejectCount) {
        this.rejectCount = rejectCount;
    }

    public Integer getEventuallyReject() {
        return eventuallyReject;
    }

    public void setEventuallyReject(Integer eventuallyReject) {
        this.eventuallyReject = eventuallyReject;
    }

    public Integer getReNew() {
        return reNew;
    }

    public void setReNew(Integer reNew) {
        this.reNew = reNew;
    }

    public Integer getEventuallyPass() {
        return eventuallyPass;
    }

    public void setEventuallyPass(Integer eventuallyPass) {
        this.eventuallyPass = eventuallyPass;
    }
}
