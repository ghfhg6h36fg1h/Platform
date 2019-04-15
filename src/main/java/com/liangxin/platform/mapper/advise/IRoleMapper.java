package com.liangxin.platform.mapper.advise;

import com.liangxin.platform.common.entity.advise.generate.pt.Role;
import com.liangxin.platform.common.entity.advise.inputParam.role.RoleInput;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IRoleMapper {
    List<Role> getAll(@Param("pListInput") RoleInput pListInput);

    int isExistsByName(@Param("pName") String pName);

    Integer delMenuRelationToRole(@Param("pRoleId") String pRoleId);

    Integer delUserRelationToRole(@Param("pRoleId") String pRoleId);

    Integer addMenuAction (@Param("pRoleId") String pRoleId,
                           @Param("pListMenuIds") List<String> pListMenuIds);
}
