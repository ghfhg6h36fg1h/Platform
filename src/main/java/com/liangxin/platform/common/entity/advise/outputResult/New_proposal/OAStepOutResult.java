package com.liangxin.platform.common.entity.advise.outputResult.New_proposal;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by Enzo Cotter on 2019-3-20.
 */
public class OAStepOutResult {
    private String ID;
    private String Node_Name;
    private String ActionKey;
    private String ActionInfo;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date Node_Date;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNode_Name() {
        return Node_Name;
    }

    public void setNode_Name(String node_Name) {
        Node_Name = node_Name;
    }


    public Date getNode_Date() {
        return Node_Date;
    }

    public void setNode_Date(Date node_Date) {
        Node_Date = node_Date;
    }

    public String getActionKey() {
        return ActionKey;
    }

    public void setActionKey(String actionKey) {
        ActionKey = actionKey;
    }

    public String getActionInfo() {
        return ActionInfo;
    }

    public void setActionInfo(String actionInfo) {
        ActionInfo = actionInfo;
    }
}
