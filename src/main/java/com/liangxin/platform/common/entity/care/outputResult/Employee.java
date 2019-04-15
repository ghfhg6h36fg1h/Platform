package com.liangxin.platform.common.entity.care.outputResult;

import java.util.Date;

public class Employee {
    private String id;
    private String workId;
    private String name;
    private String email;
    private Date birthday;
    private Date contractEndDate;//雇佣日期
    private Date hireValid;//有效雇佣日期
    private String hrLevel;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Date getHireValid() {
        return hireValid;
    }

    public void setHireValid(Date hireValid) {
        this.hireValid = hireValid;
    }

    public String getHrLevel() {
        return hrLevel;
    }

    public void setHrLevel(String hrLevel) {
        this.hrLevel = hrLevel;
    }
}
