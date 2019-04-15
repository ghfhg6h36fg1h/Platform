package com.liangxin.platform.common.entity.tax.inputParam;

import java.math.BigDecimal;

public class TaxSearchListInput {
    private String empno;
    private String name;
    private BigDecimal state;
    private String searchApplyStartDate;
    private String searchApplyEndDate;
    private String searchApprovalStartDate;
    private String searchApprovalEndDate;
    private Integer currentPage = 1;
    private Integer pageSize = 20;

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

    public String getSearchApplyStartDate() {
        return searchApplyStartDate;
    }

    public void setSearchApplyStartDate(String searchApplyStartDate) {
        this.searchApplyStartDate = searchApplyStartDate;
    }

    public String getSearchApplyEndDate() {
        return searchApplyEndDate;
    }

    public void setSearchApplyEndDate(String searchApplyEndDate) {
        this.searchApplyEndDate = searchApplyEndDate;
    }

    public String getSearchApprovalStartDate() {
        return searchApprovalStartDate;
    }

    public void setSearchApprovalStartDate(String searchApprovalStartDate) {
        this.searchApprovalStartDate = searchApprovalStartDate;
    }

    public String getSearchApprovalEndDate() {
        return searchApprovalEndDate;
    }

    public void setSearchApprovalEndDate(String searchApprovalEndDate) {
        this.searchApprovalEndDate = searchApprovalEndDate;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
