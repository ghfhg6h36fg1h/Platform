package com.liangxin.platform.common.entity.sys.mail;

import java.util.List;

public class MailSet {
    private String sendType = "smtp";//服务器类型
    private String serverAddress;//邮箱服务器地址
    private String userName;//发送邮箱用户名
    private String userPassWord;//发送邮箱密码
    private String sendFromAddress;//使用的发送帐号


    private String mailSubject;//邮件主题
    private String mailText;//邮件文字内同
    private List<String> sendToAddress;//将要发送的地址
    private List<String> copyToAddress;//将要抄送的地址
    private Integer fontSize = 16;


    private String sendTemple;//邮件发送类型，此为寻找模板关键字
    private String reSendRecordId;//重发邮件时对应记录Id
    private String sendToUserWorkId;
    private List<String> upWorkIdList;//将要抄送的地址
    private String sendToUserName;
    private List<String> imageBodyList;//邮件体中的图片
    private String vocationalDate;//业务日期，like 转正日期或者合同到期日期
    private String hrLevel;//业务日期，like 转正日期或者合同到期日期

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public String getMailText() {
        return mailText;
    }

    public void setMailText(String mailText) {
        this.mailText = mailText;
    }

    public String getSendFromAddress() {
        return sendFromAddress;
    }

    public void setSendFromAddress(String sendFromAddress) {
        this.sendFromAddress = sendFromAddress;
    }

    public List<String> getSendToAddress() {
        return sendToAddress;
    }

    public void setSendToAddress(List<String> sendToAddress) {
        this.sendToAddress = sendToAddress;
    }

    public List<String> getCopyToAddress() {
        return copyToAddress;
    }

    public void setCopyToAddress(List<String> copyToAddress) {
        this.copyToAddress = copyToAddress;
    }

    public String getSendTemple() {
        return sendTemple;
    }

    public void setSendTemple(String sendTemple) {
        this.sendTemple = sendTemple;
    }

    public String getReSendRecordId() {
        return reSendRecordId;
    }

    public void setReSendRecordId(String reSendRecordId) {
        this.reSendRecordId = reSendRecordId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public String getSendToUserWorkId() {
        return sendToUserWorkId;
    }

    public void setSendToUserWorkId(String sendToUserWorkId) {
        this.sendToUserWorkId = sendToUserWorkId;
    }

    public String getSendToUserName() {
        return sendToUserName;
    }

    public void setSendToUserName(String sendToUserName) {
        this.sendToUserName = sendToUserName;
    }

    public List<String> getImageBodyList() {
        return imageBodyList;
    }

    public void setImageBodyList(List<String> imageBodyList) {
        this.imageBodyList = imageBodyList;
    }

    public String getVocationalDate() {
        return vocationalDate;
    }

    public void setVocationalDate(String vocationalDate) {
        this.vocationalDate = vocationalDate;
    }

    public String getHrLevel() {
        return hrLevel;
    }

    public void setHrLevel(String hrLevel) {
        this.hrLevel = hrLevel;
    }

    public List<String> getUpWorkIdList() {
        return upWorkIdList;
    }

    public void setUpWorkIdList(List<String> upWorkIdList) {
        this.upWorkIdList = upWorkIdList;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }
}
