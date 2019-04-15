package com.liangxin.platform.common.entity.advise.generate.pt;

import java.util.Date;

public class WechatInformLog {
    /**
     * null
     */
    private String id;

    /**
     * THE ID OF TELATIVE RECORD
     */
    private String relativeId;

    /**
     * null
     */
    private String message;

    /**
     * CREATETIME.
     */
    private Date createTime;

    /**
     * null
     * @return ID_ null
     */
    public String getId() {
        return id;
    }

    /**
     * null
     * @param id null
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * THE ID OF TELATIVE RECORD
     * @return RELATIVE_ID_ THE ID OF TELATIVE RECORD
     */
    public String getRelativeId() {
        return relativeId;
    }

    /**
     * THE ID OF TELATIVE RECORD
     * @param relativeId THE ID OF TELATIVE RECORD
     */
    public void setRelativeId(String relativeId) {
        this.relativeId = relativeId == null ? null : relativeId.trim();
    }

    /**
     * null
     * @return MESSAGE_ null
     */
    public String getMessage() {
        return message;
    }

    /**
     * null
     * @param message null
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * CREATETIME.
     * @return CREATE_TIME_ CREATETIME.
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * CREATETIME.
     * @param createTime CREATETIME.
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}