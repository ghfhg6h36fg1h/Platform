package com.liangxin.platform.common.entity.LXYKT;

import static com.liangxin.platform.common.tools.StringUtils.getPrettyNumber;
import static com.liangxin.platform.common.tools.StringUtils.subKqDate;

public class ConsumeInfo {  //消费信息

    private String devName=""; // 设备名称
    private String posDay=""; //消费时间
    private String posMoney=""; //消费金额
    private String cardUseNum=""; //使用次数
    private String cardMoney=""; //卡余额
    private String secid=""; // 补贴扇区

    public String getDevName() {
        return devName;
    }
    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getPosDay() {
        return posDay;
    }
    public void setPosDay(String posDay) {
        this.posDay = subKqDate(posDay);
    }

    public String getPosMoney() {
        return posMoney;
    }
    public void setPosMoney(String posMoney) {
        this.posMoney = getPrettyNumber(posMoney);
    }
    public String getCardUseNum() {
        return cardUseNum;
    }
    public void setCardUseNum(String cardUseNum) {
        this.cardUseNum = cardUseNum;
    }

    public String getCardMoney(){
        return cardMoney;
    }

    public void setCardMoney(String cardMoney){
        this.cardMoney = getPrettyNumber(cardMoney);
    }

    public String getSecid(){
        return secid;
    }

    public void setSecid(String secid){
        this.secid = secid;
    }
}
