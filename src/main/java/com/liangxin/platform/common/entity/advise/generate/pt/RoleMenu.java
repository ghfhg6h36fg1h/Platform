package com.liangxin.platform.common.entity.advise.generate.pt;

public class RoleMenu {
    /**
     * null
     */
    private String roleId;

    /**
     * null
     */
    private String menuId;

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

    /**
     * null
     * @return MENU_ID_ null
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * null
     * @param menuId null
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }
}