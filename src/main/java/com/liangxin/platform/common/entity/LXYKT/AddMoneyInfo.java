package com.liangxin.platform.common.entity.LXYKT;

import static com.liangxin.platform.common.tools.StringUtils.getPrettyNumber;
import static com.liangxin.platform.common.tools.StringUtils.subKqDate;

public class AddMoneyInfo {   //预支信息

    private String addMoney=""; //预支金额
    private String getTime=""; //预支时间
    private String addType="自助预支"; //预支方式

    public String getAddMoney() {
        return addMoney;
    }
    public void setAddMoney(String addMoney) {
        this.addMoney = getPrettyNumber(addMoney);
    }

    public String getGetTime() {
        return getTime;
    }
    public void setGetTime(String getTime) {
        this.getTime = subKqDate(getTime);
    }

    public String getAddType() {
        return addType;
    }
    public void setAddType(String addType) {
        this.addType = addType;
    }
}
