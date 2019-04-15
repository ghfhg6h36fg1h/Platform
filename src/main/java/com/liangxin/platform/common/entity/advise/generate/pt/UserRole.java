package com.liangxin.platform.common.entity.advise.generate.pt;

public class UserRole {
    /**
     * null
     */
    private String userId;

    /**
     * null
     */
    private String roleId;

    /**
     * null
     * @return USER_ID_ null
     */
    public String getUserId() {
        return userId;
    }

    /**
     * null
     * @param userId null
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * null
     * @return ROLE_ID_ null
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * null
     * @param roleId null
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}